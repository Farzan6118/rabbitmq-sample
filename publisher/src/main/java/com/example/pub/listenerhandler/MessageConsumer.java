package com.example.pub.listenerhandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    private final Logger LOGGER = LoggerFactory.getLogger(MessageConsumer.class);

    public void handleMessage(String message) {
        LOGGER.info("Received: [{}]", message);
    }
}
