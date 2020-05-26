package com.lqs.hrm.service;

import java.util.List;

import com.lqs.hrm.entity.User;
import com.lqs.hrm.entity.UserRole;

/**
 * 用户-角色Service接口
 * @author luckyliuqs
 *
 */
public interface UserRoleService {
	
	/**
	 * 通过urId查询
	 * @param userAccount
	 * @param userPwd
	 * @return
	 */
	UserRole get(Integer urId);

	/**
	 * 通过用户账户查询
	 * @param userAccount
	 * @param userPwd
	 * @return
	 */
	List<UserRole> listByUserAccount(String userAccount);
	
	/**
	 * 通过角色id查询
	 * @param userAccount
	 * @param userPwd
	 * @return
	 */
	List<UserRole> listByRoleId(Integer roleId);
	
	/**
	 * 通过用户账户，角色id查询
	 * @param userAccount
	 * @param userPwd
	 * @return
	 */
	List<UserRole> listByUserAccountRoleId(String userAccount, Integer roleId);
	
	
	/**
	 * 修改用户角色
	 * @param userAccount
	 * @param newUserPwd
	 * @return
	 */
	int update(UserRole userRole);
	
	/**
	 * 添加用户角色
	 * @param userRole
	 * @return
	 */
	int add(UserRole userRole);
}
