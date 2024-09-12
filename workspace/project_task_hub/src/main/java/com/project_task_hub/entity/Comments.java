package com.project_task_hub.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Comments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String content;
	
	private LocalDateTime createdDateTime;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Issues issue;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(LocalDateTime localDateTime) {
		this.createdDateTime = localDateTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Issues getIssue() {
		return issue;
	}

	public void setIssue(Issues issue) {
		this.issue = issue;
	}

	@Override
	public int hashCode() {
		return Objects.hash(content, createdDateTime, id, issue, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comments other = (Comments) obj;
		return Objects.equals(content, other.content) && Objects.equals(createdDateTime, other.createdDateTime)
				&& Objects.equals(id, other.id) && Objects.equals(issue, other.issue)
				&& Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Comments [id=" + id + ", content=" + content + ", createdDateTime=" + createdDateTime + ", user=" + user
				+ ", issue=" + issue + "]";
	}
	
	
	
}
