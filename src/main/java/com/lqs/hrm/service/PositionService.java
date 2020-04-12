package com.lqs.hrm.service;

import java.util.List;

import com.lqs.hrm.entity.Position;

/**
 * 职位Service接口
 * @author Administrator
 *
 */
public interface PositionService {
	/**
	 * 根据职位id查询
	 * @param deptId
	 * @return
	 */
	Position get(Integer positionId);
	/**
	 * 根据职位名称查询
	 * @param deptName
	 * @return
	 */
	List<Position> listByPositionName(String positionName);
	/**
	 * 根据职位所属部门id查询
	 * @param deptName
	 * @return
	 */
	List<Position> listBymanageEmpjobid(String manageEmpjobid);
	/**
	 * 根据职位级别查询
	 * @param dlId
	 * @return
	 */
	List<Position> listByPlId(Integer plId);
	/**
	 * 根据部门id，部门名称查询
	 * @param deptId
	 * @param deptName
	 * @return
	 */
	List<Position> listByDeptIdName(Integer deptId, String deptName);
	/**
	 * 根据id，部门主管id查询
	 * @param deptId
	 * @param manageEmpjobid
	 * @return
	 */
	List<Position> listByDeptIdManageEmpJobId(Integer deptId, String manageEmpjobid);
	/**
	 * 根据部门id，部门级别查询
	 * @param deptId
	 * @param dlId
	 * @return
	 */
	List<Position> listByDeptIdDlId(Integer deptId, Integer dlId);
	/**
	 * 根据部门名称，部门主管id查询
	 * @param deptName
	 * @param manageEmpjobid
	 * @return
	 */
	List<Position> listByDeptNameManageEmpJobId(String deptName, String manageEmpjobid);
	/**
	 * 根据部门名称，部门级别查询
	 * @param deptName
	 * @param dlId
	 * @return
	 */
	List<Position> listByDeptNameDlId(String deptName, Integer dlId);
	/**
	 * 根据部门主管id，部门级别查询
	 * @param manageEmpjobid
	 * @param dlId
	 * @return
	 */
	List<Position> listByManageEmpJobIdDlId(String manageEmpjobid, Integer dlId);
	/**
	 * 根据部门id，部门名称，部门主管id查询
	 * @param deptId
	 * @param deptName
	 * @param manageEmpjobid
	 * @return
	 */
	List<Position> listByDeptIdNameManageEmpJobId(Integer deptId, String deptName, String manageEmpjobid);
	
	/**
	 * 根据部门id，部门名称，部门级别查询
	 * @param deptId
	 * @param deptName
	 * @param manageEmpjobid
	 * @return
	 */
	List<Position> listByDeptIdNameDlId(Integer deptId, String deptName, Integer dlId);
	/**
	 * 根据部门id，部门主管id，部门级别查询
	 * @param deptId
	 * @param manageEmpjobid
	 * @param dlId
	 * @return
	 */
	List<Position> listByDeptIdManageEmpJonIdDlId(Integer deptId, String manageEmpjobid, Integer dlId);
	/**
	 * 根据部门名称，部门主管id，部门级别查询
	 * @param deptName
	 * @param manageEmpjobid
	 * @param dlId
	 * @return
	 */
	List<Position> listByDeptNameManageEmpJonIdDlId(String deptName, String manageEmpjobid, Integer dlId);
	/**
	 * 根据id，部门名称，部门主管id，部门级别查询
	 * @param deptId
	 * @param deptName
	 * @param manageEmpjobid
	 * @param dlId
	 * @return
	 */
	List<Position> listByAll(Integer deptId, String deptName, String manageEmpjobid, Integer dlId);
	/**
	 * @return 查询出所有部门信息
	 */
	List<Position> listByNo();
	
	int insert(Position department);
	int update(Position department);
	int delte(Integer positionId);
}
