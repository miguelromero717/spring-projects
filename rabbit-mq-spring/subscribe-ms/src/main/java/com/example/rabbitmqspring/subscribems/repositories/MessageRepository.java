package com.example.rabbitmqspring.subscribems.repositories;

import com.example.rabbitmqspring.subscribems.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}

