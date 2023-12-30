package com.example.messagingrabbitmq.service;

import com.example.messagingrabbitmq.model.Contact;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MQSender {
    private final Queue queue;
    private final String routingKey;
    private final TopicExchange topicExchange;
    private final RabbitTemplate rabbitTemplate;

    public MQSender(
            @Value("${rabbitmq.routingKey}") String routingKey
            , RabbitTemplate rabbitTemplate
            , TopicExchange topicExchange
            , Queue queue
    ) {
        this.routingKey = routingKey;
        this.rabbitTemplate = rabbitTemplate;
        this.topicExchange = topicExchange;
        this.queue = queue;
    }

    public void sendMessageUsingQueue(Contact message) {
        rabbitTemplate.convertAndSend(queue.getName(), message);
    }

    public void sendMessageUsingTopic(Contact message) {
        rabbitTemplate.convertAndSend(topicExchange.getName(), routingKey, message);
    }
}
