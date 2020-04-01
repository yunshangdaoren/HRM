package com.lqs.hrm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lqs.hrm.entity.Department;
import com.lqs.hrm.json.JsonCommonResult;
import com.lqs.hrm.json.JsonPageResult;
import com.lqs.hrm.service.impl.DepartmentLevelServiceImpl;
import com.lqs.hrm.service.impl.DepartmentServiceImpl;
import com.lqs.hrm.util.PageRequest;
import com.lqs.hrm.util.PageResult;
import com.lqs.hrm.util.PageResultUtil;

@Controller
@RequestMapping("department")
public class DepartmentController {
	@Autowired
	private DepartmentServiceImpl departmentService;
	@Autowired
	private DepartmentLevelServiceImpl departmentLevelService;
	

	@RequestMapping("departmentDetail.do")
	public String departmentIndex(){
		return "department/departmentDetail";
	}
	
	@RequestMapping("departmentManage.do")
	public String departmentManage(ModelMap map, HttpServletRequest request){
		PageHelper.startPage(0, 1);
		List<Department> departmentList = departmentService.list();
		PageInfo<Department> pageInfo = new PageInfo<>(departmentList);
		map.put("pageInfo", pageInfo);
		return "department/departmentManage";
	}
	
	@RequestMapping("addDepartment.do")
	public String add(Department department, HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> resultMap = new HashMap<>();
		
		String deptLevelStr = request.getParameter("level");
		String parentDeptNameStr = request.getParameter("parentDeptName");
		String deptManageNameStr = request.getParameter("deptManageName");
		String deptStatusStr = request.getParameter("status");
		
		//部门级别
		int deptLevel = departmentLevelService.get(Integer.parseInt(deptLevelStr)).getLevel();
		//上级部门id
		int parentId = 0;
		if (parentDeptNameStr != null || !"".equals(parentDeptNameStr)) {
			Department parentDepartment = departmentService.get(parentDeptNameStr);
			parentId = parentDepartment.getDeptId();
		}
		//部门主管工号
		int manageEmpjobid = 0;
		
		
		//departmentService.insert(department);
		return "";
	}
	
	@RequestMapping("list")
	@ResponseBody
	public JsonPageResult list(PageRequest pageRequest) {
		PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
		List<Department> list = departmentService.list();
		if (list == null) {
			return new JsonPageResult("100", null, "没有数据！");
		}
		return new JsonPageResult("200", PageResultUtil.getPageResult(new PageInfo<>(list)), "请求成功！");
	}

	
}

