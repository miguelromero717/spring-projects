package com.example.rabbitmqspring.subscribems.services;

import com.example.rabbitmqspring.subscribems.domain.Message;
import com.example.rabbitmqspring.subscribems.domain.QueueMessage;
import com.example.rabbitmqspring.subscribems.repositories.MessageRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public List<Message> getMessages() {
        return messageRepository.findAll();
    }

    @RabbitListener(queues = "${queue.name}")
    public void readMessage(QueueMessage message) {
        Message mes = new Message(message.getText(), message.getDate());
        save(mes);
    }

    @Override
    public Message save(Message message) {
        return messageRepository.save(message);
    }
}