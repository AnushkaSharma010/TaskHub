package com.project_task_hub.response;

import java.util.Objects;

public class MessageResponse {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public int hashCode() {
		return Objects.hash(message);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MessageResponse other = (MessageResponse) obj;
		return Objects.equals(message, other.message);
	}

	@Override
	public String toString() {
		return "MessageResponse [message=" + message + "]";
	}
	
	
}
