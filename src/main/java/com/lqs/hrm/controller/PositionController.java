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
import com.lqs.hrm.entity.Position;
import com.lqs.hrm.entity.PositionLevel;
import com.lqs.hrm.entity.Status;
import com.lqs.hrm.entity.User;
import com.lqs.hrm.json.JsonCommonResult;
import com.lqs.hrm.json.JsonPageResult;
import com.lqs.hrm.service.impl.DepartmentLevelServiceImpl;
import com.lqs.hrm.service.impl.DepartmentServiceImpl;
import com.lqs.hrm.service.impl.EmployeeDepartmentServiceImpl;
import com.lqs.hrm.service.impl.EmployeeServiceImpl;
import com.lqs.hrm.service.impl.PositionLevelServiceImpl;
import com.lqs.hrm.service.impl.PositionServiceImpl;
import com.lqs.hrm.service.impl.StatusServiceImpl;
import com.lqs.hrm.util.PageRequest;
import com.lqs.hrm.util.PageResult;
import com.lqs.hrm.util.PageResultUtil;

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
			positionList.add(position);
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
		setPositionInfo(positionList);
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
		return "/department/positionList";
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
					positionList.add(position);
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
		setPositionInfo(positionList);
		return new JsonPageResult("200", PageResultUtil.getPageResult(new PageInfo<>(positionList)), "请求成功！");
	}
	
	/**
	 * 设置查询出来的职位实体类信息
	 * @param departmentList
	 */
	public void setPositionInfo(List<Position> list) {
		for (int i = 0; i < list.size(); i++) {
			//设置职位级别
			list.get(i).setPlLeve(positionLevelService.get(list.get(i).getPlId()).getLevel());
			//设置职位上级职位名称
			if(list.get(i).getParentPositionid() != 0) {
				list.get(i).setParentPositionName(positionService.get(list.get(i).getParentPositionid()).getPositionName());
			}
			//设置职位所属部门名称
			if (list.get(i).getDeptId() != null) {
				list.get(i).setDeptName(departmentService.get(list.get(i).getDeptId()).getDeptName());
			} 
			//设置职位状态名称
			list.get(i).setStatusName(statusService.get(list.get(i).getStatusId()).getStatusName());
			//设置操作人名称
			if(list.get(i).getOperatorEmpjobid() != null && !list.get(i).getOperatorEmpjobid().isEmpty()) {
				list.get(i).setOperatorEmpName(employeeService.get(list.get(i).getOperatorEmpjobid()).getEmpName());
			}
		}
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
		int result2 = 0;
		if (result1 == 0 || result2 == 0) {
			return new JsonCommonResult<Object>("100", null, "添加失败");
		}
		return new JsonCommonResult<Object>("200", null, "添加成功");
	}
	
	
}

