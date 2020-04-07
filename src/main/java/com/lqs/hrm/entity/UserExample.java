package com.lqs.hrm.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table user
	 * @mbg.generated  Tue Apr 07 12:42:26 CST 2020
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table user
	 * @mbg.generated  Tue Apr 07 12:42:26 CST 2020
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table user
	 * @mbg.generated  Tue Apr 07 12:42:26 CST 2020
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Tue Apr 07 12:42:26 CST 2020
	 */
	public UserExample() {
		oredCriteria = new ArrayList<>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Tue Apr 07 12:42:26 CST 2020
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Tue Apr 07 12:42:26 CST 2020
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Tue Apr 07 12:42:26 CST 2020
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Tue Apr 07 12:42:26 CST 2020
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Tue Apr 07 12:42:26 CST 2020
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Tue Apr 07 12:42:26 CST 2020
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Tue Apr 07 12:42:26 CST 2020
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Tue Apr 07 12:42:26 CST 2020
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
	 * @mbg.generated  Tue Apr 07 12:42:26 CST 2020
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Tue Apr 07 12:42:26 CST 2020
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table user
	 * @mbg.generated  Tue Apr 07 12:42:26 CST 2020
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

		public Criteria andUserAccountEqualTo(String value) {
			addCriterion("user_account =", value, "userAccount");
			return (Criteria) this;
		}

		public Criteria andUserAccountNotEqualTo(String value) {
			addCriterion("user_account <>", value, "userAccount");
			return (Criteria) this;
		}

		public Criteria andUserAccountGreaterThan(String value) {
			addCriterion("user_account >", value, "userAccount");
			return (Criteria) this;
		}

		public Criteria andUserAccountGreaterThanOrEqualTo(String value) {
			addCriterion("user_account >=", value, "userAccount");
			return (Criteria) this;
		}

		public Criteria andUserAccountLessThan(String value) {
			addCriterion("user_account <", value, "userAccount");
			return (Criteria) this;
		}

		public Criteria andUserAccountLessThanOrEqualTo(String value) {
			addCriterion("user_account <=", value, "userAccount");
			return (Criteria) this;
		}

		public Criteria andUserAccountLike(String value) {
			addCriterion("user_account like", value, "userAccount");
			return (Criteria) this;
		}

		public Criteria andUserAccountNotLike(String value) {
			addCriterion("user_account not like", value, "userAccount");
			return (Criteria) this;
		}

		public Criteria andUserAccountIn(List<String> values) {
			addCriterion("user_account in", values, "userAccount");
			return (Criteria) this;
		}

		public Criteria andUserAccountNotIn(List<String> values) {
			addCriterion("user_account not in", values, "userAccount");
			return (Criteria) this;
		}

		public Criteria andUserAccountBetween(String value1, String value2) {
			addCriterion("user_account between", value1, value2, "userAccount");
			return (Criteria) this;
		}

		public Criteria andUserAccountNotBetween(String value1, String value2) {
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

		public Criteria andSecurityMailIsNull() {
			addCriterion("security_mail is null");
			return (Criteria) this;
		}

		public Criteria andSecurityMailIsNotNull() {
			addCriterion("security_mail is not null");
			return (Criteria) this;
		}

		public Criteria andSecurityMailEqualTo(String value) {
			addCriterion("security_mail =", value, "securityMail");
			return (Criteria) this;
		}

		public Criteria andSecurityMailNotEqualTo(String value) {
			addCriterion("security_mail <>", value, "securityMail");
			return (Criteria) this;
		}

		public Criteria andSecurityMailGreaterThan(String value) {
			addCriterion("security_mail >", value, "securityMail");
			return (Criteria) this;
		}

		public Criteria andSecurityMailGreaterThanOrEqualTo(String value) {
			addCriterion("security_mail >=", value, "securityMail");
			return (Criteria) this;
		}

		public Criteria andSecurityMailLessThan(String value) {
			addCriterion("security_mail <", value, "securityMail");
			return (Criteria) this;
		}

		public Criteria andSecurityMailLessThanOrEqualTo(String value) {
			addCriterion("security_mail <=", value, "securityMail");
			return (Criteria) this;
		}

		public Criteria andSecurityMailLike(String value) {
			addCriterion("security_mail like", value, "securityMail");
			return (Criteria) this;
		}

		public Criteria andSecurityMailNotLike(String value) {
			addCriterion("security_mail not like", value, "securityMail");
			return (Criteria) this;
		}

		public Criteria andSecurityMailIn(List<String> values) {
			addCriterion("security_mail in", values, "securityMail");
			return (Criteria) this;
		}

		public Criteria andSecurityMailNotIn(List<String> values) {
			addCriterion("security_mail not in", values, "securityMail");
			return (Criteria) this;
		}

		public Criteria andSecurityMailBetween(String value1, String value2) {
			addCriterion("security_mail between", value1, value2, "securityMail");
			return (Criteria) this;
		}

		public Criteria andSecurityMailNotBetween(String value1, String value2) {
			addCriterion("security_mail not between", value1, value2, "securityMail");
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

		public Criteria andCreateEmpjobidIsNull() {
			addCriterion("create_empJobId is null");
			return (Criteria) this;
		}

		public Criteria andCreateEmpjobidIsNotNull() {
			addCriterion("create_empJobId is not null");
			return (Criteria) this;
		}

		public Criteria andCreateEmpjobidEqualTo(String value) {
			addCriterion("create_empJobId =", value, "createEmpjobid");
			return (Criteria) this;
		}

		public Criteria andCreateEmpjobidNotEqualTo(String value) {
			addCriterion("create_empJobId <>", value, "createEmpjobid");
			return (Criteria) this;
		}

		public Criteria andCreateEmpjobidGreaterThan(String value) {
			addCriterion("create_empJobId >", value, "createEmpjobid");
			return (Criteria) this;
		}

		public Criteria andCreateEmpjobidGreaterThanOrEqualTo(String value) {
			addCriterion("create_empJobId >=", value, "createEmpjobid");
			return (Criteria) this;
		}

		public Criteria andCreateEmpjobidLessThan(String value) {
			addCriterion("create_empJobId <", value, "createEmpjobid");
			return (Criteria) this;
		}

		public Criteria andCreateEmpjobidLessThanOrEqualTo(String value) {
			addCriterion("create_empJobId <=", value, "createEmpjobid");
			return (Criteria) this;
		}

		public Criteria andCreateEmpjobidLike(String value) {
			addCriterion("create_empJobId like", value, "createEmpjobid");
			return (Criteria) this;
		}

		public Criteria andCreateEmpjobidNotLike(String value) {
			addCriterion("create_empJobId not like", value, "createEmpjobid");
			return (Criteria) this;
		}

		public Criteria andCreateEmpjobidIn(List<String> values) {
			addCriterion("create_empJobId in", values, "createEmpjobid");
			return (Criteria) this;
		}

		public Criteria andCreateEmpjobidNotIn(List<String> values) {
			addCriterion("create_empJobId not in", values, "createEmpjobid");
			return (Criteria) this;
		}

		public Criteria andCreateEmpjobidBetween(String value1, String value2) {
			addCriterion("create_empJobId between", value1, value2, "createEmpjobid");
			return (Criteria) this;
		}

		public Criteria andCreateEmpjobidNotBetween(String value1, String value2) {
			addCriterion("create_empJobId not between", value1, value2, "createEmpjobid");
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

		public Criteria andLastOperatorDateIsNull() {
			addCriterion("last_operator_date is null");
			return (Criteria) this;
		}

		public Criteria andLastOperatorDateIsNotNull() {
			addCriterion("last_operator_date is not null");
			return (Criteria) this;
		}

		public Criteria andLastOperatorDateEqualTo(Date value) {
			addCriterion("last_operator_date =", value, "lastOperatorDate");
			return (Criteria) this;
		}

		public Criteria andLastOperatorDateNotEqualTo(Date value) {
			addCriterion("last_operator_date <>", value, "lastOperatorDate");
			return (Criteria) this;
		}

		public Criteria andLastOperatorDateGreaterThan(Date value) {
			addCriterion("last_operator_date >", value, "lastOperatorDate");
			return (Criteria) this;
		}

		public Criteria andLastOperatorDateGreaterThanOrEqualTo(Date value) {
			addCriterion("last_operator_date >=", value, "lastOperatorDate");
			return (Criteria) this;
		}

		public Criteria andLastOperatorDateLessThan(Date value) {
			addCriterion("last_operator_date <", value, "lastOperatorDate");
			return (Criteria) this;
		}

		public Criteria andLastOperatorDateLessThanOrEqualTo(Date value) {
			addCriterion("last_operator_date <=", value, "lastOperatorDate");
			return (Criteria) this;
		}

		public Criteria andLastOperatorDateIn(List<Date> values) {
			addCriterion("last_operator_date in", values, "lastOperatorDate");
			return (Criteria) this;
		}

		public Criteria andLastOperatorDateNotIn(List<Date> values) {
			addCriterion("last_operator_date not in", values, "lastOperatorDate");
			return (Criteria) this;
		}

		public Criteria andLastOperatorDateBetween(Date value1, Date value2) {
			addCriterion("last_operator_date between", value1, value2, "lastOperatorDate");
			return (Criteria) this;
		}

		public Criteria andLastOperatorDateNotBetween(Date value1, Date value2) {
			addCriterion("last_operator_date not between", value1, value2, "lastOperatorDate");
			return (Criteria) this;
		}

		public Criteria andOperatorEmpjobidIsNull() {
			addCriterion("operator_empJobId is null");
			return (Criteria) this;
		}

		public Criteria andOperatorEmpjobidIsNotNull() {
			addCriterion("operator_empJobId is not null");
			return (Criteria) this;
		}

		public Criteria andOperatorEmpjobidEqualTo(String value) {
			addCriterion("operator_empJobId =", value, "operatorEmpjobid");
			return (Criteria) this;
		}

		public Criteria andOperatorEmpjobidNotEqualTo(String value) {
			addCriterion("operator_empJobId <>", value, "operatorEmpjobid");
			return (Criteria) this;
		}

		public Criteria andOperatorEmpjobidGreaterThan(String value) {
			addCriterion("operator_empJobId >", value, "operatorEmpjobid");
			return (Criteria) this;
		}

		public Criteria andOperatorEmpjobidGreaterThanOrEqualTo(String value) {
			addCriterion("operator_empJobId >=", value, "operatorEmpjobid");
			return (Criteria) this;
		}

		public Criteria andOperatorEmpjobidLessThan(String value) {
			addCriterion("operator_empJobId <", value, "operatorEmpjobid");
			return (Criteria) this;
		}

		public Criteria andOperatorEmpjobidLessThanOrEqualTo(String value) {
			addCriterion("operator_empJobId <=", value, "operatorEmpjobid");
			return (Criteria) this;
		}

		public Criteria andOperatorEmpjobidLike(String value) {
			addCriterion("operator_empJobId like", value, "operatorEmpjobid");
			return (Criteria) this;
		}

		public Criteria andOperatorEmpjobidNotLike(String value) {
			addCriterion("operator_empJobId not like", value, "operatorEmpjobid");
			return (Criteria) this;
		}

		public Criteria andOperatorEmpjobidIn(List<String> values) {
			addCriterion("operator_empJobId in", values, "operatorEmpjobid");
			return (Criteria) this;
		}

		public Criteria andOperatorEmpjobidNotIn(List<String> values) {
			addCriterion("operator_empJobId not in", values, "operatorEmpjobid");
			return (Criteria) this;
		}

		public Criteria andOperatorEmpjobidBetween(String value1, String value2) {
			addCriterion("operator_empJobId between", value1, value2, "operatorEmpjobid");
			return (Criteria) this;
		}

		public Criteria andOperatorEmpjobidNotBetween(String value1, String value2) {
			addCriterion("operator_empJobId not between", value1, value2, "operatorEmpjobid");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table user
	 * @mbg.generated  Tue Apr 07 12:42:26 CST 2020
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
     * @mbg.generated do_not_delete_during_merge Tue Apr 07 12:42:26 CST 2020
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }
}