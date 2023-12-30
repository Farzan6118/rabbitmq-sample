package com.example.messagingrabbitmq.api;

import com.example.messagingrabbitmq.model.Contact;
import com.example.messagingrabbitmq.service.MQSender;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageController {
    private final MQSender MQSender;

    public MessageController(MQSender MQSender) {
        this.MQSender = MQSender;
    }

    @RequestMapping(value = "/sendWithQueue", method = RequestMethod.GET)
    public String sendWithQueue(@RequestBody Contact message) {
        MQSender.sendMessageUsingQueue(message);
        return "";
    }

    @RequestMapping(value = "/sendWithTopic", method = RequestMethod.GET)
    public String sendWithTopic(@RequestBody Contact message) {
        MQSender.sendMessageUsingTopic(message);
        return "";
    }
}
