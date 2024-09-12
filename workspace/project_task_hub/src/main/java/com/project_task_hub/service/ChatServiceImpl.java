package com.project_task_hub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project_task_hub.entity.Chat;
import com.project_task_hub.repository.ChatRepository;

@Service
@Transactional

public class ChatServiceImpl implements ChatService{

	@Autowired
	private ChatRepository chatRepository;
	
	@Override
	public Chat createChat(Chat chat) {
		// TODO Auto-generated method stub
		return chatRepository.save(chat);
	}

}
