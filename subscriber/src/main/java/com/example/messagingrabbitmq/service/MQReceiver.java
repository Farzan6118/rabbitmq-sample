package com.example.messagingrabbitmq.service;

import camundajar.impl.com.google.gson.Gson;
import com.example.messagingrabbitmq.model.Contact;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MQReceiver {

    @RabbitListener(queues = "${rabbitmq.queueName}")
    public void receiveMessage(String message) {
        Contact convertedObject = new Gson().fromJson(message, Contact.class);
        System.err.println("message received: " + convertedObject.getFirstName());
    }
}