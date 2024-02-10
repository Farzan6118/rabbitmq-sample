package com.example.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("queue")
public class QueueConfig {
    @Value("${rabbitmq.exchangeName}")
    private String topicExchange;
    @Value("${rabbitmq.routingKey}")
    private String routingKey;

    @Bean
    public Queue queue1() {
        return new Queue("queue1", false, false, false, null);
    }

    @Bean
    public Queue queue2() {
        return new Queue("queue2", false, false, false, null);
    }

    @Bean
    public Queue queue3() {
        return new Queue("queue3", false, false, false, null);
    }

    // generating Anonymous queues (auto delete queues)


    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(topicExchange);
    }

    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Binding binding1() {
        return BindingBuilder
                .bind(queue1())
                .to(topicExchange())
                .with(routingKey);
    }

    @Bean
    public Binding binding2() {
        return BindingBuilder
                .bind(queue2())
                .to(topicExchange())
                .with(routingKey);
    }

    @Bean
    public Binding binding3() {
        return BindingBuilder
                .bind(queue3())
                .to(topicExchange())
                .with(routingKey);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}
