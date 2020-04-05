package com.lqs.hrm;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lqs.hrm.entity.Department;
import com.lqs.hrm.service.DepartmentService;
import com.lqs.hrm.service.impl.DepartmentServiceImpl;

public class DepartmentTest {
	@Autowired 
	private DepartmentServiceImpl service;
	
	@Test
	void add() {
		Department department = new Department();
		int code = service.insert(department);
		System.out.println("code:" + code);
	}
}
