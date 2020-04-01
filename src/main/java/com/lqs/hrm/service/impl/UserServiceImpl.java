package com.lqs.hrm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lqs.hrm.entity.User;
import com.lqs.hrm.entity.UserExample;
import com.lqs.hrm.mapper.UserMapper;

@Service
public class UserServiceImpl {
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 修改账户密码
	 * @param userAccount
	 * @param newUserPwd
	 * @return
	 */
	public int updateUserPwd(String userAccount, String newUserPwd) {
		UserExample example = new UserExample();
		example.createCriteria().andUserAccountEqualTo(userAccount);
		User user = new User();
		user.setUserPwd(newUserPwd);
		return userMapper.updateByExampleSelective(user, example);
	}
	
	public User getUser(String userAccount, String userPwd) {
		UserExample userExample = new UserExample();
		userExample.createCriteria().andUserAccountEqualTo(userAccount).andUserPwdEqualTo(userPwd);
		List<User> users = userMapper.selectByExample(userExample);
		if (users.size() == 0) {
			return null;
		}
		return users.get(0);
	}
	
	public User getUser(String userAccount) {
		UserExample userExample = new UserExample();
		userExample.createCriteria().andUserAccountEqualTo(userAccount);
		List<User> users = userMapper.selectByExample(userExample);
		if (users.size() == 0) {
			return null;
		}
		return users.get(0);
	}
	
}
