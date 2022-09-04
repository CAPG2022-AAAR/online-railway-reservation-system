package com.orrs.authmicro.messageQueue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @RabbitListener(queues = MQConfig.PRIMARYQ)
    public void listener(CustomMessage message){
        System.out.println(message);
    }
}
