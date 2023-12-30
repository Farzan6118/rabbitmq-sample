package com.example.messagingrabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    private final String queueName;
    private final String topicExchange;
    private final String routingKey;

    public RabbitMQConfig(
            @Value("${rabbitmq.queueName}") String queueName,
            @Value("${rabbitmq.exchangeName}") String topicExchange,
            @Value("${rabbitmq.routingKey}") String routingKey
    ) {
        this.queueName = queueName;
        this.routingKey = routingKey;
        this.topicExchange = topicExchange;
    }

    @Bean
    public Queue queue() {
        return new Queue(queueName, false);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(topicExchange);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder
                .bind(queue())
                .to(topicExchange())
                .with(routingKey);
    }

}
