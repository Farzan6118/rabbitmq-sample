package com.example.pub.send;

import com.example.pub.model.Contact;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("queue")
public class QueuePublisher {
    private final RabbitTemplate rabbitTemplate;

    public QueuePublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessageInQueue(Contact message, String queueName) {
        String convertedObject = new Gson().toJson(message);
        rabbitTemplate.convertAndSend(queueName, convertedObject);
        System.out.println(" [x] Sent '" + message + "' in '" + queueName + "' queue");
    }
}
