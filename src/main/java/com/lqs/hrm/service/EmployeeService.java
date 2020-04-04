package com.lqs.hrm.service;

import java.util.List;

import com.lqs.hrm.entity.Employee;

public interface EmployeeService {
	/**
	 * @param empJobid
	 * @return 指定员工编号的员工信息
	 */
	Employee get(String empJobid);
	
	/**
	 * 根据职工名称和所属部门id查询
	 * @param empName
	 * @param deptId
	 * @return
	 */
	List<Employee> listByEmpNameDeptId(String empName, Integer deptId);
	
	/**
	 * 根据职工名称查询
	 * @param empName
	 * @param deptId
	 * @return
	 */
	List<Employee> listByEmpName(String empName);
}
