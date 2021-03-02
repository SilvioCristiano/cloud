package com.cloud.backend.service;


import org.springframework.security.core.context.SecurityContextHolder;

import com.cloud.backend.security.UserSS;

public class UserService {
	
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}
}