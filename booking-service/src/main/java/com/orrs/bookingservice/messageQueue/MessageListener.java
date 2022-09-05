package com.orrs.bookingservice.messageQueue;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @RabbitListener(queues = MQConfig.TICKETQ)
    public void listener(CustomMessage message){
        System.out.println(message);
    }
}
