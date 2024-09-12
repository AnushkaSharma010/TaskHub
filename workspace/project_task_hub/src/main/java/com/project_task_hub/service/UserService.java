package com.project_task_hub.service;

import com.project_task_hub.entity.User;

public interface UserService {

	User findUserProfileByJwt(String jwt) throws Exception;
	User findUserById(Long userId) throws Exception;
	User findUserByEmailId(String email) throws Exception;
	User updateUserProjectSize(User user, int number) throws Exception;
}
