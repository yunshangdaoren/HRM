package com.lqs.hrm.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.buf.StringUtils;
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
import com.lqs.hrm.entity.EmployeePosition;
import com.lqs.hrm.entity.User;
import com.lqs.hrm.json.JsonCommonResult;
import com.lqs.hrm.json.JsonPageResult;
import com.lqs.hrm.service.impl.DepartmentLevelServiceImpl;
import com.lqs.hrm.service.impl.DepartmentServiceImpl;
import com.lqs.hrm.service.impl.EmployeePositionServiceImpl;
import com.lqs.hrm.service.impl.EmployeeServiceImpl;
import com.lqs.hrm.service.impl.PositionServiceImpl;
import com.lqs.hrm.service.impl.StatusServiceImpl;
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
	@Autowired
	private StatusServiceImpl statusService;
	@Autowired
	private EmployeePositionServiceImpl employeePositionService;
	@Autowired
	private PositionServiceImpl positionService;
	
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
		Enumeration<String> enumeration = request.getParameterNames();
		//上级部门id
		int parentDeptId = 0;
		//上级部门列表
		
		while (enumeration.hasMoreElements()) {
			String parameterStr = (String) enumeration.nextElement();
			parentDeptId = Integer.valueOf(request.getParameter(parameterStr));
		}
		List<Department> departmentList = new ArrayList<>();
		//分页
		PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
		if (parentDeptId == 0) {
			departmentList = departmentService.listByNo();
		}else {
			departmentList = departmentService.listByParentId(parentDeptId);
		}
		//设置查询出来的部门信息
		setDeptInfo(departmentList);
		//设置分页查询结果
		PageResult pageResult = PageResultUtil.getPageResult(new PageInfo<>(departmentList));
		//返回查询的部门信息
		map.put("pageResult", pageResult);
		return "/department/departmentStructureManage";
	}
	
	
	@RequestMapping("query.do")
	@ResponseBody
	public JsonPageResult query(HttpServletRequest request, PageRequest pageRequest) {
		System.out.println("====pageNum:"+pageRequest.getPageNum());
		//部门级别信息
		Enumeration<String> enumeration = request.getParameterNames();
		//上级部门id
		int parentDeptId = 0;
		while (enumeration.hasMoreElements()) {
			String parameterStr = (String) enumeration.nextElement();
			System.out.println("====:"+parameterStr);
			if (!com.lqs.hrm.util.StringUtil.isEquqls(parameterStr, "pageNum")) {
				parentDeptId = Integer.valueOf(request.getParameter(parameterStr));
			}
			System.out.println("====deptId:"+parentDeptId);
		}
		List<Department> departmentList = new ArrayList<>();
		//分页
		PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
		if (parentDeptId == 0) {
			departmentList = departmentService.listByNo();
		}else {
			departmentList = departmentService.listByParentId(parentDeptId);
		}
		if (departmentList.size()==0 || departmentList == null) {
			return new JsonPageResult("100", null, "无数据！");
		}
		//设置查询出来的部门信息
		setDeptInfo(departmentList);
		PageResult pageResult = PageResultUtil.getPageResult(new PageInfo<>(departmentList));
		return new JsonPageResult("200", PageResultUtil.getPageResult(new PageInfo<>(departmentList)), "请求成功！");
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
	 * 设置查询出来的部门级别实体类信息
	 * @param departmentList
	 */
	public void setDepartmentLevelInfo(DepartmentLevel departmentLevel) {
		if (departmentLevel != null) {
			//设置操作人名称
			if(departmentLevel.getOperatorEmpjobid() != null && !departmentLevel.getOperatorEmpjobid().isEmpty()) {
				departmentLevel.setOperatorEmpName(employeeService.get(departmentLevel.getOperatorEmpjobid()).getEmpName());
			}
		}
	}
	
	/**
	 * 设置查询出来的部门实体类信息
	 * @param departmentList
	 */
	public void setDeptInfo(List<Department> list) {
		if (list.size() != 0 || list != null) {
			for (int i = 0; i < list.size(); i++) {
				//设置部门级别
				list.get(i).setDlLeve(departmentLevelService.get(list.get(i).getDlId()).getLevel());
				//设置部门主管职位名称
				if (list.get(i).getManagePositionid() != null && list.get(i).getManagePositionid().intValue()!= 0) {
					list.get(i).setManagePositionName(positionService.get(list.get(i).getManagePositionid()).getPositionName());
				}
				//设置部门主管人工号和姓名
				if(list.get(i).getManagePositionid() != null && list.get(i).getManagePositionid() != 0) {
					//获取部门主管职位
					List<EmployeePosition> employeePositionList = employeePositionService.listByPositionId(list.get(i).getManagePositionid());
					if (employeePositionList == null || employeePositionList.size() == 0) {
						//该部门主管职位还未分配给职工
						list.get(i).setManageEmpName("");
					}else {
						//该部门主管职位还已分配给职工，则查找该职工信息
						Employee employee = employeeService.get(employeePositionList.get(0).getEmpJobid());
						//设置部门主管人工号和姓名
						list.get(i).setManageEmpJobId(employee.getEmpJobid());
						list.get(i).setManageEmpName(employee.getEmpName());
					}
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
		//设置查询出来的部门级别信息
		setDepartmentLevelInfo(departmentLevel);
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
		//检查该部门级别下面是否还有部门信息
		List<Department> departmentList = departmentService.listByDlId(Integer.valueOf(dlIdStr));
		if (departmentList != null && departmentList.size() != 0) {
			//该部门级别下面还有部门信息，不能删除
			return new JsonCommonResult<>("100", null, "该部门级别下面还有部门信息，不能删除！");
		}
		int result = departmentLevelService.delete(Integer.valueOf(dlIdStr));
		if (result == 0) {
			return new JsonCommonResult<>("100", null, "删除失败");
		}
		return new JsonCommonResult<>("200", null, "删除成功");
	}
	
}

