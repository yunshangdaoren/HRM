package com.lqs.hrm.service;

import com.lqs.hrm.entity.Employee;

public interface EmployeeService {
	/**
	 * @param empJobid
	 * @return 指定员工编号的员工信息
	 */
	Employee get(String empJobid);
}
