package com.orrs.availabletraininfo.messageQueue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @RabbitListener(queues = MQConfig.TRAINQ)
    public void listener(CustomMessage message){
        System.out.println(message);
    }
}
