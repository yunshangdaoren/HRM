package com.lqs.hrm.service;

import java.util.List;

import com.lqs.hrm.entity.User;

public interface UserService {

	/**
	 * 修改用户密码
	 * @param userAccount
	 * @param newUserPwd
	 * @return
	 */
	int update(String userAccount, String newUserPwd);
	
	/**
	 * 通过用户账户和密码获取用户信息
	 * @param userAccount
	 * @param userPwd
	 * @return
	 */
	User get(String userAccount, String userPwd);
	
	/**
	 * 通过用户账户获取用户信息
	 * @param userAccount
	 * @return
	 */
	User get(String userAccount);
	
	
	/**
	 * 删除系统用户信息
	 * @param userAccount
	 * @return
	 */
	int delete(String userAccount);
	
	/**
	 * 添加
	 * @param user
	 * @return
	 */
	int add(User user);
	
	int update(User user);
	
	/**
	 * 通过账户状态查询
	 * @param statusId
	 * @return
	 */
	List<User> listByStatusId(Integer statusId);
	
	/**
	 * 通过账户和状态查询
	 * @param userAccount
	 * @param statusId
	 * @return
	 */
	List<User> listByUserAccountStatusId(String userAccount, Integer statusId);
	
	/**
	 * 查询出所有账户信息，除了超级管理员的
	 * @return
	 */
	List<User> listByNoExceptSuperManager();
}
