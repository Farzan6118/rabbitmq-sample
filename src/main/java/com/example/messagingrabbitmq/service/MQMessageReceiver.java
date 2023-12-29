package com.example.messagingrabbitmq.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MQMessageReceiver {

    @RabbitListener(queues = "${rabbitmq.queueName}")
    public void receiveMessage(String message) {
        System.err.println("Message received: " + message);
    }
}
