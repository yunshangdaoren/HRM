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
import com.lqs.hrm.entity.DepartmentLevel;
import com.lqs.hrm.entity.Status;
import com.lqs.hrm.json.JsonCommonResult;
import com.lqs.hrm.json.JsonPageResult;
import com.lqs.hrm.service.impl.DepartmentLevelServiceImpl;
import com.lqs.hrm.service.impl.DepartmentServiceImpl;
import com.lqs.hrm.service.impl.StatusServiceImpl;
import com.lqs.hrm.service.impl.UserServiceImpl;
import com.lqs.hrm.util.PageRequest;
import com.lqs.hrm.util.PageResult;
import com.lqs.hrm.util.PageResultUtil;

@Controller
@RequestMapping("departmentStatus")
public class StatusController {
	@Autowired
	private StatusServiceImpl statusService;
	
	/**
	 * 返回添加部门要填充的部门状态信息
	 * @return
	 */
	@RequestMapping("getStatus.do")
	@ResponseBody
	public JsonCommonResult<List<Status>> getStatus(){
		//查询部门级别信息
		List<Status> list = statusService.list();
		if (list == null) {
			return new JsonCommonResult<List<Status>>("100", null, "没有数据！");
		}
		return new JsonCommonResult<List<Status>>("200", list, "请求成功");
	}

	
}

