package com.lqs.hrm.service;

import java.util.List;

import com.lqs.hrm.entity.Contract;
import com.lqs.hrm.entity.Department;

/**
 * 合同Service接口
 * @author Administrator
 *
 */
public interface ContractService {
	/**
	 * 根据合同id查询
	 * @param conId
	 * @return
	 */
	Contract get(Integer conId);
	
	/**
	 * @return 根据合同所属部门id查询
	 */
	List<Contract> listBydeptId(Integer deptId);
	
	/**
	 * @return 根据合同所属职位id查询
	 */
	List<Contract> listByPositionId(Integer positionId);
	
	/**
	 * @return 根据合同所属状态id查询
	 */
	List<Contract> listByStatusId(Integer statusId);
	
	/**
	 * @return 根据合同id、所属部门id查询
	 */
	List<Contract> listByConIdDeptId(Integer conId, Integer deptId);
	
	/**
	 * @return 根据合同id、所属职位id查询
	 */
	List<Contract> listByConIdPositionId(Integer conId, Integer positionId);
	
	/**
	 * @return 根据合同id、所属状态id查询
	 */
	List<Contract> listByConIdStatusId(Integer conId, Integer statusId);
	
	/**
	 * @return 根据合同所属部门id、所属职位id查询
	 */
	List<Contract> listByDeptIdPositionId(Integer deptId, Integer positionId);
	
	/**
	 * @return 根据合同所属部门id、状态id查询
	 */
	List<Contract> listByDeptIdStatusId(Integer deptId, Integer statusId);
	
	/**
	 * @return 根据合同所属职位id、所属状态id查询
	 */
	List<Contract> listByPositionIdStatusId(Integer positionId, Integer statusId);
	
	/**
	 * @return 根据合同id、所属部门id、所属职位id查询
	 */
	List<Contract> listByConIdDeptIdPositionId(Integer conId, Integer deptId, Integer positionId);
	
	/**
	 * @return 根据合同id、所属部门id、状态id查询
	 */
	List<Contract> listByConIdDeptIdStatusId(Integer conId, Integer deptId, Integer statusId);
	
	/**
	 * @return 根据合同id、所属职位id、状态id查询
	 */
	List<Contract> listByConIdPositionIdStatusId(Integer conId, Integer deptId, Integer statusId);

	/**
	 * @return 根据合同所属部门id、所属职位id、状态id查询
	 */
	List<Contract> listByDeptIdPositionIdStatusId(Integer deptId, Integer positionId, Integer statusId);
	
	/**
	 * @return 根据合同id、所属部门id、所属职位id、所属状态id查询
	 */
	List<Contract> listByConIdDeptIdPositionStatusId(Integer conId, Integer deptId, Integer positionId, Integer statusId);
	
	/**
	 * @return 查询出所有合同信息
	 */
	List<Contract> listByNo();
	
	/**
	 * 根据职工姓名查询所有合同信息
	 * @param empName
	 * @return
	 */
	List<Contract> listByEmpName(String empName);
	
	/**
	 * 根据职工姓名、状态id查询所有合同信息
	 * @param empName
	 * @param statusId
	 */
	List<Contract> listByEmpNameStatusId(String empName, Integer statusId);
	
	/**
	 * 添加合同
	 * @param contract
	 * @return
	 */
	int insert(Contract contract);
	
	/**
	 * 更新合同
	 * @param contract
	 * @return
	 */
	int update(Contract contract);
	
	/**
	 * 删除合同
	 * @param conId
	 * @return
	 */
	int delte(Integer conId);
	
	
}
