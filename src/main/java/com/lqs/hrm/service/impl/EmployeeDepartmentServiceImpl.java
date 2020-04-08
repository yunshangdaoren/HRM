package com.lqs.hrm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lqs.hrm.entity.Employee;
import com.lqs.hrm.entity.EmployeeDepartment;
import com.lqs.hrm.entity.EmployeeDepartmentExample;
import com.lqs.hrm.entity.EmployeeExample;
import com.lqs.hrm.mapper.EmployeeDepartmentMapper;
import com.lqs.hrm.mapper.EmployeeMapper;
import com.lqs.hrm.service.EmployeeDepartmentService;
import com.lqs.hrm.service.EmployeeService;

/**
 * 职工-部门Service
 * @author Administrator
 *
 */
@Service
public class EmployeeDepartmentServiceImpl implements EmployeeDepartmentService{
	@Autowired
	private EmployeeDepartmentMapper employeeDepartmentMapper;
	
	/**
	 * 根据职工工号查询
	 */
	@Override
	public List<EmployeeDepartment> get(String empJobid) {
		EmployeeDepartmentExample example = new EmployeeDepartmentExample();
		example.or().andEmpJobidEqualTo(empJobid);
		return employeeDepartmentMapper.selectByExample(example);
	}
	
	/**
	 * 根据部门id查询
	 */
	@Override
	public List<EmployeeDepartment> get(Integer deptId) {
		EmployeeDepartmentExample example = new EmployeeDepartmentExample();
		example.or().andDeptIdEqualTo(deptId);
		return employeeDepartmentMapper.selectByExample(example);
	}

	/**
	 * 根据职工号、部门id查询
	 */
	@Override
	public EmployeeDepartment get(String empJobid, Integer deptId) {
		EmployeeDepartmentExample example = new EmployeeDepartmentExample();
		example.or().andEmpJobidEqualTo(empJobid).andDeptIdEqualTo(deptId);
		List<EmployeeDepartment> list = employeeDepartmentMapper.selectByExample(example);
		if (list.size() == 0) {
			return null;
		}
		return list.get(0);
	}

	/**
	 * 
	 * 添加
	 */
	@Override
	public int insert(EmployeeDepartment employeeDepartment) {
		return employeeDepartmentMapper.insertSelective(employeeDepartment);
	}
	
}
