package com.example.sub.receive;

import com.example.sub.model.Contact;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("topics")
public class TopicReceiver {

    @RabbitListener(queues = "#{autoDeleteQueue1.name}")
    public void receiveMessage1(String message) {
        Contact convertedObject = new Gson().fromJson(message, Contact.class);
        System.err.println("topic message " + convertedObject + " received in 'queue1'");
    }

    @RabbitListener(queues = "#{autoDeleteQueue2.name}")
    public void receiveMessage2(String message) {
        Contact convertedObject = new Gson().fromJson(message, Contact.class);
        System.err.println("topic message " + convertedObject + " received in 'queue2'");
    }

    @RabbitListener(queues = "#{autoDeleteQueue3.name}")
    public void receiveMessage3(String message) {
        Contact convertedObject = new Gson().fromJson(message, Contact.class);
        System.err.println("topic message " + convertedObject + " received in 'queue3'");
    }

    @RabbitListener(queues = "#{autoDeleteQueue4.name}")
    public void receiveMessage4(String message) {
        Contact convertedObject = new Gson().fromJson(message, Contact.class);
        System.err.println("topic message " + convertedObject + " received in 'queue4'");
    }

    @RabbitListener(queues = "#{autoDeleteQueue5.name}")
    public void receiveMessage5(String message) {
        Contact convertedObject = new Gson().fromJson(message, Contact.class);
        System.err.println("topic message " + convertedObject + " received in 'queue5'");
    }
}