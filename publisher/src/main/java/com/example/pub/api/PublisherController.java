package com.example.pub.api;

import com.example.pub.model.Contact;
import com.example.pub.send.PubSubPublisher;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Profile("pub_sub")
@RestController
@RequestMapping("/api/v1/publish")
public class PublisherController {
    private final PubSubPublisher pubSubPublisher;

    public PublisherController(PubSubPublisher pubSubPublisher) {
        this.pubSubPublisher = pubSubPublisher;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void PublishMessage(@RequestBody Contact message) {
        pubSubPublisher.publishMessage(message);
    }
}
