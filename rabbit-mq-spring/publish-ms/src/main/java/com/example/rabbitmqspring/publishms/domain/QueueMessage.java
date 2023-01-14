package com.example.rabbitmqspring.publishms.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class QueueMessage {

    private String text;
    private Date date;

}
