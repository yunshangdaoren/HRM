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
	
	/**
	 * @return 所有部门信息
	 */
	List<Department> list();
	
	List<Department> listByManageEmpJobId(String manageEmpjobid);
	List<Department> listByDlId(Integer dlId);
	List<Department> listByDeptIdName(Integer deptId, String deptName);
	List<Department> listByDeptIdManageEmpJobId(Integer deptId, String manageEmpjobid);
	List<Department> listByDeptIdDlId(Integer deptId, Integer dlId);
	List<Department> listByDeptNameManageEmpJobId(String deptName, String manageEmpjobid);
	List<Department> listByDeptNameDlId(String deptName, Integer dlId);
	List<Department> listByManageEmpJobIdDlId(String manageEmpjobid, Integer dlId);
	List<Department> listByDeptIdNameManageEmpJobId(Integer deptId, String deptName, String manageEmpjobid);
	List<Department> listByDeptIdManageEmpJonIdDlId(Integer deptId, String manageEmpjobid, Integer dlId);
	List<Department> listByDeptNameManageEmpJonIdDlId(String deptName, String manageEmpjobid, Integer dlId);
	List<Department> listByAll(Integer deptId, String deptName, String manageEmpjobid, Integer dlId);
	
	int insert(Department department);
	int update(Department department);
	int delte(Integer deptId);
}
