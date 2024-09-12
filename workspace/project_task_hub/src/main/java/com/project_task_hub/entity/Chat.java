package com.project_task_hub.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Chat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "chat", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Messages> messages = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany
	private List<User> users = new ArrayList<>();
	
	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}


	@JsonIgnore
	@OneToOne
	private Project project;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Messages> getMessages() {
		return messages;
	}


	public void setMessages(List<Messages> messages) {
		this.messages = messages;
	}


	public Project getProject() {
		return project;
	}


	public void setProject(Project project) {
		this.project = project;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, messages, name, project,users);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chat other = (Chat) obj;
		return Objects.equals(id, other.id) && Objects.equals(messages, other.messages)
				&& Objects.equals(name, other.name) && Objects.equals(project, other.project)&& Objects.equals(users, other.users);
	}


	@Override
	public String toString() {
		return "Chat [id=" + id + ", name=" + name + ", messages=" + messages + ", project=" + project + ",users="+ users +"]";
	}

	
	
}
