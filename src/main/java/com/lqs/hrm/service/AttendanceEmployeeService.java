package com.lqs.hrm.service;

import java.util.Date;
import java.util.List;

import com.lqs.hrm.entity.AttendanceEmployee;

/**
 * 职工考勤信息Service接口
 * @author luckyliuqs
 *
 */
public interface AttendanceEmployeeService {

	/**
	 * 根据id查询
	 * @return
	 */
	AttendanceEmployee get(Integer aeId);
	
	/**
	 * 根据考勤日期查询
	 * @param date
	 * @return
	 */
	List<AttendanceEmployee> listByDate(Date date);
	
	/**
	 * 根据指定开始日期和结束日期查询
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	List<AttendanceEmployee> listByDate(Date beginDate, Date endDate);
	
	/**
	 * 根据职工工号查询
	 * @param empJobId
	 * @return
	 */
	List<AttendanceEmployee> listByEmpJobId(String empJobId);
	
	/**
	 * 根据考勤状态id查询
	 * @param statusId
	 * @return
	 */
	List<AttendanceEmployee> listByStatusId(Integer statusId);
	
	/**
	 * 根据职工工号，考勤日期查询
	 * @param aeId
	 * @param empJobId
	 * @return
	 */
	List<AttendanceEmployee> listByEmpJobIdDate(String empJobId, Date date);
	
	/**
	 * 根据职工工号和状态id查询
	 * @param aeId
	 * @param statusIs
	 * @return
	 */
	List<AttendanceEmployee> listByEmpJobIdStatusId(String empJobId, Integer statusIs);
	
	/**
	 * 根据考勤日期和状态id查询
	 * @param empJobId
	 * @param statusId
	 * @return
	 */
	List<AttendanceEmployee> listByDateStatusId(Date date, Integer statusId);
	
	/**
	 * 根据职工工号，考勤日期，状态id查询
	 * @param aeId
	 * @param empJobId
	 * @param statusId
	 * @return
	 */
	List<AttendanceEmployee> listByEmpJobIdDateStatusId(String empJobId, Date date, Integer statusId);
	/**
	 * 查询出所有职工考勤信息
	 * @return
	 */
	List<AttendanceEmployee> listByNo();
	
	/**
	 * 添加职工考勤信息
	 * @param attendanceEmployee
	 * @return
	 */
	int add(AttendanceEmployee attendanceEmployee);
	
	/**
	 * 删除职工考勤信息
	 * @param attendanceEmployee
	 * @return
	 */
	int update(AttendanceEmployee attendanceEmployee);
	
}
