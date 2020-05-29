package com.lqs.hrm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lqs.hrm.entity.User;
import com.lqs.hrm.entity.UserExample;
import com.lqs.hrm.mapper.UserMapper;
import com.lqs.hrm.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 修改账户密码
	 * @param userAccount
	 * @param newUserPwd
	 * @return
	 */
	public int update(String userAccount, String newUserPwd) {
		UserExample example = new UserExample();
		example.createCriteria().andUserAccountEqualTo(userAccount);
		User user = new User();
		user.setUserPwd(newUserPwd);
		return userMapper.updateByExampleSelective(user, example);
	}
	
	/**
	 * 通过用户账户和密码获取用户信息
	 * @param userAccount
	 * @param userPwd
	 * @return
	 */
	public User get(String userAccount, String userPwd) {
		UserExample userExample = new UserExample();
		userExample.createCriteria().andUserAccountEqualTo(userAccount).andUserPwdEqualTo(userPwd);
		List<User> users = userMapper.selectByExample(userExample);
		if (users.size() == 0) {
			return null;
		}
		return users.get(0);
	}
	
	/**
	 * 通过用户账户获取用户信息
	 * @param userAccount
	 * @return
	 */
	public User get(String userAccount) {
		UserExample userExample = new UserExample();
		userExample.createCriteria().andUserAccountEqualTo(userAccount);
		List<User> users = userMapper.selectByExample(userExample);
		if (users.size() == 0) {
			return null;
		}
		return users.get(0);
	}

	/**
	 * 删除
	 */
	@Override
	public int delete(String userAccount) {
		UserExample example = new UserExample();
		example.createCriteria().andUserAccountEqualTo(userAccount);
		return userMapper.deleteByExample(example);
	}

	/**
	 * 添加
	 */
	@Override
	public int add(User user) {
		return userMapper.insert(user);
	}

	@Override
	public int update(User user) {
		UserExample example = new UserExample();
		example.or().andUserAccountEqualTo(user.getUserAccount());
		return userMapper.updateByExampleSelective(user, example);
	}

	@Override
	public List<User> listByStatusId(Integer statusId) {
		UserExample example = new UserExample();
		example.or().andStatusIdEqualTo(statusId);
		return userMapper.selectByExample(example);
	}

	@Override
	public List<User> listByUserAccountStatusId(String userAccount, Integer statusId) {
		UserExample example = new UserExample();
		example.or().andStatusIdEqualTo(statusId).andUserAccountEqualTo(userAccount);
		return userMapper.selectByExample(example);
	}

	@Override
	public List<User> listByNoExceptSuperManager() {
		UserExample example = new UserExample();
		example.or().andUserAccountNotEqualTo("1");
		return userMapper.selectByExample(example);
	}
	
}
