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
	 * 查询出所有的用户角色信息
	 * @return
	 */
	List<UserRole> listByNo();
	
	/**
	 * 查询出所有用户角色信息，除了超级管理员
	 * @return
	 */
	List<UserRole> listByNoExceptSuperManager();
	
	/**
	 * 修改用户角色
	 * @param userAccount
	 * @param newUserPwd
	 * @return
	 */
	int update(UserRole userRole);
	
	/**
	 * 删除
	 * @param urId
	 * @return
	 */
	int delete(Integer urId);
	
	/**
	 * 添加用户角色
	 * @param userRole
	 * @return
	 */
	int add(UserRole userRole);
}
