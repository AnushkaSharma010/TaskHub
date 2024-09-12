package com.project_task_hub.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project_task_hub.entity.Comments;
import com.project_task_hub.entity.Issues;
import com.project_task_hub.entity.User;
import com.project_task_hub.repository.CommentRepository;
import com.project_task_hub.repository.IssueRepository;
import com.project_task_hub.repository.UserRepository;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private IssueRepository issueRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Comments createComment(Long issueId, Long userId, String commentContent) throws Exception {
		Optional<Issues> issueOp = issueRepository.findById(issueId);
		Optional<User> userOp = userRepository.findById(userId);
		if(issueOp.isEmpty()) {
			throw new Exception("issue not found by issueId: "+ issueId);
		}
		if(userOp.isEmpty()) {
			throw new Exception("user not found by userId: "+ userId);
		}
		
		Issues issue = issueOp.get();
		User user = userOp.get();
		Comments comment = new Comments();
		comment.setContent(commentContent);
		comment.setIssue(issue);
		comment.setCreatedDateTime(LocalDateTime.now());
		comment.setUser(user);
		Comments saveComment = commentRepository.save(comment);
		issue.getComments().add(saveComment);
		
		return saveComment;
	}

	@Override
	public void deleteComment(Long commentId, Long userId) throws Exception {
		Optional<Comments> commentOp = commentRepository.findById(commentId);
		Optional<User> userOp = userRepository.findById(userId);
		if(commentOp.isEmpty()) {
			throw new Exception("comment not found by commentId: "+ commentId);
		}
		if(userOp.isEmpty()) {
			throw new Exception("user not found by userId: "+userId);
		}
		
		Comments comment = commentOp.get();
		User user = userOp.get();
		if(comment.getUser().equals(user)) {
			commentRepository.delete(comment);
		} else {
			throw new Exception("User does not have permission to delete the comment..");
		}
		
	}

	@Override
	public List<Comments> findCommentsByIssueId(Long issueId) throws Exception {
		
		return commentRepository.findByIssueId(issueId);
	}

}
