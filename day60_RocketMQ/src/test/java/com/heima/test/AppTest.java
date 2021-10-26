package com.heima.test;

import com.heima.Order.Order;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Test
    public void test1(){
        /**
         convertAndSend(D destination, Object payload)
         参数一： 代表消息的主题，topic
         参数二： 消息的内容
         */
        rocketMQTemplate.convertAndSend("topic","hello RocketMQ");
    }
    //发送延时消息
    @Test
    public void testDelay(){
        /**
         * syncSend(String destination, Message<?> message, long timeout, int delayLevel)
         *    destination : 消息的主题
         *    message: 消息内容
         *    timeout: 发送消息的超时时间
         *    delayLevel : 延时的等级，这个方法是缺陷不能做到时间非常准确（不能指定某一天某个时刻）。因为延时等级是固定好
         *          1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h
         */
        Message<String> message = MessageBuilder.withPayload("延迟消息").build();
        rocketMQTemplate.syncSend("topic_delay",message,3000,2);//这个消息发送出去之后30秒消费者才可见
    }

    @Test
    public void testSync() {
        rocketMQTemplate.syncSend("topic-name", "发送同步消息 !");
    }
    @Test
    public void async() {
        rocketMQTemplate.asyncSend("topic-name", "发送异步消息!", new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("发送成功回调");
            }

            @Override
            public void onException(Throwable throwable) {
                System.out.println("发送失败回调"+throwable.getMessage());
            }
        });
        System.out.println("===最终输出===");
        while (true);
    }

    //    ==========================发送顺序消息==========================
    @Test
    public void  testOrderMessage(){
        //1. 得到所有订单的消息
        List<Order> orderList = Order.buildOrders();

        //2. 注册消息队列选择器，作用：每发送一个消息都会触发这里方法得到该消息应该要进入到哪个队列
        rocketMQTemplate.setMessageQueueSelector(new MessageQueueSelector() {
            /**
             * 这个方法: 每发送一个消息都触发方法
             * @param list   消息队列集合，默认4个队列
             * @param message   消息对象
             * @param key   消息的标记 ,orderid
             * @return  返回该消息应该进入哪个队列
             */
            @Override
            public MessageQueue select(List<MessageQueue> list, org.apache.rocketmq.common.message.Message message, Object key) {
                //1. 得到消息的标记，得到orderId
                int orderid = Integer.parseInt( key+"");
                //2. 计算该order需要进入哪个队列索引
                //  4%4=0  5%4=1
                int index = orderid%list.size();

                return list.get(index);
            }
        });

        //3. 遍历订单发送消息
        for (Order order : orderList) {
            /**
             *   syncSendOrderly(String destination, String message, String hashKey)
             *          destination：主题topic
             *          message: 发送的消息
             *          hashKey: 消息的标记
             */
            rocketMQTemplate.syncSendOrderly("topic_order",order.toString(),order.getId()+"");
        }

    }

    //====================广播消息==============
    @Test
    public void  testBroadCast(){
        rocketMQTemplate.syncSend("topic_broadcast","广播消息");
    }
}
