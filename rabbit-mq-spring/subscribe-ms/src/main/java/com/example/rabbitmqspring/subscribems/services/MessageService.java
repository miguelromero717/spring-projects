package com.example.rabbitmqspring.subscribems.services;

import com.example.rabbitmqspring.subscribems.domain.Message;

import java.util.List;

public interface MessageService {

    Message save(Message message);

    List<Message> getMessages();

}

