package com.project_task_hub.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project_task_hub.entity.Chat;
import com.project_task_hub.entity.Messages;
import com.project_task_hub.entity.User;
import com.project_task_hub.repository.MessageRepository;
import com.project_task_hub.repository.UserRepository;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProjectService projectService;
	
	@Override
	public Messages sendMessage(Long senderId, Long projectId, String content) throws Exception {
		User user = userRepository.findById(senderId).orElseThrow(() -> new Exception("user not found by userId: "+senderId));
		Chat chat = projectService.getProjectById(projectId).getChat();
		
		Messages message = new Messages();
		message.setChat(chat);
		message.setContent(content);
		message.setSender(user);
		message.setCreatedAt(LocalDateTime.now());
		
		Messages saveMessage = messageRepository.save(message);
		chat.getMessages().add(saveMessage);
		return saveMessage;
	}

	@Override
	public List<Messages> getMessagesByProjectId(Long projectId) throws Exception {
	       Chat chat = projectService.getChatByProjectId(projectId);
	       List<Messages> messages = messageRepository.findByChatIdOrderByCreatedAtAsc(chat.getId());
		return messages;
	}

}
