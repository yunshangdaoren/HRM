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
import com.lqs.hrm.entity.Roles;
import com.lqs.hrm.entity.User;
import com.lqs.hrm.entity.UserRole;
import com.lqs.hrm.json.JsonCommonResult;
import com.lqs.hrm.json.JsonPageResult;
import com.lqs.hrm.service.impl.RolesServiceImpl;
import com.lqs.hrm.service.impl.UserRoleServiceImpl;
import com.lqs.hrm.service.impl.UserServiceImpl;
import com.lqs.hrm.util.PageRequest;
import com.lqs.hrm.util.PageResult;
import com.lqs.hrm.util.PageResultUtil;
import com.lqs.hrm.util.entity.RoleInfoUtil;
import com.lqs.hrm.util.entity.UserRoleInfoUtil;

/**
 * 角色信息Controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("role")
public class RoleController {
	@Autowired
	private RolesServiceImpl rolesService;
	@Autowired
	private RoleInfoUtil roleInfoUtil;
	
	/**
	 * 跳转至角色列表页面
	 * @param request
	 * @param pageRequest
	 * @param map
	 * @return
	 */
	@RequestMapping("toRoleList.do")
	public String toUserRoleList(HttpServletRequest request, PageRequest pageRequest, ModelMap map){
		//获取角色ID
		String roleIdStr = request.getParameter("roleId");
		//分页
		PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
		List<Roles> roleList = new ArrayList<>();
		//查询条件判断
		if (StringUtil.isEmpty(roleIdStr)) {
			//如果查询的条件全部为空，则查询出所有角色信息，除了超级管理员
			roleList = rolesService.listByNo();
		}else {
			//则根据角色ID查询
			roleList.add(rolesService.get(Integer.valueOf(roleIdStr)));
		}
		
		//设置查询出来的角色信息
		roleInfoUtil.setRoleInfo(roleList);
		//设置分页查询结果
		PageResult pageResult = PageResultUtil.getPageResult(new PageInfo<>(roleList));
		//返回查询的部门信息
		map.put("pageResult", pageResult);
		//返回查询的条件信息
		map.put("roleIdStr", roleIdStr);
		return "/system/userRoleList";
	}
	
	/**
	 * 返回所有角色信息
	 * @return
	 */
	@RequestMapping("list.do")
	@ResponseBody
	public JsonCommonResult<List<Roles>> list(){
		//查询部门级别信息
		List<Roles> roleList = rolesService.listByNo();
		if (roleList.size() == 0 ||roleList == null) {
			return new JsonCommonResult<>("100", null, "没有数据！");
		}
		return new JsonCommonResult<List<Roles>>("200", roleList, "请求成功");
	}

}
