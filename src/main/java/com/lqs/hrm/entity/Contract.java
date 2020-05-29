package com.lqs.hrm.entity;

import java.util.Date;

/**
 * 合同实体类
 * @author luckyliuqs
 *
 */
public class Contract {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column contract.con_id
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	private Integer conId;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column contract.emp_name
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	private String empName;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column contract.emp_sex
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	private Integer empSex;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column contract.emp_IDCard
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	private String empIdcard;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column contract.dept_id
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	private Integer deptId;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column contract.position_id
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	private Integer positionId;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column contract.begin_date
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	private Date beginDate;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column contract.end_date
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	private Date endDate;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column contract.end_reason
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	private String endReason;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column contract.sign_date
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	private Date signDate;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column contract.monthly_salary
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	private Long monthlySalary;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column contract.entry_time
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	private Date entryTime;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column contract.status_id
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	private Integer statusId;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column contract.note
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	private String note;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column contract.add_date
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	private Date addDate;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column contract.add_empJobId
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	private String addEmpjobid;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column contract.entry_check_date
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	private Date entryCheckDate;

	/**
	 * 入职审批人工号
	 * This field was generated by MyBatis Generator. This field corresponds to the database column contract.entry_check_empJobId
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	private String entryCheckEmpjobid;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column contract.resign_check_date
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	private Date resignCheckDate;

	/**
	 * 离职审批人工号
	 * This field was generated by MyBatis Generator. This field corresponds to the database column contract.resign_check_empJobId
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	private String resignCheckEmpjobid;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column contract.con_id
	 * @return  the value of contract.con_id
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	public Integer getConId() {
		return conId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column contract.con_id
	 * @param conId  the value for contract.con_id
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	public void setConId(Integer conId) {
		this.conId = conId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column contract.emp_name
	 * @return  the value of contract.emp_name
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column contract.emp_name
	 * @param empName  the value for contract.emp_name
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column contract.emp_sex
	 * @return  the value of contract.emp_sex
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	public Integer getEmpSex() {
		return empSex;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column contract.emp_sex
	 * @param empSex  the value for contract.emp_sex
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	public void setEmpSex(Integer empSex) {
		this.empSex = empSex;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column contract.emp_IDCard
	 * @return  the value of contract.emp_IDCard
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	public String getEmpIdcard() {
		return empIdcard;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column contract.emp_IDCard
	 * @param empIdcard  the value for contract.emp_IDCard
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	public void setEmpIdcard(String empIdcard) {
		this.empIdcard = empIdcard;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column contract.dept_id
	 * @return  the value of contract.dept_id
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column contract.dept_id
	 * @param deptId  the value for contract.dept_id
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column contract.position_id
	 * @return  the value of contract.position_id
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	public Integer getPositionId() {
		return positionId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column contract.position_id
	 * @param positionId  the value for contract.position_id
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column contract.begin_date
	 * @return  the value of contract.begin_date
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	public Date getBeginDate() {
		return beginDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column contract.begin_date
	 * @param beginDate  the value for contract.begin_date
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column contract.end_date
	 * @return  the value of contract.end_date
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column contract.end_date
	 * @param endDate  the value for contract.end_date
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column contract.end_reason
	 * @return  the value of contract.end_reason
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	public String getEndReason() {
		return endReason;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column contract.end_reason
	 * @param endReason  the value for contract.end_reason
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	public void setEndReason(String endReason) {
		this.endReason = endReason;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column contract.sign_date
	 * @return  the value of contract.sign_date
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	public Date getSignDate() {
		return signDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column contract.sign_date
	 * @param signDate  the value for contract.sign_date
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column contract.monthly_salary
	 * @return  the value of contract.monthly_salary
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	public Long getMonthlySalary() {
		return monthlySalary;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column contract.monthly_salary
	 * @param monthlySalary  the value for contract.monthly_salary
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	public void setMonthlySalary(Long monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column contract.entry_time
	 * @return  the value of contract.entry_time
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	public Date getEntryTime() {
		return entryTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column contract.entry_time
	 * @param entryTime  the value for contract.entry_time
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column contract.status_id
	 * @return  the value of contract.status_id
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	public Integer getStatusId() {
		return statusId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column contract.status_id
	 * @param statusId  the value for contract.status_id
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column contract.note
	 * @return  the value of contract.note
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	public String getNote() {
		return note;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column contract.note
	 * @param note  the value for contract.note
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column contract.add_date
	 * @return  the value of contract.add_date
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	public Date getAddDate() {
		return addDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column contract.add_date
	 * @param addDate  the value for contract.add_date
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column contract.add_empJobId
	 * @return  the value of contract.add_empJobId
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	public String getAddEmpjobid() {
		return addEmpjobid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column contract.add_empJobId
	 * @param addEmpjobid  the value for contract.add_empJobId
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	public void setAddEmpjobid(String addEmpjobid) {
		this.addEmpjobid = addEmpjobid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column contract.entry_check_date
	 * @return  the value of contract.entry_check_date
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	public Date getEntryCheckDate() {
		return entryCheckDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column contract.entry_check_date
	 * @param entryCheckDate  the value for contract.entry_check_date
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	public void setEntryCheckDate(Date entryCheckDate) {
		this.entryCheckDate = entryCheckDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column contract.entry_check_empJobId
	 * @return  the value of contract.entry_check_empJobId
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	public String getEntryCheckEmpjobid() {
		return entryCheckEmpjobid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column contract.entry_check_empJobId
	 * @param entryCheckEmpjobid  the value for contract.entry_check_empJobId
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	public void setEntryCheckEmpjobid(String entryCheckEmpjobid) {
		this.entryCheckEmpjobid = entryCheckEmpjobid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column contract.resign_check_date
	 * @return  the value of contract.resign_check_date
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	public Date getResignCheckDate() {
		return resignCheckDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column contract.resign_check_date
	 * @param resignCheckDate  the value for contract.resign_check_date
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	public void setResignCheckDate(Date resignCheckDate) {
		this.resignCheckDate = resignCheckDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column contract.resign_check_empJobId
	 * @return  the value of contract.resign_check_empJobId
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	public String getResignCheckEmpjobid() {
		return resignCheckEmpjobid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column contract.resign_check_empJobId
	 * @param resignCheckEmpjobid  the value for contract.resign_check_empJobId
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	public void setResignCheckEmpjobid(String resignCheckEmpjobid) {
		this.resignCheckEmpjobid = resignCheckEmpjobid;
	}

	/**
     * 职工性别描述
     */
    private String empSexName = "";
    
    /**
     * 所属部门名称
     */
    private String deptName = "";

    /**
     * 所属职位名称
     */
    private String positionName;

    /**
     * 状态名称
     */
    private String statusName;

    /**
     * 录入人名称
     */
    private String addEmpName = "";

    /**
     * 入职审批人姓名
     */
    private String entryCheckEmpName = "";
    
    /**
     * 离职审批人姓名
     */
    private String resignCheckEmpName = "";

    public String getEmpSexName() {
		return empSexName;
	}

	public void setEmpSexName(String empSexName) {
		this.empSexName = empSexName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getAddEmpName() {
		return addEmpName;
	}

	public void setAddEmpName(String addEmpName) {
		this.addEmpName = addEmpName;
	}

	public String getEntryCheckEmpName() {
		return entryCheckEmpName;
	}

	public void setEntryCheckEmpName(String entryCheckEmpName) {
		this.entryCheckEmpName = entryCheckEmpName;
	}

	public String getResignCheckEmpName() {
		return resignCheckEmpName;
	}

	public void setResignCheckEmpName(String resignCheckEmpName) {
		this.resignCheckEmpName = resignCheckEmpName;
	}
	
    
}