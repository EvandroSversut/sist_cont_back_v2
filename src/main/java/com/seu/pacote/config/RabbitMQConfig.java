package com.seu.pacote.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_NAME = "testeQueue";
    public static final String EXCHANGE_NAME = "testeExchange";
    public static final String ROUTING_KEY = "testeKey";

    @Bean
    public Queue testeQueue() {
        return new Queue(QUEUE_NAME, true);
    }

    @Bean
    public DirectExchange testeExchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding testeBinding(Queue testeQueue, DirectExchange testeExchange) {
        return BindingBuilder.bind(testeQueue).to(testeExchange).with(ROUTING_KEY);
    }
}

