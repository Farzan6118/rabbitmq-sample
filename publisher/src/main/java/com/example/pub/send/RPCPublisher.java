package com.example.pub.send;

import com.example.pub.model.Contact;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.amqp.rabbit.RabbitConverterFuture;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Component
@Profile("rpc")
public class RPCPublisher {

    private final AsyncRabbitTemplate asyncRabbitTemplate;
    private final DirectExchange exchange;

    Logger logger = LoggerFactory.getLogger(RPCPublisher.class);

    public RPCPublisher(AsyncRabbitTemplate asyncRabbitTemplate, DirectExchange exchange) {
        this.asyncRabbitTemplate = asyncRabbitTemplate;
        this.exchange = exchange;
    }

    public String sendAndReceiveWithRPC(Contact message) {
        try {
            String jsonMessage = new Gson().toJson(message);
            RabbitConverterFuture<String> contact = asyncRabbitTemplate.convertSendAndReceive(
                    exchange.getName(), "rpc", jsonMessage);
            String response = contact.get(30, TimeUnit.SECONDS);
            logger.info("response: " + response);
            return response;
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}