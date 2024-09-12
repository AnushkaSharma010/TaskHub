package com.project_task_hub.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.project_task_hub.entity.Project;
import com.project_task_hub.entity.User;

public class IssueDTO {

	private Long id;
	private String title;
	private String description;
	private String status;
	private Long projectId;
	private String priority;
	private LocalDate dueDate;
	private List<String> tags = new ArrayList<>();
	private Project project;
	private User assignee;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public User getAssignee() {
		return assignee;
	}
	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}
	@Override
	public int hashCode() {
		return Objects.hash(assignee, description, dueDate, id, priority, project, projectId, status, tags, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IssueDTO other = (IssueDTO) obj;
		return Objects.equals(assignee, other.assignee) && Objects.equals(description, other.description)
				&& Objects.equals(dueDate, other.dueDate) && Objects.equals(id, other.id)
				&& Objects.equals(priority, other.priority) && Objects.equals(project, other.project)
				&& Objects.equals(projectId, other.projectId) && Objects.equals(status, other.status)
				&& Objects.equals(tags, other.tags) && Objects.equals(title, other.title);
	}
	@Override
	public String toString() {
		return "IssueDTO [id=" + id + ", title=" + title + ", description=" + description + ", status=" + status
				+ ", projectId=" + projectId + ", priority=" + priority + ", dueDate=" + dueDate + ", tags=" + tags
				+ ", project=" + project + ", assignee=" + assignee + "]";
	}
	
	
}
