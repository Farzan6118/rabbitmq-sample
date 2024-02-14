package com.example.sub.config;

import org.springframework.amqp.core.Queue;
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

}
