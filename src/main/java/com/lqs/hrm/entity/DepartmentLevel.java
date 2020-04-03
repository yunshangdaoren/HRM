package com.lqs.hrm.entity;

import java.util.Date;

public class DepartmentLevel {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column department_level.dl_id
     *
     * @mbg.generated Wed Apr 01 12:26:27 CST 2020
     */
    private Integer dlId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column department_level.level
     *
     * @mbg.generated Wed Apr 01 12:26:27 CST 2020
     */
    private Integer level;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column department_level.level_desc
     *
     * @mbg.generated Wed Apr 01 12:26:27 CST 2020
     */
    private String levelDesc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column department_level.last_operator_date
     *
     * @mbg.generated Wed Apr 01 12:26:27 CST 2020
     */
    private Date lastOperatorDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column department_level.operator_empJobId
     *
     * @mbg.generated Wed Apr 01 12:26:27 CST 2020
     */
    private String operatorEmpjobid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column department_level.dl_id
     *
     * @return the value of department_level.dl_id
     *
     * @mbg.generated Wed Apr 01 12:26:27 CST 2020
     */
    public Integer getDlId() {
        return dlId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column department_level.dl_id
     *
     * @param dlId the value for department_level.dl_id
     *
     * @mbg.generated Wed Apr 01 12:26:27 CST 2020
     */
    public void setDlId(Integer dlId) {
        this.dlId = dlId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column department_level.level
     *
     * @return the value of department_level.level
     *
     * @mbg.generated Wed Apr 01 12:26:27 CST 2020
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column department_level.level
     *
     * @param level the value for department_level.level
     *
     * @mbg.generated Wed Apr 01 12:26:27 CST 2020
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column department_level.level_desc
     *
     * @return the value of department_level.level_desc
     *
     * @mbg.generated Wed Apr 01 12:26:27 CST 2020
     */
    public String getLevelDesc() {
        return levelDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column department_level.level_desc
     *
     * @param levelDesc the value for department_level.level_desc
     *
     * @mbg.generated Wed Apr 01 12:26:27 CST 2020
     */
    public void setLevelDesc(String levelDesc) {
        this.levelDesc = levelDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column department_level.last_operator_date
     *
     * @return the value of department_level.last_operator_date
     *
     * @mbg.generated Wed Apr 01 12:26:27 CST 2020
     */
    public Date getLastOperatorDate() {
        return lastOperatorDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column department_level.last_operator_date
     *
     * @param lastOperatorDate the value for department_level.last_operator_date
     *
     * @mbg.generated Wed Apr 01 12:26:27 CST 2020
     */
    public void setLastOperatorDate(Date lastOperatorDate) {
        this.lastOperatorDate = lastOperatorDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column department_level.operator_empJobId
     *
     * @return the value of department_level.operator_empJobId
     *
     * @mbg.generated Wed Apr 01 12:26:27 CST 2020
     */
    public String getOperatorEmpjobid() {
        return operatorEmpjobid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column department_level.operator_empJobId
     *
     * @param operatorEmpjobid the value for department_level.operator_empJobId
     *
     * @mbg.generated Wed Apr 01 12:26:27 CST 2020
     */
    public void setOperatorEmpjobid(String operatorEmpjobid) {
        this.operatorEmpjobid = operatorEmpjobid;
    }
}