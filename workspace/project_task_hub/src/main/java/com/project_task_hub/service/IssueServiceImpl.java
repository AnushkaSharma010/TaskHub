package com.project_task_hub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project_task_hub.entity.Issues;
import com.project_task_hub.entity.Project;
import com.project_task_hub.entity.User;
import com.project_task_hub.repository.IssueRepository;
import com.project_task_hub.request.IssueRequest;




@Service
@Transactional
public class IssueServiceImpl implements IssueService {

	@Autowired
	private IssueRepository issueRepository;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private UserService userService;
	
	@Override
	public Issues getIssueById(Long issueId) throws Exception {
		Optional<Issues> issue = issueRepository.findById(issueId);
		if(issue.isPresent()) {
			return issue.get();
		}
		throw new Exception("No issue found by issueId: "+ issueId);
	}

	@Override
	public List<Issues> getIssueByProjectId(Long projectId) throws Exception {
	
		return issueRepository.findByProjectId(projectId);
	}

	@Override
	public Issues createIssue(IssueRequest issueRequest, User user) throws Exception {
		Project project = projectService.getProjectById(issueRequest.getProjectID());
		Issues issue = new Issues();
		issue.setTitle(issueRequest.getTitle());
		issue.setPriority(issueRequest.getPriority());
		issue.setDescription(issueRequest.getDescription());
		issue.setDueDate(issueRequest.getDueDate());
		issue.setProjectID(issueRequest.getProjectID());
		issue.setStatus(issueRequest.getStatus());
		issue.setProject(project);
		
		return issueRepository.save(issue);
	}

	@Override
	public void deleteIssue(Long issueId, Long userId) throws Exception {
	
		issueRepository.deleteById(issueId);
		
	}

	@Override
	public Issues addUserToIssue(Long issueId, Long userId) throws Exception {
		Issues issue = getIssueById(issueId);
		User user = userService.findUserById(userId);
		issue.setAssignee(user);
		return issueRepository.save(issue);
	}

	@Override
	public Issues updateIssueStatus(Long issueId, String status) throws Exception {
		Issues issue = getIssueById(issueId);
		issue.setStatus(status);
		return issueRepository.save(issue);
	}

}
