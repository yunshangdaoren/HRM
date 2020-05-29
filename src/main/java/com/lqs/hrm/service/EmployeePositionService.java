package com.lqs.hrm.service;

import java.util.List;

import com.lqs.hrm.entity.Contract;
import com.lqs.hrm.entity.Department;
import com.lqs.hrm.entity.EmployeePosition;

/**
 * 职工-职位Service接口
 * @author Administrator
 *
 */
public interface EmployeePositionService {
	/**
	 * 根据id查询
	 * @param conId
	 * @return
	 */
	EmployeePosition get(Integer epId);
	
	/**
	 * 根据职位id查询
	 * @param deptId
	 * @param positionId
	 * @return
	 */
	List<EmployeePosition> listByPositionId(Integer positionId);
	
	/**
	 * 根据职工工号查询
	 * @param deptId
	 * @param positionId
	 * @return
	 */
	List<EmployeePosition> listByEmpJobId(String empJobId);
	
	/**
	 * 根据职工工号，职位id查询
	 * @param deptId
	 * @param positionId
	 * @return
	 */
	List<EmployeePosition> listByEmpJobIdPositionId(String empJobId, Integer positionId);
	
	/**
	 * 添加职工-职位信息
	 * @param contract
	 * @return
	 */
	int add(EmployeePosition employeePosition);
	
	/**
	 * 更新
	 * @param employeePosition
	 * @return
	 */
	int update(EmployeePosition employeePosition);
	
	/**
	 * 删除
	 * @param employeePosition
	 * @return
	 */
	int delete(Integer epId);
	
}
