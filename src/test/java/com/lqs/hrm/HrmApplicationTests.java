package com.lqs.hrm;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lqs.hrm.entity.User;
import com.lqs.hrm.service.LoginService;

@SpringBootTest
class HrmApplicationTests {
	@Autowired 
	private LoginService service;

	@Test
	void contextLoads() {
	}

	@Test
	void getUser() {
		User user = service.getUser(new Integer(1), "123456");
		System.out.println("User信息如下：==========================");
		System.out.println("User信息如下：==========================");
		System.out.println("User信息如下：==========================");
		System.out.println("User信息如下：==========================");
		System.out.println("User信息如下：==========================");
		System.out.println("User信息如下：==========================");
		System.out.println("User信息如下：==========================");
		System.out.println("User信息如下：==========================");
		System.out.println(user.getUserAccount());
	}
}
