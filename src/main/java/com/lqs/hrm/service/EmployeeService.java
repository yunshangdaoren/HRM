package com.lqs.hrm.service;

import java.util.Date;
import java.util.List;

import com.lqs.hrm.entity.Employee;

public interface EmployeeService {
	/**
	 * 根据职工工号查询
	 * @param empJobid
	 * @return 
	 */
	Employee get(String empJobId);
	/**
	 * 根据职工姓名查询
	 * @param empName
	 * @param deptId
	 * @return
	 */
	List<Employee> listByEmpName(String empName);
	/**
	 * 根据职工状态id查询
	 * @param statusId
	 * @return
	 */
	List<Employee> listByStatusId(Integer statusId);
	
	/**
	 * 根据职工工号和姓名查询
	 * @param 
	 * @return
	 */
	List<Employee> listByEmpJobIdEmpName(String empJobId, String empName);
	/**
	 * 根据职工工号，状态id查询
	 * @param 
	 * @return
	 */
	List<Employee> listByEmpJobIdStatusId(String empJobId, Integer statusId);
	/**
	 * 根据职工姓名，状态id查询
	 * @param 
	 * @return
	 */
	List<Employee> listByEmpNameStatusId(String empName, Integer statusId);
	/**
	 * 根据职工工号，姓名，状态id查询
	 * @param 
	 * @return
	 */
	List<Employee> listByEmpJobIdEmpNameStatusId(String empJobId, String empName, Integer statusId);
	/**
	 * 根据职工性别查询
	 * @param 
	 * @return
	 */
	List<Employee> listByEmpSex(Integer empSex);
	/**
	 * 查询出所有职工信息
	 * @return
	 */
	List<Employee> listByNo();
	
	/**
	 * 添加职工信息
	 * @param employee
	 * @return
	 */
	int add(Employee employee);
	
	/**
	 * 修改职工信息
	 * @param employee
	 * @return
	 */
	int update(String empJobId);
	
	
}
