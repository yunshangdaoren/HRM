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
		String deptLevel = request.getParameter("level");
		String parentDeptName = request.getParameter("parentDeptName");
		String deptManageName = request.getParameter("deptManageName");
		String deptStatus = request.getParameter("status");
		
		
		
		
		//departmentService.insert(department);
		return "";
	}
	
	
}
