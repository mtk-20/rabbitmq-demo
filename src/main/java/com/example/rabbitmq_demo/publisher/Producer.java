package com.example.rabbitmq_demo.publisher;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Producer {

    private final RabbitTemplate rabbitTemplate;

    private static final Logger log = LoggerFactory.getLogger(Producer.class);

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${rabbitmq.routing_key.name}")
    private String routingKey;

    public void sendMessage(String message) {
        log.info(String.format("Message sent to %s", message));
        rabbitTemplate.convertAndSend(exchangeName, routingKey, message);
    }
}
