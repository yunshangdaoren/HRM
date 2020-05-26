package com.lqs.hrm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lqs.hrm.entity.Roles;
import com.lqs.hrm.mapper.RolesMapper;
import com.lqs.hrm.service.RolesService;

/**
 * 角色Service接口实现类
 * @author luckyliuqs
 *
 */
@Service
public class RolesServiceImpl implements RolesService{
	@Autowired
	private RolesMapper rolesMapper;

	@Override
	public Roles get(Integer roleId) {
		return rolesMapper.selectByPrimaryKey(roleId);
	}

	@Override
	public int add(Roles roles) {
		return rolesMapper.insertSelective(roles);
	}

	@Override
	public int update(Roles roles) {
		return rolesMapper.updateByPrimaryKey(roles);
	}

}
