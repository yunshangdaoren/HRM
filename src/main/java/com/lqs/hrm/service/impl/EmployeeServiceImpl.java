package com.lqs.hrm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lqs.hrm.entity.Employee;
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

}
