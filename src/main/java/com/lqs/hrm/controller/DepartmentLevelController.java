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
import com.lqs.hrm.entity.DepartmentLevel;
import com.lqs.hrm.entity.Employee;
import com.lqs.hrm.json.JsonCommonResult;
import com.lqs.hrm.json.JsonPageResult;
import com.lqs.hrm.service.impl.DepartmentLevelServiceImpl;
import com.lqs.hrm.service.impl.DepartmentServiceImpl;
import com.lqs.hrm.service.impl.EmployeeServiceImpl;
import com.lqs.hrm.service.impl.StatusServiceImpl;
import com.lqs.hrm.service.impl.UserServiceImpl;
import com.lqs.hrm.util.PageRequest;
import com.lqs.hrm.util.PageResult;
import com.lqs.hrm.util.PageResultUtil;

@Controller
@RequestMapping("departmentLevel")
public class DepartmentLevelController {
	@Autowired
	private DepartmentServiceImpl departmentService;
	@Autowired
	private DepartmentLevelServiceImpl departmentLevelService;
	@Autowired
	private EmployeeServiceImpl employeeService;
	
	/**
	 * 查询部门并跳转至部门架构管理页面
	 * @param request
	 * @param pageRequest
	 * @param map
	 * @return
	 */
	@RequestMapping("departmentStructureManage.do")
	public String departmentStructureManage(HttpServletRequest request, PageRequest pageRequest, ModelMap map){
		//所有部门级别信息
		List<DepartmentLevel> departmentLevelList = departmentLevelService.list();
		//返回查询的所有部门级别信息
		map.put("departmentLevelList", departmentLevelList);
		//查询一级部门的部门级别信息
		DepartmentLevel departmentLevel = departmentLevelService.getByLevel(1);
		//返回所有一级部门信息
		List<Department> firstDepartmentList = departmentService.listByDlId(departmentLevel.getDlId());
		//返回所有一级部门信息
		map.put("firstDepartmentList", firstDepartmentList);
		return "department/departmentStructureManage";
	}
	
	/**
	 * 查询部门级别并跳转至级别架构管理页面
	 * @param request
	 * @param pageRequest
	 * @param map
	 * @return
	 */
	@RequestMapping("levelStructureManage.do")
	public String levelStructureManage(HttpServletRequest request, PageRequest pageRequest, ModelMap map){
		//所有部门级别信息
		List<DepartmentLevel> departmentLevelList = departmentLevelService.list();
		setDepartmentLevelInfo(departmentLevelList);
		PageResult pageResult = PageResultUtil.getPageResult(new PageInfo<>(departmentLevelList));
		//返回查询的部门级别信息
		map.put("pageResult", pageResult);
		return "department/levelStructureManage";
	}
	
	/**
	 * 设置查询出来的部门级别实体类信息
	 * @param departmentList
	 */
	public void setDepartmentLevelInfo(List<DepartmentLevel> list) {
		if (list.size() != 0 || list != null) {
			for (int i = 0; i < list.size(); i++) {
				//设置操作人名称
				if(list.get(i).getOperatorEmpjobid() != null && !list.get(i).getOperatorEmpjobid().isEmpty()) {
					list.get(i).setOperatorEmpName(employeeService.get(list.get(i).getOperatorEmpjobid()).getEmpName());
				}
			}
		}
	}
	
	/**
	 * 返回所有部门级别信息
	 * @return
	 */
	@RequestMapping("list.do")
	@ResponseBody
	public JsonCommonResult<List<DepartmentLevel>> list(){
		//查询部门级别信息
		List<DepartmentLevel> list = departmentLevelService.list();
		if (list.size() == 0 ||list == null) {
			return new JsonCommonResult<>("100", null, "没有数据！");
		}
		return new JsonCommonResult<List<DepartmentLevel>>("200", list, "请求成功");
	}

	/**
	 * 添加部门级别信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("add.do")
	@ResponseBody
	public JsonCommonResult<Object> add(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> resultMap = new HashMap<>();
		//获取级别值
		String levelStr = request.getParameter("level");
		//获取级别描述
		String levelDescStr = request.getParameter("levelDesc");
		//获取备注
		String levelNoteStr = request.getParameter("levelNote");
		if (!StringUtil.isEmpty(parentDeptNameStr)) {
			Department parentDepartment = departmentService.listByDeptName(parentDeptNameStr).get(0);
			parentId = parentDepartment.getDeptId();
			System.out.println("获取到上级部门id:"+parentId);
		}
		return new JsonCommonResult<>();
	}
	
}

