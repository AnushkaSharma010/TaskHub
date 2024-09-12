package com.project_task_hub.service;

import java.util.List;

import com.project_task_hub.entity.Chat;
import com.project_task_hub.entity.Project;
import com.project_task_hub.entity.User;

public interface ProjectService {

	Project createProject(Project project, User user) throws Exception;
	
	void deleteProject(Long projectId, Long userId) throws Exception;
	
	Project updateProject(Project updateProject, Long userId) throws Exception;
	
	void addUserToProject(Long projectId, Long userId) throws Exception;
	
	void removeUserFromProject(Long projectId, Long userId) throws Exception;
	
	Project getProjectById(Long projectId) throws Exception;
	
	List<Project> getProjectByTeam(User user, String category, String tag) throws Exception;
	
	Chat getChatByProjectId(Long projectId) throws Exception;
	
	List<Project> searchProjects(String keyword, User user) throws Exception;
}
