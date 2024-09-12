package com.project_task_hub.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Messages {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String content;
	
	private LocalDateTime createdAt;
	
	@ManyToOne
	private User sender;
	
	@ManyToOne
	private Chat chat;

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

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

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

	@Override
	public int hashCode() {
		return Objects.hash(chat, content, createdAt, id, sender);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Messages other = (Messages) obj;
		return Objects.equals(chat, other.chat) && Objects.equals(content, other.content)
				&& Objects.equals(createdAt, other.createdAt) && Objects.equals(id, other.id)
				&& Objects.equals(sender, other.sender);
	}

	@Override
	public String toString() {
		return "Messages [id=" + id + ", content=" + content + ", createdAt=" + createdAt + ", sender=" + sender
				+ ", chat=" + chat + "]";
	}

	

	 
	
}
