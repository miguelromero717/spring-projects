package com.example.rabbitmqspring.publishms.services;

import com.example.rabbitmqspring.publishms.domain.QueueMessage;

public interface QueueSender {

    void send(QueueMessage message);

}
