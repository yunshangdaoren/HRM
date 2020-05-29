package com.lqs.hrm.controller;

import java.util.Date;
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
import com.github.pagehelper.util.StringUtil;
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
	public String loginCheck(HttpServletRequest request,HttpServletResponse response) {
		//返回结果Map
		Map<String, Object> resultMap = new HashMap<>();
		User user = loginService.getUser(request.getParameter("userAccount"), request.getParameter("userPwd"));
		if (user == null) {
			//无该用户
			resultMap.put("statusCode", "0");
			resultMap.put("message", "账号或密码错误!");
		}else {
			//查询到该用户
			HttpSession session = request.getSession();
			session.setAttribute("session_loginUser", user);
			session.setMaxInactiveInterval(24*60*60);
			if (StringUtil.isNotEmpty(request.getParameter("remember"))) {
				//记住账户密码
				Cookie cookieUserAccount = new Cookie("HRMUserAccount"+request.getParameter("userAccount"),request.getParameter("userPwd"));
				cookieUserAccount.setMaxAge(30*24*60*60);
				response.addCookie(cookieUserAccount);
			}else {
				//不记住账户和密码，需要清除浏览器储存的用户账户和密码
				//获取到浏览器所有Cookie
				Cookie[] cookies = request.getCookies();
				for (Cookie cookie : cookies) {
					if (cookie.getName().length() > 14) {
						//判断是否为登录账户的Cookie
						if (cookie.getName().replace("HRMUserAccount", "").equals(request.getParameter("userAccount"))) {
							//删除该cookie
							cookie.setMaxAge(0);
							response.addCookie(cookie);
						}
					}
				}
			}
			//修改该账户的最后一次登录时间
			user.setLastLoginTime(new Date());
			//修改该账户的登录次数
			user.setLoginCount(user.getLoginCount() + 1);
			//更新该账户信息
			userService.update(user);
			resultMap.put("statusCode", "1");
			resultMap.put("message", "登录成功!");
			resultMap.put("url", "http://localhost:8080/workbench/toIndex.do");
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
			int status = userService.update(userAccount, newUserPwd);
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









