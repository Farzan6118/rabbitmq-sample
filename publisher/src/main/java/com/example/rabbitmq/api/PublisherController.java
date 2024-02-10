package com.example.rabbitmq.api;

import com.example.rabbitmq.model.Contact;
import com.example.rabbitmq.publisher.PubSubPublisher;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Profile("pub-sub")
@RestController
@RequestMapping("/api/v1/publish")
public class PublisherController {
    private final PubSubPublisher pubSubPublisher;

    public PublisherController(PubSubPublisher pubSubPublisher) {
        this.pubSubPublisher = pubSubPublisher;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void PublishMessage(@RequestBody Contact message) {
        pubSubPublisher.publishMessage(message);
    }
}
