package com.example.pub.api;

import com.example.pub.model.Contact;
import com.example.pub.send.RoutingPublisher;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Profile("routing")
@RestController
@RequestMapping("/api/v1/routing")
public class RoutingController {

    private final RoutingPublisher routingPublisher;

    public RoutingController(RoutingPublisher routingPublisher) {
        this.routingPublisher = routingPublisher;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void SendUsingRouting(@RequestBody Contact message) {
        routingPublisher.sendMessageWithRouting(message);
    }
}
