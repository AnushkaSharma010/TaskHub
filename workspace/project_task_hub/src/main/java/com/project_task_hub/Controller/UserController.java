package com.project_task_hub.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project_task_hub.entity.User;
import com.project_task_hub.service.UserService;

@RestController
@RequestMapping("api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/profile")
	public ResponseEntity<User> getUserProfile(@RequestHeader("Authorization") String jwt) throws Exception{
		User user = userService.findUserProfileByJwt(jwt);
		if(user == null) {
			throw new Exception("can not get profile of user");
		}
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}

}
