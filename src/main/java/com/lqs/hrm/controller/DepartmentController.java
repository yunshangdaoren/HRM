package com.lqs.hrm.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.lqs.hrm.entity.Status;
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
import com.lqs.hrm.util.entity.DepartmentInfoUtil;

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
	private EmployeePositionServiceImpl employeePositionService;
	@Autowired
	private PositionServiceImpl positionService;
	@Autowired
	private DepartmentInfoUtil departmentInfoUtil;
	
	/**
	 * 查询部门并跳转至部门列表页面
	 * @param request
	 * @param pageRequest
	 * @param map
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("toDepartmentList.do")
	public String toDepartmentList(HttpServletRequest request, PageRequest pageRequest, ModelMap map) throws ParseException{
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
			//System.out.println("查询条件都为空");
			//如果查询的条件全部为空，则查询出所有部门信息
			departmentList = departmentService.listByNo();
		}else if(StringUtil.isEmpty(deptNameStr) && StringUtil.isEmpty(manageEmpNameStr) && StringUtil.isEmpty(dlIdStr)) {
			//则根据部门id查询
			Department department = departmentService.get(Integer.valueOf(deptIdStr));
			if (department != null) {
				departmentList.add(department);
			}
		}else if(StringUtil.isEmpty(deptIdStr) && StringUtil.isEmpty(manageEmpNameStr) && StringUtil.isEmpty(dlIdStr)){
			//则根据部门名称查询
			departmentList = departmentService.listByDeptName(deptNameStr);
		}else if(StringUtil.isEmpty(deptIdStr) && StringUtil.isEmpty(deptNameStr) && StringUtil.isEmpty(dlIdStr)) {
			//根据部门主管名称查询
			//查询指定职工名称的职工信息
			List<Employee> employeeList = employeeService.listByEmpName(manageEmpNameStr);
			//对职工列表进行遍历查询出相应的职位
			for (Employee employee : employeeList) {
				//获取到职工-部门列表信息
				List<EmployeePosition> employeePositionList = employeePositionService.listByEmpJobId(employee.getEmpJobid());
				//对职工-部门列表信息进行遍历
				for (EmployeePosition employeePosition : employeePositionList) {
					//得到职工职位信息，查询为部门主管的职位信息
					Position position = positionService.get(employeePosition.getPositionId());
					if (position.getIsOnly()) {
						//如果该职位为唯一职位，即部门主管职位（只能分配给一个职工的职位），则找出该职位属于哪个部门
						List<Department> departments = departmentService.listByParentId(position.getPositionId());
						if (departments != null || departments.size() != 0) {
							departmentList.add(departments.get(0));
						}
					}
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
			//对职工列表进行遍历查询出相应的职位
			for (Employee employee : employeeList) {
				//获取到职工-部门列表信息
				List<EmployeePosition> employeePositionList = employeePositionService.listByEmpJobId(employee.getEmpJobid());
				//对职工-部门列表信息进行遍历
				for (EmployeePosition employeePosition : employeePositionList) {
					//得到职工职位信息，查询为部门主管的职位信息
					Position position = positionService.get(employeePosition.getPositionId());
					if (position.getIsOnly()) {
						//如果该职位为唯一职位，即部门主管职位（只能分配给一个职工的职位），则找出该职位属于哪个部门
						List<Department> departments = departmentService.listByParentId(position.getPositionId());
						if (departments != null || departments.size() != 0) {
							if (com.lqs.hrm.util.StringUtil.isEquqls((String.valueOf(departments.get(0).getDeptId())), deptIdStr)) {
								departmentList.add(departments.get(0));
							}
						}
					}
				}
			}
		}else if(StringUtil.isEmpty(deptNameStr) && StringUtil.isEmpty(manageEmpNameStr)) {
			//根据部门id，部门级别查询
			departmentList = departmentService.listByDeptIdDlId(Integer.valueOf(deptIdStr), Integer.valueOf(dlIdStr));
		}else if(StringUtil.isEmpty(deptIdStr) && StringUtil.isEmpty(dlIdStr)) {
			//根据部门名称，部门主管名称查询
			//查询指定职工名称的职工信息
			List<Employee> employeeList = employeeService.listByEmpName(manageEmpNameStr);
			//对职工列表进行遍历查询出相应的职位
			for (Employee employee : employeeList) {
				//获取到职工-部门列表信息
				List<EmployeePosition> employeePositionList = employeePositionService.listByEmpJobId(employee.getEmpJobid());
				//对职工-部门列表信息进行遍历
				for (EmployeePosition employeePosition : employeePositionList) {
					//得到职工职位信息，查询为部门主管的职位信息
					Position position = positionService.get(employeePosition.getPositionId());
					if (position.getIsOnly()) {
						//如果该职位为唯一职位，即部门主管职位（只能分配给一个职工的职位），则找出该职位属于哪个部门
						List<Department> departments = departmentService.listByParentId(position.getPositionId());
						if (departments != null || departments.size() != 0) {
							if (com.lqs.hrm.util.StringUtil.isEquqls((String.valueOf(departments.get(0).getDeptName())), deptNameStr)) {
								departmentList.add(departments.get(0));
							}
						}
					}
				}
			}
		}else if(StringUtil.isEmpty(deptIdStr) && StringUtil.isEmpty(manageEmpNameStr)) {
			//根据部门名称，部门级别查询
			departmentList = departmentService.listByDeptNameDlId(deptNameStr, Integer.valueOf(dlIdStr));
		}else if(StringUtil.isEmpty(deptIdStr) && StringUtil.isEmpty(deptNameStr)) {
			//根据部门主管名称，部门级别查询
			//查询指定职工名称的职工信息
			List<Employee> employeeList = employeeService.listByEmpName(manageEmpNameStr);
			//对职工列表进行遍历查询出相应的职位
			for (Employee employee : employeeList) {
				//获取到职工-部门列表信息
				List<EmployeePosition> employeePositionList = employeePositionService.listByEmpJobId(employee.getEmpJobid());
				//对职工-部门列表信息进行遍历
				for (EmployeePosition employeePosition : employeePositionList) {
					//得到职工职位信息，查询为部门主管的职位信息
					Position position = positionService.get(employeePosition.getPositionId());
					if (position.getIsOnly()) {
						//如果该职位为唯一职位，即部门主管职位（只能分配给一个职工的职位），则找出该职位属于哪个部门
						List<Department> departments = departmentService.listByParentId(position.getPositionId());
						if (departments != null || departments.size() != 0) {
							if (com.lqs.hrm.util.StringUtil.isEquqls((String.valueOf(departments.get(0).getDlId())), dlIdStr)) {
								departmentList.add(departments.get(0));
							}
						}
					}
				}
			}
		}else if(StringUtil.isEmpty(dlIdStr)) {
			//根据部门id，部门名称，部门主管名称查询
			//查询指定职工名称的职工信息
			List<Employee> employeeList = employeeService.listByEmpName(manageEmpNameStr);
			//对职工列表进行遍历查询出相应的职位
			for (Employee employee : employeeList) {
				//获取到职工-部门列表信息
				List<EmployeePosition> employeePositionList = employeePositionService.listByEmpJobId(employee.getEmpJobid());
				//对职工-部门列表信息进行遍历
				for (EmployeePosition employeePosition : employeePositionList) {
					//得到职工职位信息，查询为部门主管的职位信息
					Position position = positionService.get(employeePosition.getPositionId());
					if (position.getIsOnly()) {
						//如果该职位为唯一职位，即部门主管职位（只能分配给一个职工的职位），则找出该职位属于哪个部门
						List<Department> departments = departmentService.listByParentId(position.getPositionId());
						if (departments != null || departments.size() != 0) {
							if (com.lqs.hrm.util.StringUtil.isEquqls((String.valueOf(departments.get(0).getDeptId())), deptIdStr)
									&& com.lqs.hrm.util.StringUtil.isEquqls((String.valueOf(departments.get(0).getDeptName())), deptNameStr)) {
								departmentList.add(departments.get(0));
							}
						}
					}
				}
			}
		}else if(StringUtil.isEmpty(manageEmpNameStr)) {
			//根据部门id，部门名称，部门级别查询
			departmentList = departmentService.listByDeptIdNameDlId(Integer.valueOf(deptIdStr), deptIdStr, Integer.valueOf(dlIdStr));
		}else if(StringUtil.isEmpty(deptNameStr)) {
			//根据部门id，部门主管名称，部门级别查询
			//查询指定职工名称的职工信息
			List<Employee> employeeList = employeeService.listByEmpName(manageEmpNameStr);
			//对职工列表进行遍历查询出相应的职位
			for (Employee employee : employeeList) {
				//获取到职工-部门列表信息
				List<EmployeePosition> employeePositionList = employeePositionService.listByEmpJobId(employee.getEmpJobid());
				//对职工-部门列表信息进行遍历
				for (EmployeePosition employeePosition : employeePositionList) {
					//得到职工职位信息，查询为部门主管的职位信息
					Position position = positionService.get(employeePosition.getPositionId());
					if (position.getIsOnly()) {
						//如果该职位为唯一职位，即部门主管职位（只能分配给一个职工的职位），则找出该职位属于哪个部门
						List<Department> departments = departmentService.listByParentId(position.getPositionId());
						if (departments != null || departments.size() != 0) {
							if (com.lqs.hrm.util.StringUtil.isEquqls((String.valueOf(departments.get(0).getDeptId())), deptIdStr)
									&& com.lqs.hrm.util.StringUtil.isEquqls((String.valueOf(departments.get(0).getDlId())), dlIdStr)) {
								departmentList.add(departments.get(0));
							}
						}
					}
				}
			}
		}else if(StringUtil.isEmpty(deptIdStr)) {
			//根据部门名称，部门主管名称，部门级别查询
			//查询指定职工名称的职工信息
			List<Employee> employeeList = employeeService.listByEmpName(manageEmpNameStr);
			//对职工列表进行遍历查询出相应的职位
			for (Employee employee : employeeList) {
				//获取到职工-部门列表信息
				List<EmployeePosition> employeePositionList = employeePositionService.listByEmpJobId(employee.getEmpJobid());
				//对职工-部门列表信息进行遍历
				for (EmployeePosition employeePosition : employeePositionList) {
					//得到职工职位信息，查询为部门主管的职位信息
					Position position = positionService.get(employeePosition.getPositionId());
					if (position.getIsOnly()) {
						//如果该职位为唯一职位，即部门主管职位（只能分配给一个职工的职位），则找出该职位属于哪个部门
						List<Department> departments = departmentService.listByParentId(position.getPositionId());
						if (departments != null || departments.size() != 0) {
							if (com.lqs.hrm.util.StringUtil.isEquqls((String.valueOf(departments.get(0).getDeptName())), deptNameStr)
									&& com.lqs.hrm.util.StringUtil.isEquqls((String.valueOf(departments.get(0).getDlId())), dlIdStr)) {
								departmentList.add(departments.get(0));
							}
						}
					}
				}
			}
		}else {
			//根据id，部门名称，部门主管名称，部门级别查询
			//查询指定职工名称的职工信息
			List<Employee> employeeList = employeeService.listByEmpName(manageEmpNameStr);
			//对职工列表进行遍历查询出相应的职位
			for (Employee employee : employeeList) {
				//获取到职工-部门列表信息
				List<EmployeePosition> employeePositionList = employeePositionService.listByEmpJobId(employee.getEmpJobid());
				//对职工-部门列表信息进行遍历
				for (EmployeePosition employeePosition : employeePositionList) {
					//得到职工职位信息，查询为部门主管的职位信息
					Position position = positionService.get(employeePosition.getPositionId());
					if (position.getIsOnly()) {
						//如果该职位为唯一职位，即部门主管职位（只能分配给一个职工的职位），则找出该职位属于哪个部门
						List<Department> departments = departmentService.listByParentId(position.getPositionId());
						if (departments != null || departments.size() != 0) {
							if (com.lqs.hrm.util.StringUtil.isEquqls((String.valueOf(departments.get(0).getDeptId())), deptIdStr) 
									&& com.lqs.hrm.util.StringUtil.isEquqls((String.valueOf(departments.get(0).getDeptName())), deptNameStr)
									&& com.lqs.hrm.util.StringUtil.isEquqls((String.valueOf(departments.get(0).getDlId())), dlIdStr)) {
								departmentList.add(departments.get(0));
							}
						}
					}
				}
			}
		}
		departmentInfoUtil.setDepartmentInfo(departmentList);
		//设置分页查询结果
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
	 * @throws ParseException 
	 */
	@RequestMapping("query.do")
	@ResponseBody
	public JsonPageResult query(HttpServletRequest request, PageRequest pageRequest) throws ParseException {
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
					//System.out.println("查询条件都为空");
					//如果查询的条件全部为空，则查询出所有部门信息
					departmentList = departmentService.listByNo();
				}else if(StringUtil.isEmpty(deptNameStr) && StringUtil.isEmpty(manageEmpNameStr) && StringUtil.isEmpty(dlIdStr)) {
					//则根据部门id查询
					Department department = departmentService.get(Integer.valueOf(deptIdStr));
					if (department != null) {
						departmentList.add(department);
					}
				}else if(StringUtil.isEmpty(deptIdStr) && StringUtil.isEmpty(manageEmpNameStr) && StringUtil.isEmpty(dlIdStr)){
					//则根据部门名称查询
					departmentList = departmentService.listByDeptName(deptNameStr);
				}else if(StringUtil.isEmpty(deptIdStr) && StringUtil.isEmpty(deptNameStr) && StringUtil.isEmpty(dlIdStr)) {
					//根据部门主管名称查询
					//查询指定职工名称的职工信息
					List<Employee> employeeList = employeeService.listByEmpName(manageEmpNameStr);
					//对职工列表进行遍历查询出相应的职位
					for (Employee employee : employeeList) {
						//获取到职工-部门列表信息
						List<EmployeePosition> employeePositionList = employeePositionService.listByEmpJobId(employee.getEmpJobid());
						//对职工-部门列表信息进行遍历
						for (EmployeePosition employeePosition : employeePositionList) {
							//得到职工职位信息，查询为部门主管的职位信息
							Position position = positionService.get(employeePosition.getPositionId());
							if (position.getIsOnly()) {
								//如果该职位为唯一职位，即部门主管职位（只能分配给一个职工的职位），则找出该职位属于哪个部门
								List<Department> departments = departmentService.listByParentId(position.getPositionId());
								if (departments != null || departments.size() != 0) {
									departmentList.add(departments.get(0));
								}
							}
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
					//对职工列表进行遍历查询出相应的职位
					for (Employee employee : employeeList) {
						//获取到职工-部门列表信息
						List<EmployeePosition> employeePositionList = employeePositionService.listByEmpJobId(employee.getEmpJobid());
						//对职工-部门列表信息进行遍历
						for (EmployeePosition employeePosition : employeePositionList) {
							//得到职工职位信息，查询为部门主管的职位信息
							Position position = positionService.get(employeePosition.getPositionId());
							if (position.getIsOnly()) {
								//如果该职位为唯一职位，即部门主管职位（只能分配给一个职工的职位），则找出该职位属于哪个部门
								List<Department> departments = departmentService.listByParentId(position.getPositionId());
								if (departments != null || departments.size() != 0) {
									if (com.lqs.hrm.util.StringUtil.isEquqls((String.valueOf(departments.get(0).getDeptId())), deptIdStr)) {
										departmentList.add(departments.get(0));
									}
								}
							}
						}
					}
				}else if(StringUtil.isEmpty(deptNameStr) && StringUtil.isEmpty(manageEmpNameStr)) {
					//根据部门id，部门级别查询
					departmentList = departmentService.listByDeptIdDlId(Integer.valueOf(deptIdStr), Integer.valueOf(dlIdStr));
				}else if(StringUtil.isEmpty(deptIdStr) && StringUtil.isEmpty(dlIdStr)) {
					//根据部门名称，部门主管名称查询
					//查询指定职工名称的职工信息
					List<Employee> employeeList = employeeService.listByEmpName(manageEmpNameStr);
					//对职工列表进行遍历查询出相应的职位
					for (Employee employee : employeeList) {
						//获取到职工-部门列表信息
						List<EmployeePosition> employeePositionList = employeePositionService.listByEmpJobId(employee.getEmpJobid());
						//对职工-部门列表信息进行遍历
						for (EmployeePosition employeePosition : employeePositionList) {
							//得到职工职位信息，查询为部门主管的职位信息
							Position position = positionService.get(employeePosition.getPositionId());
							if (position.getIsOnly()) {
								//如果该职位为唯一职位，即部门主管职位（只能分配给一个职工的职位），则找出该职位属于哪个部门
								List<Department> departments = departmentService.listByParentId(position.getPositionId());
								if (departments != null || departments.size() != 0) {
									if (com.lqs.hrm.util.StringUtil.isEquqls((String.valueOf(departments.get(0).getDeptName())), deptNameStr)) {
										departmentList.add(departments.get(0));
									}
								}
							}
						}
					}
				}else if(StringUtil.isEmpty(deptIdStr) && StringUtil.isEmpty(manageEmpNameStr)) {
					//根据部门名称，部门级别查询
					departmentList = departmentService.listByDeptNameDlId(deptNameStr, Integer.valueOf(dlIdStr));
				}else if(StringUtil.isEmpty(deptIdStr) && StringUtil.isEmpty(deptNameStr)) {
					//根据部门主管名称，部门级别查询
					//查询指定职工名称的职工信息
					List<Employee> employeeList = employeeService.listByEmpName(manageEmpNameStr);
					//对职工列表进行遍历查询出相应的职位
					for (Employee employee : employeeList) {
						//获取到职工-部门列表信息
						List<EmployeePosition> employeePositionList = employeePositionService.listByEmpJobId(employee.getEmpJobid());
						//对职工-部门列表信息进行遍历
						for (EmployeePosition employeePosition : employeePositionList) {
							//得到职工职位信息，查询为部门主管的职位信息
							Position position = positionService.get(employeePosition.getPositionId());
							if (position.getIsOnly()) {
								//如果该职位为唯一职位，即部门主管职位（只能分配给一个职工的职位），则找出该职位属于哪个部门
								List<Department> departments = departmentService.listByParentId(position.getPositionId());
								if (departments != null || departments.size() != 0) {
									if (com.lqs.hrm.util.StringUtil.isEquqls((String.valueOf(departments.get(0).getDlId())), dlIdStr)) {
										departmentList.add(departments.get(0));
									}
								}
							}
						}
					}
				}else if(StringUtil.isEmpty(dlIdStr)) {
					//根据部门id，部门名称，部门主管名称查询
					//查询指定职工名称的职工信息
					List<Employee> employeeList = employeeService.listByEmpName(manageEmpNameStr);
					//对职工列表进行遍历查询出相应的职位
					for (Employee employee : employeeList) {
						//获取到职工-部门列表信息
						List<EmployeePosition> employeePositionList = employeePositionService.listByEmpJobId(employee.getEmpJobid());
						//对职工-部门列表信息进行遍历
						for (EmployeePosition employeePosition : employeePositionList) {
							//得到职工职位信息，查询为部门主管的职位信息
							Position position = positionService.get(employeePosition.getPositionId());
							if (position.getIsOnly()) {
								//如果该职位为唯一职位，即部门主管职位（只能分配给一个职工的职位），则找出该职位属于哪个部门
								List<Department> departments = departmentService.listByParentId(position.getPositionId());
								if (departments != null || departments.size() != 0) {
									if (com.lqs.hrm.util.StringUtil.isEquqls((String.valueOf(departments.get(0).getDeptId())), deptIdStr)
											&& com.lqs.hrm.util.StringUtil.isEquqls((String.valueOf(departments.get(0).getDeptName())), deptNameStr)) {
										departmentList.add(departments.get(0));
									}
								}
							}
						}
					}
				}else if(StringUtil.isEmpty(manageEmpNameStr)) {
					//根据部门id，部门名称，部门级别查询
					departmentList = departmentService.listByDeptIdNameDlId(Integer.valueOf(deptIdStr), deptIdStr, Integer.valueOf(dlIdStr));
				}else if(StringUtil.isEmpty(deptNameStr)) {
					//根据部门id，部门主管名称，部门级别查询
					//查询指定职工名称的职工信息
					List<Employee> employeeList = employeeService.listByEmpName(manageEmpNameStr);
					//对职工列表进行遍历查询出相应的职位
					for (Employee employee : employeeList) {
						//获取到职工-部门列表信息
						List<EmployeePosition> employeePositionList = employeePositionService.listByEmpJobId(employee.getEmpJobid());
						//对职工-部门列表信息进行遍历
						for (EmployeePosition employeePosition : employeePositionList) {
							//得到职工职位信息，查询为部门主管的职位信息
							Position position = positionService.get(employeePosition.getPositionId());
							if (position.getIsOnly()) {
								//如果该职位为唯一职位，即部门主管职位（只能分配给一个职工的职位），则找出该职位属于哪个部门
								List<Department> departments = departmentService.listByParentId(position.getPositionId());
								if (departments != null || departments.size() != 0) {
									if (com.lqs.hrm.util.StringUtil.isEquqls((String.valueOf(departments.get(0).getDeptId())), deptIdStr)
											&& com.lqs.hrm.util.StringUtil.isEquqls((String.valueOf(departments.get(0).getDlId())), dlIdStr)) {
										departmentList.add(departments.get(0));
									}
								}
							}
						}
					}
				}else if(StringUtil.isEmpty(deptIdStr)) {
					//根据部门名称，部门主管名称，部门级别查询
					//查询指定职工名称的职工信息
					List<Employee> employeeList = employeeService.listByEmpName(manageEmpNameStr);
					//对职工列表进行遍历查询出相应的职位
					for (Employee employee : employeeList) {
						//获取到职工-部门列表信息
						List<EmployeePosition> employeePositionList = employeePositionService.listByEmpJobId(employee.getEmpJobid());
						//对职工-部门列表信息进行遍历
						for (EmployeePosition employeePosition : employeePositionList) {
							//得到职工职位信息，查询为部门主管的职位信息
							Position position = positionService.get(employeePosition.getPositionId());
							if (position.getIsOnly()) {
								//如果该职位为唯一职位，即部门主管职位（只能分配给一个职工的职位），则找出该职位属于哪个部门
								List<Department> departments = departmentService.listByParentId(position.getPositionId());
								if (departments != null || departments.size() != 0) {
									if (com.lqs.hrm.util.StringUtil.isEquqls((String.valueOf(departments.get(0).getDeptName())), deptNameStr)
											&& com.lqs.hrm.util.StringUtil.isEquqls((String.valueOf(departments.get(0).getDlId())), dlIdStr)) {
										departmentList.add(departments.get(0));
									}
								}
							}
						}
					}
				}else {
					//根据id，部门名称，部门主管名称，部门级别查询
					//查询指定职工名称的职工信息
					List<Employee> employeeList = employeeService.listByEmpName(manageEmpNameStr);
					//对职工列表进行遍历查询出相应的职位
					for (Employee employee : employeeList) {
						//获取到职工-部门列表信息
						List<EmployeePosition> employeePositionList = employeePositionService.listByEmpJobId(employee.getEmpJobid());
						//对职工-部门列表信息进行遍历
						for (EmployeePosition employeePosition : employeePositionList) {
							//得到职工职位信息，查询为部门主管的职位信息
							Position position = positionService.get(employeePosition.getPositionId());
							if (position.getIsOnly()) {
								//如果该职位为唯一职位，即部门主管职位（只能分配给一个职工的职位），则找出该职位属于哪个部门
								List<Department> departments = departmentService.listByParentId(position.getPositionId());
								if (departments != null || departments.size() != 0) {
									if (com.lqs.hrm.util.StringUtil.isEquqls((String.valueOf(departments.get(0).getDeptId())), deptIdStr) 
											&& com.lqs.hrm.util.StringUtil.isEquqls((String.valueOf(departments.get(0).getDeptName())), deptNameStr)
											&& com.lqs.hrm.util.StringUtil.isEquqls((String.valueOf(departments.get(0).getDlId())), dlIdStr)) {
										departmentList.add(departments.get(0));
									}
								}
							}
						}
					}
				}
		if (departmentList == null) {
			return new JsonPageResult("100", null, "没有数据！");
		}
		departmentInfoUtil.setDepartmentInfo(departmentList);
		return new JsonPageResult("200", PageResultUtil.getPageResult(new PageInfo<>(departmentList)), "请求成功！");
	}
	
	/**
	 * 模糊查询、返回查询的指定部门信息
	 * 根据部门名称模糊查询
	 * @param request
	 * @param pageRequest
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("queryLikeDeptName.do")
	@ResponseBody
	public JsonCommonResult<List<Department>> queryLikeDeptName(HttpServletRequest request, PageRequest pageRequest) throws ParseException {
		//查询条件信息
		String deptNameStr = request.getParameter("deptName");
		System.out.println("要查询的部门名称为："+deptNameStr);
		//分页
		//PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
		List<Department> departmentList = new ArrayList<>();
		//查询条件判断
		if (StringUtil.isEmpty(deptNameStr)) {
			//如果查询的条件全部为空，则查询出所有部门信息
			departmentList = departmentService.listByNo();
			System.out.println("查询所有部门信息");
		}else {
			//根据部门名称模糊查询
			departmentList = departmentService.listLikeDeptName(deptNameStr);
			System.out.println("进行模糊查询");
		}
		if (departmentList == null || departmentList.size() == 0) {
			System.out.println("查询list大小："+departmentList.size());
			return new JsonCommonResult<List<Department>>("100", null, "没有数据！");
		}
		departmentInfoUtil.setDepartmentInfo(departmentList);
		return new JsonCommonResult<List<Department>>("200",departmentList, "请求成功！");
	}
	
	/**
	 * 查询指定id的部门信息
	 * @param request
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("get.do")
	@ResponseBody
	public JsonCommonResult<Department> get(HttpServletRequest request) throws ParseException {
		//部门级别id
		String deptIdStr = request.getParameter("deptId");
		Department department = departmentService.get(Integer.valueOf(deptIdStr));
		departmentInfoUtil.setDepartmentInfo(department);
		if(department == null) {
			return new JsonCommonResult<Department>("100",null, "请求失败！");
		}
		return new JsonCommonResult<Department>("200",department, "请求成功！");
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
		//获取上级部门id
		String parentIdStr = request.getParameter("parentId");
		//获取部门主管职位id
		String managePositionidStr = request.getParameter("managePositionid");
		//获取部门状态id
		String statusIdStr = request.getParameter("statusId");
		//获取部门描述
		String deptDescStr = request.getParameter("deptDesc");
		
		Department department = new Department();
		//设置部门名称
		department.setDeptName(deptNameStr);
		//设置部门级别id
		department.setDlId(Integer.valueOf(dlIdStr));
		//设置部门人数
		department.setDeptEmpnum(0);
		//设置部门状态id
		department.setStatusId(Integer.valueOf(statusIdStr));
		//设置上级部门id
		if (StringUtil.isNotEmpty(parentIdStr)) {
			department.setParentId(Integer.valueOf(parentIdStr));
		}
		//设置部门主管职位
		if (StringUtil.isNotEmpty(managePositionidStr)) {
			department.setManagePositionid(Integer.valueOf(managePositionidStr));
		}
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
		
		//添加部门信息
		int result2 = departmentService.insert(department);
		if (result2 == 0) {
			return new JsonCommonResult<Object>("100", null, "添加失败");
		}
		return new JsonCommonResult<Object>("200", null, "添加成功");
	}
	/**
	 * 查询指定父部门的所有子部门信息
	 * @param request
	 * @return
	 */
	@RequestMapping("getChildDepartmentList.do")
	@ResponseBody
	public JsonCommonResult<List<Department>> getChildDepartmentList(HttpServletRequest request) {
		//部门级别值
		String levelStr = request.getParameter("level");
		//上级部门id
		String parentDeptIdStr = request.getParameter("parentDeptId");
		//System.out.println("==========上级部门id："+parentDeptIdStr);
		int level = Integer.valueOf(levelStr);
		int parentDeptId = Integer.valueOf(parentDeptIdStr);
		//获取部门级别id
		int dlId = departmentLevelService.getByLevel(level).getDlId();
		List<Department> departmentList = null;
		if (parentDeptId != 0) {
			//有上级部门，查询上级部门id下的所有子部门信息
			departmentList = departmentService.listByParentId(parentDeptId);
		}else {
			//没有上级部门
			departmentList = departmentService.listByDlId(dlId);
		}
		
		if(departmentList.size() == 0 || departmentList == null) {
			return new JsonCommonResult<List<Department>>("100",null, "无信息!");
		}
		return new JsonCommonResult<List<Department>>("200",departmentList, "请求成功！");
	}
	
	/**
	 * 修改部门信息
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("update.do")
	@ResponseBody
	public JsonCommonResult<Object> update(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> resultMap = new HashMap<>();
		//获取部门id
		String deptIdStr = request.getParameter("deptId");
		//获取部门名称
		String deptNameStr = request.getParameter("deptName");
		//获取部门级别id
		String dlIdStr = request.getParameter("dlId");
		//获取上级部门id
		String parentIdStr = request.getParameter("parentId");
		//获取部门主管职位id
		String managePositionidStr = request.getParameter("managePositionid");
		//获取部门状态id
		String statusIdStr = request.getParameter("statusId");
		//获取部门描述
		String deptDescStr = request.getParameter("deptDesc");
		
		Department department = departmentService.get(Integer.valueOf(deptIdStr));
		//设置部门名称
		department.setDeptName(deptNameStr);
		//设置部门级别id
		department.setDlId(Integer.valueOf(dlIdStr));
		//设置部门级别
		department.setDlId(Integer.valueOf(dlIdStr));
		department.setDeptEmpnum(0);
		//设置部门状态id
		department.setStatusId(Integer.valueOf(statusIdStr));
		//设置上级部门id
		if (StringUtil.isNotEmpty(parentIdStr)) {
			department.setParentId(Integer.valueOf(parentIdStr));
		}
		//设置部门主管职位
		if (StringUtil.isNotEmpty(managePositionidStr)) {
			department.setManagePositionid(Integer.valueOf(managePositionidStr));
		}
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
		
		//添加部门信息
		int result = departmentService.update(department);
		if (result == 0) {
			return new JsonCommonResult<Object>("100", null, "修改失败");
		}
		return new JsonCommonResult<Object>("200", null, "修改成功");
	}
	
	/**
	 * 删除指定id的部门信息
	 * @param request
	 * @return
	 */
	@RequestMapping("delete.do")
	@ResponseBody
	public JsonCommonResult<Object> delete(HttpServletRequest request) {
		//获取部门Id 
		String deptIdStr = request.getParameter("deptId");		
		//检查该部门下面是否还有职位信息
		List<Position> positionList = positionService.listByDeptId(Integer.valueOf(deptIdStr));
		if (positionList != null && positionList.size() != 0) {
			//该部门级别下面还有部门信息，不能删除
			System.out.println("该部门下面还有职位信息");
			return new JsonCommonResult<>("100", null, "该部门下面还有职位信息，不能删除！");
		}else {
			System.out.println("该部门下面没有职位信息");
		}
		int result = departmentService.delete(Integer.valueOf(deptIdStr));
		if (result == 0) {
			return new JsonCommonResult<>("100", null, "删除失败");
		}
		return new JsonCommonResult<>("200", null, "删除成功");
	}
	
	/**
	 * 查询部门信息，并跳转至部门详情页面
	 * 1.根据职工工号查询
	 * 2.根据部门id查询
	 * @param request
	 * @param pageRequest
	 * @param map
	 * @return
	 */
	@RequestMapping("toDepartmentDetail.do")
	public String toDepartmentDetail(HttpServletRequest request, PageRequest pageRequest, ModelMap map){
		String empJobIdStr = request.getParameter("empJobId");
		String deptIdStr = request.getParameter("deptId");
		List<Department> departmentList = new ArrayList<Department>();
		if (StringUtil.isEmpty(empJobIdStr)) {
			//根据部门ID查询
			Department department = departmentService.get(Integer.valueOf(deptIdStr));
			if (department != null) {
				departmentList.add(department);
			}
		}else if(StringUtil.isEmpty(deptIdStr)) {
			//根据职工工号查询
			//查询该职工所属的部门信息
			List<EmployeePosition> employeePositionList = employeePositionService.listByEmpJobId(empJobIdStr);
			for (EmployeePosition employeePosition : employeePositionList) {
				//找到对应的职位
				Position position = positionService.get(employeePosition.getPositionId());
				//找到职位对应的部门
				Department department = departmentService.get(position.getDeptId());
				if (department != null) {
					departmentList.add(department);
				}
			}
		}else {
			//根据部门ID，职工工号查询
			//查询该职工所属的部门信息
			List<EmployeePosition> employeePositionList = employeePositionService.listByEmpJobId(empJobIdStr);
			for (EmployeePosition employeePosition : employeePositionList) {
				//找到对应的职位
				Position position = positionService.get(employeePosition.getPositionId());
				//找到职位对应的部门
				Department department = departmentService.get(position.getDeptId());
				if (department != null && department.getDeptId() == Integer.valueOf(deptIdStr)) {
					departmentList.add(department);
				}
			}
		}
		//查询该
		if (departmentList != null) {
			departmentInfoUtil.setDepartmentInfo(departmentList);
		}
		//回显查询条件
		map.put("departmentList", departmentList);
		return "department/departmentDetail";
	}
	
	/**
	 * 查询部门信息，并跳转至登录账户职工的部门详情页面
	 * 1.根据职工工号查询
	 * 2.根据部门id查询
	 * @param request
	 * @param pageRequest
	 * @param map
	 * @return
	 */
	@RequestMapping("toMyDepartmentDetail.do")
	public String toMyDepartmentDetail(HttpServletRequest request, PageRequest pageRequest, ModelMap map){
		List<Department> departmentList = new ArrayList<Department>();
		//获取当前登录系统人工号
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("session_loginUser");
		List<EmployeePosition> employeePositionList = employeePositionService.listByEmpJobId(user.getUserAccount());
		if (employeePositionList != null && employeePositionList.size() != 0) {
			for (EmployeePosition employeePosition : employeePositionList) {
				//找到对应的职位
				Position position = positionService.get(employeePosition.getPositionId());
				//找到职位对应的部门
				Department department = departmentService.get(position.getDeptId());
				if (department != null) {
					departmentList.add(department);
				}
			}
		}
		//查询该
		if (departmentList != null) {
			departmentInfoUtil.setDepartmentInfo(departmentList);
		}
		//回显查询条件
		map.put("departmentList", departmentList);
		return "department/myDepartmentDetail";
	}
	
	
	
}

