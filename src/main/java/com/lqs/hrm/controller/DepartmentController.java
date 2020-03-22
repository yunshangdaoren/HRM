package com.lqs.hrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("department")
public class DepartmentController {

	@RequestMapping("departmentIndex.do")
	public String departmentIndex(){
		return "department/departmentIndex";
	}
	
	
}
