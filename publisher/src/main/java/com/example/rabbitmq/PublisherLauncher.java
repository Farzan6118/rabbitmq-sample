package com.example.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PublisherLauncher {

    public static void main(String[] args) {
        SpringApplication.run(PublisherLauncher.class, args);
    }

}
