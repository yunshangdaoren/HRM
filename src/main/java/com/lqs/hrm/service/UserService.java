package com.lqs.hrm.service;

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
	
}
