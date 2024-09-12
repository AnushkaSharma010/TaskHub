package com.project_task_hub.request;

import java.util.Objects;

public class CreateMessageRequest {

	private Long senderId;
	
	private String content;
	
	private Long projectId;

	public Long getSenderId() {
		return senderId;
	}

	public void setSenderId(Long senderId) {
		this.senderId = senderId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(content, projectId, senderId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreateMessageRequest other = (CreateMessageRequest) obj;
		return Objects.equals(content, other.content) && Objects.equals(projectId, other.projectId)
				&& Objects.equals(senderId, other.senderId);
	}

	@Override
	public String toString() {
		return "CreateMessageRequest [senderId=" + senderId + ", content=" + content + ", projectId=" + projectId + "]";
	}
	
	
}
