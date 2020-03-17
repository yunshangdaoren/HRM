package com.lqs.hrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("login")
public class LoginController {
	
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "loginPage";
	}
}
