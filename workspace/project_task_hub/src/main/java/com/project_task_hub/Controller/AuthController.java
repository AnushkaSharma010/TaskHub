package com.project_task_hub.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project_task_hub.config.JwtProvider;
import com.project_task_hub.entity.User;
import com.project_task_hub.repository.UserRepository;
import com.project_task_hub.request.LoginRequest;
import com.project_task_hub.response.AuthResponse;
import com.project_task_hub.service.CustomUserDetaiIsImpl;

@RestController
@RequestMapping("api/auth")
public class AuthController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private CustomUserDetaiIsImpl customUserDetails;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/signUp")
	
	public ResponseEntity<AuthResponse> createUser(@RequestBody User user) throws Exception{
		User isUserExist = userRepository.findByEmail(user.getEmail());
		if(isUserExist != null) {
			throw new Exception("Email already exist with another account");
		}
		User newUser = new User();
		newUser.setFullName(user.getFullName());
		newUser.setEmail(user.getEmail());
		newUser.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(newUser);
		Authentication authenticate = new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword());
		SecurityContextHolder.getContext().setAuthentication(authenticate);
		String jwt = JwtProvider.generateToken(authenticate);
		AuthResponse response = new AuthResponse();
		response.setMessage("signUp successfull..");
		response.setJwtToken(jwt);
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}

	@PostMapping("/signIn")
    public ResponseEntity<AuthResponse> signIn(@RequestBody LoginRequest loginRequest){
		
		String username = loginRequest.getEmail();
		String password = loginRequest.getPassword();
		Authentication authenticate =authenticate(username,password);
		SecurityContextHolder.getContext().setAuthentication(authenticate);
		String jwt = JwtProvider.generateToken(authenticate);
		AuthResponse response = new AuthResponse();
		response.setMessage("signIn successfull..");
		response.setJwtToken(jwt);
		return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

	private Authentication authenticate(String username, String password) {
		UserDetails userDetail = customUserDetails.loadUserByUsername(username);
		if(userDetail==null) {
			throw new BadCredentialsException("invalid Username!!");
		}
		if(!passwordEncoder.matches(password, userDetail.getPassword())) {
			throw new BadCredentialsException("invalid Password!!");
		}
		return new UsernamePasswordAuthenticationToken(userDetail, null, userDetail.getAuthorities());
	}

}

   
