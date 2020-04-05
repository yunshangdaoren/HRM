package com.lqs.hrm.service;

import java.util.List;

import com.lqs.hrm.entity.Employee;
import com.lqs.hrm.entity.EmployeeDepartment;

public interface EmployeeDepartmentService {
	/**
	 * 根据职工工号查询
	 * @param empJobid
	 * @return
	 */
	List<EmployeeDepartment> get(String empJobid);
	/**
	 * 根据部门id查询
	 * @param deptId
	 * @return
	 */
	List<EmployeeDepartment> get(Integer deptId);
	/**
	 * 根据职工号、部门id查询
	 * @param empJobid
	 * @param deptId
	 * @return
	 */
	List<EmployeeDepartment> get(String empJobid, Integer deptId);
	
	/**
	 * 添加
	 * @param empJobid
	 * @param deptId
	 * @return
	 */
	int insert(EmployeeDepartment employeeDepartment);
}
