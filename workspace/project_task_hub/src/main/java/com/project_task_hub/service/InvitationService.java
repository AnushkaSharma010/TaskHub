package com.project_task_hub.service;

import com.project_task_hub.entity.Invitation;

import jakarta.mail.MessagingException;

public interface InvitationService {

	public void sendInvitation(String email, Long projectId) throws MessagingException;
	
	public Invitation acceptInvitation(String token, Long userId) throws Exception;
	
	public String getTokenByUserMail(String userEmail);
	
	public void deleteToken(String token);
	
}
