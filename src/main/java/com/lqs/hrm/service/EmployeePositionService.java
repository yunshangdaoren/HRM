package com.lqs.hrm.service;

import java.util.List;

import com.lqs.hrm.entity.Contract;
import com.lqs.hrm.entity.Department;
import com.lqs.hrm.entity.EmployeePosition;

/**
 * 职工-职位Service接口
 * @author Administrator
 *
 */
public interface EmployeePositionService {
	/**
	 * 根据查职工职位id询
	 * @param conId
	 * @return
	 */
	EmployeePosition get(Integer epId);
	
	/**
	 * 添加职工-职位信息
	 * @param contract
	 * @return
	 */
	int add(EmployeePosition employeePosition);
	
	
	
}
