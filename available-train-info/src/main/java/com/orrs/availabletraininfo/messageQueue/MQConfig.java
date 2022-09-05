package com.orrs.availabletraininfo.messageQueue;



import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {

    public static final String PRIMARY_MESSAGE_ROUTING_KEY = "primary message routing key";
    public static final String TICKET_MESSAGE_ROUTING_KEY = "ticket message routing key";
    public static final String PAYMENT_MESSAGE_ROUTING_KEY = "payment message routing key";
    public static final String TRAIN_MESSAGE_ROUTING_KEY = "train message routing key";
    public static final String TICKETQ = "Ticketq";
    public static final String PAYMENTQ = "Paymentq";
    public static final String TRAINQ = "Trainq";
    public static final String PRIMARYQ = "Primaryq";
    public static final String TICKETE = "Tickete";
    public static final String PAYMENTE = "Paymente";
    public static final String TRAINE = "Traine";
    public static final String PRIMARYE = "Primarye";

    @Bean
    public Queue ticketQueue(){
        return new Queue(TICKETQ);
    }

    @Bean
    public Queue paymentQueue(){
        return new Queue(PAYMENTQ);
    }

    @Bean
    public Queue trainQueue(){
        return new Queue(TRAINQ);
    }

    @Bean
    public Queue primaryQueue(){
        return new Queue(PRIMARYQ);
    }
    @Bean
    public TopicExchange ticketExchange(){
        return new TopicExchange(TICKETE);
    }
    @Bean
    public TopicExchange paymentExchange(){
        return new TopicExchange(PAYMENTE);
    }
    @Bean
    public TopicExchange trainExchange(){
        return new TopicExchange(TRAINE);
    }
    @Bean
    public TopicExchange primaryExchange(){
        return new TopicExchange(PRIMARYE);
    }
    @Bean
    public Binding bindingPrimary(Queue primaryQueue, TopicExchange primaryExchange){
        return BindingBuilder
                .bind(primaryQueue)
                .to(primaryExchange)
                .with(PRIMARY_MESSAGE_ROUTING_KEY);
    }
    @Bean
    public Binding bindingTicket(Queue ticketQueue, TopicExchange ticketExchange){
        return BindingBuilder
                .bind(ticketQueue)
                .to(ticketExchange)
                .with(TICKET_MESSAGE_ROUTING_KEY);
    }
    @Bean
    public Binding bindingPayment(Queue paymentQueue, TopicExchange paymentExchange){
        return BindingBuilder
                .bind(paymentQueue)
                .to(paymentExchange)
                .with(PAYMENT_MESSAGE_ROUTING_KEY);
    }
    @Bean
    public Binding bindingTrain(Queue trainQueue , TopicExchange trainExchange){
        return BindingBuilder
                .bind(trainQueue)
                .to(trainExchange)
                .with(TRAIN_MESSAGE_ROUTING_KEY);
    }

    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory){
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }

}
