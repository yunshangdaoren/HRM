package com.lqs.hrm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lqs.hrm.entity.DepartmentLevel;
import com.lqs.hrm.entity.DepartmentLevelExample;
import com.lqs.hrm.mapper.DepartmentLevelMapper;
import com.lqs.hrm.service.DepartmentLevelService;

/**
 * 部门级别Service
 * @author luckyliuqs
 *
 */
@Service
public class DepartmentLevelServiceImpl implements DepartmentLevelService{
	@Autowired
	private DepartmentLevelMapper departmentLevelMapper;

	/**
	 * 指定的部门级别信息
	 */
	@Override
	public DepartmentLevel get(Integer dlId) {
		return departmentLevelMapper.selectByPrimaryKey(dlId);
	}

	/**
	 * 部门级别列表
	 */
	@Override
	public List<DepartmentLevel> list() {
		DepartmentLevelExample example = new DepartmentLevelExample();
		example.createCriteria().andDlIdIsNotNull();
		return departmentLevelMapper.selectByExample(example);
	}

}
