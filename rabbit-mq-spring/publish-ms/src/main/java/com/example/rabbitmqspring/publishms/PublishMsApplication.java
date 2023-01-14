package com.example.rabbitmqspring.publishms;

import com.example.rabbitmqspring.publishms.config.QueueProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        QueueProperties.class
})
public class PublishMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PublishMsApplication.class, args);
    }

}
