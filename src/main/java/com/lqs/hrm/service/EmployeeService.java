package com.lqs.hrm.service;

import java.util.Date;
import java.util.List;

import com.lqs.hrm.entity.Employee;

public interface EmployeeService {
	/**
	 * @param empJobid
	 * @return 指定员工编号的员工信息
	 */
	Employee get(String empJobid);
	
	/**
	 * 根据日期查询
	 * @param empName
	 * @param deptId
	 * @return
	 */
	List<Employee> listByEmpNameDeptId(Date lastOperatorDate);
	
	/**
	 * 根据职工名称查询
	 * @param empName
	 * @param deptId
	 * @return
	 */
	List<Employee> listByEmpName(String empName);
	
	/**
	 * 查询出所有职工信息
	 * @return
	 */
	List<Employee> list();
	
	/**
	 * 添加职工信息
	 * @param employee
	 * @return
	 */
	int add(Employee employee);
}
