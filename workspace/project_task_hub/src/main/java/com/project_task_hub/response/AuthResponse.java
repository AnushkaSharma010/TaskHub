package com.project_task_hub.response;

import java.util.Objects;

public class AuthResponse {

	private String message;
	private String jwtToken;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getJwtToken() {
		return jwtToken;
	}
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	@Override
	public int hashCode() {
		return Objects.hash(jwtToken, message);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuthResponse other = (AuthResponse) obj;
		return Objects.equals(jwtToken, other.jwtToken) && Objects.equals(message, other.message);
	}
	@Override
	public String toString() {
		return "AuthResponse [message=" + message + ", jwtToken=" + jwtToken + "]";
	}
	
}
