package com.lqs.hrm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lqs.hrm.entity.Roles;
import com.lqs.hrm.entity.User;
import com.lqs.hrm.entity.UserRole;
import com.lqs.hrm.json.JsonCommonResult;
import com.lqs.hrm.service.impl.RolesServiceImpl;
import com.lqs.hrm.service.impl.UserRoleServiceImpl;

/**
 * 工作台Controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("workbench")
public class WorkbenchController {
	@Autowired
	private UserRoleServiceImpl userRoleService;
	@Autowired
	private RolesServiceImpl rolesService;
	
	/**
	 * 跳转到管理员工作台
	 * @return
	 */
	@RequestMapping("toIndex.do")
	public String index(HttpServletRequest request) {
		//获取当前登录系统人工号
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("session_loginUser");
		
		//判断登录用户类型
		List<UserRole> userRoleList = null;
		if (user != null) {
			userRoleList = userRoleService.listByUserAccount(user.getUserAccount());
		}
		
		Roles roles = rolesService.get(userRoleList.get(0).getRoleId());
		//设置登录用户角色
		session.setAttribute("roles", roles);
		session.setMaxInactiveInterval(24*60*60);
		System.out.println("------Roles:"+roles.toString());
		if (roles.getRoleId() == 3) {
			//跳转到普通职工首页
			return "workbench/employeeIndex";
		}else {
			//跳转到管理员和企业管理者首页
			return "workbench/managerIndex";
		}
	}
}
