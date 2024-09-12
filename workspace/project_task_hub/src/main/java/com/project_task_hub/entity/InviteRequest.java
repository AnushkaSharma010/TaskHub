package com.project_task_hub.entity;

import java.util.Objects;

public class InviteRequest {

	private Long projectId;
	private String email;
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, projectId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InviteRequest other = (InviteRequest) obj;
		return Objects.equals(email, other.email) && Objects.equals(projectId, other.projectId);
	}
	@Override
	public String toString() {
		return "InviteRequest [projectId=" + projectId + ", email=" + email + "]";
	}
	
	
}
