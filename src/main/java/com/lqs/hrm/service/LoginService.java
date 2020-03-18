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
	private UserMapper userMapper;
	
	public User getUser(Integer userAccount, String userPwd) {
		UserExample userExample = new UserExample();
		userExample.or().andUserAccountEqualTo(userAccount).andUserPwdEqualTo(userPwd);
		List<User> users = userMapper.selectByExample(userExample);
		if (users.size() == 0) {
			return null;
		}
		return users.get(0);
	}
}
