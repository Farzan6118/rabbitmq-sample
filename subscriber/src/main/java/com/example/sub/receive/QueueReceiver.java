package com.example.sub.receive;

import com.example.sub.model.Contact;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("queue")
public class QueueReceiver {

    @RabbitListener(queues = "queue1")
    public void receiveMessage1(String message) {
        Contact convertedObject = new Gson().fromJson(message, Contact.class);
        System.err.println("queue message " + convertedObject + " received in 'queue1'");
    }

    @RabbitListener(queues = "queue2")
    public void receiveMessage2(String message) {
        Contact convertedObject = new Gson().fromJson(message, Contact.class);
        System.err.println("queue message " + convertedObject + " received in 'queue2'");
    }

    @RabbitListener(queues = "queue3")
    public void receiveMessage3(String message) {
        Contact convertedObject = new Gson().fromJson(message, Contact.class);
        System.err.println("queue message " + convertedObject + " received in 'queue3'");
    }
}