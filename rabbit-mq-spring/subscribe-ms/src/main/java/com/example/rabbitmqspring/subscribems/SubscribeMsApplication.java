package com.example.rabbitmqspring.subscribems;

import com.example.rabbitmqspring.subscribems.config.QueueProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        QueueProperties.class
})
public class SubscribeMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SubscribeMsApplication.class, args);
    }

}
