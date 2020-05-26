package com.lqs.hrm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lqs.hrm.entity.UserRole;
import com.lqs.hrm.entity.UserRoleExample;
import com.lqs.hrm.mapper.UserRoleMapper;
import com.lqs.hrm.service.UserRoleService;

/**
 * 用户角色Service接口实现类
 * @author luckyliuqs
 *
 */
@Service
public class UserRoleServiceImpl implements UserRoleService{
	@Autowired
	private UserRoleMapper userRoleMapper;

	@Override
	public UserRole get(Integer urId) {
		return userRoleMapper.selectByPrimaryKey(urId);
	}

	@Override
	public List<UserRole> listByUserAccount(String userAccount) {
		UserRoleExample example = new UserRoleExample();
		example.or().andUserAccountEqualTo(userAccount);
		return userRoleMapper.selectByExample(example);
	}

	@Override
	public List<UserRole> listByRoleId(Integer roleId) {
		UserRoleExample example = new UserRoleExample();
		example.or().andRoleIdEqualTo(roleId);
		return userRoleMapper.selectByExample(example);
	}

	@Override
	public List<UserRole> listByUserAccountRoleId(String userAccount, Integer roleId) {
		UserRoleExample example = new UserRoleExample();
		example.or().andUserAccountEqualTo(userAccount).andRoleIdEqualTo(roleId);
		return userRoleMapper.selectByExample(example);
	}

	@Override
	public int update(UserRole userRole) {
		return userRoleMapper.updateByPrimaryKeySelective(userRole);
	}

	@Override
	public int add(UserRole userRole) {
		return userRoleMapper.insertSelective(userRole);
	}

	
}
