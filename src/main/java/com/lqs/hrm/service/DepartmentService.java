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
	
	/**
	 * 通过部门名称获取部门信息
	 * @param deptName
	 * @return
	 */
	Department get(String deptName);
	List<Department> list();
	List<Department> listByManageEmpJobId(Integer manageEmpjobid);
	List<Department> list(String deptName);
	List<Department> list(Integer deptLevel);
	int insert(Department department);
	int update(Department department);
	int delte(Integer deptId);
}
