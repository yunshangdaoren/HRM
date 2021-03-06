package com.lqs.hrm.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.lqs.hrm.entity.Contract;
import com.lqs.hrm.entity.Department;
import com.lqs.hrm.entity.Employee;
import com.lqs.hrm.entity.EmployeeContract;
import com.lqs.hrm.entity.EmployeePosition;
import com.lqs.hrm.entity.Position;
import com.lqs.hrm.entity.Status;
import com.lqs.hrm.entity.User;
import com.lqs.hrm.entity.UserRole;
import com.lqs.hrm.json.JsonCommonResult;
import com.lqs.hrm.json.JsonPageResult;
import com.lqs.hrm.service.impl.ContractServiceImpl;
import com.lqs.hrm.service.impl.DepartmentServiceImpl;
import com.lqs.hrm.service.impl.EmployeeContractServiceImpl;
import com.lqs.hrm.service.impl.EmployeePositionServiceImpl;
import com.lqs.hrm.service.impl.EmployeeServiceImpl;
import com.lqs.hrm.service.impl.PositionServiceImpl;
import com.lqs.hrm.service.impl.StatusServiceImpl;
import com.lqs.hrm.service.impl.UserRoleServiceImpl;
import com.lqs.hrm.service.impl.UserServiceImpl;
import com.lqs.hrm.util.PageRequest;
import com.lqs.hrm.util.PageResult;
import com.lqs.hrm.util.PageResultUtil;
import com.lqs.hrm.util.entity.ContractInfoUtil;

/**
 * 合同Controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("contract")
public class ContractController {
	@Autowired
	private ContractServiceImpl contractService;
	@Autowired
	private DepartmentServiceImpl departmentService;
	@Autowired
	private PositionServiceImpl positionService;
	@Autowired
	private StatusServiceImpl statusService;
	@Autowired
	private EmployeeServiceImpl employeeService;
	@Autowired
	private EmployeeContractServiceImpl employeeContractService;
	@Autowired
	private ContractInfoUtil contractInfoUtil;
	@Autowired
	private EmployeePositionServiceImpl employeePositionService;
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private UserRoleServiceImpl userRoleService;
	
	
	/**
	 * 查询合同并跳转至合同详情页面
	 * @param request
	 * @param pageRequest
	 * @param map
	 * @return
	 */
	@RequestMapping("toAllContractList.do")
	public String toAllContractList(HttpServletRequest request, PageRequest pageRequest, ModelMap map){
		//查询条件信息
		String conIdStr = request.getParameter("conId"); //合同id
		String deptNameStr = request.getParameter("deptName"); //所属部门名称
		String positionNameStr = request.getParameter("positionName"); //所属职位名称
		String statusIdStr = request.getParameter("statusId"); //状态
		//分页
		PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
		List<Contract> contractList = new ArrayList<>();
		//查询条件判断
		if (StringUtil.isEmpty(conIdStr) && StringUtil.isEmpty(deptNameStr) && StringUtil.isEmpty(positionNameStr) && StringUtil.isEmpty(statusIdStr)) {
			//如果查询的条件全部为空，则查询出所有合同信息
			contractList = contractService.listByNo();
		}else if(StringUtil.isEmpty(deptNameStr) && StringUtil.isEmpty(positionNameStr) && StringUtil.isEmpty(statusIdStr)) {
			//则根据合同id查询
			Contract contract = contractService.get(Integer.valueOf(conIdStr));
			if (conIdStr != null) {
				contractList.add(contract);
			}
		}else if(StringUtil.isEmpty(conIdStr) && StringUtil.isEmpty(positionNameStr) && StringUtil.isEmpty(statusIdStr)){
			//则根据所属部门名称查询
			List<Department> departmentList = departmentService.listByDeptName(deptNameStr);
			for (Department department : departmentList) {
				List<Contract> contracts = contractService.listBydeptId(department.getDeptId());
				for (Contract contract : contracts) {
					if (contract != null) {
						contractList.add(contract);
					}
				}
			}
		}else if(StringUtil.isEmpty(conIdStr) && StringUtil.isEmpty(deptNameStr) && StringUtil.isEmpty(statusIdStr)) {
			//则根据所属职位名称查询
			List<Position> positionList = positionService.listByPositionName(positionNameStr);
			for (Position position : positionList) {
				List<Contract> contracts = contractService.listByPositionId(position.getPositionId());
				for (Contract contract : contracts) {
					if (contract != null) {
						contractList.add(contract);
					}
				}
			}
		}else if(StringUtil.isEmpty(conIdStr) && StringUtil.isEmpty(deptNameStr) && StringUtil.isEmpty(positionNameStr)) {
			//则根据所属状态id查询
			List<Contract> contracts = contractService.listByStatusId(Integer.valueOf(statusIdStr));
			for (Contract contract : contracts) {
				contractList.add(contract);
			}
		}else if(StringUtil.isEmpty(positionNameStr) && StringUtil.isEmpty(statusIdStr)) {
			//根据合同id，所属部门名称查询
			List<Department> departmentList = departmentService.listByDeptName(deptNameStr);
			for (Department department : departmentList) {
				List<Contract> contracts = contractService.listByConIdDeptId(Integer.valueOf(conIdStr), department.getDeptId());
				for (Contract contract : contracts) {
					if (contract != null) {
						contractList.add(contract);
					}
				}
			}
		}else if(StringUtil.isEmpty(deptNameStr) && StringUtil.isEmpty(conIdStr)) {
			//根据合同id、所属职位名称查询
			List<Position> positionList = positionService.listByPositionName(positionNameStr);
			for (Position position : positionList) {
				List<Contract> contracts = contractService.listByConIdPositionId(Integer.valueOf(conIdStr), position.getPositionId());
				for (Contract contract : contracts) {
					if (contract != null) {
						contractList.add(contract);
					}
				}
			}
		}else if(StringUtil.isEmpty(deptNameStr) && StringUtil.isEmpty(positionNameStr)) {
			//根据合同id、所属状态id查询
			List<Contract> contracts = contractService.listByConIdStatusId(Integer.valueOf(conIdStr), Integer.valueOf(statusIdStr));
			for (Contract contract : contracts) {
				contractList.add(contract);
			}
		}else if(StringUtil.isEmpty(conIdStr) && StringUtil.isEmpty(statusIdStr)) {
			//根据合同所属部门名称、所属职位名称查询
			List<Department> departmentList = departmentService.listByDeptName(deptNameStr);
			List<Position> positionList = positionService.listByPositionName(positionNameStr);
			for (Department department : departmentList) {
				for (Position position : positionList) {
					List<Contract> contracts = contractService.listByDeptIdPositionId(department.getDeptId(), position.getPositionId());
					for (Contract contract : contracts) {
						if (contract != null) {
							contractList.add(contract);
						}
					}
				}
			}
		}else if(StringUtil.isEmpty(conIdStr) && StringUtil.isEmpty(positionNameStr)) {
			//根据合同所属部门名称、状态id查询
			List<Department> departmentList = departmentService.listByDeptName(deptNameStr);
			for (Department department : departmentList) {
				List<Contract> contracts = contractService.listByDeptIdStatusId(department.getDeptId(), Integer.valueOf(statusIdStr));
				for (Contract contract : contracts) {
					if (contract != null) {
						contractList.add(contract);
					}
				}
			}
		}else if(StringUtil.isEmpty(conIdStr) && StringUtil.isEmpty(deptNameStr)) {
			//根据合同所属职位名称、所属状态id查询
			List<Position> positionList = positionService.listByPositionName(positionNameStr);
			for (Position position : positionList) {
				List<Contract> contracts = contractService.listByPositionIdStatusId(position.getPositionId(), Integer.valueOf(statusIdStr));
				for (Contract contract : contracts) {
					if (contract != null) {
						contractList.add(contract);
					}
				}
			}
		}else if(StringUtil.isEmpty(statusIdStr)) {
			//根据合同id、所属部门名称、所属职位名称查询
			List<Department> departmentList = departmentService.listByDeptName(deptNameStr);
			List<Position> positionList = positionService.listByPositionName(positionNameStr);
			for (Department department : departmentList) {
				for (Position position : positionList) {
					List<Contract> contracts = contractService.listByConIdDeptIdPositionId(Integer.valueOf(conIdStr), department.getDeptId(), position.getPositionId());
					for (Contract contract : contracts) {
						if (contract != null) {
							contractList.add(contract);
						}
					}
				}
			}
		}else if(StringUtil.isEmpty(positionNameStr)) {
			//根据合同id、所属部门名称、状态id查询
			List<Department> departmentList = departmentService.listByDeptName(deptNameStr);
			for (Department department : departmentList) {
				List<Contract> contracts = contractService.listByConIdDeptIdStatusId(Integer.valueOf(conIdStr), department.getDeptId(), Integer.valueOf(statusIdStr));
				for (Contract contract : contracts) {
					if (contract != null) {
						contractList.add(contract);
					}
				}
			}
		}else if(StringUtil.isEmpty(deptNameStr)) {
			//根据合同id、所属职位名称、状态id查询
			List<Position> positionList = positionService.listByPositionName(positionNameStr);
			for (Position position : positionList) {
				List<Contract> contracts = contractService.listByConIdPositionIdStatusId(Integer.valueOf(conIdStr), position.getPositionId(), Integer.valueOf(statusIdStr));
				for (Contract contract : contracts) {
					if (contract != null) {
						contractList.add(contract);
					}
				}
			}
		}else if(StringUtil.isEmpty(conIdStr)) {
			//根据合同所属部门名称、所属职位名称、状态id查询
			List<Department> departmentList = departmentService.listByDeptName(deptNameStr);
			List<Position> positionList = positionService.listByPositionName(positionNameStr);
			for (Department department : departmentList) {
				for (Position position : positionList) {
					List<Contract> contracts = contractService.listByDeptIdPositionIdStatusId(department.getDeptId(), position.getPositionId(), Integer.valueOf(statusIdStr));
					for (Contract contract : contracts) {
						if (contract != null) {
							contractList.add(contract);
						}
					}
				}
			}
		}else {
			//根据合同id、所属部门名称、所属职位名称、所属状态id查询
			List<Department> departmentList = departmentService.listByDeptName(deptNameStr);
			List<Position> positionList = positionService.listByPositionName(positionNameStr);
			for (Department department : departmentList) {
				for (Position position : positionList) {
					List<Contract> contracts = contractService.listByConIdDeptIdPositionStatusId(Integer.valueOf(conIdStr), department.getDeptId(), position.getPositionId(), Integer.valueOf(statusIdStr));
					for (Contract contract : contracts) {
						if (contract != null) {
							contractList.add(contract);
						}
					}
				}
			}
		}
		contractInfoUtil.setContractInfo(contractList);
		//设置分页查询结果
		PageResult pageResult = PageResultUtil.getPageResult(new PageInfo<>(contractList));
		//返回查询的部门信息
		map.put("pageResult", pageResult);
		//回显查询条件
		map.put("conIdStr", conIdStr);
		map.put("deptNameStr", deptNameStr);
		map.put("positionNameStr", positionNameStr);
		map.put("statusIdStr", statusIdStr);
		
		//合同状态信息：合同类型为7
		List<Status> statusList = statusService.list(7);
		//返回查询的合同状态信息
		map.put("statusList", statusList);
		return "contract/allContractList";
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
				String conIdStr = request.getParameter("conId"); //合同id
				String deptNameStr = request.getParameter("deptName"); //所属部门名称
				String positionNameStr = request.getParameter("positionName"); //所属职位名称
				String statusIdStr = request.getParameter("statusId"); //状态
				//分页
				PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
				List<Contract> contractList = new ArrayList<>();
				//查询条件判断
				if (StringUtil.isEmpty(conIdStr) && StringUtil.isEmpty(deptNameStr) && StringUtil.isEmpty(positionNameStr) && StringUtil.isEmpty(statusIdStr)) {
					//如果查询的条件全部为空，则查询出所有合同信息
					contractList = contractService.listByNo();
				}else if(StringUtil.isEmpty(deptNameStr) && StringUtil.isEmpty(positionNameStr) && StringUtil.isEmpty(statusIdStr)) {
					//则根据合同id查询
					Contract contract = contractService.get(Integer.valueOf(conIdStr));
					if (conIdStr != null) {
						contractList.add(contract);
					}
				}else if(StringUtil.isEmpty(conIdStr) && StringUtil.isEmpty(positionNameStr) && StringUtil.isEmpty(statusIdStr)){
					//则根据所属部门名称查询
					List<Department> departmentList = departmentService.listByDeptName(deptNameStr);
					for (Department department : departmentList) {
						List<Contract> contracts = contractService.listBydeptId(department.getDeptId());
						for (Contract contract : contracts) {
							if (contract != null) {
								contractList.add(contract);
							}
						}
					}
				}else if(StringUtil.isEmpty(conIdStr) && StringUtil.isEmpty(deptNameStr) && StringUtil.isEmpty(statusIdStr)) {
					//则根据所属职位名称查询
					List<Position> positionList = positionService.listByPositionName(positionNameStr);
					for (Position position : positionList) {
						List<Contract> contracts = contractService.listByPositionId(position.getPositionId());
						for (Contract contract : contracts) {
							if (contract != null) {
								contractList.add(contract);
							}
						}
					}
				}else if(StringUtil.isEmpty(conIdStr) && StringUtil.isEmpty(deptNameStr) && StringUtil.isEmpty(positionNameStr)) {
					//则根据所属状态id查询
					List<Contract> contracts = contractService.listByStatusId(Integer.valueOf(statusIdStr));
					for (Contract contract : contracts) {
						contractList.add(contract);
					}
				}else if(StringUtil.isEmpty(positionNameStr) && StringUtil.isEmpty(statusIdStr)) {
					//根据合同id，所属部门名称查询
					List<Department> departmentList = departmentService.listByDeptName(deptNameStr);
					for (Department department : departmentList) {
						List<Contract> contracts = contractService.listByConIdDeptId(Integer.valueOf(conIdStr), department.getDeptId());
						for (Contract contract : contracts) {
							if (contract != null) {
								contractList.add(contract);
							}
						}
					}
				}else if(StringUtil.isEmpty(deptNameStr) && StringUtil.isEmpty(conIdStr)) {
					//根据合同id、所属职位名称查询
					List<Position> positionList = positionService.listByPositionName(positionNameStr);
					for (Position position : positionList) {
						List<Contract> contracts = contractService.listByConIdPositionId(Integer.valueOf(conIdStr), position.getPositionId());
						for (Contract contract : contracts) {
							if (contract != null) {
								contractList.add(contract);
							}
						}
					}
				}else if(StringUtil.isEmpty(deptNameStr) && StringUtil.isEmpty(positionNameStr)) {
					//根据合同id、所属状态id查询
					List<Contract> contracts = contractService.listByConIdStatusId(Integer.valueOf(conIdStr), Integer.valueOf(statusIdStr));
					for (Contract contract : contracts) {
						contractList.add(contract);
					}
				}else if(StringUtil.isEmpty(conIdStr) && StringUtil.isEmpty(statusIdStr)) {
					//根据合同所属部门名称、所属职位名称查询
					List<Department> departmentList = departmentService.listByDeptName(deptNameStr);
					List<Position> positionList = positionService.listByPositionName(positionNameStr);
					for (Department department : departmentList) {
						for (Position position : positionList) {
							List<Contract> contracts = contractService.listByDeptIdPositionId(department.getDeptId(), position.getPositionId());
							for (Contract contract : contracts) {
								if (contract != null) {
									contractList.add(contract);
								}
							}
						}
					}
				}else if(StringUtil.isEmpty(conIdStr) && StringUtil.isEmpty(positionNameStr)) {
					//根据合同所属部门名称、状态id查询
					List<Department> departmentList = departmentService.listByDeptName(deptNameStr);
					for (Department department : departmentList) {
						List<Contract> contracts = contractService.listByDeptIdStatusId(department.getDeptId(), Integer.valueOf(statusIdStr));
						for (Contract contract : contracts) {
							if (contract != null) {
								contractList.add(contract);
							}
						}
					}
				}else if(StringUtil.isEmpty(conIdStr) && StringUtil.isEmpty(deptNameStr)) {
					//根据合同所属职位名称、所属状态id查询
					List<Position> positionList = positionService.listByPositionName(positionNameStr);
					for (Position position : positionList) {
						List<Contract> contracts = contractService.listByPositionIdStatusId(position.getPositionId(), Integer.valueOf(statusIdStr));
						for (Contract contract : contracts) {
							if (contract != null) {
								contractList.add(contract);
							}
						}
					}
				}else if(StringUtil.isEmpty(statusIdStr)) {
					//根据合同id、所属部门名称、所属职位名称查询
					List<Department> departmentList = departmentService.listByDeptName(deptNameStr);
					List<Position> positionList = positionService.listByPositionName(positionNameStr);
					for (Department department : departmentList) {
						for (Position position : positionList) {
							List<Contract> contracts = contractService.listByConIdDeptIdPositionId(Integer.valueOf(conIdStr), department.getDeptId(), position.getPositionId());
							for (Contract contract : contracts) {
								if (contract != null) {
									contractList.add(contract);
								}
							}
						}
					}
				}else if(StringUtil.isEmpty(positionNameStr)) {
					//根据合同id、所属部门名称、状态id查询
					List<Department> departmentList = departmentService.listByDeptName(deptNameStr);
					for (Department department : departmentList) {
						List<Contract> contracts = contractService.listByConIdDeptIdStatusId(Integer.valueOf(conIdStr), department.getDeptId(), Integer.valueOf(statusIdStr));
						for (Contract contract : contracts) {
							if (contract != null) {
								contractList.add(contract);
							}
						}
					}
				}else if(StringUtil.isEmpty(deptNameStr)) {
					//根据合同id、所属职位名称、状态id查询
					List<Position> positionList = positionService.listByPositionName(positionNameStr);
					for (Position position : positionList) {
						List<Contract> contracts = contractService.listByConIdPositionIdStatusId(Integer.valueOf(conIdStr), position.getPositionId(), Integer.valueOf(statusIdStr));
						for (Contract contract : contracts) {
							if (contract != null) {
								contractList.add(contract);
							}
						}
					}
				}else if(StringUtil.isEmpty(conIdStr)) {
					//根据合同所属部门名称、所属职位名称、状态id查询
					List<Department> departmentList = departmentService.listByDeptName(deptNameStr);
					List<Position> positionList = positionService.listByPositionName(positionNameStr);
					for (Department department : departmentList) {
						for (Position position : positionList) {
							List<Contract> contracts = contractService.listByDeptIdPositionIdStatusId(department.getDeptId(), position.getPositionId(), Integer.valueOf(statusIdStr));
							for (Contract contract : contracts) {
								if (contract != null) {
									contractList.add(contract);
								}
							}
						}
					}
				}else {
					//根据合同id、所属部门名称、所属职位名称、所属状态id查询
					List<Department> departmentList = departmentService.listByDeptName(deptNameStr);
					List<Position> positionList = positionService.listByPositionName(positionNameStr);
					for (Department department : departmentList) {
						for (Position position : positionList) {
							List<Contract> contracts = contractService.listByConIdDeptIdPositionStatusId(Integer.valueOf(conIdStr), department.getDeptId(), position.getPositionId(), Integer.valueOf(statusIdStr));
							for (Contract contract : contracts) {
								if (contract != null) {
									contractList.add(contract);
								}
							}
						}
					}
				}
		if (contractList == null) {
			return new JsonPageResult("100", null, "没有数据！");
		}
		contractInfoUtil.setContractInfo(contractList);
		return new JsonPageResult("200", PageResultUtil.getPageResult(new PageInfo<>(contractList)), "请求成功！");
	}
	
	/**
	 * 查询指定合同id的合同信息
	 * @param request
	 * @return
	 */
	@RequestMapping("get.do")
	@ResponseBody
	public JsonCommonResult<Contract> get(HttpServletRequest request) {
		//合同id
		String conIdStr = request.getParameter("conId");
		Contract contract = contractService.get(Integer.valueOf(conIdStr));
		contractInfoUtil.setContractInfo(contract);
		if(contract == null) {
			return new JsonCommonResult<Contract>("100",null, "请求失败！");
		}
		return new JsonCommonResult<Contract>("200",contract, "请求成功！");
	}
	
	/**
	 * 转至添加合同页面
	 * @param request
	 * @param pageRequest
	 * @param map
	 * @return
	 */
	@RequestMapping("toAddContract.do")
	public String toAddContract( ModelMap map){
		return "contract/addContract";
	}
	
	/**
	 * 添加合同信息
	 * @param request
	 * @param response
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("add.do")
	@ResponseBody
	public JsonCommonResult<Object> add(HttpServletRequest request, HttpServletResponse response) throws ParseException {
		Map<String, Object> resultMap = new HashMap<>();
		//获取职工姓名
		String empNameStr = request.getParameter("empName");
		//职工性别
		String empSexStr = request.getParameter("empSex");
		//获取职工身份证号
		String empIdcardStr = request.getParameter("empIdcard");
		//获取合同所属部门名称
		String deptIdStr = request.getParameter("deptId");
		//获取合同所属职位名称
		String positionIdStr = request.getParameter("positionId");
		//获取合同开始日期
		String beginDateStr = request.getParameter("beginDate");
		//获取合同结束日期
		String endDateStr = request.getParameter("endDate");
		//获取合同月薪
		String monthlySalaryStr = request.getParameter("monthlySalary");
		//获取合同签订日期
		String signDateStr = request.getParameter("signDate");
		//获取合同备注
		String noteStr = request.getParameter("note");
		
		Contract contract = new Contract();
		contract.setEmpName(empNameStr);
		contract.setEmpSex(Integer.valueOf(empSexStr));
		contract.setEmpIdcard(empIdcardStr);
		contract.setDeptId(Integer.valueOf(deptIdStr));
		contract.setPositionId(Integer.valueOf(positionIdStr));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		contract.setBeginDate(format.parse(beginDateStr));
		contract.setEndDate(format.parse(endDateStr));
		contract.setMonthlySalary(Long.valueOf(monthlySalaryStr));
		contract.setSignDate(format.parse(signDateStr));
		contract.setNote(noteStr);
		//设置合同状态为待入职状态
		contract.setStatusId(16);
		//设置操作人工号
		//获取当前登录系统人工号
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("session_loginUser");
		if (user == null) {
			return new JsonCommonResult<Object>("100", null, "请先登录！");
		}
		//设置录入合同信息人工号
		contract.setAddEmpjobid(user.getUserAccount());
		//设置录入时间
		contract.setAddDate(new Date());
		//添加合同信息
		int result = contractService.insert(contract);
		if (result == 0) {
			return new JsonCommonResult<Object>("100", null, "添加失败");
		}
		return new JsonCommonResult<Object>("200", null, "添加成功");
	}
	
	/**
	 * 转至待入职合同审批列表页面
	 * @param request
	 * @param pageRequest
	 * @param map
	 * @return
	 */
	@RequestMapping("toCheckEntryContractList.do")
	public String toCheckEntryContractList(HttpServletRequest request, PageRequest pageRequest, ModelMap map){
		//查询条件信息
				String conIdStr = request.getParameter("conId"); //合同id
				String deptNameStr = request.getParameter("deptName"); //所属部门名称
				String positionNameStr = request.getParameter("positionName"); //所属职位名称
				//分页
				PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
				List<Contract> contractList = new ArrayList<>();
				//查询条件判断
				if (StringUtil.isEmpty(conIdStr) && StringUtil.isEmpty(deptNameStr) && StringUtil.isEmpty(positionNameStr)) {
					//如果查询的条件全部为空，则查询出所有待入职审批合同信息
					contractList = contractService.listByStatusId(16);
				}else if(StringUtil.isEmpty(deptNameStr) && StringUtil.isEmpty(positionNameStr)) {
					//则根据合同id查询所有待入职审批合同信息
					contractList = contractService.listByConIdStatusId(Integer.valueOf(conIdStr), 16);
				}else if(StringUtil.isEmpty(conIdStr) && StringUtil.isEmpty(positionNameStr)){
					//则根据所属部门名称查询所有待入职审批合同信息
					List<Department> departmentList = departmentService.listByDeptName(deptNameStr);
					for (Department department : departmentList) {
						List<Contract> contracts = contractService.listByDeptIdStatusId(department.getDeptId(), 16);
						for (Contract contract : contracts) {
							if (contract != null) {
								contractList.add(contract);
							}
						}
					}
				}else if(StringUtil.isEmpty(conIdStr) && StringUtil.isEmpty(deptNameStr)) {
					//则根据所属职位名称查询所有待入职审批合同信息
					List<Position> positionList = positionService.listByPositionName(positionNameStr);
					for (Position position : positionList) {
						List<Contract> contracts = contractService.listByPositionIdStatusId(position.getPositionId(), 16);
						for (Contract contract : contracts) {
							if (contract != null) {
								contractList.add(contract);
							}
						}
					}
				}else if(StringUtil.isEmpty(positionNameStr)) {
					//根据合同id，所属部门名称查询所有待入职审批合同信息
					List<Department> departmentList = departmentService.listByDeptName(deptNameStr);
					for (Department department : departmentList) {
						List<Contract> contracts = contractService.listByConIdDeptIdStatusId(Integer.valueOf(conIdStr), department.getDeptId(), 16);
						for (Contract contract : contracts) {
							if (contract != null) {
								contractList.add(contract);
							}
						}
					}
				}else if(StringUtil.isEmpty(deptNameStr) && StringUtil.isEmpty(conIdStr)) {
					//根据合同id、所属职位名称查询所有待入职审批合同信息
					List<Position> positionList = positionService.listByPositionName(positionNameStr);
					for (Position position : positionList) {
						List<Contract> contracts = contractService.listByConIdPositionIdStatusId(Integer.valueOf(conIdStr), position.getPositionId(), 16);
						for (Contract contract : contracts) {
							if (contract != null) {
								contractList.add(contract);
							}
						}
					}
				}else if(StringUtil.isEmpty(conIdStr)) {
					//根据合同所属部门名称、所属职位名称查询所有待入职审批合同信息
					List<Department> departmentList = departmentService.listByDeptName(deptNameStr);
					List<Position> positionList = positionService.listByPositionName(positionNameStr);
					for (Department department : departmentList) {
						for (Position position : positionList) {
							List<Contract> contracts = contractService.listByDeptIdPositionId(department.getDeptId(), position.getPositionId());
							for (Contract contract : contracts) {
								if (contract != null) {
									contractList.add(contract);
								}
							}
						}
					}
				}else{
					//根据合同id、所属部门名称、所属职位名称查询所有待入职审批合同信息
					List<Department> departmentList = departmentService.listByDeptName(deptNameStr);
					List<Position> positionList = positionService.listByPositionName(positionNameStr);
					for (Department department : departmentList) {
						for (Position position : positionList) {
							List<Contract> contracts = contractService.listByConIdDeptIdPositionStatusId(Integer.valueOf(conIdStr), department.getDeptId(), position.getPositionId(), 16);
							for (Contract contract : contracts) {
								if (contract != null) {
									contractList.add(contract);
								}
							}
						}
					}
				}
		contractInfoUtil.setContractInfo(contractList);
		//设置分页查询结果
		PageResult pageResult = PageResultUtil.getPageResult(new PageInfo<>(contractList));
		//返回查询的部门信息
		map.put("pageResult", pageResult);
		//回显查询条件
		map.put("conIdStr", conIdStr);
		map.put("deptNameStr", deptNameStr);
		map.put("positionNameStr", positionNameStr);
		return "contract/checkEntryContractList";
	}
	
	/**
	 * 转至待离职合同审批列表页面
	 * @param request
	 * @param pageRequest
	 * @param map
	 * @return
	 */
	@RequestMapping("toCheckResignContractList.do")
	public String toCheckResignContractList(HttpServletRequest request, PageRequest pageRequest, ModelMap map){
		//查询条件信息
				String conIdStr = request.getParameter("conId"); //合同id
				String deptNameStr = request.getParameter("deptName"); //所属部门名称
				String positionNameStr = request.getParameter("positionName"); //所属职位名称
				//分页
				PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
				List<Contract> contractList = new ArrayList<>();
				//查询条件判断
				if (StringUtil.isEmpty(conIdStr) && StringUtil.isEmpty(deptNameStr) && StringUtil.isEmpty(positionNameStr)) {
					//如果查询的条件全部为空，则查询出所有待审离职批合同信息
					contractList = contractService.listByStatusId(26);
				}else if(StringUtil.isEmpty(deptNameStr) && StringUtil.isEmpty(positionNameStr)) {
					//则根据合同id查询所有待离职审批合同信息
					contractList = contractService.listByConIdStatusId(Integer.valueOf(conIdStr), 16);
				}else if(StringUtil.isEmpty(conIdStr) && StringUtil.isEmpty(positionNameStr)){
					//则根据所属部门名称查询所有待离职审批合同信息
					List<Department> departmentList = departmentService.listByDeptName(deptNameStr);
					for (Department department : departmentList) {
						List<Contract> contracts = contractService.listByDeptIdStatusId(department.getDeptId(), 26);
						for (Contract contract : contracts) {
							if (contract != null) {
								contractList.add(contract);
							}
						}
					}
				}else if(StringUtil.isEmpty(conIdStr) && StringUtil.isEmpty(deptNameStr)) {
					//则根据所属职位名称查询所有待离职审批合同信息
					List<Position> positionList = positionService.listByPositionName(positionNameStr);
					for (Position position : positionList) {
						List<Contract> contracts = contractService.listByPositionIdStatusId(position.getPositionId(), 26);
						for (Contract contract : contracts) {
							if (contract != null) {
								contractList.add(contract);
							}
						}
					}
				}else if(StringUtil.isEmpty(positionNameStr)) {
					//根据合同id，所属部门名称查询所有待离职审批合同信息
					List<Department> departmentList = departmentService.listByDeptName(deptNameStr);
					for (Department department : departmentList) {
						List<Contract> contracts = contractService.listByConIdDeptIdStatusId(Integer.valueOf(conIdStr), department.getDeptId(), 26);
						for (Contract contract : contracts) {
							if (contract != null) {
								contractList.add(contract);
							}
						}
					}
				}else if(StringUtil.isEmpty(deptNameStr) && StringUtil.isEmpty(conIdStr)) {
					//根据合同id、所属职位名称查询所有待离职审批合同信息
					List<Position> positionList = positionService.listByPositionName(positionNameStr);
					for (Position position : positionList) {
						List<Contract> contracts = contractService.listByConIdPositionIdStatusId(Integer.valueOf(conIdStr), position.getPositionId(), 26);
						for (Contract contract : contracts) {
							if (contract != null) {
								contractList.add(contract);
							}
						}
					}
				}else if(StringUtil.isEmpty(conIdStr)) {
					//根据合同所属部门名称、所属职位名称查询所有待离职审批合同信息
					List<Department> departmentList = departmentService.listByDeptName(deptNameStr);
					List<Position> positionList = positionService.listByPositionName(positionNameStr);
					for (Department department : departmentList) {
						for (Position position : positionList) {
							List<Contract> contracts = contractService.listByDeptIdPositionId(department.getDeptId(), position.getPositionId());
							for (Contract contract : contracts) {
								if (contract != null) {
									contractList.add(contract);
								}
							}
						}
					}
				}else{
					//根据合同id、所属部门名称、所属职位名称查询所有待离职审批合同信息
					List<Department> departmentList = departmentService.listByDeptName(deptNameStr);
					List<Position> positionList = positionService.listByPositionName(positionNameStr);
					for (Department department : departmentList) {
						for (Position position : positionList) {
							List<Contract> contracts = contractService.listByConIdDeptIdPositionStatusId(Integer.valueOf(conIdStr), department.getDeptId(), position.getPositionId(), 26);
							for (Contract contract : contracts) {
								if (contract != null) {
									contractList.add(contract);
								}
							}
						}
					}
				}
		contractInfoUtil.setContractInfo(contractList);
		//设置分页查询结果
		PageResult pageResult = PageResultUtil.getPageResult(new PageInfo<>(contractList));
		//返回查询的部门信息
		map.put("pageResult", pageResult);
		//回显查询条件
		map.put("conIdStr", conIdStr);
		map.put("deptNameStr", deptNameStr);
		map.put("positionNameStr", positionNameStr);
		return "contract/checkResignContractList";
	}
	
	/**
	 * 审批待入职合同信息
	 * @param request
	 * @param response
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("checkEntryContract.do")
	@ResponseBody
	public JsonCommonResult<Object> checkContract(HttpServletRequest request, HttpServletResponse response){
		//获取合同id
		String conIdStr = request.getParameter("conId");
		Contract contract = contractService.get(Integer.valueOf(conIdStr));
		//审批合同，将合同置为待入职状态
		contract.setStatusId(17);
		//设置审批人工号
		//获取当前登录系统人工号
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("session_loginUser");
		if (user == null) {
			return new JsonCommonResult<Object>("100", null, "请先登录！");
		}
		//设置入职审批合同职工人工号
		contract.setEntryCheckEmpjobid(user.getUserAccount());
		//设置入职审批时间
		contract.setEntryCheckDate(new Date());
		//更新合同信息
		int result = contractService.update(contract);
		if (result == 0) {
			return new JsonCommonResult<Object>("100", null, "审批失败");
		}
		return new JsonCommonResult<Object>("200", null, "审批成功");
	}
	
	/**
	 * 审批待离职合同信息
	 * @param request
	 * @param response
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("checkResignContract.do")
	@ResponseBody
	public JsonCommonResult<Object> checkResignContract(HttpServletRequest request, HttpServletResponse response){
		//获取合同id
		String conIdStr = request.getParameter("conId");
		Contract contract = contractService.get(Integer.valueOf(conIdStr));
		//审批合同，将合同置为终止状态
		contract.setStatusId(15);
		//设置审批人工号
		//获取当前登录系统人工号
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("session_loginUser");
		if (user == null) {
			return new JsonCommonResult<Object>("100", null, "请先登录！");
		}
		//设置离职审批合同信息人工号
		contract.setResignCheckEmpjobid(user.getUserAccount());
		//设置离职审批时间
		contract.setResignCheckDate(new Date());
		//更新合同信息
		int result = contractService.update(contract);
		if (result == 0) {
			return new JsonCommonResult<Object>("100", null, "审批失败");
		}
		
		//待审批离职合同职工的工号
		System.out.println("------审批离职合同ID："+conIdStr);
		String empJobId = employeeContractService.getByConId(Integer.valueOf(conIdStr)).get(0).getEmpJobid();
		System.out.println("------职工工号："+empJobId);
		//获取职工与对应的职位关联信息
		List<EmployeePosition> employeePositionList = employeePositionService.listByEmpJobIdPositionId(empJobId, contract.getPositionId());
		//遍历
		for (EmployeePosition employeePosition : employeePositionList) {
			//删除该职工-职位信息
			int result3 = employeePositionService.delete(employeePosition.getEpId());
			if (result3 == 0) {
				return new JsonCommonResult<Object>("100", null, "审批失败");
			}
		}
		//将职工状态置为离职状态
		Employee employee = employeeService.get(empJobId);
		employee.setStatusId(8);
		int result4 = employeeService.update(employee);
		if (result4 == 0) {
			return new JsonCommonResult<Object>("100", null, "审批失败");
		}
		
		//删除该职工对应的系统账户角色信息
		int result5 = userRoleService.deleteByUserAccount(empJobId);
		if (result5 == 0) {
			return new JsonCommonResult<Object>("100", null, "审批失败");
		}
		//删除该职工对应的系统账户信息
		int result6 = userService.delete(empJobId);
		if (result6 == 0) {
			return new JsonCommonResult<Object>("100", null, "审批失败");
		}
		
		return new JsonCommonResult<Object>("200", null, "审批成功");
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
		List<Department> departmentList = null;
		if (parentDeptId != 0) {
			//有上级部门，查询上级部门id下的所有子部门信息
			departmentList = departmentService.listByParentId(parentDeptId);
		}else {
			//没有上级部门
		}
		
		if(departmentList.size() == 0 || departmentList == null) {
			return new JsonCommonResult<List<Department>>("100",null, "无信息!");
		}
		return new JsonCommonResult<List<Department>>("200",departmentList, "请求成功！");
	}
	
	/**
	 * 转至合同详情页面
	 * @param request
	 * @param pageRequest
	 * @param map
	 * @return
	 */
	@RequestMapping("detailContract.do")
	public String detailContract(HttpServletRequest request, ModelMap map){
		String conIdStr = request.getParameter("conId");
		Contract contract = null;
		if (StringUtil.isNotEmpty(conIdStr)) {
			//如果有合同ID，则直接根据合同ID查询
			contract = contractService.get(Integer.valueOf(conIdStr));
		}else {
			//如果无合同ID，则根据职工工号，职位id，部门id查询
			String empJobId = request.getParameter("empJobId");
			String positionId = request.getParameter("positionId");
			String deptId = request.getParameter("deptId");
			
			List<EmployeeContract> empcEmployeeContractList = employeeContractService.getByEmpJobid(empJobId);
			for (EmployeeContract employeeContract : empcEmployeeContractList) {
				Contract c = contractService.get(employeeContract.getConId());
				if (c.getDeptId() == Integer.valueOf(deptId) && c.getPositionId() == Integer.valueOf(positionId)) {
					contract = c;
				}
			}
		}
		
		contractInfoUtil.setContractInfo(contract);
		map.put("contract", contract);		
		return "contract/detailContract";
	}
	
	/**
	 * 跳转至待入职合同页面
	 * @param request
	 * @param pageRequest
	 * @param map
	 * @return
	 */
	@RequestMapping("needEntryContractList.do")
	public String needEntryContractList(HttpServletRequest request, PageRequest pageRequest, ModelMap map){
		//查询条件信息
		String empNameStr = request.getParameter("empName"); //职工姓名
		String deptNameStr = request.getParameter("deptName"); //所属部门名称
		String positionNameStr = request.getParameter("positionName"); //所属职位名称
		//分页
		PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
		List<Contract> contractList = new ArrayList<>();
		//查询条件判断
		if (StringUtil.isEmpty(empNameStr) && StringUtil.isEmpty(deptNameStr) && StringUtil.isEmpty(positionNameStr)) {
			//如果查询的条件全部为空，则查询出所有待入职合同信息
			contractList = contractService.listByStatusId(17);
		}else if(StringUtil.isEmpty(deptNameStr) && StringUtil.isEmpty(positionNameStr)) {
			//则根据职工姓名查询所有待入职合同信息
			//查询出该职工对应的所有合同信息
			List<Contract> contracts = contractService.listByEmpName(empNameStr);
			//遍历找出待入职的合同
			for (Contract contract : contracts) {
				if (contract.getStatusId() == 17) {
					contractList.add(contract);
				}
			}
		}else if(StringUtil.isEmpty(empNameStr) && StringUtil.isEmpty(positionNameStr)){
			//则根据部门名称查询所有待入职合同信息
			//查询出所有部门信息
			List<Department> departments = departmentService.listByDeptName(deptNameStr);
			for (Department department : departments) {
				List<Contract> contracts = contractService.listByDeptIdStatusId(department.getDeptId(), 17);
				for (Contract contract : contracts) {
					contractList.add(contract);
				}
			}
		}else if(StringUtil.isEmpty(empNameStr) && StringUtil.isEmpty(deptNameStr)) {
			//则根据职位名称查询所有待入职合同信息
			//查询出所有职位信息
			List<Position> positionList = positionService.listByPositionName(positionNameStr);
			for (Position position : positionList) {
				List<Contract> contracts = contractService.listByPositionIdStatusId(position.getPositionId(), 17);
				for (Contract contract : contracts) {
					contractList.add(contract);
				}
			}
		}else if(StringUtil.isEmpty(positionNameStr)) {
			//则根据职工姓名、部门名称查询所有待入职合同信息
			//查询出该职工对应的所有合同信息
			List<Contract> contracts = contractService.listByEmpNameStatusId(empNameStr, 17);
			//查询出所有部门信息
			List<Department> departments = departmentService.listByDeptName(deptNameStr);
			for (Contract contract : contracts) {
				for (Department department : departments) {
					if (contract.getDeptId() == department.getDeptId()) {
						contractList.add(contract);
					}
				}
			}
		}else if(StringUtil.isEmpty(deptNameStr)) {
			//则根据职工姓名、职位名称查询所有待入职合同信息
			//查询出该职工对应的所有合同信息
			List<Contract> contracts = contractService.listByEmpNameStatusId(empNameStr, 17);
			//查询出所有职位信息
			List<Position> positionList = positionService.listByPositionName(positionNameStr);
			for (Contract contract : contracts) {
				for (Position position : positionList) {
					if (contract.getPositionId() == position.getPositionId()) {
						contractList.add(contract);
					}
				}
			}
		}else if(StringUtil.isEmpty(empNameStr)) {
			//则根据部门名称、职位名称查询所有待入职合同信息
			//查询出所有部门信息
			List<Department> departments = departmentService.listByDeptName(deptNameStr);
			//查询出所有职位信息
			List<Position> positionList = positionService.listByPositionName(positionNameStr);
			for (Department department : departments) {
				for (Position position : positionList) {
					List<Contract> contracts = contractService.listByDeptIdPositionIdStatusId(department.getDeptId(), position.getPositionId(), 17);
					for (Contract contract : contracts) {
						contractList.add(contract);
					}
				}
			}
		}else {
			//则根据职工姓名、部门名称、职位名称查询所有待入职合同信息
			//查询出所有部门信息
			List<Department> departments = departmentService.listByDeptName(deptNameStr);
			//查询出所有职位信息
			List<Position> positionList = positionService.listByPositionName(positionNameStr);
			for (Department department : departments) {
				for (Position position : positionList) {
					List<Contract> contracts = contractService.listByDeptIdPositionIdStatusId(department.getDeptId(), position.getPositionId(), 17);
					for (Contract contract : contracts) {
						if (com.lqs.hrm.util.StringUtil.isEquqls(contract.getEmpName(), empNameStr)) {
							contractList.add(contract);
						}
					}
				}
			}
		}
		contractInfoUtil.setContractInfo(contractList);
		
		//设置分页查询结果
		PageResult pageResult = PageResultUtil.getPageResult(new PageInfo<>(contractList));
		//返回查询的部门信息
		map.put("pageResult", pageResult);
		//回显查询条件
		map.put("empNameStr", empNameStr);
		map.put("deptNameStr", deptNameStr);
		map.put("positionNameStr", positionNameStr);
		
		return "employee/needEntryContractList";
	}
	
	/**
	 * 跳转至已入职合同页面
	 * @param request
	 * @param pageRequest
	 * @param map
	 * @return
	 */
	@RequestMapping("alreadyEntryContractList.do")
	public String alreadyEntryContractList(HttpServletRequest request, PageRequest pageRequest, ModelMap map){
		//查询条件信息
		String empNameStr = request.getParameter("empName"); //职工姓名
		String deptNameStr = request.getParameter("deptName"); //所属部门名称
		String positionNameStr = request.getParameter("positionName"); //所属职位名称
		//分页
				PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
				List<Contract> contractList = new ArrayList<>();
				//查询条件判断
				if (StringUtil.isEmpty(empNameStr) && StringUtil.isEmpty(deptNameStr) && StringUtil.isEmpty(positionNameStr)) {
					//如果查询的条件全部为空，则查询出所有已入职合同信息
					contractList = contractService.listByStatusId(14);
				}else if(StringUtil.isEmpty(deptNameStr) && StringUtil.isEmpty(positionNameStr)) {
					//则根据职工姓名查询所有已入职合同信息
					//查询出该职工对应的所有合同信息
					List<Contract> contracts = contractService.listByEmpName(empNameStr);
					//遍历找出已入职的合同
					for (Contract contract : contracts) {
						if (contract.getStatusId() == 14) {
							contractList.add(contract);
						}
					}
				}else if(StringUtil.isEmpty(empNameStr) && StringUtil.isEmpty(positionNameStr)){
					//则根据部门名称查询所有已入职合同信息
					//查询出所有部门信息
					List<Department> departments = departmentService.listByDeptName(deptNameStr);
					for (Department department : departments) {
						List<Contract> contracts = contractService.listByDeptIdStatusId(department.getDeptId(), 14);
						for (Contract contract : contracts) {
							contractList.add(contract);
						}
					}
				}else if(StringUtil.isEmpty(empNameStr) && StringUtil.isEmpty(deptNameStr)) {
					//则根据职位名称查询所有已入职合同信息
					//查询出所有职位信息
					List<Position> positionList = positionService.listByPositionName(positionNameStr);
					for (Position position : positionList) {
						List<Contract> contracts = contractService.listByPositionIdStatusId(position.getPositionId(), 14);
						for (Contract contract : contracts) {
							contractList.add(contract);
						}
					}
				}else if(StringUtil.isEmpty(positionNameStr)) {
					//则根据职工姓名、部门名称查询所有已入职合同信息
					//查询出该职工对应的所有合同信息
					List<Contract> contracts = contractService.listByEmpNameStatusId(empNameStr, 14);
					//查询出所有部门信息
					List<Department> departments = departmentService.listByDeptName(deptNameStr);
					for (Contract contract : contracts) {
						for (Department department : departments) {
							if (contract.getDeptId() == department.getDeptId()) {
								contractList.add(contract);
							}
						}
					}
				}else if(StringUtil.isEmpty(deptNameStr)) {
					//则根据职工姓名、职位名称查询所有已入职合同信息
					//查询出该职工对应的所有合同信息
					List<Contract> contracts = contractService.listByEmpNameStatusId(empNameStr, 14);
					//查询出所有职位信息
					List<Position> positionList = positionService.listByPositionName(positionNameStr);
					for (Contract contract : contracts) {
						for (Position position : positionList) {
							if (contract.getPositionId() == position.getPositionId()) {
								contractList.add(contract);
							}
						}
					}
				}else if(StringUtil.isEmpty(empNameStr)) {
					//则根据部门名称、职位名称查询所有已入职合同信息
					//查询出所有部门信息
					List<Department> departments = departmentService.listByDeptName(deptNameStr);
					//查询出所有职位信息
					List<Position> positionList = positionService.listByPositionName(positionNameStr);
					for (Department department : departments) {
						for (Position position : positionList) {
							List<Contract> contracts = contractService.listByDeptIdPositionIdStatusId(department.getDeptId(), position.getPositionId(), 14);
							for (Contract contract : contracts) {
								contractList.add(contract);
							}
						}
					}
				}else {
					//则根据职工姓名、部门名称、职位名称查询所有已入职合同信息
					//查询出所有部门信息
					List<Department> departments = departmentService.listByDeptName(deptNameStr);
					//查询出所有职位信息
					List<Position> positionList = positionService.listByPositionName(positionNameStr);
					for (Department department : departments) {
						for (Position position : positionList) {
							List<Contract> contracts = contractService.listByDeptIdPositionIdStatusId(department.getDeptId(), position.getPositionId(), 14);
							for (Contract contract : contracts) {
								if (com.lqs.hrm.util.StringUtil.isEquqls(contract.getEmpName(), empNameStr)) {
									contractList.add(contract);
								}
							}
						}
					}
				}
				contractInfoUtil.setContractInfo(contractList);
				
				//设置分页查询结果
				PageResult pageResult = PageResultUtil.getPageResult(new PageInfo<>(contractList));
				//返回查询的部门信息
				map.put("pageResult", pageResult);
				//回显查询条件
				map.put("empNameStr", empNameStr);
				map.put("deptNameStr", deptNameStr);
				map.put("positionNameStr", positionNameStr);
		
		return "employee/alreadyEntryContractList";
	}
	
	/**
	 * 转至我的合同页面
	 * @param request
	 * @param pageRequest
	 * @param map
	 * @return
	 */
	@RequestMapping("toMyContractList.do")
	public String myContractList(HttpServletRequest request, PageRequest pageRequest, ModelMap map){
		//分页
		PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
		//获得当前登录系统人信息
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("session_loginUser");
		//获取当前登录系统人工号
		String empJobIdStr = user.getUserAccount();
				
		//查询的合同id信息
		String conIdStr = request.getParameter("conId");
		//查询的合同状态信息
		String statusIdStr = request.getParameter("statusId");
		
		List<EmployeeContract> employeeContractList = new ArrayList<>();
		if (StringUtil.isEmpty(conIdStr) && StringUtil.isEmpty(statusIdStr)) {
			//获取当前登录系统人的所有职工合同信息
			employeeContractList = employeeContractService.getByEmpJobid(empJobIdStr);
		}else if(StringUtil.isEmpty(statusIdStr)) {
			//获取当前登录系统人的指定合同id的职工合同信息
			employeeContractList = employeeContractService.getByConIdEmpJobid(Integer.valueOf(conIdStr), empJobIdStr);
		}else if(StringUtil.isEmpty(conIdStr)) {
			//获取当前登录系统人的指定状态id的职工合同信息
			List<EmployeeContract> contracts = employeeContractService.getByEmpJobid(empJobIdStr);
			//遍历
			for (EmployeeContract ec : contracts) {
				if (contractService.get(ec.getConId()).getStatusId() == Integer.valueOf(statusIdStr)) {
					//如果状态id相同，则添加进去
					employeeContractList.add(ec);
				}
			}
		}else {
			//获取当前登录系统人的指定合同id、状态id的职工合同信息
			List<EmployeeContract> contracts = employeeContractService.getByConIdEmpJobid(Integer.valueOf(conIdStr), empJobIdStr);
			//遍历
			for (EmployeeContract ec : contracts) {
				if (contractService.get(ec.getConId()).getStatusId() == Integer.valueOf(statusIdStr)) {
					//如果状态id相同，则添加进去
					employeeContractList.add(ec);
				}
			}
		}
		//储存该职工的所有合同信息
		List<Contract> contractList = new ArrayList<>();
		for(EmployeeContract employeeContract : employeeContractList) {
			contractList.add(contractService.get(employeeContract.getConId()));
		}
		contractInfoUtil.setContractInfo(contractList);
		//设置分页查询结果
		PageResult pageResult = PageResultUtil.getPageResult(new PageInfo<>(contractList));
		//合同状态信息：合同类型为7
		List<Status> statusList = statusService.list(7);
		//返回查询的合同状态信息
		map.put("statusList", statusList);
		//返回查询的部门信息
		map.put("pageResult", pageResult);
		
		//回显查询条件
		map.put("conIdStr", conIdStr);
		map.put("statusIdStr", statusIdStr);
				
		return "contract/myContractList";
	}
	
}

