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
	List<Position> listByDeptId(Integer deptId);
	/**
	 * 根据职位级别查询
	 * @param dlId
	 * @return
	 */
	List<Position> listByPlId(Integer plId);
	
	/**
	 * 根据职位id、职位名称查询
	 * @param positionId
	 * @param positionName
	 * @return
	 */
	List<Position> listByPositionIdName(Integer positionId, String positionName);
	
	/**
	 * 根据职位id、所属部门id查询
	 * @param positionId
	 * @param deptName
	 * @return
	 */
	List<Position> listByPositionIdDeptId(Integer positionId, Integer deptId);
	/**
	 * 根据职位id、职位级别id查询
	 * @param positionId
	 * @param plId
	 * @return
	 */
	List<Position> listByPositionIdPlId(Integer positionId, Integer plId);
	/**
	 * 根据职位名称、所属部门id查询
	 * @param positionName
	 * @param deptName
	 * @return
	 */
	List<Position> listByPositionNameDeptId(String positionName, Integer deptId);
	/**
	 * 根据职位名称、职位级别id查询
	 * @param positionName
	 * @param plId
	 * @return
	 */
	List<Position> listByPositionNamePlId(String positionName, Integer plId);
	/**
	 * 根据职位所属部门id、职位级别id查询
	 * @param deptName
	 * @param plId
	 * @return
	 */
	List<Position> listByDeptIdPlId(Integer deptId, Integer plId);
	
	/**
	 * 根据职位id、职位名称、职位所属部门id查询
	 * @param positionId
	 * @param positionName
	 * @param deptName
	 * @return
	 */
	List<Position> listByPositionIdNameDeptId(Integer positionId, String positionName, Integer deptId);
	
	/**
	 * 根据职位id、职位名称、职位级别id查询
	 * @param positionId
	 * @param positionName
	 * @param plId
	 * @return
	 */
	List<Position> listByPositionIdNamePlId(Integer positionId, String positionName, Integer plId);
	
	/**
	 * 根据职位id、职位所属部门id、职位级别id查询
	 * @param positionId
	 * @param positionName
	 * @param plId
	 * @return
	 */
	List<Position> listByPositionIdDeptIdPlId(Integer positionId, Integer deptId, Integer plId);
	
	/**
	 * 根据职位名称、职位所属部门id、职位级别id查询
	 * @param positionName
	 * @param deptName
	 * @param plId
	 * @return
	 */
	List<Position> listByPositionNameDeptIdPlId(String positionName, Integer deptId, Integer plId);
	/**
	 * 根据职位id、职位名称、职位所属部门id、职位级别id查询
	 * @param positionId
	 * @param positionName
	 * @param deptName
	 * @param plId
	 * @return
	 */
	List<Position> listByAll(Integer positionId, String positionName, Integer deptId, Integer plId);
	
	/**
	 * @return 查询出所有职位信息
	 */
	List<Position> listByNo();
	
	int insert(Position position);
	int update(Position position);
	int delte(Integer positionId);
}
