package com.example.rabbitmqspring.subscribems.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "messages")
@Getter
@Setter
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "time")
    @Temporal(TemporalType.DATE)
    private Date time;

    public Message() {
    }

    public Message(String name, Date time) {
        this.name = name;
        this.time = time;
    }

}
