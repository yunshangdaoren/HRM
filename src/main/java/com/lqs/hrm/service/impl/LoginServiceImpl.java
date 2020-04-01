package com.lqs.hrm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lqs.hrm.entity.User;
import com.lqs.hrm.entity.UserExample;
import com.lqs.hrm.mapper.UserMapper;

@Service
public class LoginServiceImpl {
	@Autowired
	private UserServiceImpl userService;
	
	public User getUser(String userAccount, String userPwd) {
		return userService.getUser(userAccount, userPwd);
	}
	
	
}
