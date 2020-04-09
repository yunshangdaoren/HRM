package com.lqs.hrm;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lqs.hrm.entity.Department;
import com.lqs.hrm.entity.Status;
import com.lqs.hrm.entity.User;
import com.lqs.hrm.service.impl.DepartmentServiceImpl;
import com.lqs.hrm.service.impl.LoginServiceImpl;
import com.lqs.hrm.service.impl.MailServiceImpl;
import com.lqs.hrm.service.impl.StatusServiceImpl;
import com.lqs.hrm.service.impl.UserServiceImpl;

@SpringBootTest
class StatusTests {
	@Autowired 
	private StatusServiceImpl statusService;
	
	
	@Test
	void get() {
		Status status = statusService.get(1);
		System.out.println("测试status:"+status);
	}
	
	
}
