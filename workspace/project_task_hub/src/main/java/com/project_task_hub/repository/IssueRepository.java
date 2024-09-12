package com.project_task_hub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project_task_hub.entity.Issues;

public interface IssueRepository extends JpaRepository<Issues, Long> {

	List<Issues> findByProjectId(Long id);
	
	
}
