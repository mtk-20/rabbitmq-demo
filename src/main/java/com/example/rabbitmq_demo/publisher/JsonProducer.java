package com.example.rabbitmq_demo.publisher;

import com.example.rabbitmq_demo.model.User;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JsonProducer {

    private final RabbitTemplate rabbitTemplate;

    private static final Logger log = LoggerFactory.getLogger(Producer.class);

    @Value("${rabbitmq.json.routing_key.name}")
    private String jsonRoutingKey;

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    public void sendJsonMessage(User user) {
        log.info(String.format("Message sent to >>> %s", user.getName()));
        rabbitTemplate.convertAndSend(exchangeName, jsonRoutingKey, user);
    }
}
