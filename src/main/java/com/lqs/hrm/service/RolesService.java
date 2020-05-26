package com.lqs.hrm.service;

import com.lqs.hrm.entity.Roles;

/**
 * 角色Service接口
 * @author luckyliuqs
 *
 */
public interface RolesService {

	Roles get(Integer roleId);
	
	int add(Roles roles);
	
	int update(Roles roles);
}
