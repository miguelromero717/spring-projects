package com.example.rabbitmqspring.subscribems.controllers;

import com.example.rabbitmqspring.subscribems.domain.Message;
import com.example.rabbitmqspring.subscribems.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/messages")
public class MessagesController {

    private MessageService messageService;

    @Autowired
    public MessagesController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Message>> getMessages() {
        List<Message> list = messageService.getMessages();

        if (list.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(list);
    }

}
