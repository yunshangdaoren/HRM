package com.lqs.hrm.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.lqs.hrm.entity.Department;
import com.lqs.hrm.entity.DepartmentLevel;
import com.lqs.hrm.entity.Position;
import com.lqs.hrm.entity.User;
import com.lqs.hrm.entity.UserRole;
import com.lqs.hrm.json.JsonCommonResult;
import com.lqs.hrm.service.impl.UserRoleServiceImpl;
import com.lqs.hrm.service.impl.UserServiceImpl;
import com.lqs.hrm.util.PageRequest;
import com.lqs.hrm.util.PageResult;
import com.lqs.hrm.util.PageResultUtil;
import com.lqs.hrm.util.entity.UserRoleInfoUtil;

/**
 * 用户角色信息Controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("userRole")
public class UserRoleController {
	@Autowired
	private UserRoleServiceImpl userRoleService;
	@Autowired
	private UserRoleInfoUtil userRoleInfoUtil;
	
	/**
	 * 跳转至用户角色列表页面
	 * @param request
	 * @param pageRequest
	 * @param map
	 * @return
	 */
	@RequestMapping("toUserRoleList.do")
	public String toUserRoleList(HttpServletRequest request, PageRequest pageRequest, ModelMap map){
		//获取职工工号
		String empJobIdStr = request.getParameter("empJobId");
		//获取角色ID
		String roleIdStr = request.getParameter("roleId");
		//分页
		PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
		List<UserRole> userRoleList = new ArrayList<>();
		//查询条件判断
		if (StringUtil.isEmpty(empJobIdStr) && StringUtil.isEmpty(roleIdStr)) {
			//如果查询的条件全部为空，则查询出所有用户角色信息，除了超级管理员
			userRoleList = userRoleService.listByNoExceptSuperManager();
		}else if(StringUtil.isEmpty(roleIdStr)) {
			//则根据职工工号查询
			userRoleList = userRoleService.listByUserAccount(empJobIdStr);
		}else if(StringUtil.isEmpty(empJobIdStr)) {
			//则根据角色ID查询
			userRoleList = userRoleService.listByRoleId(Integer.valueOf(roleIdStr));
		}else {
			//则根据职工工号，角色ID查询
			userRoleList = userRoleService.listByUserAccountRoleId(empJobIdStr, Integer.valueOf(roleIdStr));
		}
		
		//设置查询出来的用户角色信息
		userRoleInfoUtil.setUserRoleInfo(userRoleList);
		//设置分页查询结果
		PageResult pageResult = PageResultUtil.getPageResult(new PageInfo<>(userRoleList));
		//返回查询的部门信息
		map.put("pageResult", pageResult);
		//返回查询的条件信息
		map.put("empJobIdStr", empJobIdStr);
		map.put("roleIdStr", roleIdStr);
		return "/system/userRoleList";
	}
	
	/**
	 * 修改部门级别信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("update.do")
	@ResponseBody
	public JsonCommonResult<Object> update(HttpServletRequest request) {
		//获取职工工号
		String empEmpJobIdStr = request.getParameter("empJobId");
		//获取角色ID
		String roldIdStr = request.getParameter("roleId");
		//获取旧的角色ID oldRoleId
		String oldRoleIdStr = request.getParameter("oldRoleId");
		
		List<UserRole> userRoleList = userRoleService.listByUserAccountRoleId(empEmpJobIdStr, Integer.valueOf(oldRoleIdStr));
		if (userRoleList != null && userRoleList.size() != 0) {
			UserRole userRole = userRoleList.get(0);
			//重新设置用户角色信息
			userRole.setLastOperatorDate(new Date());
			userRole.setRoleId(Integer.valueOf(roldIdStr));
			//获取当前登录系统人工号
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("session_loginUser");
			if (user == null) {
				return new JsonCommonResult<Object>("100", null, "请先登录！");
			}
			//设置工号 
			userRole.setOperatorEmpjobid(user.getUserAccount());
			int result = userRoleService.update(userRole);
			System.out.println("result："+result);
			if (result == 0) {
				return new JsonCommonResult<Object>("100", null, "修改失败！");
			}
			return new JsonCommonResult<>("200", null, "修改成功");
		}
		return new JsonCommonResult<Object>("100", null, "最终修改失败！");
	}
	
}
