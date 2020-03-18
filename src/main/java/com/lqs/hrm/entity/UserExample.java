package com.lqs.hrm.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table user
	 * @mbg.generated  Wed Mar 18 15:16:26 CST 2020
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table user
	 * @mbg.generated  Wed Mar 18 15:16:26 CST 2020
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table user
	 * @mbg.generated  Wed Mar 18 15:16:26 CST 2020
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Wed Mar 18 15:16:26 CST 2020
	 */
	public UserExample() {
		oredCriteria = new ArrayList<>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Wed Mar 18 15:16:26 CST 2020
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Wed Mar 18 15:16:26 CST 2020
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Wed Mar 18 15:16:26 CST 2020
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Wed Mar 18 15:16:26 CST 2020
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Wed Mar 18 15:16:26 CST 2020
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Wed Mar 18 15:16:26 CST 2020
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Wed Mar 18 15:16:26 CST 2020
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Wed Mar 18 15:16:26 CST 2020
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Wed Mar 18 15:16:26 CST 2020
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Wed Mar 18 15:16:26 CST 2020
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table user
	 * @mbg.generated  Wed Mar 18 15:16:26 CST 2020
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andUserAccountIsNull() {
			addCriterion("user_account is null");
			return (Criteria) this;
		}

		public Criteria andUserAccountIsNotNull() {
			addCriterion("user_account is not null");
			return (Criteria) this;
		}

		public Criteria andUserAccountEqualTo(Integer value) {
			addCriterion("user_account =", value, "userAccount");
			return (Criteria) this;
		}

		public Criteria andUserAccountNotEqualTo(Integer value) {
			addCriterion("user_account <>", value, "userAccount");
			return (Criteria) this;
		}

		public Criteria andUserAccountGreaterThan(Integer value) {
			addCriterion("user_account >", value, "userAccount");
			return (Criteria) this;
		}

		public Criteria andUserAccountGreaterThanOrEqualTo(Integer value) {
			addCriterion("user_account >=", value, "userAccount");
			return (Criteria) this;
		}

		public Criteria andUserAccountLessThan(Integer value) {
			addCriterion("user_account <", value, "userAccount");
			return (Criteria) this;
		}

		public Criteria andUserAccountLessThanOrEqualTo(Integer value) {
			addCriterion("user_account <=", value, "userAccount");
			return (Criteria) this;
		}

		public Criteria andUserAccountIn(List<Integer> values) {
			addCriterion("user_account in", values, "userAccount");
			return (Criteria) this;
		}

		public Criteria andUserAccountNotIn(List<Integer> values) {
			addCriterion("user_account not in", values, "userAccount");
			return (Criteria) this;
		}

		public Criteria andUserAccountBetween(Integer value1, Integer value2) {
			addCriterion("user_account between", value1, value2, "userAccount");
			return (Criteria) this;
		}

		public Criteria andUserAccountNotBetween(Integer value1, Integer value2) {
			addCriterion("user_account not between", value1, value2, "userAccount");
			return (Criteria) this;
		}

		public Criteria andUserPwdIsNull() {
			addCriterion("user_pwd is null");
			return (Criteria) this;
		}

		public Criteria andUserPwdIsNotNull() {
			addCriterion("user_pwd is not null");
			return (Criteria) this;
		}

		public Criteria andUserPwdEqualTo(String value) {
			addCriterion("user_pwd =", value, "userPwd");
			return (Criteria) this;
		}

		public Criteria andUserPwdNotEqualTo(String value) {
			addCriterion("user_pwd <>", value, "userPwd");
			return (Criteria) this;
		}

		public Criteria andUserPwdGreaterThan(String value) {
			addCriterion("user_pwd >", value, "userPwd");
			return (Criteria) this;
		}

		public Criteria andUserPwdGreaterThanOrEqualTo(String value) {
			addCriterion("user_pwd >=", value, "userPwd");
			return (Criteria) this;
		}

		public Criteria andUserPwdLessThan(String value) {
			addCriterion("user_pwd <", value, "userPwd");
			return (Criteria) this;
		}

		public Criteria andUserPwdLessThanOrEqualTo(String value) {
			addCriterion("user_pwd <=", value, "userPwd");
			return (Criteria) this;
		}

		public Criteria andUserPwdLike(String value) {
			addCriterion("user_pwd like", value, "userPwd");
			return (Criteria) this;
		}

		public Criteria andUserPwdNotLike(String value) {
			addCriterion("user_pwd not like", value, "userPwd");
			return (Criteria) this;
		}

		public Criteria andUserPwdIn(List<String> values) {
			addCriterion("user_pwd in", values, "userPwd");
			return (Criteria) this;
		}

		public Criteria andUserPwdNotIn(List<String> values) {
			addCriterion("user_pwd not in", values, "userPwd");
			return (Criteria) this;
		}

		public Criteria andUserPwdBetween(String value1, String value2) {
			addCriterion("user_pwd between", value1, value2, "userPwd");
			return (Criteria) this;
		}

		public Criteria andUserPwdNotBetween(String value1, String value2) {
			addCriterion("user_pwd not between", value1, value2, "userPwd");
			return (Criteria) this;
		}

		public Criteria andUserNameIsNull() {
			addCriterion("user_name is null");
			return (Criteria) this;
		}

		public Criteria andUserNameIsNotNull() {
			addCriterion("user_name is not null");
			return (Criteria) this;
		}

		public Criteria andUserNameEqualTo(String value) {
			addCriterion("user_name =", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotEqualTo(String value) {
			addCriterion("user_name <>", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameGreaterThan(String value) {
			addCriterion("user_name >", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameGreaterThanOrEqualTo(String value) {
			addCriterion("user_name >=", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLessThan(String value) {
			addCriterion("user_name <", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLessThanOrEqualTo(String value) {
			addCriterion("user_name <=", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameLike(String value) {
			addCriterion("user_name like", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotLike(String value) {
			addCriterion("user_name not like", value, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameIn(List<String> values) {
			addCriterion("user_name in", values, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotIn(List<String> values) {
			addCriterion("user_name not in", values, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameBetween(String value1, String value2) {
			addCriterion("user_name between", value1, value2, "userName");
			return (Criteria) this;
		}

		public Criteria andUserNameNotBetween(String value1, String value2) {
			addCriterion("user_name not between", value1, value2, "userName");
			return (Criteria) this;
		}

		public Criteria andUserPhotoIsNull() {
			addCriterion("user_photo is null");
			return (Criteria) this;
		}

		public Criteria andUserPhotoIsNotNull() {
			addCriterion("user_photo is not null");
			return (Criteria) this;
		}

		public Criteria andUserPhotoEqualTo(String value) {
			addCriterion("user_photo =", value, "userPhoto");
			return (Criteria) this;
		}

		public Criteria andUserPhotoNotEqualTo(String value) {
			addCriterion("user_photo <>", value, "userPhoto");
			return (Criteria) this;
		}

		public Criteria andUserPhotoGreaterThan(String value) {
			addCriterion("user_photo >", value, "userPhoto");
			return (Criteria) this;
		}

		public Criteria andUserPhotoGreaterThanOrEqualTo(String value) {
			addCriterion("user_photo >=", value, "userPhoto");
			return (Criteria) this;
		}

		public Criteria andUserPhotoLessThan(String value) {
			addCriterion("user_photo <", value, "userPhoto");
			return (Criteria) this;
		}

		public Criteria andUserPhotoLessThanOrEqualTo(String value) {
			addCriterion("user_photo <=", value, "userPhoto");
			return (Criteria) this;
		}

		public Criteria andUserPhotoLike(String value) {
			addCriterion("user_photo like", value, "userPhoto");
			return (Criteria) this;
		}

		public Criteria andUserPhotoNotLike(String value) {
			addCriterion("user_photo not like", value, "userPhoto");
			return (Criteria) this;
		}

		public Criteria andUserPhotoIn(List<String> values) {
			addCriterion("user_photo in", values, "userPhoto");
			return (Criteria) this;
		}

		public Criteria andUserPhotoNotIn(List<String> values) {
			addCriterion("user_photo not in", values, "userPhoto");
			return (Criteria) this;
		}

		public Criteria andUserPhotoBetween(String value1, String value2) {
			addCriterion("user_photo between", value1, value2, "userPhoto");
			return (Criteria) this;
		}

		public Criteria andUserPhotoNotBetween(String value1, String value2) {
			addCriterion("user_photo not between", value1, value2, "userPhoto");
			return (Criteria) this;
		}

		public Criteria andEmpJobnumberIsNull() {
			addCriterion("emp_jobNumber is null");
			return (Criteria) this;
		}

		public Criteria andEmpJobnumberIsNotNull() {
			addCriterion("emp_jobNumber is not null");
			return (Criteria) this;
		}

		public Criteria andEmpJobnumberEqualTo(Integer value) {
			addCriterion("emp_jobNumber =", value, "empJobnumber");
			return (Criteria) this;
		}

		public Criteria andEmpJobnumberNotEqualTo(Integer value) {
			addCriterion("emp_jobNumber <>", value, "empJobnumber");
			return (Criteria) this;
		}

		public Criteria andEmpJobnumberGreaterThan(Integer value) {
			addCriterion("emp_jobNumber >", value, "empJobnumber");
			return (Criteria) this;
		}

		public Criteria andEmpJobnumberGreaterThanOrEqualTo(Integer value) {
			addCriterion("emp_jobNumber >=", value, "empJobnumber");
			return (Criteria) this;
		}

		public Criteria andEmpJobnumberLessThan(Integer value) {
			addCriterion("emp_jobNumber <", value, "empJobnumber");
			return (Criteria) this;
		}

		public Criteria andEmpJobnumberLessThanOrEqualTo(Integer value) {
			addCriterion("emp_jobNumber <=", value, "empJobnumber");
			return (Criteria) this;
		}

		public Criteria andEmpJobnumberIn(List<Integer> values) {
			addCriterion("emp_jobNumber in", values, "empJobnumber");
			return (Criteria) this;
		}

		public Criteria andEmpJobnumberNotIn(List<Integer> values) {
			addCriterion("emp_jobNumber not in", values, "empJobnumber");
			return (Criteria) this;
		}

		public Criteria andEmpJobnumberBetween(Integer value1, Integer value2) {
			addCriterion("emp_jobNumber between", value1, value2, "empJobnumber");
			return (Criteria) this;
		}

		public Criteria andEmpJobnumberNotBetween(Integer value1, Integer value2) {
			addCriterion("emp_jobNumber not between", value1, value2, "empJobnumber");
			return (Criteria) this;
		}

		public Criteria andRoleIdIsNull() {
			addCriterion("role_id is null");
			return (Criteria) this;
		}

		public Criteria andRoleIdIsNotNull() {
			addCriterion("role_id is not null");
			return (Criteria) this;
		}

		public Criteria andRoleIdEqualTo(Integer value) {
			addCriterion("role_id =", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdNotEqualTo(Integer value) {
			addCriterion("role_id <>", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdGreaterThan(Integer value) {
			addCriterion("role_id >", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("role_id >=", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdLessThan(Integer value) {
			addCriterion("role_id <", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdLessThanOrEqualTo(Integer value) {
			addCriterion("role_id <=", value, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdIn(List<Integer> values) {
			addCriterion("role_id in", values, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdNotIn(List<Integer> values) {
			addCriterion("role_id not in", values, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdBetween(Integer value1, Integer value2) {
			addCriterion("role_id between", value1, value2, "roleId");
			return (Criteria) this;
		}

		public Criteria andRoleIdNotBetween(Integer value1, Integer value2) {
			addCriterion("role_id not between", value1, value2, "roleId");
			return (Criteria) this;
		}

		public Criteria andStatusIdIsNull() {
			addCriterion("status_id is null");
			return (Criteria) this;
		}

		public Criteria andStatusIdIsNotNull() {
			addCriterion("status_id is not null");
			return (Criteria) this;
		}

		public Criteria andStatusIdEqualTo(Integer value) {
			addCriterion("status_id =", value, "statusId");
			return (Criteria) this;
		}

		public Criteria andStatusIdNotEqualTo(Integer value) {
			addCriterion("status_id <>", value, "statusId");
			return (Criteria) this;
		}

		public Criteria andStatusIdGreaterThan(Integer value) {
			addCriterion("status_id >", value, "statusId");
			return (Criteria) this;
		}

		public Criteria andStatusIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("status_id >=", value, "statusId");
			return (Criteria) this;
		}

		public Criteria andStatusIdLessThan(Integer value) {
			addCriterion("status_id <", value, "statusId");
			return (Criteria) this;
		}

		public Criteria andStatusIdLessThanOrEqualTo(Integer value) {
			addCriterion("status_id <=", value, "statusId");
			return (Criteria) this;
		}

		public Criteria andStatusIdIn(List<Integer> values) {
			addCriterion("status_id in", values, "statusId");
			return (Criteria) this;
		}

		public Criteria andStatusIdNotIn(List<Integer> values) {
			addCriterion("status_id not in", values, "statusId");
			return (Criteria) this;
		}

		public Criteria andStatusIdBetween(Integer value1, Integer value2) {
			addCriterion("status_id between", value1, value2, "statusId");
			return (Criteria) this;
		}

		public Criteria andStatusIdNotBetween(Integer value1, Integer value2) {
			addCriterion("status_id not between", value1, value2, "statusId");
			return (Criteria) this;
		}

		public Criteria andCreateDateIsNull() {
			addCriterion("create_date is null");
			return (Criteria) this;
		}

		public Criteria andCreateDateIsNotNull() {
			addCriterion("create_date is not null");
			return (Criteria) this;
		}

		public Criteria andCreateDateEqualTo(Date value) {
			addCriterion("create_date =", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateNotEqualTo(Date value) {
			addCriterion("create_date <>", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateGreaterThan(Date value) {
			addCriterion("create_date >", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
			addCriterion("create_date >=", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateLessThan(Date value) {
			addCriterion("create_date <", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateLessThanOrEqualTo(Date value) {
			addCriterion("create_date <=", value, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateIn(List<Date> values) {
			addCriterion("create_date in", values, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateNotIn(List<Date> values) {
			addCriterion("create_date not in", values, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateBetween(Date value1, Date value2) {
			addCriterion("create_date between", value1, value2, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateDateNotBetween(Date value1, Date value2) {
			addCriterion("create_date not between", value1, value2, "createDate");
			return (Criteria) this;
		}

		public Criteria andCreateEmpjobnumberIsNull() {
			addCriterion("create_empJobNumber is null");
			return (Criteria) this;
		}

		public Criteria andCreateEmpjobnumberIsNotNull() {
			addCriterion("create_empJobNumber is not null");
			return (Criteria) this;
		}

		public Criteria andCreateEmpjobnumberEqualTo(Integer value) {
			addCriterion("create_empJobNumber =", value, "createEmpjobnumber");
			return (Criteria) this;
		}

		public Criteria andCreateEmpjobnumberNotEqualTo(Integer value) {
			addCriterion("create_empJobNumber <>", value, "createEmpjobnumber");
			return (Criteria) this;
		}

		public Criteria andCreateEmpjobnumberGreaterThan(Integer value) {
			addCriterion("create_empJobNumber >", value, "createEmpjobnumber");
			return (Criteria) this;
		}

		public Criteria andCreateEmpjobnumberGreaterThanOrEqualTo(Integer value) {
			addCriterion("create_empJobNumber >=", value, "createEmpjobnumber");
			return (Criteria) this;
		}

		public Criteria andCreateEmpjobnumberLessThan(Integer value) {
			addCriterion("create_empJobNumber <", value, "createEmpjobnumber");
			return (Criteria) this;
		}

		public Criteria andCreateEmpjobnumberLessThanOrEqualTo(Integer value) {
			addCriterion("create_empJobNumber <=", value, "createEmpjobnumber");
			return (Criteria) this;
		}

		public Criteria andCreateEmpjobnumberIn(List<Integer> values) {
			addCriterion("create_empJobNumber in", values, "createEmpjobnumber");
			return (Criteria) this;
		}

		public Criteria andCreateEmpjobnumberNotIn(List<Integer> values) {
			addCriterion("create_empJobNumber not in", values, "createEmpjobnumber");
			return (Criteria) this;
		}

		public Criteria andCreateEmpjobnumberBetween(Integer value1, Integer value2) {
			addCriterion("create_empJobNumber between", value1, value2, "createEmpjobnumber");
			return (Criteria) this;
		}

		public Criteria andCreateEmpjobnumberNotBetween(Integer value1, Integer value2) {
			addCriterion("create_empJobNumber not between", value1, value2, "createEmpjobnumber");
			return (Criteria) this;
		}

		public Criteria andLoginTimeIsNull() {
			addCriterion("login_time is null");
			return (Criteria) this;
		}

		public Criteria andLoginTimeIsNotNull() {
			addCriterion("login_time is not null");
			return (Criteria) this;
		}

		public Criteria andLoginTimeEqualTo(Date value) {
			addCriterion("login_time =", value, "loginTime");
			return (Criteria) this;
		}

		public Criteria andLoginTimeNotEqualTo(Date value) {
			addCriterion("login_time <>", value, "loginTime");
			return (Criteria) this;
		}

		public Criteria andLoginTimeGreaterThan(Date value) {
			addCriterion("login_time >", value, "loginTime");
			return (Criteria) this;
		}

		public Criteria andLoginTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("login_time >=", value, "loginTime");
			return (Criteria) this;
		}

		public Criteria andLoginTimeLessThan(Date value) {
			addCriterion("login_time <", value, "loginTime");
			return (Criteria) this;
		}

		public Criteria andLoginTimeLessThanOrEqualTo(Date value) {
			addCriterion("login_time <=", value, "loginTime");
			return (Criteria) this;
		}

		public Criteria andLoginTimeIn(List<Date> values) {
			addCriterion("login_time in", values, "loginTime");
			return (Criteria) this;
		}

		public Criteria andLoginTimeNotIn(List<Date> values) {
			addCriterion("login_time not in", values, "loginTime");
			return (Criteria) this;
		}

		public Criteria andLoginTimeBetween(Date value1, Date value2) {
			addCriterion("login_time between", value1, value2, "loginTime");
			return (Criteria) this;
		}

		public Criteria andLoginTimeNotBetween(Date value1, Date value2) {
			addCriterion("login_time not between", value1, value2, "loginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeIsNull() {
			addCriterion("last_login_time is null");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeIsNotNull() {
			addCriterion("last_login_time is not null");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeEqualTo(Date value) {
			addCriterion("last_login_time =", value, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeNotEqualTo(Date value) {
			addCriterion("last_login_time <>", value, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeGreaterThan(Date value) {
			addCriterion("last_login_time >", value, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("last_login_time >=", value, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeLessThan(Date value) {
			addCriterion("last_login_time <", value, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeLessThanOrEqualTo(Date value) {
			addCriterion("last_login_time <=", value, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeIn(List<Date> values) {
			addCriterion("last_login_time in", values, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeNotIn(List<Date> values) {
			addCriterion("last_login_time not in", values, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeBetween(Date value1, Date value2) {
			addCriterion("last_login_time between", value1, value2, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLastLoginTimeNotBetween(Date value1, Date value2) {
			addCriterion("last_login_time not between", value1, value2, "lastLoginTime");
			return (Criteria) this;
		}

		public Criteria andLoginCountIsNull() {
			addCriterion("login_count is null");
			return (Criteria) this;
		}

		public Criteria andLoginCountIsNotNull() {
			addCriterion("login_count is not null");
			return (Criteria) this;
		}

		public Criteria andLoginCountEqualTo(Integer value) {
			addCriterion("login_count =", value, "loginCount");
			return (Criteria) this;
		}

		public Criteria andLoginCountNotEqualTo(Integer value) {
			addCriterion("login_count <>", value, "loginCount");
			return (Criteria) this;
		}

		public Criteria andLoginCountGreaterThan(Integer value) {
			addCriterion("login_count >", value, "loginCount");
			return (Criteria) this;
		}

		public Criteria andLoginCountGreaterThanOrEqualTo(Integer value) {
			addCriterion("login_count >=", value, "loginCount");
			return (Criteria) this;
		}

		public Criteria andLoginCountLessThan(Integer value) {
			addCriterion("login_count <", value, "loginCount");
			return (Criteria) this;
		}

		public Criteria andLoginCountLessThanOrEqualTo(Integer value) {
			addCriterion("login_count <=", value, "loginCount");
			return (Criteria) this;
		}

		public Criteria andLoginCountIn(List<Integer> values) {
			addCriterion("login_count in", values, "loginCount");
			return (Criteria) this;
		}

		public Criteria andLoginCountNotIn(List<Integer> values) {
			addCriterion("login_count not in", values, "loginCount");
			return (Criteria) this;
		}

		public Criteria andLoginCountBetween(Integer value1, Integer value2) {
			addCriterion("login_count between", value1, value2, "loginCount");
			return (Criteria) this;
		}

		public Criteria andLoginCountNotBetween(Integer value1, Integer value2) {
			addCriterion("login_count not between", value1, value2, "loginCount");
			return (Criteria) this;
		}

		public Criteria andRememberPwdIsNull() {
			addCriterion("remember_pwd is null");
			return (Criteria) this;
		}

		public Criteria andRememberPwdIsNotNull() {
			addCriterion("remember_pwd is not null");
			return (Criteria) this;
		}

		public Criteria andRememberPwdEqualTo(Boolean value) {
			addCriterion("remember_pwd =", value, "rememberPwd");
			return (Criteria) this;
		}

		public Criteria andRememberPwdNotEqualTo(Boolean value) {
			addCriterion("remember_pwd <>", value, "rememberPwd");
			return (Criteria) this;
		}

		public Criteria andRememberPwdGreaterThan(Boolean value) {
			addCriterion("remember_pwd >", value, "rememberPwd");
			return (Criteria) this;
		}

		public Criteria andRememberPwdGreaterThanOrEqualTo(Boolean value) {
			addCriterion("remember_pwd >=", value, "rememberPwd");
			return (Criteria) this;
		}

		public Criteria andRememberPwdLessThan(Boolean value) {
			addCriterion("remember_pwd <", value, "rememberPwd");
			return (Criteria) this;
		}

		public Criteria andRememberPwdLessThanOrEqualTo(Boolean value) {
			addCriterion("remember_pwd <=", value, "rememberPwd");
			return (Criteria) this;
		}

		public Criteria andRememberPwdIn(List<Boolean> values) {
			addCriterion("remember_pwd in", values, "rememberPwd");
			return (Criteria) this;
		}

		public Criteria andRememberPwdNotIn(List<Boolean> values) {
			addCriterion("remember_pwd not in", values, "rememberPwd");
			return (Criteria) this;
		}

		public Criteria andRememberPwdBetween(Boolean value1, Boolean value2) {
			addCriterion("remember_pwd between", value1, value2, "rememberPwd");
			return (Criteria) this;
		}

		public Criteria andRememberPwdNotBetween(Boolean value1, Boolean value2) {
			addCriterion("remember_pwd not between", value1, value2, "rememberPwd");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table user
	 * @mbg.generated  Wed Mar 18 15:16:26 CST 2020
	 */
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table user
     *
     * @mbg.generated do_not_delete_during_merge Wed Mar 18 15:16:26 CST 2020
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }
}