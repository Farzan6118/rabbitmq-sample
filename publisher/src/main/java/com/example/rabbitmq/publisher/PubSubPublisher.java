package com.example.rabbitmq.publisher;

import com.example.rabbitmq.model.Contact;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("pub-sub")
public class PubSubPublisher {
    private final RabbitTemplate rabbitTemplate;

    @Value("${spring.pubsub.fanout.name}")
    private String fanout;


    public PubSubPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Profile("pub-sub")
    public void publishMessage(Contact message) {
        rabbitTemplate.convertAndSend(fanout, "", message);
        System.out.println(" [x] '" + message + "' published");
    }
}
