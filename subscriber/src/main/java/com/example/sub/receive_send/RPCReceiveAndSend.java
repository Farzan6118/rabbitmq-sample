package com.example.sub.receive_send;

import com.example.sub.model.Contact;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("rpc")
public class RPCReceiveAndSend {

    Logger logger = LoggerFactory.getLogger(RPCReceiveAndSend.class);
    @RabbitListener(queues = "tut.rpc.requests")
    public String receiveMessage(String message) {
        Gson gson = new Gson();
        logger.info(message + " received: ");
        Contact convertedObject = gson.fromJson(String.valueOf(message), Contact.class);
        convertedObject.setPhoneNumber(20 + convertedObject.getPhoneNumber());
        convertedObject.setFirstName("sir " + convertedObject.getFirstName());
        String response = gson.toJson(convertedObject);
        logger.info(response + " converted and sent back: ");
        return response;
    }
}