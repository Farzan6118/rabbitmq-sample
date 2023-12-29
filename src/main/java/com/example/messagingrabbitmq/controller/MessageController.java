package com.example.messagingrabbitmq.controller;

import com.example.messagingrabbitmq.service.MQMessageSender;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class MessageController {
    private final MQMessageSender MQMessageSender;

    public MessageController(MQMessageSender MQMessageSender) {
        this.MQMessageSender = MQMessageSender;
    }

    @GetMapping("/sendWithQueue")
    public ResponseEntity<String> sendWithQueue(@RequestBody Map<String, String> message) {
        return ResponseEntity.ok(MQMessageSender.sendMessageUsingQueue(message.get("message")));
    }

    @GetMapping("/sendWithTopic")
    public ResponseEntity<String> sendWithTopic(@RequestBody Map<String, String> message) {
        return ResponseEntity.ok(MQMessageSender.sendMessageUsingTopic(message.get("message")));
    }

}
