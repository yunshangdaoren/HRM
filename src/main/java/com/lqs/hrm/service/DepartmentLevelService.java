package com.lqs.hrm.service;

import java.util.List;

import com.lqs.hrm.entity.DepartmentLevel;

public interface DepartmentLevelService {
	
	/**
	 * @param dlId
	 * @return 指定的部门级别信息
	 */
	DepartmentLevel get(Integer dlId);
	
	/**
	 * @return 部门级别列表
	 */
	List<DepartmentLevel> list();
}
