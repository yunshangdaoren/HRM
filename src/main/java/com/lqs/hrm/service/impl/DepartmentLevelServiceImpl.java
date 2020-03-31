package com.lqs.hrm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lqs.hrm.entity.DepartmentLevel;
import com.lqs.hrm.mapper.DepartmentLevelMapper;
import com.lqs.hrm.service.DepartmentLevelService;

@Service
public class DepartmentLevelServiceImpl implements DepartmentLevelService{
	@Autowired
	private DepartmentLevelMapper departmentLevelMapper;

	@Override
	public DepartmentLevel get(Integer dlId) {
		return departmentLevelMapper.selectByPrimaryKey(dlId);
	}

}
