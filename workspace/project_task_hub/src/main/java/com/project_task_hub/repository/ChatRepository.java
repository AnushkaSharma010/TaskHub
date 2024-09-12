package com.project_task_hub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project_task_hub.entity.Chat;

public interface ChatRepository extends JpaRepository<Chat, Long> {

}
