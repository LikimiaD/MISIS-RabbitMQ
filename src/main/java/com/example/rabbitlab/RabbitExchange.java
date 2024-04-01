package com.example.rabbitlab;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.CommandLineRunner;

@Configuration
public class RabbitExchange {

    final static String fanoutExchange = "TolochikIgor-fanout-exchange-2103829";
    final static String fanoutQueue = "TolochikIgor-fanout-queue-2103829";

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(fanoutExchange);
    }

    @Bean
    Queue fanoutQueue() {
        return new Queue(fanoutQueue, true);
    }

    @Bean
    Binding fanoutBinding(Queue fanoutQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue).to(fanoutExchange);
    }
}