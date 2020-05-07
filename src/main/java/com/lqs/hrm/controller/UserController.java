package com.lqs.hrm.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.lqs.hrm.entity.User;
import com.lqs.hrm.service.impl.UserServiceImpl;

/**
 * 用户信息Controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	UserServiceImpl userService;
	
	/**
	 * 修改密码
	 * @param u
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("changeUserPwd.do")
	public String changeUserPwd(String currentUserPwd, String newUserPwd, HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> resultMap = new HashMap<>();
		//获取当前登录用户的密码
		HttpSession session = request.getSession();
		User sessionLoginUser = (User) session.getAttribute("session_loginUser");
		String userPwd = sessionLoginUser.getUserPwd();
		
		//判断密码跟输入的当前密码是否一致
		if(!userPwd.equals(currentUserPwd)) {
			//不一致则返回报错
			resultMap.put("statusCode", 0);
			resultMap.put("message", "当前密码错误!");
			return JSON.toJSONString(resultMap);
		}
		//密码一致，则修改密码
		//更新Session里面的用户密码信息
		sessionLoginUser.setUserPwd(newUserPwd);
		int statusCode = userService.update(sessionLoginUser.getUserAccount(), newUserPwd);
		if(statusCode == 1) {
			resultMap.put("statusCode", statusCode);
			resultMap.put("message", "修改成功！");
		}else {
			resultMap.put("statusCode", 0);
			resultMap.put("message", "修改失败！");
		}
		return JSON.toJSONString(resultMap);
	}
	
	@RequestMapping("get")
	@ResponseBody
	public User get(String userAccount) {
		return userService.get(userAccount);
	}
	
	
	
}
