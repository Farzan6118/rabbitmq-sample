package com.example.rabbitmq.publisher;

import com.example.rabbitmq.model.Contact;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("queue")
public class QueuePublisher {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Profile("queue")
    public void sendMessageInQueue(Contact message, String queueName) {
        rabbitTemplate.convertAndSend(queueName, message);
        System.out.println(" [x] Sent '" + message + "' in '" + queueName + "' queue");
    }
}
