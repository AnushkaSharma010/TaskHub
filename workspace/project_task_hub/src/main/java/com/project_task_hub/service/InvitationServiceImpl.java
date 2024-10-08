package com.project_task_hub.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project_task_hub.entity.Invitation;
import com.project_task_hub.repository.InvitationRepository;

import jakarta.mail.MessagingException;

@Service
@Transactional
public class InvitationServiceImpl implements InvitationService{
	
	@Autowired
	private InvitationRepository invitationRepository;
	
	@Autowired
	private EmailService emailService;
	

	@Override
	public void sendInvitation(String email, Long projectId) throws MessagingException {
		String invitationToken = UUID.randomUUID().toString();
		Invitation invitation = new Invitation();
		invitation.setEmail(email);
		invitation.setProjectID(projectId);
		invitation.setToken(invitationToken);
		
		invitationRepository.save(invitation);
		
		String invitationLink = "http://localhost:3000/accept_invitation?token="+invitationToken;
		emailService.sendEmailWithToken(email, invitationLink);
		
	}

	@Override
	public Invitation acceptInvitation(String token, Long userId) throws Exception {
		Invitation invitation = invitationRepository.findByToken(token);
		if(invitation == null) {
			throw new Exception("Invalid invitation ");
		}
		return invitation;
	}

	@Override
	public String getTokenByUserMail(String userEmail) {
		
		return invitationRepository.findByEmail(userEmail).getToken();
	}

	@Override
	public void deleteToken(String token) {
		Invitation invitation = invitationRepository.findByToken(token);
		invitationRepository.delete(invitation);
		
	}

}
