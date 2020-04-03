package com.lqs.hrm.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DepartmentExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table department
     *
     * @mbg.generated Wed Apr 01 12:40:26 CST 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table department
     *
     * @mbg.generated Wed Apr 01 12:40:26 CST 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table department
     *
     * @mbg.generated Wed Apr 01 12:40:26 CST 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table department
     *
     * @mbg.generated Wed Apr 01 12:40:26 CST 2020
     */
    public DepartmentExample() {
        oredCriteria = new ArrayList<>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table department
     *
     * @mbg.generated Wed Apr 01 12:40:26 CST 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table department
     *
     * @mbg.generated Wed Apr 01 12:40:26 CST 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table department
     *
     * @mbg.generated Wed Apr 01 12:40:26 CST 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table department
     *
     * @mbg.generated Wed Apr 01 12:40:26 CST 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table department
     *
     * @mbg.generated Wed Apr 01 12:40:26 CST 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table department
     *
     * @mbg.generated Wed Apr 01 12:40:26 CST 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table department
     *
     * @mbg.generated Wed Apr 01 12:40:26 CST 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table department
     *
     * @mbg.generated Wed Apr 01 12:40:26 CST 2020
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table department
     *
     * @mbg.generated Wed Apr 01 12:40:26 CST 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table department
     *
     * @mbg.generated Wed Apr 01 12:40:26 CST 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table department
     *
     * @mbg.generated Wed Apr 01 12:40:26 CST 2020
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

        public Criteria andDeptIdIsNull() {
            addCriterion("dept_id is null");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNotNull() {
            addCriterion("dept_id is not null");
            return (Criteria) this;
        }

        public Criteria andDeptIdEqualTo(Integer value) {
            addCriterion("dept_id =", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotEqualTo(Integer value) {
            addCriterion("dept_id <>", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThan(Integer value) {
            addCriterion("dept_id >", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("dept_id >=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThan(Integer value) {
            addCriterion("dept_id <", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThanOrEqualTo(Integer value) {
            addCriterion("dept_id <=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdIn(List<Integer> values) {
            addCriterion("dept_id in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotIn(List<Integer> values) {
            addCriterion("dept_id not in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdBetween(Integer value1, Integer value2) {
            addCriterion("dept_id between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotBetween(Integer value1, Integer value2) {
            addCriterion("dept_id not between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptNameIsNull() {
            addCriterion("dept_name is null");
            return (Criteria) this;
        }

        public Criteria andDeptNameIsNotNull() {
            addCriterion("dept_name is not null");
            return (Criteria) this;
        }

        public Criteria andDeptNameEqualTo(String value) {
            addCriterion("dept_name =", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotEqualTo(String value) {
            addCriterion("dept_name <>", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameGreaterThan(String value) {
            addCriterion("dept_name >", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameGreaterThanOrEqualTo(String value) {
            addCriterion("dept_name >=", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameLessThan(String value) {
            addCriterion("dept_name <", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameLessThanOrEqualTo(String value) {
            addCriterion("dept_name <=", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameLike(String value) {
            addCriterion("dept_name like", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotLike(String value) {
            addCriterion("dept_name not like", value, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameIn(List<String> values) {
            addCriterion("dept_name in", values, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotIn(List<String> values) {
            addCriterion("dept_name not in", values, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameBetween(String value1, String value2) {
            addCriterion("dept_name between", value1, value2, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptNameNotBetween(String value1, String value2) {
            addCriterion("dept_name not between", value1, value2, "deptName");
            return (Criteria) this;
        }

        public Criteria andDeptDescIsNull() {
            addCriterion("dept_desc is null");
            return (Criteria) this;
        }

        public Criteria andDeptDescIsNotNull() {
            addCriterion("dept_desc is not null");
            return (Criteria) this;
        }

        public Criteria andDeptDescEqualTo(String value) {
            addCriterion("dept_desc =", value, "deptDesc");
            return (Criteria) this;
        }

        public Criteria andDeptDescNotEqualTo(String value) {
            addCriterion("dept_desc <>", value, "deptDesc");
            return (Criteria) this;
        }

        public Criteria andDeptDescGreaterThan(String value) {
            addCriterion("dept_desc >", value, "deptDesc");
            return (Criteria) this;
        }

        public Criteria andDeptDescGreaterThanOrEqualTo(String value) {
            addCriterion("dept_desc >=", value, "deptDesc");
            return (Criteria) this;
        }

        public Criteria andDeptDescLessThan(String value) {
            addCriterion("dept_desc <", value, "deptDesc");
            return (Criteria) this;
        }

        public Criteria andDeptDescLessThanOrEqualTo(String value) {
            addCriterion("dept_desc <=", value, "deptDesc");
            return (Criteria) this;
        }

        public Criteria andDeptDescLike(String value) {
            addCriterion("dept_desc like", value, "deptDesc");
            return (Criteria) this;
        }

        public Criteria andDeptDescNotLike(String value) {
            addCriterion("dept_desc not like", value, "deptDesc");
            return (Criteria) this;
        }

        public Criteria andDeptDescIn(List<String> values) {
            addCriterion("dept_desc in", values, "deptDesc");
            return (Criteria) this;
        }

        public Criteria andDeptDescNotIn(List<String> values) {
            addCriterion("dept_desc not in", values, "deptDesc");
            return (Criteria) this;
        }

        public Criteria andDeptDescBetween(String value1, String value2) {
            addCriterion("dept_desc between", value1, value2, "deptDesc");
            return (Criteria) this;
        }

        public Criteria andDeptDescNotBetween(String value1, String value2) {
            addCriterion("dept_desc not between", value1, value2, "deptDesc");
            return (Criteria) this;
        }

        public Criteria andDlIdIsNull() {
            addCriterion("dl_id is null");
            return (Criteria) this;
        }

        public Criteria andDlIdIsNotNull() {
            addCriterion("dl_id is not null");
            return (Criteria) this;
        }

        public Criteria andDlIdEqualTo(Integer value) {
            addCriterion("dl_id =", value, "dlId");
            return (Criteria) this;
        }

        public Criteria andDlIdNotEqualTo(Integer value) {
            addCriterion("dl_id <>", value, "dlId");
            return (Criteria) this;
        }

        public Criteria andDlIdGreaterThan(Integer value) {
            addCriterion("dl_id >", value, "dlId");
            return (Criteria) this;
        }

        public Criteria andDlIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("dl_id >=", value, "dlId");
            return (Criteria) this;
        }

        public Criteria andDlIdLessThan(Integer value) {
            addCriterion("dl_id <", value, "dlId");
            return (Criteria) this;
        }

        public Criteria andDlIdLessThanOrEqualTo(Integer value) {
            addCriterion("dl_id <=", value, "dlId");
            return (Criteria) this;
        }

        public Criteria andDlIdIn(List<Integer> values) {
            addCriterion("dl_id in", values, "dlId");
            return (Criteria) this;
        }

        public Criteria andDlIdNotIn(List<Integer> values) {
            addCriterion("dl_id not in", values, "dlId");
            return (Criteria) this;
        }

        public Criteria andDlIdBetween(Integer value1, Integer value2) {
            addCriterion("dl_id between", value1, value2, "dlId");
            return (Criteria) this;
        }

        public Criteria andDlIdNotBetween(Integer value1, Integer value2) {
            addCriterion("dl_id not between", value1, value2, "dlId");
            return (Criteria) this;
        }

        public Criteria andDeptEmpnumIsNull() {
            addCriterion("dept_empNum is null");
            return (Criteria) this;
        }

        public Criteria andDeptEmpnumIsNotNull() {
            addCriterion("dept_empNum is not null");
            return (Criteria) this;
        }

        public Criteria andDeptEmpnumEqualTo(Integer value) {
            addCriterion("dept_empNum =", value, "deptEmpnum");
            return (Criteria) this;
        }

        public Criteria andDeptEmpnumNotEqualTo(Integer value) {
            addCriterion("dept_empNum <>", value, "deptEmpnum");
            return (Criteria) this;
        }

        public Criteria andDeptEmpnumGreaterThan(Integer value) {
            addCriterion("dept_empNum >", value, "deptEmpnum");
            return (Criteria) this;
        }

        public Criteria andDeptEmpnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("dept_empNum >=", value, "deptEmpnum");
            return (Criteria) this;
        }

        public Criteria andDeptEmpnumLessThan(Integer value) {
            addCriterion("dept_empNum <", value, "deptEmpnum");
            return (Criteria) this;
        }

        public Criteria andDeptEmpnumLessThanOrEqualTo(Integer value) {
            addCriterion("dept_empNum <=", value, "deptEmpnum");
            return (Criteria) this;
        }

        public Criteria andDeptEmpnumIn(List<Integer> values) {
            addCriterion("dept_empNum in", values, "deptEmpnum");
            return (Criteria) this;
        }

        public Criteria andDeptEmpnumNotIn(List<Integer> values) {
            addCriterion("dept_empNum not in", values, "deptEmpnum");
            return (Criteria) this;
        }

        public Criteria andDeptEmpnumBetween(Integer value1, Integer value2) {
            addCriterion("dept_empNum between", value1, value2, "deptEmpnum");
            return (Criteria) this;
        }

        public Criteria andDeptEmpnumNotBetween(Integer value1, Integer value2) {
            addCriterion("dept_empNum not between", value1, value2, "deptEmpnum");
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

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Integer value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Integer value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Integer value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Integer value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Integer> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Integer> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Integer value1, Integer value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andManageEmpjobidIsNull() {
            addCriterion("manage_empJobId is null");
            return (Criteria) this;
        }

        public Criteria andManageEmpjobidIsNotNull() {
            addCriterion("manage_empJobId is not null");
            return (Criteria) this;
        }

        public Criteria andManageEmpjobidEqualTo(String value) {
            addCriterion("manage_empJobId =", value, "manageEmpjobid");
            return (Criteria) this;
        }

        public Criteria andManageEmpjobidNotEqualTo(String value) {
            addCriterion("manage_empJobId <>", value, "manageEmpjobid");
            return (Criteria) this;
        }

        public Criteria andManageEmpjobidGreaterThan(String value) {
            addCriterion("manage_empJobId >", value, "manageEmpjobid");
            return (Criteria) this;
        }

        public Criteria andManageEmpjobidGreaterThanOrEqualTo(String value) {
            addCriterion("manage_empJobId >=", value, "manageEmpjobid");
            return (Criteria) this;
        }

        public Criteria andManageEmpjobidLessThan(String value) {
            addCriterion("manage_empJobId <", value, "manageEmpjobid");
            return (Criteria) this;
        }

        public Criteria andManageEmpjobidLessThanOrEqualTo(String value) {
            addCriterion("manage_empJobId <=", value, "manageEmpjobid");
            return (Criteria) this;
        }

        public Criteria andManageEmpjobidLike(String value) {
            addCriterion("manage_empJobId like", value, "manageEmpjobid");
            return (Criteria) this;
        }

        public Criteria andManageEmpjobidNotLike(String value) {
            addCriterion("manage_empJobId not like", value, "manageEmpjobid");
            return (Criteria) this;
        }

        public Criteria andManageEmpjobidIn(List<String> values) {
            addCriterion("manage_empJobId in", values, "manageEmpjobid");
            return (Criteria) this;
        }

        public Criteria andManageEmpjobidNotIn(List<String> values) {
            addCriterion("manage_empJobId not in", values, "manageEmpjobid");
            return (Criteria) this;
        }

        public Criteria andManageEmpjobidBetween(String value1, String value2) {
            addCriterion("manage_empJobId between", value1, value2, "manageEmpjobid");
            return (Criteria) this;
        }

        public Criteria andManageEmpjobidNotBetween(String value1, String value2) {
            addCriterion("manage_empJobId not between", value1, value2, "manageEmpjobid");
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
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table department
     *
     * @mbg.generated do_not_delete_during_merge Wed Apr 01 12:40:26 CST 2020
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table department
     *
     * @mbg.generated Wed Apr 01 12:40:26 CST 2020
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
}