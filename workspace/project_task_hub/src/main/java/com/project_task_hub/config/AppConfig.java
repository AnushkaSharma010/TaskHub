package com.project_task_hub.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
public class AppConfig {
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.sessionManagement(Management -> Management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.authorizeHttpRequests(Authorize -> Authorize
				.requestMatchers("/api/**").permitAll() 
				.anyRequest().authenticated())
		.addFilterBefore(new JwtTokenValidator(), BasicAuthenticationFilter.class)
		.csrf(csrf -> csrf.disable())
		.cors(cors -> cors.configurationSource(corsConfigurationSource()));
		return http.build();
	}
	
//	@Bean
//	SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
//		http.sessionManagement(Management -> Management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//		.authorizeHttpRequests(Autherize -> Autherize.requestMatchers("/**").authenticated()
//				.anyRequest().permitAll())
//		.addFilterBefore(new JwtTokenValidator(), BasicAuthenticationFilter.class)
//		.csrf(csrf -> csrf.disable())
//		.cors(cors -> cors.configurationSource(corsConfigurationSource()));
//		return http.build();
//	}
	
	private CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList(
				"http://localhost:3001",
				"http://localhost:5173",
				"http://localhost:4200"
		));
		configuration.setAllowCredentials(true);
		configuration.setAllowedMethods(Arrays.asList("*")); // or specify exact methods like Arrays.asList("GET", "POST")
		configuration.setAllowedHeaders(Arrays.asList("*")); // or specify exact headers
		configuration.setMaxAge(3600L);
		
		return request -> configuration;
	}
//	
//	private CorsConfigurationSource corsConfigurationSource() {
//		return new CorsConfigurationSource() {
//			
//			@Override
//			public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
//				CorsConfiguration cfg = new CorsConfiguration();
//				cfg.setAllowedOrigins(Arrays.asList(
//						"http://localhost:3001/",
//						"http://localhost:5173",
//						"http://localhost:4200"
//						));
//				cfg.setAllowCredentials(true);
//				cfg.setAllowedMethods(Collections.singletonList("*"));
//				cfg.setAllowedHeaders(Collections.singletonList("*"));
//				cfg.setAllowedHeaders(Arrays.asList("Authorization"));
//				cfg.setMaxAge(3600L);
//				return cfg;
//			}
//		};
		
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
