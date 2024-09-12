package com.project_task_hub.request;

import java.time.LocalDate;
import java.util.Objects;

public class IssueRequest {

    private String title;
	
	private String description;
	
	private String status;
	
	private String priority;
	
	private Long projectID;
	
	private LocalDate dueDate;

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

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Long getProjectID() {
		return projectID;
	}

	public void setProjectID(Long projectID) {
		this.projectID = projectID;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, dueDate, priority, projectID, status, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IssueRequest other = (IssueRequest) obj;
		return Objects.equals(description, other.description) && Objects.equals(dueDate, other.dueDate)
				&& Objects.equals(priority, other.priority) && Objects.equals(projectID, other.projectID)
				&& Objects.equals(status, other.status) && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "IssueRequest [title=" + title + ", description=" + description + ", status=" + status + ", priority="
				+ priority + ", projectID=" + projectID + ", dueDate=" + dueDate + "]";
	}
	
	
}
