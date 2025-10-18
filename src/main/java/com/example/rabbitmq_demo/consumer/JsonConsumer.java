package com.example.rabbitmq_demo.consumer;

import com.example.rabbitmq_demo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class JsonConsumer {

    private static  final Logger log = LoggerFactory.getLogger(JsonConsumer.class);

    @RabbitListener(queues = {"${rabbitmq.jason.queue.name}"})
    public void jsonConsume(User user) {
        log.info(String.format("Json Message received from %s", user.getName()));
    }

}
