package com.project_task_hub.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String description;
	
	private String category;
	
	@ElementCollection
	private List<String> tags = new ArrayList<>();


	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public List<User> getTeam() {
		return team;
	}

	public void setTeam(List<User> team) {
		this.team = team;
	}

	@JsonIgnore
	@OneToOne(mappedBy = "project",cascade = CascadeType.ALL, orphanRemoval = true)
	private Chat chat;

	@ManyToOne
	private User owner;
	
	@OneToMany(mappedBy = "project",cascade = CascadeType.ALL, orphanRemoval = true)
	List<Issues> issues = new ArrayList<>();
	
	@ManyToMany
	List<User> team = new ArrayList<>();
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

	
	
	
	
	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public List<Issues> getIssues() {
		return issues;
	}

	public void setIssues(List<Issues> issues) {
		this.issues = issues;
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, chat, description, id, issues, name, owner, tags, team);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		return Objects.equals(category, other.category) && Objects.equals(chat, other.chat)
				&& Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(issues, other.issues) && Objects.equals(name, other.name)
				&& Objects.equals(owner, other.owner) && Objects.equals(tags, other.tags)
				&& Objects.equals(team, other.team);
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", description=" + description + ", category=" + category
				+ ", tags=" + tags + ", chat=" + chat + ", owner=" + owner + ", issues=" + issues + ", team=" + team
				+ "]";
	}

	
	
}
