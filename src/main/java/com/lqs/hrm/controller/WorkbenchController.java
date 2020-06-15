package com.lqs.hrm.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lqs.hrm.entity.AttendanceEmployee;
import com.lqs.hrm.entity.Roles;
import com.lqs.hrm.entity.User;
import com.lqs.hrm.entity.UserRole;
import com.lqs.hrm.json.JsonCommonResult;
import com.lqs.hrm.service.impl.AttendanceEmployeeServiceImpl;
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
	@Autowired
	private AttendanceEmployeeServiceImpl attendanceEmployeeService;
	
	/**
	 * 跳转到管理员工作台
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("toIndex.do")
	public String index(HttpServletRequest request, ModelMap map) throws ParseException {
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
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
		//获取当前登录用户的考勤信息
		List<AttendanceEmployee> attendanceEmployeeList = attendanceEmployeeService.listByEmpJobIdDate(user.getUserAccount(), format2.parse(format.format(new Date()).substring(0, 10)));
		AttendanceEmployee attendanceEmployee = null;
		if (attendanceEmployeeList != null && attendanceEmployeeList.size() > 0) {
			attendanceEmployee = attendanceEmployeeList.get(0);
		}
		map.put("attendanceEmployee", attendanceEmployee);
		if (roles.getRoleId() == 1) {
			//跳转到超级管理员
			return "workbench/managerIndex";
		}else if(roles.getRoleId() == 2){
			//跳转到职工管理者首页
			return "workbench/simpleEmployeeIndex";
		}else {
			//跳转到普通职工首页
			return "workbench/simpleEmployeeIndex";
		}
	}
}
