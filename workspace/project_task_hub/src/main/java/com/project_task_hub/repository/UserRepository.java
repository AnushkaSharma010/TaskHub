package com.project_task_hub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project_task_hub.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
	
}
