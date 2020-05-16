package com.lqs.hrm.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.lqs.hrm.entity.User;
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
		//部门级别信息
		List<DepartmentLevel> departmentLevelList = departmentLevelService.list();
		//返回查询的部门级别信息
		map.put("departmentLevelList", departmentLevelList);
		
//		//查询所有一级部门信息
//		DepartmentLevel departmentLevel = departmentLevelService.getByLevel(1);
//		//返回所有一级部门信息
//		List<Department> firstDepartmentList = departmentService.listByDlId(departmentLevel.getDlId());
//		//返回所有一级部门信息
//		map.put("firstDepartmentList", firstDepartmentList);
		return "/department/departmentStructureManage";
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
		//分页
		PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
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
	 * 查询指定id的部门级别信息
	 * @param request
	 * @return
	 */
	@RequestMapping("get.do")
	@ResponseBody
	public JsonCommonResult<DepartmentLevel> get(HttpServletRequest request) {
		//部门级别id
		String dlIdStr = request.getParameter("dlId");
		DepartmentLevel departmentLevel = departmentLevelService.get(Integer.valueOf(dlIdStr));
		if(departmentLevel == null) {
			return new JsonCommonResult<DepartmentLevel>("100",null, "请求失败！");
		}
		return new JsonCommonResult<DepartmentLevel>("200",departmentLevel, "请求成功！");
	}
	
	/**
	 * 添加部门级别信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("add.do")
	@ResponseBody
	public JsonCommonResult<Object> add(HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<>();
		//获取级别值
		String levelStr = request.getParameter("level");
		//获取级别描述
		String levelDescStr = request.getParameter("levelDesc");
		//获取备注
		String levelNoteStr = request.getParameter("levelNote");
		DepartmentLevel departmentLevel = new DepartmentLevel();
		departmentLevel.setLevel(Integer.valueOf(levelStr));
		departmentLevel.setLevelDesc(levelDescStr);
		departmentLevel.setLevelNote(levelNoteStr);
		//设置最后一次操作时间
		departmentLevel.setLastOperatorDate(new Date());
		//设置操作人工号
		//获取当前登录系统人工号
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("session_loginUser");
		if (user == null) {
			return new JsonCommonResult<Object>("100", null, "请先登录！");
		}
		//设置工号
		departmentLevel.setOperatorEmpjobid(user.getUserAccount());
		int result = departmentLevelService.add(departmentLevel);
		if (result == 0) {
			return new JsonCommonResult<>("100", null, "添加失败");
		}
		return new JsonCommonResult<>("200", null, "添加成功");
	}
	
	/**
	 * 添加部门级别信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("update.do")
	@ResponseBody
	public JsonCommonResult<Object> update(HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<>();
		//获取级别Id 
		String dlIdStr = request.getParameter("dlId");
		//获取级别值
		String levelStr = request.getParameter("level");
		//获取级别描述
		String levelDescStr = request.getParameter("levelDesc");
		//获取备注
		String levelNoteStr = request.getParameter("levelNote");
		
		DepartmentLevel departmentLevel = departmentLevelService.get(Integer.valueOf(dlIdStr));
		departmentLevel.setLevel(Integer.valueOf(levelStr));
		departmentLevel.setLevelDesc(levelDescStr);
		departmentLevel.setLevelNote(levelNoteStr);
		//设置最后一次操作时间
		departmentLevel.setLastOperatorDate(new Date());
		//设置操作人工号
		//获取当前登录系统人工号
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("session_loginUser");
		if (user == null) {
			return new JsonCommonResult<Object>("100", null, "请先登录！");
		}
		//设置工号
		departmentLevel.setOperatorEmpjobid(user.getUserAccount());
		int result = departmentLevelService.update(departmentLevel);
		if (result == 0) {
			return new JsonCommonResult<>("100", null, "修改失败");
		}
		return new JsonCommonResult<>("200", null, "修改成功");
	}
	
	/**
	 * 删除指定id的部门级别信息
	 * @param request
	 * @return
	 */
	@RequestMapping("delete.do")
	@ResponseBody
	public JsonCommonResult<Object> delete(HttpServletRequest request) {
		//获取级别Id 
		String dlIdStr = request.getParameter("dlId");		
		int result = departmentLevelService.delete(Integer.valueOf(dlIdStr));
		if (result == 0) {
			return new JsonCommonResult<>("100", null, "删除失败");
		}
		return new JsonCommonResult<>("200", null, "删除成功");
	}
	
}

