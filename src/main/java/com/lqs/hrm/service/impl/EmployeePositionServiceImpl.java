package com.lqs.hrm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lqs.hrm.entity.EmployeePosition;
import com.lqs.hrm.mapper.EmployeePositionMapper;
import com.lqs.hrm.service.EmployeePositionService;

/**
 * 职工-职位Service实现类
 * @author luckyliuqs
 *
 */
@Service
public class EmployeePositionServiceImpl implements EmployeePositionService{
	@Autowired
	private EmployeePositionMapper employeePositionMapper;
	
	/**
	 * 根据职工职位id进行查询
	 */
	@Override
	public EmployeePosition get(Integer epId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 添加职工-职位信息
	 */
	@Override
	public int add(EmployeePosition employeePosition) {
		return employeePositionMapper.insertSelective(employeePosition);
	}

}
