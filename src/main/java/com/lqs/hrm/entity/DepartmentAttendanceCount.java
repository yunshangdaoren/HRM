package com.lqs.hrm.entity;

import java.util.Date;

/**
 * 部门考勤统计实体类
 * @author luckyliuqs
 *
 */
public class DepartmentAttendanceCount {
	/**
	 * 部门id
	 */
	private Integer deptId;
	
	/**
	 * 部门名称
	 */
	private String deptName;
	
	/**
	 * 考勤日期
	 */
	private Date signDate;
	
	/**
	 * 部门职工数量
	 */
	private Integer deptEmpnum;
	
	 /**
     * 未签到职工数量
     */
    private Integer notSignEmployeeNum;
    
    /**
     * 签到且未签退职工数量
     */
    private Integer signNotLogoutEmployeeNum;
    
    /**
     * 签到且早退职工数量
     */
    private Integer signLeaveEarlyEmployeeNum;
    
    /**
     * 迟到且未签退职工数量
     */
    private Integer lateNotLeaveEmployeeNum;
    
    /**
     * 迟到且早退职工数量
     */
    private Integer lateLeaveEarlyEmployeeNum;
    
    /**
     * 到勤职工数量
     */
    private Integer normalEmployeeNum;

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Integer getDeptEmpnum() {
		return deptEmpnum;
	}

	public void setDeptEmpnum(Integer deptEmpnum) {
		this.deptEmpnum = deptEmpnum;
	}

	public Integer getNotSignEmployeeNum() {
		return notSignEmployeeNum;
	}

	public void setNotSignEmployeeNum(Integer notSignEmployeeNum) {
		this.notSignEmployeeNum = notSignEmployeeNum;
	}

	public Integer getSignNotLogoutEmployeeNum() {
		return signNotLogoutEmployeeNum;
	}

	public void setSignNotLogoutEmployeeNum(Integer signNotLogoutEmployeeNum) {
		this.signNotLogoutEmployeeNum = signNotLogoutEmployeeNum;
	}

	public Integer getSignLeaveEarlyEmployeeNum() {
		return signLeaveEarlyEmployeeNum;
	}

	public void setSignLeaveEarlyEmployeeNum(Integer signLeaveEarlyEmployeeNum) {
		this.signLeaveEarlyEmployeeNum = signLeaveEarlyEmployeeNum;
	}

	public Integer getLateNotLeaveEmployeeNum() {
		return lateNotLeaveEmployeeNum;
	}

	public void setLateNotLeaveEmployeeNum(Integer lateNotLeaveEmployeeNum) {
		this.lateNotLeaveEmployeeNum = lateNotLeaveEmployeeNum;
	}

	public Integer getLateLeaveEarlyEmployeeNum() {
		return lateLeaveEarlyEmployeeNum;
	}

	public void setLateLeaveEarlyEmployeeNum(Integer lateLeaveEarlyEmployeeNum) {
		this.lateLeaveEarlyEmployeeNum = lateLeaveEarlyEmployeeNum;
	}

	public Integer getNormalEmployeeNum() {
		return normalEmployeeNum;
	}

	public void setNormalEmployeeNum(Integer normalEmployeeNum) {
		this.normalEmployeeNum = normalEmployeeNum;
	}

	public Date getSignDate() {
		return signDate;
	}

	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}
	
}
