package com.example.pub.send;

import com.example.pub.model.Contact;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
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

    public TopicPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessageWithTopic(Contact message) {
        String key = keys[this.index.get()];
        rabbitTemplate.convertAndSend("test.topic", key, message);
        System.out.println(" [x] Sent '" + message + "' with topic");
    }

}
