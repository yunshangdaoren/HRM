package com.lqs.hrm.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 考勤时间设置实体类
 * @author luckyliuqs
 *
 */
public class AttendanceEmployeeExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table attendance_employee
	 * @mbg.generated  Mon May 25 19:54:19 CST 2020
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table attendance_employee
	 * @mbg.generated  Mon May 25 19:54:19 CST 2020
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table attendance_employee
	 * @mbg.generated  Mon May 25 19:54:19 CST 2020
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table attendance_employee
	 * @mbg.generated  Mon May 25 19:54:19 CST 2020
	 */
	public AttendanceEmployeeExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table attendance_employee
	 * @mbg.generated  Mon May 25 19:54:19 CST 2020
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table attendance_employee
	 * @mbg.generated  Mon May 25 19:54:19 CST 2020
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table attendance_employee
	 * @mbg.generated  Mon May 25 19:54:19 CST 2020
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table attendance_employee
	 * @mbg.generated  Mon May 25 19:54:19 CST 2020
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table attendance_employee
	 * @mbg.generated  Mon May 25 19:54:19 CST 2020
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table attendance_employee
	 * @mbg.generated  Mon May 25 19:54:19 CST 2020
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table attendance_employee
	 * @mbg.generated  Mon May 25 19:54:19 CST 2020
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table attendance_employee
	 * @mbg.generated  Mon May 25 19:54:19 CST 2020
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table attendance_employee
	 * @mbg.generated  Mon May 25 19:54:19 CST 2020
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table attendance_employee
	 * @mbg.generated  Mon May 25 19:54:19 CST 2020
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table attendance_employee
	 * @mbg.generated  Mon May 25 19:54:19 CST 2020
	 */
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
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

		public Criteria andAeIdIsNull() {
			addCriterion("ae_id is null");
			return (Criteria) this;
		}

		public Criteria andAeIdIsNotNull() {
			addCriterion("ae_id is not null");
			return (Criteria) this;
		}

		public Criteria andAeIdEqualTo(Integer value) {
			addCriterion("ae_id =", value, "aeId");
			return (Criteria) this;
		}

		public Criteria andAeIdNotEqualTo(Integer value) {
			addCriterion("ae_id <>", value, "aeId");
			return (Criteria) this;
		}

		public Criteria andAeIdGreaterThan(Integer value) {
			addCriterion("ae_id >", value, "aeId");
			return (Criteria) this;
		}

		public Criteria andAeIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ae_id >=", value, "aeId");
			return (Criteria) this;
		}

		public Criteria andAeIdLessThan(Integer value) {
			addCriterion("ae_id <", value, "aeId");
			return (Criteria) this;
		}

		public Criteria andAeIdLessThanOrEqualTo(Integer value) {
			addCriterion("ae_id <=", value, "aeId");
			return (Criteria) this;
		}

		public Criteria andAeIdIn(List<Integer> values) {
			addCriterion("ae_id in", values, "aeId");
			return (Criteria) this;
		}

		public Criteria andAeIdNotIn(List<Integer> values) {
			addCriterion("ae_id not in", values, "aeId");
			return (Criteria) this;
		}

		public Criteria andAeIdBetween(Integer value1, Integer value2) {
			addCriterion("ae_id between", value1, value2, "aeId");
			return (Criteria) this;
		}

		public Criteria andAeIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ae_id not between", value1, value2, "aeId");
			return (Criteria) this;
		}

		public Criteria andDateIsNull() {
			addCriterion("date is null");
			return (Criteria) this;
		}

		public Criteria andDateIsNotNull() {
			addCriterion("date is not null");
			return (Criteria) this;
		}

		public Criteria andDateEqualTo(Date value) {
			addCriterion("date =", value, "date");
			return (Criteria) this;
		}

		public Criteria andDateNotEqualTo(Date value) {
			addCriterion("date <>", value, "date");
			return (Criteria) this;
		}

		public Criteria andDateGreaterThan(Date value) {
			addCriterion("date >", value, "date");
			return (Criteria) this;
		}

		public Criteria andDateGreaterThanOrEqualTo(Date value) {
			addCriterion("date >=", value, "date");
			return (Criteria) this;
		}

		public Criteria andDateLessThan(Date value) {
			addCriterion("date <", value, "date");
			return (Criteria) this;
		}

		public Criteria andDateLessThanOrEqualTo(Date value) {
			addCriterion("date <=", value, "date");
			return (Criteria) this;
		}

		public Criteria andDateIn(List<Date> values) {
			addCriterion("date in", values, "date");
			return (Criteria) this;
		}

		public Criteria andDateNotIn(List<Date> values) {
			addCriterion("date not in", values, "date");
			return (Criteria) this;
		}

		public Criteria andDateBetween(Date value1, Date value2) {
			addCriterion("date between", value1, value2, "date");
			return (Criteria) this;
		}

		public Criteria andDateNotBetween(Date value1, Date value2) {
			addCriterion("date not between", value1, value2, "date");
			return (Criteria) this;
		}

		public Criteria andSignTimeIsNull() {
			addCriterion("sign_time is null");
			return (Criteria) this;
		}

		public Criteria andSignTimeIsNotNull() {
			addCriterion("sign_time is not null");
			return (Criteria) this;
		}

		public Criteria andSignTimeEqualTo(Date value) {
			addCriterion("sign_time =", value, "signTime");
			return (Criteria) this;
		}

		public Criteria andSignTimeNotEqualTo(Date value) {
			addCriterion("sign_time <>", value, "signTime");
			return (Criteria) this;
		}

		public Criteria andSignTimeGreaterThan(Date value) {
			addCriterion("sign_time >", value, "signTime");
			return (Criteria) this;
		}

		public Criteria andSignTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("sign_time >=", value, "signTime");
			return (Criteria) this;
		}

		public Criteria andSignTimeLessThan(Date value) {
			addCriterion("sign_time <", value, "signTime");
			return (Criteria) this;
		}

		public Criteria andSignTimeLessThanOrEqualTo(Date value) {
			addCriterion("sign_time <=", value, "signTime");
			return (Criteria) this;
		}

		public Criteria andSignTimeIn(List<Date> values) {
			addCriterion("sign_time in", values, "signTime");
			return (Criteria) this;
		}

		public Criteria andSignTimeNotIn(List<Date> values) {
			addCriterion("sign_time not in", values, "signTime");
			return (Criteria) this;
		}

		public Criteria andSignTimeBetween(Date value1, Date value2) {
			addCriterion("sign_time between", value1, value2, "signTime");
			return (Criteria) this;
		}

		public Criteria andSignTimeNotBetween(Date value1, Date value2) {
			addCriterion("sign_time not between", value1, value2, "signTime");
			return (Criteria) this;
		}

		public Criteria andLogoutTimeIsNull() {
			addCriterion("logout_time is null");
			return (Criteria) this;
		}

		public Criteria andLogoutTimeIsNotNull() {
			addCriterion("logout_time is not null");
			return (Criteria) this;
		}

		public Criteria andLogoutTimeEqualTo(Date value) {
			addCriterion("logout_time =", value, "logoutTime");
			return (Criteria) this;
		}

		public Criteria andLogoutTimeNotEqualTo(Date value) {
			addCriterion("logout_time <>", value, "logoutTime");
			return (Criteria) this;
		}

		public Criteria andLogoutTimeGreaterThan(Date value) {
			addCriterion("logout_time >", value, "logoutTime");
			return (Criteria) this;
		}

		public Criteria andLogoutTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("logout_time >=", value, "logoutTime");
			return (Criteria) this;
		}

		public Criteria andLogoutTimeLessThan(Date value) {
			addCriterion("logout_time <", value, "logoutTime");
			return (Criteria) this;
		}

		public Criteria andLogoutTimeLessThanOrEqualTo(Date value) {
			addCriterion("logout_time <=", value, "logoutTime");
			return (Criteria) this;
		}

		public Criteria andLogoutTimeIn(List<Date> values) {
			addCriterion("logout_time in", values, "logoutTime");
			return (Criteria) this;
		}

		public Criteria andLogoutTimeNotIn(List<Date> values) {
			addCriterion("logout_time not in", values, "logoutTime");
			return (Criteria) this;
		}

		public Criteria andLogoutTimeBetween(Date value1, Date value2) {
			addCriterion("logout_time between", value1, value2, "logoutTime");
			return (Criteria) this;
		}

		public Criteria andLogoutTimeNotBetween(Date value1, Date value2) {
			addCriterion("logout_time not between", value1, value2, "logoutTime");
			return (Criteria) this;
		}

		public Criteria andEmpJobidIsNull() {
			addCriterion("emp_jobId is null");
			return (Criteria) this;
		}

		public Criteria andEmpJobidIsNotNull() {
			addCriterion("emp_jobId is not null");
			return (Criteria) this;
		}

		public Criteria andEmpJobidEqualTo(String value) {
			addCriterion("emp_jobId =", value, "empJobid");
			return (Criteria) this;
		}

		public Criteria andEmpJobidNotEqualTo(String value) {
			addCriterion("emp_jobId <>", value, "empJobid");
			return (Criteria) this;
		}

		public Criteria andEmpJobidGreaterThan(String value) {
			addCriterion("emp_jobId >", value, "empJobid");
			return (Criteria) this;
		}

		public Criteria andEmpJobidGreaterThanOrEqualTo(String value) {
			addCriterion("emp_jobId >=", value, "empJobid");
			return (Criteria) this;
		}

		public Criteria andEmpJobidLessThan(String value) {
			addCriterion("emp_jobId <", value, "empJobid");
			return (Criteria) this;
		}

		public Criteria andEmpJobidLessThanOrEqualTo(String value) {
			addCriterion("emp_jobId <=", value, "empJobid");
			return (Criteria) this;
		}

		public Criteria andEmpJobidLike(String value) {
			addCriterion("emp_jobId like", value, "empJobid");
			return (Criteria) this;
		}

		public Criteria andEmpJobidNotLike(String value) {
			addCriterion("emp_jobId not like", value, "empJobid");
			return (Criteria) this;
		}

		public Criteria andEmpJobidIn(List<String> values) {
			addCriterion("emp_jobId in", values, "empJobid");
			return (Criteria) this;
		}

		public Criteria andEmpJobidNotIn(List<String> values) {
			addCriterion("emp_jobId not in", values, "empJobid");
			return (Criteria) this;
		}

		public Criteria andEmpJobidBetween(String value1, String value2) {
			addCriterion("emp_jobId between", value1, value2, "empJobid");
			return (Criteria) this;
		}

		public Criteria andEmpJobidNotBetween(String value1, String value2) {
			addCriterion("emp_jobId not between", value1, value2, "empJobid");
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
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table attendance_employee
	 * @mbg.generated  Mon May 25 19:54:19 CST 2020
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
     * This class corresponds to the database table attendance_employee
     *
     * @mbg.generated do_not_delete_during_merge Mon May 25 19:23:51 CST 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}