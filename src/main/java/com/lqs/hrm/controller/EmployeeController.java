package com.lqs.hrm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.lqs.hrm.entity.Department;
import com.lqs.hrm.entity.Employee;
import com.lqs.hrm.entity.EmployeeDepartment;
import com.lqs.hrm.entity.Status;
import com.lqs.hrm.entity.User;
import com.lqs.hrm.json.JsonCommonResult;
import com.lqs.hrm.service.impl.DepartmentServiceImpl;
import com.lqs.hrm.service.impl.EmployeeDepartmentServiceImpl;
import com.lqs.hrm.service.impl.EmployeeServiceImpl;
import com.lqs.hrm.service.impl.StatusServiceImpl;
import com.lqs.hrm.service.impl.UserServiceImpl;

/**
 * 职工信息Controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("employee")
public class EmployeeController {
	@Autowired
	EmployeeServiceImpl employeeService;
	@Autowired
	private DepartmentServiceImpl departmentService;
	@Autowired
	private StatusServiceImpl statusService;
	@Autowired
	private EmployeeDepartmentServiceImpl employeeDepartmentService;
	
	@RequestMapping("get.do")
	@ResponseBody
	public JsonCommonResult<Employee> get(String empJobid) {
		Employee employee =  employeeService.get(empJobid);
		//获取部门信息
		List<EmployeeDepartment> list = employeeDepartmentService.get(empJobid);
		//list
		List<Integer> deptIdList = new ArrayList<Integer>();
		List<String> deptNameList = new ArrayList<String>();
		for (EmployeeDepartment employeeDepartment : list) {
			//设置职工所属部门信息
			deptIdList.add(employeeDepartment.getDeptId());
			deptNameList.add(departmentService.get(employeeDepartment.getDeptId()).getDeptName());
		}
		//设置职工所属部门信息
		employee.setDeptIdList(deptIdList);
		employee.setDeptNameList(deptNameList);
		//设置职工状态名称
		Status status = statusService.get(1);
		employee.setStatusName(statusService.get(employee.getStatusId()).getStatusName());
		return new JsonCommonResult<Employee>("200", employee, "获取成功！");
	}
	
	
	
}
