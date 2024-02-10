package com.example.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("topics")
public class TopicConfig {

    @Value("${spring.topic.exchange.name}")
    private String topic;
    @Value("${spring.topic.routing_key.one}")
    private String routingKeyOne;
    @Value("${spring.topic.routing_key.two}")
    private String routingKeyTwo;
    @Value("${spring.topic.routing_key.three}")
    private String routingKeyThree;
    @Value("${spring.topic.routing_key.four}")
    private String routingKeyFour;
    @Value("${spring.topic.routing_key.five}")
    private String routingKeyFive;

    @Bean
    public TopicExchange topic() {
        return new TopicExchange(topic);
    }

    @Bean
    public Queue autoDeleteQueue1() {
        return new AnonymousQueue();
    }

    @Bean
    public Queue autoDeleteQueue2() {
        return new AnonymousQueue();
    }

    @Bean
    public Queue autoDeleteQueue3() {
        return new AnonymousQueue();
    }

    @Bean
    public Queue autoDeleteQueue4() {
        return new AnonymousQueue();
    }

    @Bean
    public Queue autoDeleteQueue5() {
        return new AnonymousQueue();
    }

    @Bean
    public Binding binding1a(TopicExchange topic,
                             Queue autoDeleteQueue1) {
        return BindingBuilder.bind(autoDeleteQueue1)
                .to(topic)
                .with(routingKeyOne);
    }

    @Bean
    public Binding binding2b(TopicExchange topic,
                             Queue autoDeleteQueue2) {
        return BindingBuilder.bind(autoDeleteQueue2)
                .to(topic)
                .with(routingKeyTwo);
    }

    @Bean
    public Binding binding3c(TopicExchange topic,
                             Queue autoDeleteQueue3) {
        return BindingBuilder.bind(autoDeleteQueue3)
                .to(topic)
                .with(routingKeyThree);
    }

    @Bean
    public Binding binding4d(TopicExchange topic,
                             Queue autoDeleteQueue4) {
        return BindingBuilder.bind(autoDeleteQueue4)
                .to(topic)
                .with(routingKeyFour);
    }

    @Bean
    public Binding binding5e(TopicExchange topic,
                             Queue autoDeleteQueue5) {
        return BindingBuilder.bind(autoDeleteQueue5)
                .to(topic)
                .with(routingKeyFive);
    }
}
