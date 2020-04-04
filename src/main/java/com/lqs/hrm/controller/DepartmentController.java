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
import com.github.pagehelper.util.StringUtil;
import com.lqs.hrm.entity.Department;
import com.lqs.hrm.entity.Employee;
import com.lqs.hrm.json.JsonPageResult;
import com.lqs.hrm.service.impl.DepartmentLevelServiceImpl;
import com.lqs.hrm.service.impl.DepartmentServiceImpl;
import com.lqs.hrm.service.impl.EmployeeServiceImpl;
import com.lqs.hrm.service.impl.StatusServiceImpl;
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
	private EmployeeServiceImpl employeeService;
	

	@RequestMapping("list.do")
	public String departmentIndex(PageRequest pageRequest, ModelMap map){
		PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
		List<Department> departmentList = departmentService.listByNo();
		setDeptInfo(departmentList);
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
			//Department parentDepartment = departmentService.listByDeptName(parentDeptNameStr);
			//parentId = parentDepartment.getDeptId();
		}
		//部门主管工号
		int manageEmpjobid = 0;
		
		
		//departmentService.insert(department);
		return "";
	}
	
	@RequestMapping("query.do")
	@ResponseBody
	public JsonPageResult list(HttpServletRequest request, PageRequest pageRequest) {
		//查询条件信息
		String deptIdStr = request.getParameter("deptId");
		String deptNameStr = request.getParameter("deptName");
		String manageEmpNameStr = request.getParameter("manageEmpName");
		String dlIdStr = request.getParameter("dlId");
		//分页
		PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
		List<Department> departmentList = new ArrayList<>();
		//查询条件判断
		if (StringUtil.isEmpty(deptIdStr) && StringUtil.isEmpty(deptNameStr) && StringUtil.isEmpty(manageEmpNameStr) && StringUtil.isEmpty(dlIdStr)) {
			System.out.println("查询条件都为空");
			//如果查询的条件全部为空，则查询出所有部门信息
			departmentList = departmentService.listByNo();
		}else if(StringUtil.isEmpty(deptNameStr) && StringUtil.isEmpty(manageEmpNameStr) && StringUtil.isEmpty(dlIdStr)) {
			//则根据部门id查询
			Department department = departmentService.get(Integer.valueOf(deptIdStr));
			departmentList.add(department);
		}else if(StringUtil.isEmpty(deptIdStr) && StringUtil.isEmpty(manageEmpNameStr) && StringUtil.isEmpty(dlIdStr)){
			//则根据部门名称查询
			departmentList = departmentService.listByDeptName(deptNameStr);
		}else if(StringUtil.isEmpty(deptIdStr) && StringUtil.isEmpty(deptNameStr) && StringUtil.isEmpty(dlIdStr)) {
			//根据部门主管名称查询
			//查询指定职工名称的职工信息
			List<Employee> employeeList = employeeService.listByEmpName(manageEmpNameStr);
			//对职工列表进行遍历查询出相应的部门信息
			for (Employee employee : employeeList) {
				List<Department> list = departmentService.listBymanageEmpjobid(employee.getEmpJobid());
				for (Department department : list) {
					departmentList.add(department);
				}
			}
		}else if(StringUtil.isEmpty(deptIdStr) && StringUtil.isEmpty(deptNameStr) && StringUtil.isEmpty(manageEmpNameStr)) {
			//根据部门级别查询
			departmentList = departmentService.listByDlId(Integer.valueOf(dlIdStr));
		}else if(StringUtil.isEmpty(manageEmpNameStr) && StringUtil.isEmpty(dlIdStr)) {
			//根据部门id，部门名称查询
			departmentList = departmentService.listByDeptIdName(Integer.valueOf(deptIdStr), deptNameStr);
		}else if(StringUtil.isEmpty(deptNameStr) && StringUtil.isEmpty(dlIdStr)) {
			//根据部门id，部门主管名称查询
			//查询指定职工名称的职工信息
			List<Employee> employeeList = employeeService.listByEmpName(manageEmpNameStr);
			//对职工列表进行遍历查询出相应的部门信息
			for (Employee employee : employeeList) {
				List<Department> list = departmentService.listByDeptIdManageEmpJobId(Integer.valueOf(deptIdStr), employee.getEmpJobid());
				for (Department department : list) {
					departmentList.add(department);
				}
			}
		}else if(StringUtil.isEmpty(deptNameStr) && StringUtil.isEmpty(manageEmpNameStr)) {
			//根据部门id，部门级别查询
			departmentList = departmentService.listByDeptIdDlId(Integer.valueOf(deptIdStr), Integer.valueOf(dlIdStr));
		}else if(StringUtil.isEmpty(deptIdStr) && StringUtil.isEmpty(dlIdStr)) {
			//根据部门名称，部门主管名称查询
			List<Employee> employeeList = employeeService.listByEmpName(manageEmpNameStr);
			//对职工列表进行遍历查询出相应的部门信息
			for (Employee employee : employeeList) {
				List<Department> list = departmentService.listByDeptNameManageEmpJobId(deptNameStr, employee.getEmpJobid());
				for (Department department : list) {
					departmentList.add(department);
				}
			}
		}else if(StringUtil.isEmpty(deptIdStr) && StringUtil.isEmpty(manageEmpNameStr)) {
			//根据部门名称，部门级别查询
			departmentList = departmentService.listByDeptNameDlId(deptNameStr, Integer.valueOf(dlIdStr));
		}else if(StringUtil.isEmpty(deptIdStr) && StringUtil.isEmpty(deptNameStr)) {
			//根据部门主管名称，部门级别查询
			List<Employee> employeeList = employeeService.listByEmpName(manageEmpNameStr);
			//对职工列表进行遍历查询出相应的部门信息
			for (Employee employee : employeeList) {
				List<Department> list = departmentService.listByManageEmpJobIdDlId(employee.getEmpJobid(), Integer.valueOf(dlIdStr));
				for (Department department : list) {
					departmentList.add(department);
				}
			}
		}else if(StringUtil.isEmpty(dlIdStr)) {
			//根据部门id，部门名称，部门主管名称查询
			List<Employee> employeeList = employeeService.listByEmpName(manageEmpNameStr);
			//对职工列表进行遍历查询出相应的部门信息
			for (Employee employee : employeeList) {
				List<Department> list = departmentService.listByDeptIdNameManageEmpJobId(Integer.valueOf(deptIdStr), deptNameStr, employee.getEmpJobid());
				for (Department department : list) {
					departmentList.add(department);
				}
			}
		}else if(StringUtil.isEmpty(manageEmpNameStr)) {
			//根据部门id，部门名称，部门级别查询
			departmentList = departmentService.listByDeptIdNameDlId(Integer.valueOf(deptIdStr), deptIdStr, Integer.valueOf(dlIdStr));
		}else if(StringUtil.isEmpty(deptNameStr)) {
			//根据部门id，部门主管名称，部门级别查询
			List<Employee> employeeList = employeeService.listByEmpName(manageEmpNameStr);
			//对职工列表进行遍历查询出相应的部门信息
			for (Employee employee : employeeList) {
				List<Department> list = departmentService.listByDeptIdManageEmpJonIdDlId(Integer.valueOf(deptIdStr), employee.getEmpJobid(), Integer.valueOf(dlIdStr));
				for (Department department : list) {
					departmentList.add(department);
				}
			}
		}else if(StringUtil.isEmpty(deptIdStr)) {
			//根据部门名称，部门主管名称，部门级别查询
			List<Employee> employeeList = employeeService.listByEmpName(manageEmpNameStr);
			//对职工列表进行遍历查询出相应的部门信息
			for (Employee employee : employeeList) {
				List<Department> list = departmentService.listByDeptNameManageEmpJonIdDlId(deptIdStr, employee.getEmpJobid(), Integer.valueOf(dlIdStr));
				for (Department department : list) {
					departmentList.add(department);
				}
			}
		}else {
			//根据id，部门名称，部门主管名称，部门级别查询
			departmentList = departmentService.listByAll(Integer.valueOf(deptIdStr), deptNameStr, manageEmpNameStr, Integer.valueOf(dlIdStr));
		}
		if (departmentList == null) {
			return new JsonPageResult("100", null, "没有数据！");
		}
		setDeptInfo(departmentList);
		return new JsonPageResult("200", PageResultUtil.getPageResult(new PageInfo<>(departmentList)), "请求成功！");
	}
	
	/**
	 * 设置查询出来的部门实体类信息
	 * @param departmentList
	 */
	public void setDeptInfo(List<Department> list) {
		for (int i = 0; i < list.size(); i++) {
			//设置部门级别
			list.get(i).setDlLeve(departmentLevelService.get(list.get(i).getDlId()).getLevel());
			//设置部门主管名称
			if(list.get(i).getManageEmpjobid() != null && !list.get(i).getManageEmpjobid().isEmpty()) {
				list.get(i).setManageEmpName(employeeService.get(list.get(i).getManageEmpjobid()).getEmpName());
			}
			//设置上级部门名称
			if (list.get(i).getParentId() != null) {
				list.get(i).setParentDeptName(departmentService.get(list.get(i).getParentId()).getDeptName());
			} 
			//设置部门状态名称
			list.get(i).setStatusName(statusService.get(list.get(i).getStatusId()).getStatusName());
			//设置操作人名称
			if(list.get(i).getOperatorEmpjobid() != null && !list.get(i).getOperatorEmpjobid().isEmpty()) {
				list.get(i).setOperatorEmpName(employeeService.get(list.get(i).getOperatorEmpjobid()).getEmpName());
			}
		}
	}
}

