package com.example.rabbitmqspring.subscribems.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "queue")
@Getter
@Setter
public class QueueProperties {

    private String name;
    private String exchange;
    private String routingKey;

}
