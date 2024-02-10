package com.example.rabbitmq.publisher;

import com.example.rabbitmq.model.Contact;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
@Profile("topics")
public class TopicPublisher {
    private final String[] keys = {
            "quick.orange.rabbit"
            , "lazy.orange.elephant"
            , "quick.orange.fox"
            , "lazy.brown.fox"
            , "lazy.pink.rabbit"
            , "quick.brown.fox"
    };
    private final RabbitTemplate rabbitTemplate;
    AtomicInteger index = new AtomicInteger(0);
    @Value("${spring.topic.exchange.name}")
    private String topic;

    public TopicPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Profile("topics")
    public void sendMessageWithTopic(Contact message) {
        String key = keys[this.index.get()];
        rabbitTemplate.convertAndSend(topic, key, message);
        System.out.println(" [x] Sent '" + message + "' with topic");
    }

}
