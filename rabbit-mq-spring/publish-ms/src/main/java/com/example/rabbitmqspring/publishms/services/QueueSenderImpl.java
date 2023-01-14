package com.example.rabbitmqspring.publishms.services;

import com.example.rabbitmqspring.publishms.config.QueueProperties;
import com.example.rabbitmqspring.publishms.domain.QueueMessage;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueueSenderImpl implements QueueSender{

    private AmqpTemplate queueTemplate;
    private QueueProperties queueProperties;

    @Autowired
    public QueueSenderImpl(AmqpTemplate queueTemplate, QueueProperties queueProperties) {
        this.queueTemplate = queueTemplate;
        this.queueProperties = queueProperties;
    }

    public void send(QueueMessage message) {
        queueTemplate.convertAndSend(
                queueProperties.getExchange(),
                queueProperties.getRoutingKey(),
                message
        );
    }
}
