package com.project_task_hub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project_task_hub.entity.Messages;

public interface MessageRepository extends JpaRepository<Messages, Long> {
	
	List<Messages> findByChatIdOrderByCreatedAtAsc(Long chatId);

}
