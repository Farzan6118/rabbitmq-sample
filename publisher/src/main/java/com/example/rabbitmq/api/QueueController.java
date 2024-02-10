package com.example.rabbitmq.api;

import com.example.rabbitmq.model.Contact;
import com.example.rabbitmq.publisher.QueuePublisher;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Profile("queue")
@RestController
@RequestMapping("/api/v1/queue")
public class QueueController {
    private final QueuePublisher queuePublisher;

    public QueueController(QueuePublisher queuePublisher) {
        this.queuePublisher = queuePublisher;
    }

    @RequestMapping(value = "/{queueName}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void sendInQueue(@RequestBody Contact message, @PathVariable String queueName) {
        queuePublisher.sendMessageInQueue(message, queueName);
    }
}