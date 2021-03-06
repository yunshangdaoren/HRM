package com.lqs.hrm.entity;

import java.util.Date;

/**
 * 职位实体类
 * @author luckyliuqs
 *
 */
public class Position {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column position.position_id
	 * @mbg.generated  Mon May 25 00:11:54 CST 2020
	 */
	private Integer positionId;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column position.position_name
	 * @mbg.generated  Mon May 25 00:11:54 CST 2020
	 */
	private String positionName;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column position.position_desc
	 * @mbg.generated  Mon May 25 00:11:54 CST 2020
	 */
	private String positionDesc;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column position.pl_id
	 * @mbg.generated  Mon May 25 00:11:54 CST 2020
	 */
	private Integer plId;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column position.dept_id
	 * @mbg.generated  Mon May 25 00:11:54 CST 2020
	 */
	private Integer deptId;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column position.parent_positionId
	 * @mbg.generated  Mon May 25 00:11:54 CST 2020
	 */
	private Integer parentPositionid;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column position.status_id
	 * @mbg.generated  Mon May 25 00:11:54 CST 2020
	 */
	private Integer statusId;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column position.last_operator_date
	 * @mbg.generated  Mon May 25 00:11:54 CST 2020
	 */
	private Date lastOperatorDate;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column position.operator_empJobId
	 * @mbg.generated  Mon May 25 00:11:54 CST 2020
	 */
	private String operatorEmpjobid;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column position.is_only
	 * @mbg.generated  Mon May 25 00:11:54 CST 2020
	 */
	private Boolean isOnly;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column position.position_id
	 * @return  the value of position.position_id
	 * @mbg.generated  Mon May 25 00:11:54 CST 2020
	 */
	public Integer getPositionId() {
		return positionId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column position.position_id
	 * @param positionId  the value for position.position_id
	 * @mbg.generated  Mon May 25 00:11:54 CST 2020
	 */
	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column position.position_name
	 * @return  the value of position.position_name
	 * @mbg.generated  Mon May 25 00:11:54 CST 2020
	 */
	public String getPositionName() {
		return positionName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column position.position_name
	 * @param positionName  the value for position.position_name
	 * @mbg.generated  Mon May 25 00:11:54 CST 2020
	 */
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column position.position_desc
	 * @return  the value of position.position_desc
	 * @mbg.generated  Mon May 25 00:11:54 CST 2020
	 */
	public String getPositionDesc() {
		return positionDesc;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column position.position_desc
	 * @param positionDesc  the value for position.position_desc
	 * @mbg.generated  Mon May 25 00:11:54 CST 2020
	 */
	public void setPositionDesc(String positionDesc) {
		this.positionDesc = positionDesc;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column position.pl_id
	 * @return  the value of position.pl_id
	 * @mbg.generated  Mon May 25 00:11:54 CST 2020
	 */
	public Integer getPlId() {
		return plId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column position.pl_id
	 * @param plId  the value for position.pl_id
	 * @mbg.generated  Mon May 25 00:11:54 CST 2020
	 */
	public void setPlId(Integer plId) {
		this.plId = plId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column position.dept_id
	 * @return  the value of position.dept_id
	 * @mbg.generated  Mon May 25 00:11:54 CST 2020
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column position.dept_id
	 * @param deptId  the value for position.dept_id
	 * @mbg.generated  Mon May 25 00:11:54 CST 2020
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column position.parent_positionId
	 * @return  the value of position.parent_positionId
	 * @mbg.generated  Mon May 25 00:11:54 CST 2020
	 */
	public Integer getParentPositionid() {
		return parentPositionid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column position.parent_positionId
	 * @param parentPositionid  the value for position.parent_positionId
	 * @mbg.generated  Mon May 25 00:11:54 CST 2020
	 */
	public void setParentPositionid(Integer parentPositionid) {
		this.parentPositionid = parentPositionid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column position.status_id
	 * @return  the value of position.status_id
	 * @mbg.generated  Mon May 25 00:11:54 CST 2020
	 */
	public Integer getStatusId() {
		return statusId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column position.status_id
	 * @param statusId  the value for position.status_id
	 * @mbg.generated  Mon May 25 00:11:54 CST 2020
	 */
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column position.last_operator_date
	 * @return  the value of position.last_operator_date
	 * @mbg.generated  Mon May 25 00:11:54 CST 2020
	 */
	public Date getLastOperatorDate() {
		return lastOperatorDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column position.last_operator_date
	 * @param lastOperatorDate  the value for position.last_operator_date
	 * @mbg.generated  Mon May 25 00:11:54 CST 2020
	 */
	public void setLastOperatorDate(Date lastOperatorDate) {
		this.lastOperatorDate = lastOperatorDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column position.operator_empJobId
	 * @return  the value of position.operator_empJobId
	 * @mbg.generated  Mon May 25 00:11:54 CST 2020
	 */
	public String getOperatorEmpjobid() {
		return operatorEmpjobid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column position.operator_empJobId
	 * @param operatorEmpjobid  the value for position.operator_empJobId
	 * @mbg.generated  Mon May 25 00:11:54 CST 2020
	 */
	public void setOperatorEmpjobid(String operatorEmpjobid) {
		this.operatorEmpjobid = operatorEmpjobid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column position.is_only
	 * @return  the value of position.is_only
	 * @mbg.generated  Mon May 25 00:11:54 CST 2020
	 */
	public Boolean getIsOnly() {
		return isOnly;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column position.is_only
	 * @param isOnly  the value for position.is_only
	 * @mbg.generated  Mon May 25 00:11:54 CST 2020
	 */
	public void setIsOnly(Boolean isOnly) {
		this.isOnly = isOnly;
	}

	/**
     * 职位级别
     */
    private Integer plLeve;
    
    /**
     * 职位级别描述
     */
    private String plLevelDesc;

    /**
     * 职位所属部门名称
     */
    private String deptName = "";

    /**
     * 上级职位名称
     */
    private String parentPositionName = "";

    /**
     * 状态名称
     */
    private String statusName = "";
    

    /**
     * 操作人名称
     */
    private String operatorEmpName = "";

    public Integer getPlLeve() {
		return plLeve;
	}

	public void setPlLeve(Integer plLeve) {
		this.plLeve = plLeve;
	}

	public String getPlLevelDesc() {
		return plLevelDesc;
	}

	public void setPlLevelDesc(String plLevelDesc) {
		this.plLevelDesc = plLevelDesc;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getParentPositionName() {
		return parentPositionName;
	}

	public void setParentPositionName(String parentPositionName) {
		this.parentPositionName = parentPositionName;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getOperatorEmpName() {
		return operatorEmpName;
	}

	public void setOperatorEmpName(String operatorEmpName) {
		this.operatorEmpName = operatorEmpName;
	}
    
}