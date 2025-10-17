package com.example.rabbitmq_demo.controller;

import com.example.rabbitmq_demo.model.User;
import com.example.rabbitmq_demo.publisher.JsonProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/json")
public class JsonController {

    private final JsonProducer producer;

    @PostMapping("/publish")
    public ResponseEntity<?> sendJsonMessage(@RequestBody User user) {
        producer.sendMessage(user);
        return ResponseEntity.ok("Json message sent to >>> " + user.getName());
    }
}
