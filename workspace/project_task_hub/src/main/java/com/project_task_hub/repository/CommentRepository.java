package com.project_task_hub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project_task_hub.entity.Comments;

public interface CommentRepository extends JpaRepository<Comments, Long> {

	List<Comments> findByIssueId(Long issueId);
}
