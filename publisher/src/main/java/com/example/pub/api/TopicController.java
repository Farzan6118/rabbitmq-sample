package com.example.pub.api;

import com.example.pub.model.Contact;
import com.example.pub.send.TopicPublisher;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Profile("topics")
@RestController
@RequestMapping("/api/v1/topic")
public class TopicController {
    private final com.example.pub.send.TopicPublisher TopicPublisher;

    public TopicController(TopicPublisher TopicPublisher) {
        this.TopicPublisher = TopicPublisher;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void SendInTopic(@RequestBody Contact message) {
        TopicPublisher.sendMessageWithTopic(message);
    }
}
