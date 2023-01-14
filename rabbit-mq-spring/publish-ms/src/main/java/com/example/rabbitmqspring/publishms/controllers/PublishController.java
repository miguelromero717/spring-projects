package com.example.rabbitmqspring.publishms.controllers;

import com.example.rabbitmqspring.publishms.domain.QueueMessage;
import com.example.rabbitmqspring.publishms.services.QueueSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(path = "/publish")
public class PublishController {

    private QueueSender queueSender;

    @Autowired
    public PublishController(QueueSender queueSender) {
        this.queueSender = queueSender;
    }

    @PostMapping(path = "/{name}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> publishMessage(@PathVariable String name) {
        this.queueSender.send(new QueueMessage(name, new Date()));
        return ResponseEntity.ok("Message Published!!!");
    }
}
