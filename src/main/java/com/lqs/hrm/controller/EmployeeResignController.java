package com.lqs.hrm.controller;

import java.security.KeyStore.Entry;
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

import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.lqs.hrm.entity.Contract;
import com.lqs.hrm.entity.Department;
import com.lqs.hrm.entity.DepartmentLevel;
import com.lqs.hrm.entity.Employee;
import com.lqs.hrm.entity.EmployeeContract;
import com.lqs.hrm.entity.EmployeePosition;
import com.lqs.hrm.entity.EmployeeResign;
import com.lqs.hrm.entity.EntryCount;
import com.lqs.hrm.entity.Position;
import com.lqs.hrm.entity.Status;
import com.lqs.hrm.entity.User;
import com.lqs.hrm.json.JsonCommonResult;
import com.lqs.hrm.json.JsonPageResult;
import com.lqs.hrm.service.EmployeePositionService;
import com.lqs.hrm.service.impl.ContractServiceImpl;
import com.lqs.hrm.service.impl.DepartmentServiceImpl;
import com.lqs.hrm.service.impl.EmployeeContractServiceImpl;
import com.lqs.hrm.service.impl.EmployeePositionServiceImpl;
import com.lqs.hrm.service.impl.EmployeeResignServiceImpl;
import com.lqs.hrm.service.impl.EmployeeServiceImpl;
import com.lqs.hrm.service.impl.EntryCountServiceImpl;
import com.lqs.hrm.service.impl.PositionServiceImpl;
import com.lqs.hrm.service.impl.StatusServiceImpl;
import com.lqs.hrm.service.impl.UserServiceImpl;
import com.lqs.hrm.util.PageRequest;
import com.lqs.hrm.util.PageResult;
import com.lqs.hrm.util.PageResultUtil;
import com.lqs.hrm.util.entity.ContractInfoUtil;
import com.lqs.hrm.util.entity.EmployeeInfoUtil;
import com.lqs.hrm.util.entity.EmployeeResignInfoUtil;

/**
 * 职工离职信息Controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("employeeResign")
public class EmployeeResignController {
	@Autowired
	EmployeeResignServiceImpl employeeResignService;
	@Autowired
	private DepartmentServiceImpl departmentService;
	@Autowired
	private StatusServiceImpl statusService;
	@Autowired
	private ContractServiceImpl contractService;
	@Autowired
	private PositionServiceImpl positionService;
	@Autowired
	private EmployeeServiceImpl employeeService;
	@Autowired
	private EmployeePositionServiceImpl employeePositionService;
	@Autowired
	private EmployeeInfoUtil employeeInfoUtil;
	@Autowired
	private EmployeeResignInfoUtil employeeResignInfoUtil;
	@Autowired
	private EmployeeContractServiceImpl employeeContractService;
	@Autowired
	private ContractInfoUtil contractInfoUtil;
	
	/**
	 * 查询部门并跳转至所有职工离职申请单列表页面
	 * @param request
	 * @param pageRequest
	 * @param map
	 * @return
	 */
	@RequestMapping("toEmployeeResignList.do")
	public String toEmployeeResignList(HttpServletRequest request, PageRequest pageRequest, ModelMap map){
		//查询条件信息
		//离职id
		String resignIdStr = request.getParameter("resignId");
		//职工工号
		String empJobIdStr = request.getParameter("empJobId");
		//离职状态
		String statusIdStr = request.getParameter("statusId");
		//分页
		PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
		List<EmployeeResign> employeeResignList = new ArrayList<>();
		
		//查询条件判断
		if (StringUtil.isEmpty(resignIdStr) && StringUtil.isEmpty(empJobIdStr) && StringUtil.isEmpty(statusIdStr)) {
			//如果查询的条件全部为空，则查询出所有离职信息
			employeeResignList = employeeResignService.listByNo();
		}else if(StringUtil.isEmpty(empJobIdStr) && StringUtil.isEmpty(statusIdStr)) {
			//则根据离职id查询
			EmployeeResign employeeResign = employeeResignService.get(Integer.valueOf(resignIdStr));
			if (employeeResign != null) {
				employeeResignList.add(employeeResign);
			}
		}else if(StringUtil.isEmpty(resignIdStr) && StringUtil.isEmpty(statusIdStr)){
			//则根据职工工号查询
			employeeResignList = employeeResignService.listByEmpJobId(empJobIdStr);
		}else if(StringUtil.isEmpty(resignIdStr) && StringUtil.isEmpty(empJobIdStr)) {
			//根据离职状态查询
			employeeResignList = employeeResignService.listByStatusId(Integer.valueOf(statusIdStr));
		}else if(StringUtil.isEmpty(statusIdStr)) {
			//根据离职id，职工工号查询
			employeeResignList = employeeResignService.listByResignIdEmpJobId(Integer.valueOf(resignIdStr), empJobIdStr);
		}else if(StringUtil.isEmpty(empJobIdStr)) {
			//根据离职id，离职状态查询
			employeeResignList = employeeResignService.listByResignIdStatusId(Integer.valueOf(resignIdStr), Integer.valueOf(statusIdStr));
		}else if(StringUtil.isEmpty(statusIdStr)) {
			//根据职工工号,离职状态查询
			employeeResignList = employeeResignService.listByEmpJobIdStatusId(empJobIdStr, Integer.valueOf(statusIdStr));
		}else {
			//根据离职id，职工工号,离职状态查询
			employeeResignList = employeeResignService.listByResignIdEmpJobIdStatusId(Integer.valueOf(resignIdStr), empJobIdStr, Integer.valueOf(statusIdStr));
		}
		employeeResignInfoUtil.setEmployeeResignInfo(employeeResignList);
		//设置分页查询结果
		PageResult pageResult = PageResultUtil.getPageResult(new PageInfo<>(employeeResignList));
		//返回查询的部门信息
		map.put("pageResult", pageResult);
		//回显查询条件
		map.put("resignIdStr", resignIdStr);
		map.put("empJobIdStr", empJobIdStr);
		map.put("statusIdStr", statusIdStr);
		
		//离职申请单状态信息:类型为12
		List<Status> statusList = statusService.list(12);
		//返回查询的职工状态信息
		map.put("statusList", statusList);
		return "employee/employeeResignList";
	}
	
	/**
	 * 查询部门并跳转至所有待审批离职申请单列表页面
	 * 待审批状态id为：18
	 * @param request
	 * @param pageRequest
	 * @param map
	 * @return
	 */
	@RequestMapping("toEmployeeResignCheckList.do")
	public String toEmployeeResignCheckList(HttpServletRequest request, PageRequest pageRequest, ModelMap map){
		//查询条件信息
		//离职id
		String resignIdStr = request.getParameter("resignId");
		//职工工号
		String empJobIdStr = request.getParameter("empJobId");
		//分页
		PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
		List<EmployeeResign> employeeResignList = new ArrayList<>();
		
		//查询条件判断
		if (StringUtil.isEmpty(empJobIdStr) && StringUtil.isEmpty(resignIdStr)) {
			//如果查询的条件全部为空，则查询出所有待审批离职申请信息
			employeeResignList = employeeResignService.listByStatusId(18);
		}else if(StringUtil.isEmpty(empJobIdStr)) {
			//则根据离职id查询
			EmployeeResign employeeResign = employeeResignService.get(Integer.valueOf(resignIdStr));
			if (employeeResign != null) {
				employeeResignList.add(employeeResign);
			}
		}else if(StringUtil.isEmpty(resignIdStr)) {
			//根据职工工号查询
			employeeResignList = employeeResignService.listByEmpJobIdStatusId(empJobIdStr, 18);
		}else{
			//根据离职id，职工工号查询
			employeeResignList = employeeResignService.listByResignIdEmpJobIdStatusId(Integer.valueOf(resignIdStr), empJobIdStr, 18);
		}
		employeeResignInfoUtil.setEmployeeResignInfo(employeeResignList);
		//设置分页查询结果
		PageResult pageResult = PageResultUtil.getPageResult(new PageInfo<>(employeeResignList));
		//返回查询的部门信息
		map.put("pageResult", pageResult);
		//回显查询条件
		map.put("resignIdStr", resignIdStr);
		map.put("empJobIdStr", empJobIdStr);
		
		//离职申请单状态信息:类型为12
		List<Status> statusList = statusService.list(12);
		//返回查询的职工状态信息
		map.put("statusList", statusList);
		return "employee/employeeResignCheckList";
	}
	
	/**
	 * 返回查询的指定离职申请单信息
	 * 根据职工工号、职工姓名，部门名称、职工状态查询
	 * @param request
	 * @param pageRequest
	 * @return
	 */
	@RequestMapping("query.do")
	@ResponseBody
	public JsonPageResult query(HttpServletRequest request, PageRequest pageRequest) {
		//查询条件信息
				//离职id
				String resignIdStr = request.getParameter("resignId");
				//职工工号
				String empJobIdStr = request.getParameter("empJobId");
				//离职状态
				String statusIdStr = request.getParameter("statusId");
				//分页
				PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
				List<EmployeeResign> employeeResignList = new ArrayList<>();
				
				//查询条件判断
				if (StringUtil.isEmpty(empJobIdStr) && StringUtil.isEmpty(resignIdStr) && StringUtil.isEmpty(empJobIdStr) && StringUtil.isEmpty(statusIdStr)) {
					//如果查询的条件全部为空，则查询出所有离职信息
					employeeResignList = employeeResignService.listByNo();
				}else if(StringUtil.isEmpty(empJobIdStr) && StringUtil.isEmpty(statusIdStr)) {
					//则根据离职id查询
					EmployeeResign employeeResign = employeeResignService.get(Integer.valueOf(resignIdStr));
					if (employeeResign != null) {
						employeeResignList.add(employeeResign);
					}
				}else if(StringUtil.isEmpty(resignIdStr) && StringUtil.isEmpty(statusIdStr)){
					//则根据职工工号查询
					employeeResignList = employeeResignService.listByEmpJobId(empJobIdStr);
				}else if(StringUtil.isEmpty(resignIdStr) && StringUtil.isEmpty(empJobIdStr)) {
					//根据离职状态查询
					employeeResignList = employeeResignService.listByStatusId(Integer.valueOf(statusIdStr));
				}else if(StringUtil.isEmpty(statusIdStr)) {
					//根据离职id，职工工号查询
					employeeResignList = employeeResignService.listByResignIdEmpJobId(Integer.valueOf(resignIdStr), empJobIdStr);
				}else if(StringUtil.isEmpty(empJobIdStr)) {
					//根据离职id，离职状态查询
					employeeResignList = employeeResignService.listByResignIdStatusId(Integer.valueOf(resignIdStr), Integer.valueOf(statusIdStr));
				}else if(StringUtil.isEmpty(statusIdStr)) {
					//根据职工工号,离职状态查询
					employeeResignList = employeeResignService.listByEmpJobIdStatusId(empJobIdStr, Integer.valueOf(statusIdStr));
				}else {
					//根据离职id，职工工号,离职状态查询
					employeeResignList = employeeResignService.listByResignIdEmpJobIdStatusId(Integer.valueOf(resignIdStr), empJobIdStr, Integer.valueOf(statusIdStr));
				}
		
		if (employeeResignList == null) {
			return new JsonPageResult("100", null, "没有数据！");
		}
		employeeResignInfoUtil.setEmployeeResignInfo(employeeResignList);
		return new JsonPageResult("200", PageResultUtil.getPageResult(new PageInfo<>(employeeResignList)), "请求成功！");
	}
		
	/**
	 * 获取指定id的离职信息
	 * @param empJobid
	 * @return
	 */
	@RequestMapping("get.do")
	@ResponseBody
	public JsonCommonResult<EmployeeResign> get(HttpServletRequest request) {
		String resignIdStr = request.getParameter("resignId");
		EmployeeResign employeeResign = null;
		if (StringUtil.isNotEmpty(resignIdStr)) {
			employeeResign =  employeeResignService.get(Integer.valueOf(resignIdStr));
		}
	    
		if (employeeResign != null) {
			//设置离职实体类信息
			employeeResignInfoUtil.setEmployeeResignInfo(employeeResign);
			//返回查询结果
			return new JsonCommonResult<EmployeeResign>("200", employeeResign, "获取成功！");
		}
		return new JsonCommonResult<EmployeeResign>("100", null, "获取数据失败！");
	}
	
	/**
	 * 转至离职申请单信息添加页面
	 * @param request
	 * @param pageRequest
	 * @param map
	 * @return
	 */
	@RequestMapping("toAddEmployeeResignInfo.do")
	public String toAddEmployeeResignInfo(HttpServletRequest request, ModelMap map){
		//获取当前登录系统人工号
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("session_loginUser");
		//得到职工信息
		Employee employee = employeeService.get(user.getUserAccount());
		employeeInfoUtil.setEmployeeInfo(employee);
		List<Department> departments = employee.getDepartmentList();
		System.out.println("职工部门信息："+departments);
		for (Department department : departments) {
			System.out.println("部门名称："+department.getDeptName());
		}
		//得到职工所属部门信息
		map.put("employee", employee);
		return "employee/addEmployeeResignInfo";
	}
	
	/**
	 * 转至我的离职申请单列表页面
	 * @param request
	 * @param pageRequest
	 * @param map
	 * @return
	 */
	@RequestMapping("toMyEmployeeResignList.do")
	public String toMyEmployeeResignList(HttpServletRequest request, PageRequest pageRequest, ModelMap map){
		//获取当前登录系统人工号
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("session_loginUser");
		//得到职工信息
		Employee employee = employeeService.get(user.getUserAccount());
		
		//查询条件信息
				//离职id
				String resignIdStr = request.getParameter("resignId");
				//离职状态
				String statusIdStr = request.getParameter("statusId");
				//分页
				PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
				List<EmployeeResign> employeeResignList = new ArrayList<>();
				
				//查询条件判断
				if (StringUtil.isEmpty(resignIdStr) && StringUtil.isEmpty(statusIdStr)) {
					//如果查询的条件全部为空，则查询出我的所有离职信息
					employeeResignList = employeeResignService.listByEmpJobId(employee.getEmpJobid());
				}else if(StringUtil.isEmpty(statusIdStr)) {
					employeeResignList = employeeResignService.listByResignIdEmpJobId(Integer.valueOf(resignIdStr), employee.getEmpJobid());
				}else if(StringUtil.isEmpty(resignIdStr)){
					//则根据离职状态查询
					employeeResignList = employeeResignService.listByEmpJobIdStatusId(employee.getEmpJobid(), Integer.valueOf(statusIdStr));
				}else {
					//根据离职id，离职状态查询
					employeeResignList = employeeResignService.listByResignIdEmpJobIdStatusId(Integer.valueOf(resignIdStr), employee.getEmpJobid(), Integer.valueOf(statusIdStr));
				}
				employeeResignInfoUtil.setEmployeeResignInfo(employeeResignList);
				//设置分页查询结果
				PageResult pageResult = PageResultUtil.getPageResult(new PageInfo<>(employeeResignList));
		
		
		//离职申请单状态信息:类型为12
		List<Status> statusList = statusService.list(12);
		
		//回显查询条件
		map.put("resignIdStr", resignIdStr);
		map.put("statusIdStr", statusIdStr);
				
		//返回查询的职工状态信息
		map.put("statusList", statusList);
		map.put("pageResult", pageResult);
		return "employee/myEmployeeResignList";
	}
	
	/**
	 * 返回查询的指定离职申请单信息
	 * 根据职工工号、职工姓名，部门名称、职工状态查询
	 * @param request
	 * @param pageRequest
	 * @return
	 */
	@RequestMapping("queryMy.do")
	@ResponseBody
	public JsonPageResult queryMy(HttpServletRequest request, PageRequest pageRequest) {
		//获取当前登录系统人工号
				HttpSession session = request.getSession();
				User user = (User) session.getAttribute("session_loginUser");
				//得到职工信息
				Employee employee = employeeService.get(user.getUserAccount());
				
				//查询条件信息
						//离职id
						String resignIdStr = request.getParameter("resignId");
						//离职状态
						String statusIdStr = request.getParameter("statusId");
						//分页
						PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
						List<EmployeeResign> employeeResignList = new ArrayList<>();
						
						//查询条件判断
						if (StringUtil.isEmpty(resignIdStr) && StringUtil.isEmpty(statusIdStr)) {
							//如果查询的条件全部为空，则查询出我的所有离职信息
							employeeResignList = employeeResignService.listByEmpJobId(employee.getEmpJobid());
						}else if(StringUtil.isEmpty(statusIdStr)) {
							employeeResignList = employeeResignService.listByResignIdEmpJobId(Integer.valueOf(resignIdStr), employee.getEmpJobid());
						}else if(StringUtil.isEmpty(resignIdStr)){
							//则根据离职状态查询
							employeeResignList = employeeResignService.listByEmpJobIdStatusId(employee.getEmpJobid(), Integer.valueOf(statusIdStr));
						}else {
							//根据离职id，离职状态查询
							employeeResignList = employeeResignService.listByResignIdEmpJobIdStatusId(Integer.valueOf(resignIdStr), employee.getEmpJobid(), Integer.valueOf(statusIdStr));
						}
						employeeResignInfoUtil.setEmployeeResignInfo(employeeResignList);
						//设置分页查询结果
						PageResult pageResult = PageResultUtil.getPageResult(new PageInfo<>(employeeResignList));
				
		
		if (employeeResignList == null) {
			return new JsonPageResult("100", null, "没有数据！");
		}
		employeeResignInfoUtil.setEmployeeResignInfo(employeeResignList);
		return new JsonPageResult("200", PageResultUtil.getPageResult(new PageInfo<>(employeeResignList)), "请求成功！");
	}
	
	/**
	 * 转至离职申请单详细信息页面
	 * @param request
	 * @param pageRequest
	 * @param map
	 * @return
	 */
	@RequestMapping("toEmployeeResignDetail.do")
	public String toEmployeeResignDetail(HttpServletRequest request, ModelMap map){
		//获取到申请单id
		String resignIdStr = request.getParameter("resignId");
		EmployeeResign employeeResign = null;
		if (StringUtil.isNotEmpty(resignIdStr)) {
			employeeResign = employeeResignService.get(Integer.valueOf(resignIdStr));
		}
		employeeResignInfoUtil.setEmployeeResignInfo(employeeResign);
		
		map.put("employeeResign", employeeResign);
		return "employee/employeeResignDetail";
	}
	
	/**
	 * 职工离职申请单提交
	 * @param request
	 * @param response
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("employeeResignSubmit.do")
	@ResponseBody
	public JsonCommonResult<Object> employeeResign(HttpServletRequest request, HttpServletResponse response) throws ParseException {
		Map<String, Object> resultMap = new HashMap<>();
		//获取职工工号
		String empJobIdStr = request.getParameter("empJobId");
		//离职部门id
		String deptIdStr = request.getParameter("deptId");
		//离职职位id
		String positionIdStr = request.getParameter("positionId");
		//离职日期
		String resignDate = request.getParameter("resignDate");
		//离职原因
		String resignReason = request.getParameter("resignReason");
		
		EmployeeResign employeeResign = new EmployeeResign();
		employeeResign.setEmpJobid(empJobIdStr);
		employeeResign.setDeptId(Integer.valueOf(deptIdStr));
		employeeResign.setPositionId(Integer.valueOf(positionIdStr));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		employeeResign.setResignDate(format.parse(resignDate));
		employeeResign.setResignReason(resignReason);
		
		//设置申请日期
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		employeeResign.setApplyDate(format2.parse(format2.format(new Date())));
		
		//设置离职申请单状态为待审核状态
		employeeResign.setStatusId(18);
		//设置操作人工号
		
		int result = employeeResignService.add(employeeResign);
		if (result == 0) {
			return new JsonCommonResult<Object>("100", null, "申请失败");
		}
		return new JsonCommonResult<Object>("200", null, "申请成功");
	}
	
	/**
	 * 职工离职申请单审核
	 * @param request
	 * @param response
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("employeeResignCheck.do")
	@ResponseBody
	public JsonCommonResult<Object> employeeResignCheck(HttpServletRequest request, HttpServletResponse response) throws ParseException {
		Map<String, Object> resultMap = new HashMap<>();
		//获取申请单ID
		String resignIdStr = request.getParameter("resignId");
		//获取离职申请单
		EmployeeResign employeeResign = employeeResignService.get(Integer.valueOf(resignIdStr));
		//设置该离职申请单状态为已审批：
		employeeResign.setStatusId(19);
		//更新该离职申请单详细
		int result1 = employeeResignService.update(employeeResign);
		if (result1 == 0) {
			return new JsonCommonResult<Object>("100", null, "审核失败");
		}
		//获取该职工对应的合同信息
		List<EmployeeContract> employeeContractList = employeeContractService.getByEmpJobid(employeeResign.getEmpJobid());
		//查询到该职工对应的在合同期内的合同
		//遍历职工-合同信息
		//System.out.println("合同列表大小："+employeeContractList.size());
		for (EmployeeContract employeeContract : employeeContractList) {
			Contract contract = contractService.get(employeeContract.getConId());
			//System.out.println("职工工号："+employeeContract.getEmpJobid());
			//如果该份合同属于该职工的该职位，且在正常状态下，即在合同期内
			if (contract.getPositionId() == employeeResign.getPositionId() && contract.getStatusId() == 14) {
				//System.out.println("找到合同信息");
				//将该份合同状态置为待离职
				contract.setStatusId(26);
				//设置离职原因
				contract.setEndReason(employeeResign.getResignReason());
				//更新该份合同信息
				int result2 = contractService.update(contract);
				if (result2 == 0) {
					return new JsonCommonResult<Object>("100", null, "审核失败");
				}
				break;
			}
		}
		return new JsonCommonResult<Object>("200", null, "审核成功");
	}
	
}
