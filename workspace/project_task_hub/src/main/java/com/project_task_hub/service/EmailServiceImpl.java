package com.project_task_hub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
@Transactional
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	
	@Override
	public void sendEmailWithToken(String userEmail, String link) throws MessagingException {
		MimeMessage msg = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg);

		String subj = "Join Project Team Invitation";
		String text = "Click here to join the project team.."+ link;
		
		helper.setSubject(subj);
		helper.setText(text);
		helper.setTo(userEmail);
		
		try {
			javaMailSender.send(msg);
		} 
		catch (MailSendException e) {
			throw new MailSendException("Failed to send email..");
		}
	}

}
