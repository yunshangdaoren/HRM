package com.lqs.hrm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lqs.hrm.entity.Employee;
import com.lqs.hrm.entity.EmployeeExample;
import com.lqs.hrm.mapper.EmployeeMapper;
import com.lqs.hrm.service.EmployeeService;

/**
 * 员工信息Service
 * @author Administrator
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	EmployeeMapper employeeMapper;
	
	
	@Override
	public Employee get(String empJobid) {
		return employeeMapper.selectByPrimaryKey(empJobid);
	}

	/**
	 * 根据职工名称和所属部门id查询
	 */
//	@Override
//	public List<Employee> listByEmpNameDeptId(String empName, Integer deptId) {
//		EmployeeExample example = new EmployeeExample();
//		example.or().andEmpNameEqualTo(empName).andDeptIdEqualTo(deptId);
//		return employeeMapper.selectByExample(example);
//	}

	/**
	 * 根据职工名称查询
	 */
	@Override
	public List<Employee> listByEmpName(String empName) {
		EmployeeExample example = new EmployeeExample();
		example.or().andEmpNameEqualTo(empName);
		return employeeMapper.selectByExample(example);
	}

}
