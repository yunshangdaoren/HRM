package com.lqs.hrm.controller;

import java.util.ArrayList;
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
import com.lqs.hrm.service.impl.StatusServiceImpl;
import com.lqs.hrm.service.impl.UserServiceImpl;
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
	@Autowired
	private StatusServiceImpl statusService;
	@Autowired
	private UserServiceImpl userService;
	

	@RequestMapping("list.do")
	public String departmentIndex(PageRequest pageRequest, ModelMap map){
		PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
		List<Department> departmentList = departmentService.list();
		for (Department department : departmentList) {
			//设置部门级别
			department.setDlLeve(departmentLevelService.get(department.getDlId()).getLevel());
			//设置部门状态名称
			department.setStatusName(statusService.get(department.getStatusId()).getStatusName());
			//设置上级部门名称
			if (department.getParentId() != null) {
				department.setParentDeptName(departmentService.get(department.getParentId()).getDeptName());
			} 
			//设置部门主管名称
			if("".equals(department.getManageEmpjobid()) || department.getManageEmpjobid() != null) {
				department.setManageEmpName(userService.getUser(department.getManageEmpjobid()).getUserName());
			}
			//设置操作人名称
			if("".equals(department.getOperatorEmpjobid()) || department.getOperatorEmpjobid() != null) {
				department.setManageEmpName(userService.getUser(department.getOperatorEmpjobid()).getUserName());
			}
			department.setOperatorEmpName(userService.getUser(department.getOperatorEmpjobid()).getUserName());
		}
		PageResult pageResult = PageResultUtil.getPageResult(new PageInfo<>(departmentList));
		map.put("pageResult", pageResult);
		return "department/list";
	}
	
	@RequestMapping("add.do")
	public String add(Department department, HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> resultMap = new HashMap<>();
		//获取部门级别信息
		String deptLevelStr = request.getParameter("level");
		//获取部门级别信息
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
	
	@RequestMapping("query.do")
	@ResponseBody
	public JsonPageResult list(HttpServletRequest request, PageRequest pageRequest) {
		String deptIdStr = request.getParameter("deptId");
		String deptNameStr = request.getParameter("deptName");
		String manageEmpNameStr = request.getParameter("manageEmpName");
		String dlIdStr = request.getParameter("dlId");
		//分页
		PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
		List<Department> list = new ArrayList<Department>();
		System.out.println(deptIdStr+"-"+deptNameStr+"-"+manageEmpNameStr+"-"+dlIdStr);
		if (deptIdStr==null && deptNameStr==null && manageEmpNameStr==null && dlIdStr==null) {
			System.out.println("查询条件都为空");
			//如果查询的条件全部为空，则查询出所有部门信息
			list = departmentService.list();
		}else if(deptNameStr==null && manageEmpNameStr==null && dlIdStr==null) {
			//如果查询条件：部门名称，部门主管名称，部门级别为空，则根据部门id查询
			//查询部门id所在部门
			Department department = departmentService.get(Integer.valueOf(deptIdStr));
			list.add(department);
		}else {
			System.out.println("不为空");
		}
		if (list == null) {
			return new JsonPageResult("100", null, "没有数据！");
		}
		return new JsonPageResult("200", PageResultUtil.getPageResult(new PageInfo<>(list)), "请求成功！");
	}

	
}

