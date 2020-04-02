package com.lqs.hrm.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class User {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.user_account
	 * @mbg.generated  Wed Apr 01 12:26:38 CST 2020
	 */
	private String userAccount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.user_pwd
	 * @mbg.generated  Wed Apr 01 12:26:38 CST 2020
	 */
	private String userPwd;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.user_name
	 * @mbg.generated  Wed Apr 01 12:26:38 CST 2020
	 */
	private String userName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.user_photo
	 * @mbg.generated  Wed Apr 01 12:26:38 CST 2020
	 */
	private String userPhoto;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.security_mail
	 * @mbg.generated  Wed Apr 01 12:26:38 CST 2020
	 */
	private String securityMail;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.emp_jobId
	 * @mbg.generated  Wed Apr 01 12:26:38 CST 2020
	 */
	private String empJobid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.role_id
	 * @mbg.generated  Wed Apr 01 12:26:38 CST 2020
	 */
	private Integer roleId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.status_id
	 * @mbg.generated  Wed Apr 01 12:26:38 CST 2020
	 */
	private Integer statusId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.create_date
	 * @mbg.generated  Wed Apr 01 12:26:38 CST 2020
	 */
	private Date createDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.create_empJobId
	 * @mbg.generated  Wed Apr 01 12:26:38 CST 2020
	 */
	private String createEmpjobid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.last_login_time
	 * @mbg.generated  Wed Apr 01 12:26:38 CST 2020
	 */
	private Date lastLoginTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.login_count
	 * @mbg.generated  Wed Apr 01 12:26:38 CST 2020
	 */
	private Integer loginCount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.remember_pwd
	 * @mbg.generated  Wed Apr 01 12:26:38 CST 2020
	 */
	private Boolean rememberPwd;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.last_operator_date
	 * @mbg.generated  Wed Apr 01 12:26:38 CST 2020
	 */
	private Date lastOperatorDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.operator_empJobId
	 * @mbg.generated  Wed Apr 01 12:26:38 CST 2020
	 */
	private String operatorEmpjobid;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.user_account
	 * @return  the value of user.user_account
	 * @mbg.generated  Wed Apr 01 12:26:38 CST 2020
	 */
	public String getUserAccount() {
		return userAccount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.user_account
	 * @param userAccount  the value for user.user_account
	 * @mbg.generated  Wed Apr 01 12:26:38 CST 2020
	 */
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.user_pwd
	 * @return  the value of user.user_pwd
	 * @mbg.generated  Wed Apr 01 12:26:38 CST 2020
	 */
	public String getUserPwd() {
		return userPwd;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.user_pwd
	 * @param userPwd  the value for user.user_pwd
	 * @mbg.generated  Wed Apr 01 12:26:38 CST 2020
	 */
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.user_name
	 * @return  the value of user.user_name
	 * @mbg.generated  Wed Apr 01 12:26:38 CST 2020
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.user_name
	 * @param userName  the value for user.user_name
	 * @mbg.generated  Wed Apr 01 12:26:38 CST 2020
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.user_photo
	 * @return  the value of user.user_photo
	 * @mbg.generated  Wed Apr 01 12:26:38 CST 2020
	 */
	public String getUserPhoto() {
		return userPhoto;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.user_photo
	 * @param userPhoto  the value for user.user_photo
	 * @mbg.generated  Wed Apr 01 12:26:38 CST 2020
	 */
	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.security_mail
	 * @return  the value of user.security_mail
	 * @mbg.generated  Wed Apr 01 12:26:38 CST 2020
	 */
	public String getSecurityMail() {
		return securityMail;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.security_mail
	 * @param securityMail  the value for user.security_mail
	 * @mbg.generated  Wed Apr 01 12:26:38 CST 2020
	 */
	public void setSecurityMail(String securityMail) {
		this.securityMail = securityMail;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.emp_jobId
	 * @return  the value of user.emp_jobId
	 * @mbg.generated  Wed Apr 01 12:26:38 CST 2020
	 */
	public String getEmpJobid() {
		return empJobid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.emp_jobId
	 * @param empJobid  the value for user.emp_jobId
	 * @mbg.generated  Wed Apr 01 12:26:38 CST 2020
	 */
	public void setEmpJobid(String empJobid) {
		this.empJobid = empJobid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.role_id
	 * @return  the value of user.role_id
	 * @mbg.generated  Wed Apr 01 12:26:38 CST 2020
	 */
	public Integer getRoleId() {
		return roleId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.role_id
	 * @param roleId  the value for user.role_id
	 * @mbg.generated  Wed Apr 01 12:26:38 CST 2020
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.status_id
	 * @return  the value of user.status_id
	 * @mbg.generated  Wed Apr 01 12:26:38 CST 2020
	 */
	public Integer getStatusId() {
		return statusId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.status_id
	 * @param statusId  the value for user.status_id
	 * @mbg.generated  Wed Apr 01 12:26:38 CST 2020
	 */
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.create_date
	 * @return  the value of user.create_date
	 * @mbg.generated  Wed Apr 01 12:26:38 CST 2020
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.create_date
	 * @param createDate  the value for user.create_date
	 * @mbg.generated  Wed Apr 01 12:26:38 CST 2020
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.create_empJobId
	 * @return  the value of user.create_empJobId
	 * @mbg.generated  Wed Apr 01 12:26:38 CST 2020
	 */
	public String getCreateEmpjobid() {
		return createEmpjobid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.create_empJobId
	 * @param createEmpjobid  the value for user.create_empJobId
	 * @mbg.generated  Wed Apr 01 12:26:38 CST 2020
	 */
	public void setCreateEmpjobid(String createEmpjobid) {
		this.createEmpjobid = createEmpjobid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.last_login_time
	 * @return  the value of user.last_login_time
	 * @mbg.generated  Wed Apr 01 12:26:38 CST 2020
	 */
	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.last_login_time
	 * @param lastLoginTime  the value for user.last_login_time
	 * @mbg.generated  Wed Apr 01 12:26:38 CST 2020
	 */
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.login_count
	 * @return  the value of user.login_count
	 * @mbg.generated  Wed Apr 01 12:26:38 CST 2020
	 */
	public Integer getLoginCount() {
		return loginCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.login_count
	 * @param loginCount  the value for user.login_count
	 * @mbg.generated  Wed Apr 01 12:26:38 CST 2020
	 */
	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.remember_pwd
	 * @return  the value of user.remember_pwd
	 * @mbg.generated  Wed Apr 01 12:26:38 CST 2020
	 */
	public Boolean getRememberPwd() {
		return rememberPwd;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.remember_pwd
	 * @param rememberPwd  the value for user.remember_pwd
	 * @mbg.generated  Wed Apr 01 12:26:38 CST 2020
	 */
	public void setRememberPwd(Boolean rememberPwd) {
		this.rememberPwd = rememberPwd;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.last_operator_date
	 * @return  the value of user.last_operator_date
	 * @mbg.generated  Wed Apr 01 12:26:38 CST 2020
	 */
	public Date getLastOperatorDate() {
		return lastOperatorDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.last_operator_date
	 * @param lastOperatorDate  the value for user.last_operator_date
	 * @mbg.generated  Wed Apr 01 12:26:38 CST 2020
	 */
	public void setLastOperatorDate(Date lastOperatorDate) {
		this.lastOperatorDate = lastOperatorDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.operator_empJobId
	 * @return  the value of user.operator_empJobId
	 * @mbg.generated  Wed Apr 01 12:26:38 CST 2020
	 */
	public String getOperatorEmpjobid() {
		return operatorEmpjobid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.operator_empJobId
	 * @param operatorEmpjobid  the value for user.operator_empJobId
	 * @mbg.generated  Wed Apr 01 12:26:38 CST 2020
	 */
	public void setOperatorEmpjobid(String operatorEmpjobid) {
		this.operatorEmpjobid = operatorEmpjobid;
	}
}