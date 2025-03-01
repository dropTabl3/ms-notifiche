package com.traction.msnotifiche.service;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationProducer {

    private final RabbitTemplate rabbitTemplate;
    private final Queue notificationQueue;
    @Autowired
    public NotificationProducer(RabbitTemplate rabbitTemplate, Queue notificationQueue) {
        this.rabbitTemplate = rabbitTemplate;
        this.notificationQueue = notificationQueue;
    }

    public void sendNotification(String message) {
        rabbitTemplate.convertAndSend(notificationQueue.getName(), message);
    }
}