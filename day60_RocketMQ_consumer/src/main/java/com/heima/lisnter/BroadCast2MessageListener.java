package com.heima.lisnter;

import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

//该类的作用就是监听指定的主题消息,如果该类需要变成一个监听器需要实现RocketMQListener接口
// topic代表的是监听主题，注意生产者发送的主题与消费者监听主题一定要一样。
// consumerGroup : 消费组,注意一个主题一般我们都是对应一个消费组
//注意： 不同的消费者可以消费多次同一个消息，同一个消费组只能消费一次相同消息
@Component
@RocketMQMessageListener(topic = "topic_broadcast",consumerGroup ="group5",messageModel = MessageModel.BROADCASTING)
public class BroadCast2MessageListener implements RocketMQListener<String> {

    //这个方法的触发时机： 一旦监听到队列里面消息，就会触发该方法
    @Override
    public void onMessage(String message) {
        System.out.println("广播消息监听者2："+message);
    }
}
