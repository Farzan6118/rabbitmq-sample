package com.example.pub.send;

import com.example.pub.model.Contact;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("pub_sub")
public class PubSubPublisher {
    private final RabbitTemplate rabbitTemplate;


    public PubSubPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Profile("pub_sub")
    public void publishMessage(Contact message) {
        rabbitTemplate.convertAndSend("fanout", "", message);
        System.out.println(" [x] '" + message + "' published");
    }
}
