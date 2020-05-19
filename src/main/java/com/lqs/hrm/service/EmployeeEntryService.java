package com.lqs.hrm.service;

import java.util.Date;
import java.util.List;

import com.lqs.hrm.entity.EmployeeEntry;

/**
 * 职工入职Service接口
 * @author Administrator
 *
 */
public interface EmployeeEntryService {
	/**
	 * 根据职工入职id查询
	 * @param conId
	 * @return
	 */
	EmployeeEntry get(Integer eeId);
	
	/**
	 * 根据职工入职日期查询
	 * @param conId
	 * @return
	 */
	List<EmployeeEntry> get(Date beginDate, Date endDate);
	
	/**
	 * 更新职工入职信息
	 * @param employeeEntry
	 * @return
	 */
	int update(EmployeeEntry employeeEntry);

}
