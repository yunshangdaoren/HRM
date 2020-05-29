package com.lqs.hrm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lqs.hrm.entity.Roles;
import com.lqs.hrm.entity.RolesExample;
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

	/**
	 * 获取所有角色信息
	 */
	@Override
	public List<Roles> listByNo() {
		RolesExample example = new RolesExample();
		example.or().andRoleIdIsNotNull();
		return rolesMapper.selectByExample(example);
	}
	
	

}
