package com.project_task_hub.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String fullName;
	
	private String email;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	
	private int projectSize;
	
	@JsonIgnore
	@OneToMany(mappedBy = "assignee", cascade = CascadeType.ALL)
	private List<Issues> assignedIssues = new ArrayList<>();
//	@ManyToOne
//	private Chat chat;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getProjectSize() {
		return projectSize;
	}

	public void setProjectSize(int projectSize) {
		this.projectSize = projectSize;
	}

	public List<Issues> getAssignedIssues() {
		return assignedIssues;
	}

	public void setAssignedIssues(List<Issues> assignedIssues) {
		this.assignedIssues = assignedIssues;
	}

	@Override
	public int hashCode() {
		return Objects.hash(assignedIssues, email, fullName, id, password, projectSize);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(assignedIssues, other.assignedIssues) && Objects.equals(email, other.email)
				&& Objects.equals(fullName, other.fullName) && Objects.equals(id, other.id)
				&& Objects.equals(password, other.password) && projectSize == other.projectSize;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", fullName=" + fullName + ", email=" + email + ", password=" + password
				+ ", projectSize=" + projectSize + ", assignedIssues=" + assignedIssues + "]";
	}
	
	
	
	
}
