package com.example.rabbitmq.api;

import com.example.rabbitmq.model.Contact;
import com.example.rabbitmq.publisher.TopicPublisher;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@Profile("topics")
@RestController
@RequestMapping("/api/v1/topic")
public class TopicController {
    private final TopicPublisher TopicPublisher;
    public TopicController(TopicPublisher TopicPublisher) {
        this.TopicPublisher = TopicPublisher;
    }
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void SendInTopic(@RequestBody Contact message) {
        TopicPublisher.sendMessageWithTopic(message);
    }
}
