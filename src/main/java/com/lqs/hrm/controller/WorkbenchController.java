package com.lqs.hrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 工作台Controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("workbench")
public class WorkbenchController {
	
	@RequestMapping("index.do")
	public String index() {
		return "workbench/index";
	}
}
