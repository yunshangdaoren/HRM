package com.lqs.hrm.entity;

import java.util.ArrayList;
import java.util.List;

public class EmployeeContractExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table employee_contract
	 * @mbg.generated  Mon May 25 00:12:41 CST 2020
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table employee_contract
	 * @mbg.generated  Mon May 25 00:12:41 CST 2020
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table employee_contract
	 * @mbg.generated  Mon May 25 00:12:41 CST 2020
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table employee_contract
	 * @mbg.generated  Mon May 25 00:12:41 CST 2020
	 */
	public EmployeeContractExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table employee_contract
	 * @mbg.generated  Mon May 25 00:12:41 CST 2020
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table employee_contract
	 * @mbg.generated  Mon May 25 00:12:41 CST 2020
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table employee_contract
	 * @mbg.generated  Mon May 25 00:12:41 CST 2020
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table employee_contract
	 * @mbg.generated  Mon May 25 00:12:41 CST 2020
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table employee_contract
	 * @mbg.generated  Mon May 25 00:12:41 CST 2020
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table employee_contract
	 * @mbg.generated  Mon May 25 00:12:41 CST 2020
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table employee_contract
	 * @mbg.generated  Mon May 25 00:12:41 CST 2020
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table employee_contract
	 * @mbg.generated  Mon May 25 00:12:41 CST 2020
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table employee_contract
	 * @mbg.generated  Mon May 25 00:12:41 CST 2020
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table employee_contract
	 * @mbg.generated  Mon May 25 00:12:41 CST 2020
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table employee_contract
	 * @mbg.generated  Mon May 25 00:12:41 CST 2020
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

		public Criteria andEcIdIsNull() {
			addCriterion("ec_id is null");
			return (Criteria) this;
		}

		public Criteria andEcIdIsNotNull() {
			addCriterion("ec_id is not null");
			return (Criteria) this;
		}

		public Criteria andEcIdEqualTo(Integer value) {
			addCriterion("ec_id =", value, "ecId");
			return (Criteria) this;
		}

		public Criteria andEcIdNotEqualTo(Integer value) {
			addCriterion("ec_id <>", value, "ecId");
			return (Criteria) this;
		}

		public Criteria andEcIdGreaterThan(Integer value) {
			addCriterion("ec_id >", value, "ecId");
			return (Criteria) this;
		}

		public Criteria andEcIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ec_id >=", value, "ecId");
			return (Criteria) this;
		}

		public Criteria andEcIdLessThan(Integer value) {
			addCriterion("ec_id <", value, "ecId");
			return (Criteria) this;
		}

		public Criteria andEcIdLessThanOrEqualTo(Integer value) {
			addCriterion("ec_id <=", value, "ecId");
			return (Criteria) this;
		}

		public Criteria andEcIdIn(List<Integer> values) {
			addCriterion("ec_id in", values, "ecId");
			return (Criteria) this;
		}

		public Criteria andEcIdNotIn(List<Integer> values) {
			addCriterion("ec_id not in", values, "ecId");
			return (Criteria) this;
		}

		public Criteria andEcIdBetween(Integer value1, Integer value2) {
			addCriterion("ec_id between", value1, value2, "ecId");
			return (Criteria) this;
		}

		public Criteria andEcIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ec_id not between", value1, value2, "ecId");
			return (Criteria) this;
		}

		public Criteria andConIdIsNull() {
			addCriterion("con_id is null");
			return (Criteria) this;
		}

		public Criteria andConIdIsNotNull() {
			addCriterion("con_id is not null");
			return (Criteria) this;
		}

		public Criteria andConIdEqualTo(Integer value) {
			addCriterion("con_id =", value, "conId");
			return (Criteria) this;
		}

		public Criteria andConIdNotEqualTo(Integer value) {
			addCriterion("con_id <>", value, "conId");
			return (Criteria) this;
		}

		public Criteria andConIdGreaterThan(Integer value) {
			addCriterion("con_id >", value, "conId");
			return (Criteria) this;
		}

		public Criteria andConIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("con_id >=", value, "conId");
			return (Criteria) this;
		}

		public Criteria andConIdLessThan(Integer value) {
			addCriterion("con_id <", value, "conId");
			return (Criteria) this;
		}

		public Criteria andConIdLessThanOrEqualTo(Integer value) {
			addCriterion("con_id <=", value, "conId");
			return (Criteria) this;
		}

		public Criteria andConIdIn(List<Integer> values) {
			addCriterion("con_id in", values, "conId");
			return (Criteria) this;
		}

		public Criteria andConIdNotIn(List<Integer> values) {
			addCriterion("con_id not in", values, "conId");
			return (Criteria) this;
		}

		public Criteria andConIdBetween(Integer value1, Integer value2) {
			addCriterion("con_id between", value1, value2, "conId");
			return (Criteria) this;
		}

		public Criteria andConIdNotBetween(Integer value1, Integer value2) {
			addCriterion("con_id not between", value1, value2, "conId");
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
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table employee_contract
	 * @mbg.generated  Mon May 25 00:12:41 CST 2020
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
     * This class corresponds to the database table employee_contract
     *
     * @mbg.generated do_not_delete_during_merge Tue May 19 13:47:12 CST 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}