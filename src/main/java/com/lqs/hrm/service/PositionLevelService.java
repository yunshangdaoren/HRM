package com.lqs.hrm.service;

import java.util.List;

import com.lqs.hrm.entity.DepartmentLevel;
import com.lqs.hrm.entity.PositionLevel;

/**
 * 职位级别Service接口
 * @author Administrator
 *
 */
public interface PositionLevelService {
	
	/**
	 * 查询指定职位级别id的职位信息
	 * @param plId
	 * @return 
	 */
	PositionLevel get(Integer plId);
	
	/**
	 * @return 职位级别列表
	 */
	List<PositionLevel> list();
}
