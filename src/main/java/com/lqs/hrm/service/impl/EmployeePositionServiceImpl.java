package com.lqs.hrm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lqs.hrm.entity.EmployeePosition;
import com.lqs.hrm.entity.EmployeePositionExample;
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
	 * 根据职位id查询
	 */
	@Override
	public List<EmployeePosition> listByPositionId(Integer positionId) {
		EmployeePositionExample example = new EmployeePositionExample();
		example.or().andPositionIdEqualTo(positionId);
		return employeePositionMapper.selectByExample(example);
	}
	
	/**
	 * 根据职工工号查询
	 */
	@Override
	public List<EmployeePosition> listByEmpJobId(String empJobId) {
		EmployeePositionExample example = new EmployeePositionExample();
		example.or().andEmpJobidEqualTo(empJobId);
		return employeePositionMapper.selectByExample(example);
	}
	
	/**
	 * 根据职工工号，职位id查询
	 */
	@Override
	public List<EmployeePosition> listByEmpJobIdPositionId(String empJobId, Integer positionId) {
		EmployeePositionExample example = new EmployeePositionExample();
		example.or().andEmpJobidEqualTo(empJobId).andPositionIdEqualTo(positionId);
		return employeePositionMapper.selectByExample(example);
	}

	/**
	 * 添加职工-职位信息
	 */
	@Override
	public int add(EmployeePosition employeePosition) {
		return employeePositionMapper.insertSelective(employeePosition);
	}

	/**
	 * 更新
	 */
	@Override
	public int update(EmployeePosition employeePosition) {
		return employeePositionMapper.updateByPrimaryKeySelective(employeePosition);
	}


}
