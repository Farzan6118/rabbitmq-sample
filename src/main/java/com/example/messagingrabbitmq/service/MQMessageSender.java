package com.example.messagingrabbitmq.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MQMessageSender {
    private final String topicExchangeName;
    private final String queueName;
    private final String routingKey;
    private final RabbitTemplate rabbitTemplate;

    public MQMessageSender(
            @Value("${rabbitmq.exchangeName}") String topicExchangeName,
            @Value("${rabbitmq.routingKey}") String routingKey,
            @Value("${rabbitmq.queueName}") String queueName,
            RabbitTemplate rabbitTemplate) {
        this.topicExchangeName = topicExchangeName;
        this.rabbitTemplate = rabbitTemplate;
        this.routingKey = routingKey;
        this.queueName = queueName;
    }

    public String sendMessageUsingQueue(String message) {
        rabbitTemplate.convertAndSend(queueName, message);
        return "Message '" + message +
                "' sent with queueName=" + queueName;
    }

    public String sendMessageUsingTopic(String message) {
        rabbitTemplate.convertAndSend(topicExchangeName, routingKey, message);
        return "Message '" + message +
                "' sent with topicExchangeName='" + topicExchangeName +
                "' and routingKey='" + routingKey + "'";
    }
}
