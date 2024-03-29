package com.example.sub.receive;

import com.example.sub.model.Contact;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("pub_sub")
public class PublishReceiver {

    @RabbitListener(queues = "#{autoDeleteQueue1.name}")
    public void receive1(String message) {
        Contact convertedObject = new Gson().fromJson(message, Contact.class);
        System.err.println("pub_sub message " + convertedObject + " received from queue1");
    }

    @RabbitListener(queues = "#{autoDeleteQueue2.name}")
    public void receive2(String message) {
        Contact convertedObject = new Gson().fromJson(message, Contact.class);
        System.err.println("pub_sub message " + convertedObject + " received from queue2");
    }

    @RabbitListener(queues = "#{autoDeleteQueue3.name}")
    public void receive3(String message) {
        Contact convertedObject = new Gson().fromJson(message, Contact.class);
        System.err.println("pub_sub message " + convertedObject + " received from queue3");
    }
}