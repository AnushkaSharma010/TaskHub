package com.project_task_hub.request;

import java.util.Objects;

public class CreateCommentRequest {

	private Long issueId;
	private String content;
	public Long getIssueId() {
		return issueId;
	}
	public void setIssueId(Long issueId) {
		this.issueId = issueId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public int hashCode() {
		return Objects.hash(content, issueId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CreateCommentRequest other = (CreateCommentRequest) obj;
		return Objects.equals(content, other.content) && Objects.equals(issueId, other.issueId);
	}
	@Override
	public String toString() {
		return "CreateCommentRequest [issueId=" + issueId + ", content=" + content + "]";
	}
	
	
}
