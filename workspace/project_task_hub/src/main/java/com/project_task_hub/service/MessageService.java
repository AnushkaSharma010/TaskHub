package com.project_task_hub.service;

import java.util.List;

import com.project_task_hub.entity.Messages;

public interface MessageService {

	Messages sendMessage(Long senderId, Long projectId, String content) throws Exception;
	List<Messages> getMessagesByProjectId(Long projectId) throws Exception;
}
