package com.project_task_hub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project_task_hub.entity.Chat;
import com.project_task_hub.entity.Messages;
import com.project_task_hub.entity.User;
import com.project_task_hub.request.CreateMessageRequest;
import com.project_task_hub.service.MessageService;
import com.project_task_hub.service.ProjectService;
import com.project_task_hub.service.UserService;

@RestController
@RequestMapping("/messages")
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProjectService projectService;
	
	@PostMapping("/send")
	public ResponseEntity<Messages> createMessage(@RequestBody CreateMessageRequest messageReq) throws Exception{
		
		User user = userService.findUserById(messageReq.getSenderId());
		if(user == null) {
			throw new Exception("user not found with userId: "+messageReq.getSenderId());
		}
		
		Chat chat = projectService.getProjectById(messageReq.getProjectId()).getChat();
		if(chat == null) {
			throw new Exception("chat not found..");
		}
		
		Messages msg = messageService.sendMessage(messageReq.getSenderId(), messageReq.getProjectId(), messageReq.getContent());
		
		return new ResponseEntity<Messages>(msg,HttpStatus.OK);
		
	}
	
	@GetMapping("/chat/{projectId}")
	public ResponseEntity<List<Messages>> getMessagesByChatId(@PathVariable Long projectId) throws Exception{
		List<Messages> msg = messageService.getMessagesByProjectId(projectId);
		return new ResponseEntity<List<Messages>>(msg,HttpStatus.OK);
	}

}
