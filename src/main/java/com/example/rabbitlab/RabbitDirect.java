package com.example.rabbitlab;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitDirect {

    final static String directExchangeName = "TolochikIgor-direct-exchange-2103829";
    final static String directQueueName = "TolochikIgor-direct-queue-2103829";
    final static String routingKey = "2103829";

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(directExchangeName);
    }

    @Bean
    Queue directQueue() {
        return new Queue(directQueueName, true);
    }

    @Bean
    Binding directBinding(Queue directQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue).to(directExchange).with(routingKey);
    }
}