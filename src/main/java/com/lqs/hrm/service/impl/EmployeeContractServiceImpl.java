package com.lqs.hrm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lqs.hrm.entity.EmployeeContract;
import com.lqs.hrm.entity.EmployeeContractExample;
import com.lqs.hrm.mapper.EmployeeContractMapper;
import com.lqs.hrm.service.EmployeeContractService;

/**
 * 职工-合同Service实现类
 * @author luckyliuqs
 *
 */
@Service
public class EmployeeContractServiceImpl implements EmployeeContractService{
	@Autowired
	private EmployeeContractMapper employeeContractMapper;
	
	/**
	 * 返回指定id的职工合同信息
	 */
	@Override
	public EmployeeContract get(Integer ecId) {
		return employeeContractMapper.selectByPrimaryKey(ecId);
	}

	/**
	 * 返回指定合同id的职工合同信息
	 */
	@Override
	public List<EmployeeContract> getByConId(Integer conId) {
		EmployeeContractExample example = new EmployeeContractExample();
		example.or().andConIdEqualTo(conId);
		return employeeContractMapper.selectByExample(example);
	}


	/**
	 * 返回指定职工id的职工合同信息
	 */
	@Override
	public List<EmployeeContract> getByEmpJobid(String empJobid) {
		EmployeeContractExample example = new EmployeeContractExample();
		example.or().andEmpJobidEqualTo(empJobid);
		return employeeContractMapper.selectByExample(example);
	}


	/**
	 * 返回所有职工合同信息
	 */
	@Override
	public List<EmployeeContract> getAll() {
		EmployeeContractExample example = new EmployeeContractExample();
		example.or().andEcIdIsNotNull();
		return employeeContractMapper.selectByExample(example);
	}

}
