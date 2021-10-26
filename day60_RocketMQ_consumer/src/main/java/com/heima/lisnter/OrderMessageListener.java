package com.heima.lisnter;

import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

//该类的作用就是监听指定的主题消息,如果该类需要变成一个监听器需要实现RocketMQListener接口
// topic代表的是监听主题，注意生产者发送的主题与消费者监听主题一定要一样。
// consumerGroup : 消费组,注意一个主题一般我们都是对应一个消费组
//注意： 不同的消费者可以消费多次同一个消息，同一个消费组只能消费一次相同消息

/**
 * consumeMode = ConsumeMode.ORDERLY 保证每一个队列每次只能进去一个线程去消费
 */
@Component
@RocketMQMessageListener(topic = "topic_order",consumerGroup ="group3",consumeMode = ConsumeMode.ORDERLY)
public class OrderMessageListener implements RocketMQListener<String> {

    //这个方法的触发时机： 一旦监听到队列里面消息，就会触发该方法
    @Override
    public void onMessage(String message) {
        System.out.println(Thread.currentThread().getName()+"消费："+message);
    }
}

