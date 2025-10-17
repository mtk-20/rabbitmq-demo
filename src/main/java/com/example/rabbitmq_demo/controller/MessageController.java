package com.example.rabbitmq_demo.controller;

import com.example.rabbitmq_demo.publisher.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MessageController {

    private final Producer producer;

    @GetMapping("/publish/{message}")
    public ResponseEntity<?> sendMessage(@PathVariable("message") String message) {
        producer.sendMessage(message);
        return ResponseEntity.ok("Message sent to RabbitMQ . . . ");
    }

}
