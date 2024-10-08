package com.project_task_hub.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project_task_hub.config.JwtProvider;
import com.project_task_hub.entity.User;
import com.project_task_hub.repository.UserRepository;

@Service
@Transactional

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Override
	public User findUserProfileByJwt(String jwt) throws Exception {
		String email =JwtProvider.getEmailFromToken(jwt);
		return findUserByEmailId(email);
	}

	@Override
	public User findUserById(Long userId) throws Exception {
		Optional<User> opUser = userRepository.findById(userId);
		if(opUser.isEmpty()) {
			throw new Exception("user not found");
		}
		return opUser.get();
	}

	@Override
	public User findUserByEmailId(String email) throws Exception {
		User user = userRepository.findByEmail(email);
		if(user == null) {
			throw new Exception("user not found");
		}
		return user;
	}

	@Override
	public User updateUserProjectSize(User user, int number) throws Exception {
		user.setProjectSize(user.getProjectSize()+number);
		return userRepository.save(user);
	}

}
