package com.lqs.hrm.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.lqs.hrm.entity.User;
import com.lqs.hrm.service.impl.LoginServiceImpl;
import com.lqs.hrm.service.impl.MailServiceImpl;
import com.lqs.hrm.service.impl.UserServiceImpl;
import com.lqs.hrm.util.RandomNumberUtil;

@Controller
@RequestMapping("login")
public class LoginController {
	@Autowired
	private LoginServiceImpl loginService;
	@Autowired
	private MailServiceImpl mailService;
	@Autowired
	private UserServiceImpl userService;
	
	/**
	 * 跳转到登录页面
	 * @return
	 */
	@RequestMapping("loginPage.do")
	public String loginPage() {
		return "loginPage";
	}
	
	/**
	 * 登录
	 * @param u
	 * @param request
	 * @param response
	 * @param map
	 * @return
	 */
	@RequestMapping("loginCheck.do")
	@ResponseBody
	public String loginCheck(User u, HttpServletRequest request,HttpServletResponse response) {
		//返回结果Map
		Map<String, Object> resultMap = new HashMap<>();
		User user = loginService.getUser(u.getUserAccount(), u.getUserPwd());
		if (user == null) {
			//无该用户
			resultMap.put("statusCode", "0");
			resultMap.put("message", "账号或密码错误!");
		}else {
			//查询到该用户
			HttpSession session = request.getSession();
			session.setAttribute("session_loginUser", user);
			session.setMaxInactiveInterval(24*60*60);
			if (u.getRememberPwd()!=null && u.getRememberPwd()==true) {
				//记住账户密码
				Cookie cookieUserAccount = new Cookie("userAccount", String.valueOf(u.getUserAccount()));
				Cookie cookieUserPwd = new Cookie("userPwd", String.valueOf(u.getUserPwd()));
				cookieUserAccount.setMaxAge(30*24*60*60);
				cookieUserPwd.setMaxAge(30*24*60*60);
				response.addCookie(cookieUserAccount);
				response.addCookie(cookieUserPwd);
			}else {
				//不记住账户和密码，需要清除浏览器储存的用户账户和密码
				//获取到浏览器所有Cookie
				Cookie[] cookies = request.getCookies();
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals(u.getUserAccount().toString()) || 
								cookie.getName().equals(u.getUserPwd().toString())) {
						//删除该cookie
						cookie.setMaxAge(0);
						response.addCookie(cookie);
					}
				}
			}
			resultMap.put("statusCode", "1");
			resultMap.put("message", "登录成功!");
			resultMap.put("url", "http://localhost:8080/workbench/index.do");
		}
		return JSON.toJSONString(resultMap);
	}
	
	/**
	 * 退出登录
	 * @param request
	 * @return
	 */
	@RequestMapping("logout.do")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/login/loginPage.do";
	}
	
	/**
	 * 发送邮件验证码
	 * @param userAccount
	 * @param securityMail
	 * @return
	 */
	@RequestMapping("sendEmailVerificationCode.do")
	@ResponseBody
	public String sendEmailVerificationCode(String userAccount, String securityMail, HttpServletRequest request) {
		//获取到随机6位数验证码
		Integer emailVerificationCode = RandomNumberUtil.getRandomSixDigitNumber();
		//返回结果Map
		Map<String, Object> resultMap = new HashMap<>();
		//储存Session Map
		Map<String, Integer> codeMap = new HashMap<>();
		codeMap.put("emailVerificationCode", emailVerificationCode);
		//Session
		HttpSession session = request.getSession();
		//将验证码储存在Session里面
		session.setAttribute(userAccount, codeMap);
		//设置验证码有效期为10分钟
		session.setMaxInactiveInterval(10*60);
		//发送验证码
		mailService.sendSimpleMail(securityMail, "找回密码", "这是一封找回密码的邮件，您的验证码为"+emailVerificationCode+",验证码有效期为10分钟。");
		resultMap.put("statusCode", "1");
		resultMap.put("message", "发送成功！");
		return JSON.toJSONString(resultMap);
	}
	
	/**
	 * 找回密码
	 * @return
	 */
	@RequestMapping("retrievePwd.do")
	@ResponseBody
	public String retrievePwd(String userAccount, String securityMail, String emailVerificationCode, String newUserPwd, HttpServletRequest request) {
		//获取到储存在Session中的验证码
		HttpSession session = request.getSession();
		//获取到储存的codeMap
		Map<String, Integer> codeMap = (Map<String, Integer>) session.getAttribute(userAccount);
		//获取到存储的邮箱验证码
		Integer code = codeMap.get("emailVerificationCode");
		//返回结果Map
		Map<String, String> resultMap = new HashMap<>();
		if (code.intValue() != Integer.valueOf(emailVerificationCode).intValue()) {
			//输入的验证码不正确
			resultMap.put("statusCode", "0");
			resultMap.put("message", "验证码不正确");
		}else {
			//验证码正确,修改账户密码
			int status = userService.updateUserPwd(userAccount, newUserPwd);
			if (status == 1) {
				//修改成功
				session.removeAttribute(userAccount);
				resultMap.put("statusCode", "1");
				resultMap.put("message", "修改成功！");
			}else {
				resultMap.put("statusCode", "0");
				resultMap.put("message", "修改失败！");
			}
		}
		return JSON.toJSONString(resultMap);
	}
	
}









