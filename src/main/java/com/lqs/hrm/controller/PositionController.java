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
import com.lqs.hrm.entity.EmployeePosition;
import com.lqs.hrm.entity.Position;
import com.lqs.hrm.entity.PositionLevel;
import com.lqs.hrm.entity.Status;
import com.lqs.hrm.entity.User;
import com.lqs.hrm.json.JsonCommonResult;
import com.lqs.hrm.json.JsonPageResult;
import com.lqs.hrm.service.impl.DepartmentLevelServiceImpl;
import com.lqs.hrm.service.impl.DepartmentServiceImpl;
import com.lqs.hrm.service.impl.EmployeePositionServiceImpl;
import com.lqs.hrm.service.impl.EmployeeServiceImpl;
import com.lqs.hrm.service.impl.PositionLevelServiceImpl;
import com.lqs.hrm.service.impl.PositionServiceImpl;
import com.lqs.hrm.service.impl.StatusServiceImpl;
import com.lqs.hrm.service.impl.UserServiceImpl;
import com.lqs.hrm.util.PageRequest;
import com.lqs.hrm.util.PageResult;
import com.lqs.hrm.util.PageResultUtil;
import com.lqs.hrm.util.entity.PositionInfoUtil;

/**
 * 职位Controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("position")
public class PositionController {
	@Autowired
	private PositionServiceImpl positionService;
	@Autowired
	private PositionLevelServiceImpl positionLevelService;
	@Autowired
	private StatusServiceImpl statusService;
	@Autowired
	private DepartmentServiceImpl departmentService;
	@Autowired
	private EmployeeServiceImpl employeeService;
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private EmployeePositionServiceImpl employeePositionService;
	@Autowired
	private PositionInfoUtil positionInfoUtil;
	
	/**
	 * 查询职位信息并跳转至职位详情页面
	 * @param request
	 * @param pageRequest
	 * @param map
	 * @return
	 */
	@RequestMapping("positionList.do")
	public String positionList(HttpServletRequest request, PageRequest pageRequest, ModelMap map){
		//查询条件信息
		String positionIdStr = request.getParameter("positionId");
		String positionNameStr = request.getParameter("positionName");
		String deptNameStr = request.getParameter("deptName");
		String plIdStr = request.getParameter("plId");
		//分页
		PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
		List<Position> positionList = new ArrayList<>();
		//查询条件判断
		if (StringUtil.isEmpty(positionIdStr) && StringUtil.isEmpty(positionNameStr) && StringUtil.isEmpty(deptNameStr) && StringUtil.isEmpty(plIdStr)) {
			//如果查询的条件全部为空，则查询出所有职位信息
			positionList = positionService.listByNo();
		}else if(StringUtil.isEmpty(positionNameStr) && StringUtil.isEmpty(deptNameStr) && StringUtil.isEmpty(plIdStr)) {
			//则根据职位id查询
			Position position = positionService.get(Integer.valueOf(positionIdStr));
			if (position != null) {
				positionList.add(position);
			}
		}else if(StringUtil.isEmpty(positionIdStr) && StringUtil.isEmpty(deptNameStr) && StringUtil.isEmpty(plIdStr)){
			//则根据职位名称查询
			positionList = positionService.listByPositionName(positionNameStr);
		}else if(StringUtil.isEmpty(positionIdStr) && StringUtil.isEmpty(positionNameStr) && StringUtil.isEmpty(plIdStr)) {
			//根据部门名称查询，查询某个部门下所有的职位
			//查询指定部门名称的部门信息
			List<Department> departmentList = departmentService.listByDeptName(deptNameStr);
			//对部门列表进行遍历查询出相应的职位信息
			for (Department department : departmentList) {
				List<Position> positions = positionService.listByDeptId(department.getDeptId());
				for (Position position : positions) {
					positionList.add(position);
				}
			}
		}else if(StringUtil.isEmpty(positionIdStr) && StringUtil.isEmpty(positionNameStr) && StringUtil.isEmpty(deptNameStr)) {
			//根据职位级别查询
			positionList = positionService.listByPlId(Integer.valueOf(plIdStr));
		}else if(StringUtil.isEmpty(deptNameStr) && StringUtil.isEmpty(plIdStr)) {
			//根据职位id，职位名称查询
			positionList = positionService.listByPositionIdName(Integer.valueOf(positionIdStr), positionNameStr);
		}else if(StringUtil.isEmpty(positionNameStr) && StringUtil.isEmpty(plIdStr)) {
			//根据职位id，部门名称查询
			//查询指定部门名称的部门信息
			List<Department> departmentList = departmentService.listByDeptName(deptNameStr);
			//对部门列表进行遍历查询出相应的职位信息
			for (Department department : departmentList) {
				List<Position> positions = positionService.listByPositionIdDeptId(Integer.valueOf(positionIdStr), department.getDeptId());
				for (Position position : positions) {
					positionList.add(position);
				}
			}
		}else if(StringUtil.isEmpty(positionNameStr) && StringUtil.isEmpty(deptNameStr)) {
			//根据职位id，职位级别查询
			positionList = positionService.listByPositionIdPlId(Integer.valueOf(positionIdStr), Integer.valueOf(plIdStr));
		}else if(StringUtil.isEmpty(positionIdStr) && StringUtil.isEmpty(plIdStr)) {
			//根据职位名称，部门名称查询
			//查询指定部门名称的部门信息
			List<Department> departmentList = departmentService.listByDeptName(deptNameStr);
			//对部门列表进行遍历查询出相应的职位信息
			for (Department department : departmentList) {
				List<Position> positions = positionService.listByPositionNameDeptId(positionNameStr, department.getDeptId());
				for (Position position : positions) {
					positionList.add(position);
				}
			}
		}else if(StringUtil.isEmpty(positionIdStr) && StringUtil.isEmpty(deptNameStr)) {
			//根据职位名称，职位级别查询
			positionList = positionService.listByPositionNamePlId(positionNameStr, Integer.valueOf(plIdStr));
		}else if(StringUtil.isEmpty(positionIdStr) && StringUtil.isEmpty(positionNameStr)) {
			//根据部门名称，职位级别查询
			//查询指定部门名称的部门信息
			List<Department> departmentList = departmentService.listByDeptName(deptNameStr);
			//对部门列表进行遍历查询出相应的职位信息
			for (Department department : departmentList) {
				List<Position> positions = positionService.listByDeptIdPlId(department.getDeptId(), Integer.valueOf(plIdStr));
				for (Position position : positions) {
					positionList.add(position);
				}
			}
		}else if(StringUtil.isEmpty(plIdStr)) {
			//根据职位id，职位名称，部门名称查询
			//查询指定部门名称的部门信息
			List<Department> departmentList = departmentService.listByDeptName(deptNameStr);
			//对部门列表进行遍历查询出相应的职位信息
			for (Department department : departmentList) {
				List<Position> positions = positionService.listByPositionIdNameDeptId(Integer.valueOf(positionIdStr), positionNameStr, department.getDeptId());
				for (Position position : positions) {
					positionList.add(position);
				}
			}
		}else if(StringUtil.isEmpty(deptNameStr)) {
			//根据职位id，职位名称，职位级别查询
			positionList = positionService.listByPositionIdNamePlId(Integer.valueOf(positionIdStr), positionNameStr, Integer.valueOf(plIdStr));
		}else if(StringUtil.isEmpty(positionNameStr)) {
			//根据职位id，部门名称，职位级别查询
			//查询指定部门名称的部门信息
			List<Department> departmentList = departmentService.listByDeptName(deptNameStr);
			//对部门列表进行遍历查询出相应的职位信息
			for (Department department : departmentList) {
				List<Position> positions = positionService.listByPositionIdDeptIdPlId(Integer.valueOf(positionIdStr), department.getDeptId(), Integer.valueOf(plIdStr));
				for (Position position : positions) {
					positionList.add(position);
				}
			}
		}else if(StringUtil.isEmpty(positionIdStr)) {
			//根据职位名称，部门名称，职位级别查询
			//查询指定部门名称的部门信息
			List<Department> departmentList = departmentService.listByDeptName(deptNameStr);
			//对部门列表进行遍历查询出相应的职位信息
			for (Department department : departmentList) {
				List<Position> positions = positionService.listByPositionNameDeptIdPlId(positionNameStr, department.getDeptId(), Integer.valueOf(plIdStr));
				for (Position position : positions) {
					positionList.add(position);
				}
			}
		}else {
			//根据职位id，职位名称，部门名称，职位级别查询
			//查询指定部门名称的部门信息
			List<Department> departmentList = departmentService.listByDeptName(deptNameStr);
			//对部门列表进行遍历查询出相应的职位信息
			for (Department department : departmentList) {
				List<Position> positions = positionService.listByAll(Integer.valueOf(positionIdStr), positionNameStr, department.getDeptId(), Integer.valueOf(plIdStr));
				for (Position position : positions) {
					positionList.add(position);
				}
			}
		}
		positionInfoUtil.setPositionInfo(positionList);
		PageResult pageResult = PageResultUtil.getPageResult(new PageInfo<>(positionList));
		//返回查询的部门信息
		map.put("pageResult", pageResult);
		//回显查询条件
		map.put("positionIdStr", positionIdStr);
		map.put("dpositionNameStr", positionNameStr);
		map.put("deptNameStr", deptNameStr);
		map.put("plIdStr", plIdStr);
		
		//职位级别信息
		List<PositionLevel> positionLevelList = positionLevelService.list();
		//返回查询的职位级别信息
		map.put("positionLevelList", positionLevelList);
		return "department/positionManage";
	}
	
	/**
	 * 返回查询的指定部门信息
	 * @param request
	 * @param pageRequest
	 * @return
	 */
	@RequestMapping("query.do")
	@ResponseBody
	public JsonPageResult list(HttpServletRequest request, PageRequest pageRequest) {
		//查询条件信息
		String positionIdStr = request.getParameter("positionId");
		String positionNameStr = request.getParameter("positionName");
		String deptNameStr = request.getParameter("deptName");
		String plIdStr = request.getParameter("plId");
		//分页
		PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
		List<Position> positionList = new ArrayList<>();
		//查询条件判断
		if (StringUtil.isEmpty(positionIdStr) && StringUtil.isEmpty(positionNameStr) && StringUtil.isEmpty(deptNameStr) && StringUtil.isEmpty(plIdStr)) {
			//如果查询的条件全部为空，则查询出所有职位信息
			positionList = positionService.listByNo();
		}else if(StringUtil.isEmpty(positionNameStr) && StringUtil.isEmpty(deptNameStr) && StringUtil.isEmpty(plIdStr)) {
			//则根据职位id查询
			Position position = positionService.get(Integer.valueOf(positionIdStr));
			if (position != null) {
				positionList.add(position);
			}
		}else if(StringUtil.isEmpty(positionIdStr) && StringUtil.isEmpty(deptNameStr) && StringUtil.isEmpty(plIdStr)){
			//则根据职位名称查询
			positionList = positionService.listByPositionName(positionNameStr);
		}else if(StringUtil.isEmpty(positionIdStr) && StringUtil.isEmpty(positionNameStr) && StringUtil.isEmpty(plIdStr)) {
			//根据部门名称查询，查询某个部门下所有的职位
			//查询指定部门名称的部门信息
			List<Department> departmentList = departmentService.listByDeptName(deptNameStr);
			//对部门列表进行遍历查询出相应的职位信息
			for (Department department : departmentList) {
				List<Position> positions = positionService.listByDeptId(department.getDeptId());
				for (Position position : positions) {
					positionList.add(position);
				}
			}
		}else if(StringUtil.isEmpty(positionIdStr) && StringUtil.isEmpty(positionNameStr) && StringUtil.isEmpty(deptNameStr)) {
			//根据职位级别查询
			positionList = positionService.listByPlId(Integer.valueOf(plIdStr));
		}else if(StringUtil.isEmpty(deptNameStr) && StringUtil.isEmpty(plIdStr)) {
			//根据职位id，职位名称查询
			positionList = positionService.listByPositionIdName(Integer.valueOf(positionIdStr), positionNameStr);
		}else if(StringUtil.isEmpty(positionNameStr) && StringUtil.isEmpty(plIdStr)) {
			//根据职位id，部门名称查询
			//查询指定部门名称的部门信息
			List<Department> departmentList = departmentService.listByDeptName(deptNameStr);
			//对部门列表进行遍历查询出相应的职位信息
			for (Department department : departmentList) {
				List<Position> positions = positionService.listByPositionIdDeptId(Integer.valueOf(positionIdStr), department.getDeptId());
				for (Position position : positions) {
					positionList.add(position);
				}
			}
		}else if(StringUtil.isEmpty(positionNameStr) && StringUtil.isEmpty(deptNameStr)) {
			//根据职位id，职位级别查询
			positionList = positionService.listByPositionIdPlId(Integer.valueOf(positionIdStr), Integer.valueOf(plIdStr));
		}else if(StringUtil.isEmpty(positionIdStr) && StringUtil.isEmpty(plIdStr)) {
			//根据职位名称，部门名称查询
			//查询指定部门名称的部门信息
			List<Department> departmentList = departmentService.listByDeptName(deptNameStr);
			//对部门列表进行遍历查询出相应的职位信息
			for (Department department : departmentList) {
				List<Position> positions = positionService.listByPositionNameDeptId(positionNameStr, department.getDeptId());
				for (Position position : positions) {
					positionList.add(position);
				}
			}
		}else if(StringUtil.isEmpty(positionIdStr) && StringUtil.isEmpty(deptNameStr)) {
			//根据职位名称，职位级别查询
			positionList = positionService.listByPositionNamePlId(positionNameStr, Integer.valueOf(plIdStr));
		}else if(StringUtil.isEmpty(positionIdStr) && StringUtil.isEmpty(positionNameStr)) {
			//根据部门名称，职位级别查询
			//查询指定部门名称的部门信息
			List<Department> departmentList = departmentService.listByDeptName(deptNameStr);
			//对部门列表进行遍历查询出相应的职位信息
			for (Department department : departmentList) {
				List<Position> positions = positionService.listByDeptIdPlId(department.getDeptId(), Integer.valueOf(plIdStr));
				for (Position position : positions) {
					positionList.add(position);
				}
			}
		}else if(StringUtil.isEmpty(plIdStr)) {
			//根据职位id，职位名称，部门名称查询
			//查询指定部门名称的部门信息
			List<Department> departmentList = departmentService.listByDeptName(deptNameStr);
			//对部门列表进行遍历查询出相应的职位信息
			for (Department department : departmentList) {
				List<Position> positions = positionService.listByPositionIdNameDeptId(Integer.valueOf(positionIdStr), positionNameStr, department.getDeptId());
				for (Position position : positions) {
					positionList.add(position);
				}
			}
		}else if(StringUtil.isEmpty(deptNameStr)) {
			//根据职位id，职位名称，职位级别查询
			positionList = positionService.listByPositionIdNamePlId(Integer.valueOf(positionIdStr), positionNameStr, Integer.valueOf(plIdStr));
		}else if(StringUtil.isEmpty(positionNameStr)) {
			//根据职位id，部门名称，职位级别查询
			//查询指定部门名称的部门信息
			List<Department> departmentList = departmentService.listByDeptName(deptNameStr);
			//对部门列表进行遍历查询出相应的职位信息
			for (Department department : departmentList) {
				List<Position> positions = positionService.listByPositionIdDeptIdPlId(Integer.valueOf(positionIdStr), department.getDeptId(), Integer.valueOf(plIdStr));
				for (Position position : positions) {
					positionList.add(position);
				}
			}
		}else if(StringUtil.isEmpty(positionIdStr)) {
			//根据职位名称，部门名称，职位级别查询
			//查询指定部门名称的部门信息
			List<Department> departmentList = departmentService.listByDeptName(deptNameStr);
			//对部门列表进行遍历查询出相应的职位信息
			for (Department department : departmentList) {
				List<Position> positions = positionService.listByPositionNameDeptIdPlId(positionNameStr, department.getDeptId(), Integer.valueOf(plIdStr));
				for (Position position : positions) {
					positionList.add(position);
				}
			}
		}else {
			//根据职位id，职位名称，部门名称，职位级别查询
			//查询指定部门名称的部门信息
			List<Department> departmentList = departmentService.listByDeptName(deptNameStr);
			//对部门列表进行遍历查询出相应的职位信息
			for (Department department : departmentList) {
				List<Position> positions = positionService.listByAll(Integer.valueOf(positionIdStr), positionNameStr, department.getDeptId(), Integer.valueOf(plIdStr));
				for (Position position : positions) {
					positionList.add(position);
				}
			}
		}
		if (positionList == null) {
			return new JsonPageResult("100", null, "没有数据！");
		}
		positionInfoUtil.setPositionInfo(positionList);
		return new JsonPageResult("200", PageResultUtil.getPageResult(new PageInfo<>(positionList)), "请求成功！");
	}
	
	/**
	 * 模糊查询、返回查询的指定部门信息
	 * 根据部门名称模糊查询
	 * @param request
	 * @param pageRequest
	 * @return
	 */
	@RequestMapping("queryLikePositionName.do")
	@ResponseBody
	public JsonCommonResult<List<Position>> queryLikePositionName(HttpServletRequest request, PageRequest pageRequest) {
		//查询条件信息
		String positionNameStr = request.getParameter("positionName");
		//分页
		//PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
		List<Position> positionList = new ArrayList<>();
		//查询条件判断
		if (StringUtil.isEmpty(positionNameStr)) {
			//如果查询的条件全部为空，则查询出所有部门信息
			positionList = positionService.listByNo();
		}else {
			//根据部门名称模糊查询
			positionList = positionService.listByPositionName(positionNameStr);
		}
		if (positionList == null || positionList.size() == 0) {
			return new JsonCommonResult<List<Position>>("100", null, "没有数据！");
		}
		positionInfoUtil.setPositionInfo(positionList);
		return new JsonCommonResult<List<Position>>("200",positionList, "请求成功！");
	}
	
	/**
	 * 查询指定id的职位信息
	 * @param request
	 * @return
	 */
	@RequestMapping("get.do")
	@ResponseBody
	public JsonCommonResult<Position> get(HttpServletRequest request) {
		//职位id
		String positionIdStr = request.getParameter("positionId");
		Position position = positionService.get(Integer.valueOf(positionIdStr));
		positionInfoUtil.setPositionInfo(position);
		if(position == null) {
			return new JsonCommonResult<Position>("100",null, "请求失败！");
		}
		return new JsonCommonResult<Position>("200",position, "请求成功！");
	}
	
	/**
	 * 添加职位信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("add.do")
	@ResponseBody
	public JsonCommonResult<Object> add(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> resultMap = new HashMap<>();
		//获取职位名称
		String positionNameStr = request.getParameter("positionName");
		//获取职位级别id
		String plIdStr = request.getParameter("plId");
		//获取职位所属部门id
		String deptIdStr = request.getParameter("deptId");
		//职位是否唯一
		Boolean isOnly = false;
		if (StringUtil.isNotEmpty(request.getParameter("isOnly"))) {
			//System.out.println("职位不唯一："+request.getParameter("isOnly"));
			isOnly = true;
		}
		//获取上级职位名称
		String parentPositionIdStr = request.getParameter("parentPositionid");
		//获取职位状态id
		String statusIdStr = request.getParameter("statusId");
		//获取职位描述
		String positionDescStr = request.getParameter("positionDesc");
		
		Position position = new Position();
		//设置职位名称
		position.setPositionName(positionNameStr);
		//设置职位描述
		position.setPositionDesc(positionDescStr);
		//设置职位级别id
		position.setPlId(Integer.valueOf(plIdStr));
		//设置职位所属部门id
		position.setDeptId(Integer.valueOf(deptIdStr));
		//设置职位是否唯一
		position.setIsOnly(isOnly);
		if (StringUtil.isNotEmpty(parentPositionIdStr)) {
			//设置上级职位id
			position.setParentPositionid(Integer.valueOf(parentPositionIdStr));
		}
		//设置职位状态id
		position.setStatusId(Integer.valueOf(statusIdStr));
		//设置最后一次操作时间
		position.setLastOperatorDate(new Date());
		//设置操作人工号
		//获取当前登录系统人工号
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("session_loginUser");
		if (user == null) {
			return new JsonCommonResult<Object>("100", null, "请先登录！");
		}
		//设置工号
		position.setOperatorEmpjobid(user.getUserAccount());
		//添加职位部门信息
		int result = positionService.insert(position);
		if (result == 0) {
			return new JsonCommonResult<Object>("100", null, "添加失败");
		}
		return new JsonCommonResult<Object>("200", null, "添加成功");
	}
	
	/**
	 * 查询职位信息，并跳转至职位详情页面
	 * 1.根据职工工号查询
	 * 2.根据职位id查询
	 * @param request
	 * @param pageRequest
	 * @param map
	 * @return
	 */
	@RequestMapping("toPositionDetail.do")
	public String toPositionDetail(HttpServletRequest request, PageRequest pageRequest, ModelMap map){
		String empJobIdStr = request.getParameter("empJobId");
		String positionIdStr = request.getParameter("positionId");
		List<Position> positionList = new ArrayList<>();
		if (StringUtil.isEmpty(empJobIdStr)) {
			//根据职位ID查询
			Position position = positionService.get(Integer.valueOf(positionIdStr));
			if (position != null) {
				positionList.add(position);
			}
		}else if(StringUtil.isEmpty(positionIdStr)) {
			//根据职工工号查询
			//查询该职工所属的职位信息
			List<EmployeePosition> employeePositionList = employeePositionService.listByEmpJobId(empJobIdStr);
			for (EmployeePosition employeePosition : employeePositionList) {
				//找到对应的职位
				Position position = positionService.get(employeePosition.getPositionId());
				if (position != null) {
					positionList.add(position);
				}
			}
		}else {
			//根据职工工号，职位id查询
			//查询该职工所属的职位信息
			List<EmployeePosition> employeePositionList = employeePositionService.listByEmpJobId(empJobIdStr);
			for (EmployeePosition employeePosition : employeePositionList) {
				//找到对应的职位
				Position position = positionService.get(employeePosition.getPositionId());
				if (position != null && position.getPositionId() == Integer.valueOf(positionIdStr)) {
					positionList.add(position);
				}
			}
		}
		//查询该
		if (positionList != null) {
			positionInfoUtil.setPositionInfo(positionList);
		}
		//回显查询条件
		map.put("positionList", positionList);
		return "department/positionDetail";
	}
	
	/**
	 * 查询职位信息，并跳转至登录系统职工的职位详情页面
	 * 1.根据职工工号查询
	 * 2.根据职位id查询
	 * @param request
	 * @param pageRequest
	 * @param map
	 * @return
	 */
	@RequestMapping("toMyPositionDetail.do")
	public String toMyPositionDetail(HttpServletRequest request, PageRequest pageRequest, ModelMap map){
		//获取当前登录系统人工号
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("session_loginUser");
		List<Position> positionList = new ArrayList<>();
		//根据职工工号查询
		//查询该职工所属的职位信息
		List<EmployeePosition> employeePositionList = employeePositionService.listByEmpJobId(user.getUserAccount());
		for (EmployeePosition employeePosition : employeePositionList) {
			//找到对应的职位
			Position position = positionService.get(employeePosition.getPositionId());
			if (position != null) {
				positionList.add(position);
			}
		}
		if (positionList != null) {
			positionInfoUtil.setPositionInfo(positionList);
		}
		//回显查询条件
		map.put("positionList", positionList);
		return "department/myPositionDetail";
	}
	
	/**
	 * 删除指定id的职位信息
	 * @param request
	 * @return
	 */
	@RequestMapping("delete.do")
	@ResponseBody
	public JsonCommonResult<Object> delete(HttpServletRequest request) {
		//获取部门Id 
		String positionIdStr = request.getParameter("positionId");		
		//检查该职位下面是否还有职工信息
		List<EmployeePosition> employeePositionList = employeePositionService.listByPositionId(Integer.valueOf(positionIdStr));
		if (employeePositionList != null && employeePositionList.size() != 0) {
			//该职位下面还有职工信息，不能删除
			return new JsonCommonResult<>("100", null, "该职位下面还有职工信息，不能删除！");
		}
		int result = positionService.delte(Integer.valueOf(positionIdStr));
		if (result == 0) {
			return new JsonCommonResult<>("100", null, "删除失败");
		}
		return new JsonCommonResult<>("200", null, "删除成功");
	}
	
	/**
	 * 修改职位信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("update.do")
	@ResponseBody
	public JsonCommonResult<Object> update(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> resultMap = new HashMap<>();
		//获取职位id
		String positionIdStr = request.getParameter("positionId");
		//获取职位名称
				String positionNameStr = request.getParameter("positionName");
				//获取职位级别id
				String plIdStr = request.getParameter("plId");
				//获取职位所属部门id
				String deptIdStr = request.getParameter("deptId");
				//职位是否唯一
				Boolean isOnly = false;
				if (StringUtil.isNotEmpty(request.getParameter("isOnly"))) {
					System.out.println("职位不唯一："+request.getParameter("isOnly"));
					isOnly = true;
				}
				//获取上级职位名称
				String parentPositionIdStr = request.getParameter("parentPositionid");
				//获取职位状态id
				String statusIdStr = request.getParameter("statusId");
				//获取职位描述
				String positionDescStr = request.getParameter("positionDesc");
				
				Position position = positionService.get(Integer.valueOf(positionIdStr));
				//设置职位名称
				position.setPositionName(positionNameStr);
				//设置职位描述
				position.setPositionDesc(positionDescStr);
				//设置职位级别id
				position.setPlId(Integer.valueOf(plIdStr));
				//设置职位所属部门id
				position.setDeptId(Integer.valueOf(deptIdStr));
				//设置职位是否唯一
				position.setIsOnly(isOnly);
				if (StringUtil.isNotEmpty(parentPositionIdStr)) {
					//设置上级职位id
					position.setParentPositionid(Integer.valueOf(parentPositionIdStr));
				}
				//设置职位状态id
				position.setStatusId(Integer.valueOf(statusIdStr));
				//设置最后一次操作时间
				position.setLastOperatorDate(new Date());
				//设置操作人工号
				//获取当前登录系统人工号
				HttpSession session = request.getSession();
				User user = (User) session.getAttribute("session_loginUser");
				if (user == null) {
					return new JsonCommonResult<Object>("100", null, "请先登录！");
				}
				//设置工号
				position.setOperatorEmpjobid(user.getUserAccount());
				//修改职位信息
				int result = positionService.update(position);
				if (result == 0) {
					return new JsonCommonResult<Object>("100", null, "修改失败");
				}
				return new JsonCommonResult<Object>("200", null, "修改成功");
	}
	
	
}

