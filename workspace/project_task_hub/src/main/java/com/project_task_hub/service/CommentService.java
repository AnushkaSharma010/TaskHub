package com.project_task_hub.service;

import java.util.List;

import com.project_task_hub.entity.Comments;

public interface CommentService {

	Comments createComment(Long issueId, Long userId, String commentContent) throws Exception;
	void deleteComment(Long commentId, Long userId) throws Exception;
	List<Comments> findCommentsByIssueId(Long issueId) throws Exception;
}
