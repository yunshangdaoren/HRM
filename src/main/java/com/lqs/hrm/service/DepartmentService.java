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
	 * 根据部门id查询
	 * @param deptId
	 * @return
	 */
	Department get(Integer deptId);
	/**
	 * 根据部门名称查询
	 * @param deptName
	 * @return
	 */
	List<Department> listByDeptName(String deptName);
	/**
	 * 根据部门主管id查询
	 * @param deptName
	 * @return
	 */
	List<Department> listBymanageEmpjobid(String manageEmpjobid);
	/**
	 * 根据部门级别查询
	 * @param dlId
	 * @return
	 */
	List<Department> listByDlId(Integer dlId);
	/**
	 * 根据部门id，部门名称查询
	 * @param deptId
	 * @param deptName
	 * @return
	 */
	List<Department> listByDeptIdName(Integer deptId, String deptName);
	/**
	 * 根据id，部门主管id查询
	 * @param deptId
	 * @param manageEmpjobid
	 * @return
	 */
	List<Department> listByDeptIdManageEmpJobId(Integer deptId, String manageEmpjobid);
	/**
	 * 根据部门id，部门级别查询
	 * @param deptId
	 * @param dlId
	 * @return
	 */
	List<Department> listByDeptIdDlId(Integer deptId, Integer dlId);
	/**
	 * 根据部门名称，部门主管id查询
	 * @param deptName
	 * @param manageEmpjobid
	 * @return
	 */
	List<Department> listByDeptNameManageEmpJobId(String deptName, String manageEmpjobid);
	/**
	 * 根据部门名称，部门级别查询
	 * @param deptName
	 * @param dlId
	 * @return
	 */
	List<Department> listByDeptNameDlId(String deptName, Integer dlId);
	/**
	 * 根据部门主管id，部门级别查询
	 * @param manageEmpjobid
	 * @param dlId
	 * @return
	 */
	List<Department> listByManageEmpJobIdDlId(String manageEmpjobid, Integer dlId);
	/**
	 * 根据部门id，部门名称，部门主管id查询
	 * @param deptId
	 * @param deptName
	 * @param manageEmpjobid
	 * @return
	 */
	List<Department> listByDeptIdNameManageEmpJobId(Integer deptId, String deptName, String manageEmpjobid);
	
	/**
	 * 根据部门id，部门名称，部门级别查询
	 * @param deptId
	 * @param deptName
	 * @param manageEmpjobid
	 * @return
	 */
	List<Department> listByDeptIdNameDlId(Integer deptId, String deptName, Integer dlId);
	/**
	 * 根据部门id，部门主管id，部门级别查询
	 * @param deptId
	 * @param manageEmpjobid
	 * @param dlId
	 * @return
	 */
	List<Department> listByDeptIdManageEmpJonIdDlId(Integer deptId, String manageEmpjobid, Integer dlId);
	/**
	 * 根据部门名称，部门主管id，部门级别查询
	 * @param deptName
	 * @param manageEmpjobid
	 * @param dlId
	 * @return
	 */
	List<Department> listByDeptNameManageEmpJonIdDlId(String deptName, String manageEmpjobid, Integer dlId);
	/**
	 * 根据id，部门名称，部门主管id，部门级别查询
	 * @param deptId
	 * @param deptName
	 * @param manageEmpjobid
	 * @param dlId
	 * @return
	 */
	List<Department> listByAll(Integer deptId, String deptName, String manageEmpjobid, Integer dlId);
	/**
	 * @return 查询出所有部门信息
	 */
	List<Department> listByNo();
	
	int insert(Department department);
	int update(Department department);
	int delte(Integer deptId);
	
	/**
	 * 根据部门名称模糊查询
	 * @param deptName
	 * @return
	 */
	List<Department> listLikeDeptName(String deptName);
}
