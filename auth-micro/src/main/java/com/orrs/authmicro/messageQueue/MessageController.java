package com.orrs.authmicro.messageQueue;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/publish")
public class MessageController {


    @Autowired
    private RabbitTemplate rabbitTemplate;


    @PostMapping("/ticket-message")
    public String ticketMessagePublisher(@RequestBody CustomMessage customMessage){
        customMessage.setMessageId(UUID.randomUUID().toString());
        customMessage.setMessageDate(new Date());
        customMessage.setMessage("Hello to fellow ticket exchanges and queues");
        rabbitTemplate.convertAndSend(MQConfig.TICKETE,
                MQConfig.TICKET_MESSAGE_ROUTING_KEY,
                customMessage);
        return "Message Published";
    }

    @PostMapping("/payment-message")
    public String paymentMessagePublisher(@RequestBody CustomMessage customMessage){
        customMessage.setMessageId(UUID.randomUUID().toString());
        customMessage.setMessageDate(new Date());
        customMessage.setMessage("Hello to fellow payment exchanges and queues");
        rabbitTemplate.convertAndSend(MQConfig.PAYMENTE,
                MQConfig.PAYMENT_MESSAGE_ROUTING_KEY,
                customMessage);
        return "Message Published";
    }

    @PostMapping("/train-message")
    public String trainMessagePublisher(@RequestBody CustomMessage customMessage){
        customMessage.setMessageId(UUID.randomUUID().toString());
        customMessage.setMessageDate(new Date());
        customMessage.setMessage("Hello to fellow train exchanges and queues");
        rabbitTemplate.convertAndSend(MQConfig.TRAINE,
                MQConfig.TRAIN_MESSAGE_ROUTING_KEY,
                customMessage);
        return "Message Published";
    }
}
