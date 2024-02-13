package com.example.sub.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("topics")
public class TopicConfig {

    private final List<String> routingKeyList = List.of("*.orange.*", "*.*.rabbit", "lazy.#", "quick.*.fox", "*.*.fox");

    @Bean
    public TopicExchange topic() {
        return new TopicExchange("test.topic");
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
                .with(routingKeyList.getFirst());
    }

    @Bean
    public Binding binding2b(TopicExchange topic,
                             Queue autoDeleteQueue2) {
        return BindingBuilder.bind(autoDeleteQueue2)
                .to(topic)
                .with(routingKeyList.get(1));
    }

    @Bean
    public Binding binding3c(TopicExchange topic,
                             Queue autoDeleteQueue3) {
        return BindingBuilder.bind(autoDeleteQueue3)
                .to(topic)
                .with(routingKeyList.get(2));
    }

    @Bean
    public Binding binding4d(TopicExchange topic,
                             Queue autoDeleteQueue4) {
        return BindingBuilder.bind(autoDeleteQueue4)
                .to(topic)
                .with(routingKeyList.get(3));
    }

    @Bean
    public Binding binding5e(TopicExchange topic,
                             Queue autoDeleteQueue5) {
        return BindingBuilder.bind(autoDeleteQueue5)
                .to(topic)
                .with(routingKeyList.getLast());
    }
}
