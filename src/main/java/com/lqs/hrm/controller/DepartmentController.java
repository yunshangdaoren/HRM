package com.lqs.hrm.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lqs.hrm.entity.Department;
import com.lqs.hrm.service.impl.DepartmentLevelServiceImpl;
import com.lqs.hrm.service.impl.DepartmentServiceImpl;

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
	public String departmentManage(){
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
	
	
}
