package com.lqs.hrm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lqs.hrm.entity.User;
import com.lqs.hrm.entity.UserExample;
import com.lqs.hrm.mapper.UserMapper;

@Service
public class LoginService {
	@Autowired
	private UserService userService;
	
	public User getUser(Integer userAccount, String userPwd) {
		return userService.getUser(userAccount, userPwd);
	}
	
	public int updateUserPwd(Integer userAccount, String newUserPwd) {
		return userService.updateUserPwd(userAccount, newUserPwd);
	}
	
}
