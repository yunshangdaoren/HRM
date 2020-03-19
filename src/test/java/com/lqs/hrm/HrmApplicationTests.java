package com.lqs.hrm;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lqs.hrm.entity.User;
import com.lqs.hrm.service.LoginService;
import com.lqs.hrm.service.mail.impl.MailServiceImpl;

@SpringBootTest
class HrmApplicationTests {
	@Autowired 
	private LoginService service;
	@Autowired
	private MailServiceImpl mailService;

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
	
	@Test
	void test() {
		mailService.sendSimpleMail("1396758907@qq.com", "测试邮件", "你好，收到测试邮件了吗？");
	}
}
