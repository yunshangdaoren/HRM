package com.lqs.hrm.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lqs.hrm.entity.User;
import com.lqs.hrm.service.LoginService;

@Controller
@RequestMapping("login")
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("loginPage")
	public String loginPage() {
		return "loginPage";
	}
	
	@RequestMapping("loginCheck")
	public String loginCheck(User u, HttpServletRequest request,HttpServletResponse response, ModelMap map ) {
		User user = loginService.getUser(u.getUserAccount(), u.getUserPwd());
		if (user == null) {
			//无该用户
			map.put("erro_loginFail", "账号或密码错误!");
			return "loginPage";
		}else {
			//查询到该用户
			HttpSession session = request.getSession();
			session.setAttribute("session_loginUser", user);
			if (u.getRememberPwd()!=null && u.getRememberPwd()==true) {
				//记住账户密码
				Cookie cookieUserAccount = new Cookie("userAccount", String.valueOf(u.getUserAccount()));
				Cookie cookieUserPwd = new Cookie("userPwd", String.valueOf(u.getUserPwd()));
				response.addCookie(cookieUserAccount);
				response.addCookie(cookieUserPwd);
			}else {
				//不记住账户和密码，需要清除浏览器储存的用户账户和密码
				//获取到浏览器所有Cookie
				Cookie[] cookies = request.getCookies();
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals(u.getUserAccount().toString()) || 
								cookie.getName().equals(u.getUserPwd().toString())) {
						System.out.println("================== ：删除Cookie");
						//删除该cookie
						cookie.setMaxAge(0);
						response.addCookie(cookie);
					}
				}
			}
			return "redirect:/hello";
		}
	}
	
	@RequestMapping("sendEmailVerificationCode")
	public String sendEmailVerificationCode(String userAccount, String securityMail) {
		
		return "status:1";
	}
	
	
}
