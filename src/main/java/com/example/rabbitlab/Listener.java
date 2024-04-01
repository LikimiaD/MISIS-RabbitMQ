package com.example.rabbitlab;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class Listener {
    @RabbitListener(queues = "TolochikIgor-fanout-queue-2103829")
    public void receiveMessageFromFanoutQueue(String message) {
        System.out.printf("%s %s | Received from fanout queue: %s\n", LocalDate.now(), LocalTime.now(), message);
    }

    @RabbitListener(queues = "TolochikIgor-direct-queue-2103829")
    public void receiveMessageFromDirectQueue(String message) {
        System.out.printf("%s %s | Received from direct queue: %s\n", LocalDate.now(), LocalTime.now(), message);
    }
}
