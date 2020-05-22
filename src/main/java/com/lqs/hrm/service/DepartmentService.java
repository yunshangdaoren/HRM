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
	 * 通过部门主管职位id查询
	 * @param managePositionId
	 * @return
	 */
	List<Department> getByManagePositionId(Integer managePositionid);
	/**
	 * 根据部门名称查询
	 * @param deptName
	 * @return
	 */
	List<Department> listByDeptName(String deptName);
	/**
	 * 根据部门级别id查询
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
	 * 根据部门id，部门级别id查询
	 * @param deptId
	 * @param dlId
	 * @return
	 */
	List<Department> listByDeptIdDlId(Integer deptId, Integer dlId);
	/**
	 * 根据部门名称，部门级别id查询
	 * @param deptName
	 * @param dlId
	 * @return
	 */
	List<Department> listByDeptNameDlId(String deptName, Integer dlId);
	
	/**
	 * 根据部门id，部门名称，部门级别id查询
	 * @param deptId
	 * @param deptName
	 * @param manageEmpjobid
	 * @return
	 */
	List<Department> listByDeptIdNameDlId(Integer deptId, String deptName, Integer dlId);
	/**
	 * @return 查询出所有部门信息
	 */
	List<Department> listByNo();
	
	int insert(Department department);
	int update(Department department);
	int delete(Integer deptId);
	
	/**
	 * 根据部门名称模糊查询
	 * @param deptName
	 * @return
	 */
	List<Department> listLikeDeptName(String deptName);
	
	/**
	 * 根据上级部门id查询所有子部门信息
	 * @param parentId
	 * @return
	 */
	List<Department> listByParentId(Integer parentId);
}
