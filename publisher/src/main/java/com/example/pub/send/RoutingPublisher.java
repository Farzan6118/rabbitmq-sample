package com.example.pub.send;

import com.example.pub.model.Contact;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("routing")
public class RoutingPublisher {
    private final RabbitTemplate rabbitTemplate;
    private final DirectExchange directExchange;
    private final String[] keys = {"orange", "black", "green"};

    public RoutingPublisher(RabbitTemplate rabbitTemplate, DirectExchange directExchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.directExchange = directExchange;
    }

    public void sendMessageWithRouting(Contact message) {
        for (String key : keys) {
            rabbitTemplate.convertAndSend(directExchange.getName(), key, message);
            System.out.println(" [x] Sent message '" + message + "' with routingKey: " + key);
        }
    }
}
