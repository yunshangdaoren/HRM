package com.lqs.hrm.service;

import java.util.List;

import com.lqs.hrm.entity.DepartmentLevel;

public interface DepartmentLevelService {
	
	/**
	 * @param dlId
	 * @return 返回指定的部门id的部门级别信息
	 */
	DepartmentLevel get(Integer dlId);
	
	/**
	 * 返回指定的部门级别的部门级别信息
	 * @param level
	 * @return
	 */
	DepartmentLevel getByLevel(Integer level);
	
	/**
	 * @return 返回所有部门级别列表
	 */
	List<DepartmentLevel> list();
	
	/**
	 * @return 返回指定部门级别的所有部门列表
	 */
	List<DepartmentLevel> list(Integer level);
	
	/**
	 * 添加部门级别信息
	 * @param departmentLevel
	 * @return
	 */
	int add(DepartmentLevel departmentLevel);
	
	/**
	 * 修改指定部门级别信息
	 * @param departmentLevel
	 * @return
	 */
	int update(DepartmentLevel departmentLevel);
	
	/**
	 * 删除指定id的部门级别信息
	 * @param dlId
	 * @return
	 */
	int delete(Integer dlId);
}
