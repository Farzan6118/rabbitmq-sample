package com.example.pub.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Map;

@Configuration
@Profile("queue")
public class QueueConfig {

    Map<String, Object> streamTypeQueue = Map.of("x-queue-type", "stream");
    Map<String, Object> quorumTypeQueue = Map.of("x-queue-type", "quorum");

    @Bean
    public Queue queue1() {
        return new Queue("queue1", true, false, false, quorumTypeQueue);
    }

    @Bean
    public Queue queue2() {
        return new Queue("queue2", true, false, false, streamTypeQueue);
    }

    @Bean
    public Queue queue3() {
        return new Queue("queue3", true, false, false, streamTypeQueue);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("exchange_test");
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
                .with("routing_key");
    }

    @Bean
    public Binding binding2() {
        return BindingBuilder
                .bind(queue2())
                .to(topicExchange())
                .with("routing_key");
    }

    @Bean
    public Binding binding3() {
        return BindingBuilder
                .bind(queue3())
                .to(topicExchange())
                .with("routing_key");
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
//        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}
