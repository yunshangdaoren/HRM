package com.lqs.hrm.service;

import java.util.List;

import com.lqs.hrm.entity.Department;

/**
 * 部门Service接口
 * @author Administrator
 *
 */
public interface DepartmentService {
	/**
	 * 通过部门id查询部门信息
	 * @param deptId
	 * @return
	 */
	Department get(Integer deptId);
	List<Department> list();
	//List<Department> list(Integer manageEmpjobid);
	List<Department> list(String deptName);
	List<Department> list(String deptName, Integer deptLevel);
	List<Department> list(Integer deptLevel);
	int insert(Department department);
	int update(Department department);
	int delte(Integer deptId);
}
