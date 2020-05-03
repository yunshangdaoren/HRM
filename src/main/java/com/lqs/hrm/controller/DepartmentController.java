package com.lqs.hrm.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.lqs.hrm.entity.Department;
import com.lqs.hrm.entity.DepartmentLevel;
import com.lqs.hrm.entity.Employee;
import com.lqs.hrm.entity.EmployeeDepartment;
import com.lqs.hrm.entity.EmployeeDepartmentExample;
import com.lqs.hrm.entity.Status;
import com.lqs.hrm.entity.User;
import com.lqs.hrm.json.JsonCommonResult;
import com.lqs.hrm.json.JsonPageResult;
import com.lqs.hrm.service.impl.DepartmentLevelServiceImpl;
import com.lqs.hrm.service.impl.DepartmentServiceImpl;
import com.lqs.hrm.service.impl.EmployeeDepartmentServiceImpl;
import com.lqs.hrm.service.impl.EmployeeServiceImpl;
import com.lqs.hrm.service.impl.StatusServiceImpl;
import com.lqs.hrm.util.PageRequest;
import com.lqs.hrm.util.PageResult;
import com.lqs.hrm.util.PageResultUtil;

/**
 * 部门Controller
 * @author Administrator
 *
 */
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
	@Autowired
	private EmployeeDepartmentServiceImpl employeeDepartmentService;
	
	/**
	 * 查询部门并跳转至部门详情页面
	 * @param request
	 * @param pageRequest
	 * @param map
	 * @return
	 */
	@RequestMapping("departmentList.do")
	public String departmentList(HttpServletRequest request, PageRequest pageRequest, ModelMap map){
		//查询条件信息
		String deptIdStr = request.getParameter("deptId");
		System.out.println("部门编号："+deptIdStr);
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
		setDeptInfo(departmentList);
		PageResult pageResult = PageResultUtil.getPageResult(new PageInfo<>(departmentList));
		//返回查询的部门信息
		map.put("pageResult", pageResult);
		//回显查询条件
		map.put("deptIdStr", deptIdStr);
		map.put("deptNameStr", deptNameStr);
		map.put("manageEmpNameStr", manageEmpNameStr);
		map.put("dlIdStr", dlIdStr);
		
		//部门级别信息
		List<DepartmentLevel> departmentLevelList = departmentLevelService.list();
		//返回查询的部门级别信息
		map.put("departmentLevelList", departmentLevelList);
		return "department/departmentList";
	}
	
	/**
	 * 返回查询的指定部门信息
	 * 根据部门id、部门名称、主管人名称、部门级别id查询
	 * @param request
	 * @param pageRequest
	 * @return
	 */
	@RequestMapping("query.do")
	@ResponseBody
	public JsonPageResult query(HttpServletRequest request, PageRequest pageRequest) {
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
	 * 模糊查询、返回查询的指定部门信息
	 * 根据部门名称模糊查询
	 * @param request
	 * @param pageRequest
	 * @return
	 */
	@RequestMapping("queryLikeDeptName.do")
	@ResponseBody
	public JsonPageResult queryLikeDeptName(HttpServletRequest request, PageRequest pageRequest) {
		//查询条件信息
		String deptNameStr = request.getParameter("deptName");
		//分页
		PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
		List<Department> departmentList = new ArrayList<>();
		//查询条件判断
		if (StringUtil.isEmpty(deptNameStr)) {
			//如果查询的条件全部为空，则查询出所有部门信息
			departmentList = departmentService.listByNo();
		}else {
			//根据部门名称模糊查询
			departmentList = departmentService.listLikeDeptName(deptNameStr);
			
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
	
	/**
	 * 添加部门信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("add.do")
	@ResponseBody
	public JsonCommonResult<Object> add(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> resultMap = new HashMap<>();
		//获取部门名称
		String deptNameStr = request.getParameter("deptName");
		//获取部门级别id
		String dlIdStr = request.getParameter("dlId");
		//获取上级部门名称
		String parentDeptNameStr = request.getParameter("parentDeptName");
		//获取部门主管名称
		String deptManageNameStr = request.getParameter("deptManageName");
		//获取部门状态id
		String statusIdStr = request.getParameter("statusId");
		//获取部门描述
		String deptDescStr = request.getParameter("deptDesc");
		//上级部门id
		int parentId = 0;
		if (!StringUtil.isEmpty(parentDeptNameStr)) {
			Department parentDepartment = departmentService.listByDeptName(parentDeptNameStr).get(0);
			parentId = parentDepartment.getDeptId();
			System.out.println("获取到上级部门id:"+parentId);
		}
		//部门主管工号
		String manageEmpjobid = "";
		if (!StringUtil.isEmpty(deptManageNameStr)) {
			Employee employee = employeeService.listByEmpName(deptManageNameStr).get(0);
			manageEmpjobid = employee.getEmpJobid();
			System.out.println("获取到部门主管工号:"+manageEmpjobid);
		}
		Department department = new Department();
		//设置部门名称
		department.setDeptName(deptNameStr);
		//设置部门级别id
		department.setDlId(Integer.valueOf(dlIdStr));
		//设置部门级别
		//department.setDlLeve(departmentLevelService.get(Integer.valueOf(dlIdStr)).getLevel());
		//设置部门人数
		department.setDeptEmpnum(0);
		//设置部门状态id
		department.setStatusId(Integer.valueOf(statusIdStr));
		//设置上级部门id
		department.setParentId(parentId);
		//设置部门主管工号
		department.setManageEmpjobid(manageEmpjobid);
		//设置最后一次操作时间
		department.setLastOperatorDate(new Date());
		//设置操作人工号
		//获取当前登录系统人工号
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("session_loginUser");
		if (user == null) {
			return new JsonCommonResult<Object>("100", null, "请先登录！");
		}
		//设置工号
		department.setOperatorEmpjobid(user.getUserAccount());
		//设置部门描述
		department.setDeptDesc(deptDescStr);
		
		//添加职工-部门信息
		EmployeeDepartment employeeDepartment = new EmployeeDepartment();
		employeeDepartment.setEmpJobid(manageEmpjobid);
		//添加部门信息
		int result1 = departmentService.insert(department);
		//获取刚刚添加的部门的id
		int deptId = departmentService.listByDeptName(deptNameStr).get(0).getDeptId();
		//添加职工-部门信息
		employeeDepartment.setDeptId(deptId);
		int result2 = employeeDepartmentService.insert(employeeDepartment);
		if (result1 == 0 || result2 == 0) {
			return new JsonCommonResult<Object>("100", null, "添加失败");
		}
		return new JsonCommonResult<Object>("200", null, "添加成功");
	}
	
	
}

