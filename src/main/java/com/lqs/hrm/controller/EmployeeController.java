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
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.lqs.hrm.entity.Contract;
import com.lqs.hrm.entity.Department;
import com.lqs.hrm.entity.Employee;
import com.lqs.hrm.entity.EmployeeContract;
import com.lqs.hrm.entity.EmployeeDepartment;
import com.lqs.hrm.entity.EmployeeEntry;
import com.lqs.hrm.entity.EmployeePosition;
import com.lqs.hrm.entity.Position;
import com.lqs.hrm.entity.Status;
import com.lqs.hrm.entity.User;
import com.lqs.hrm.json.JsonCommonResult;
import com.lqs.hrm.service.EmployeePositionService;
import com.lqs.hrm.service.impl.ContractServiceImpl;
import com.lqs.hrm.service.impl.DepartmentServiceImpl;
import com.lqs.hrm.service.impl.EmployeeContractServiceImpl;
import com.lqs.hrm.service.impl.EmployeeDepartmentServiceImpl;
import com.lqs.hrm.service.impl.EmployeeEntryServiceImpl;
import com.lqs.hrm.service.impl.EmployeePositionServiceImpl;
import com.lqs.hrm.service.impl.EmployeeServiceImpl;
import com.lqs.hrm.service.impl.PositionServiceImpl;
import com.lqs.hrm.service.impl.StatusServiceImpl;
import com.lqs.hrm.service.impl.UserServiceImpl;
import com.lqs.hrm.util.PageRequest;
import com.lqs.hrm.util.PageResult;
import com.lqs.hrm.util.PageResultUtil;

/**
 * 职工信息Controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("employee")
public class EmployeeController {
	@Autowired
	EmployeeServiceImpl employeeService;
	@Autowired
	private DepartmentServiceImpl departmentService;
	@Autowired
	private StatusServiceImpl statusService;
	@Autowired
	private EmployeeDepartmentServiceImpl employeeDepartmentService;
	@Autowired
	private ContractServiceImpl contractService;
	@Autowired
	private PositionServiceImpl positionService;
	@Autowired
	private EmployeeContractServiceImpl employeeContractService;
	@Autowired
	private EmployeeEntryServiceImpl employeeEntryService;
	@Autowired
	private EmployeePositionServiceImpl employeePositionService;
	
	/**
	 * 获取指定职工工号的职工信息
	 * @param empJobid
	 * @return
	 */
	@RequestMapping("get.do")
	@ResponseBody
	public JsonCommonResult<Employee> get(String empJobid) {
		Employee employee =  employeeService.get(empJobid);
		if (empJobid != null) {
			//获取部门信息
			List<EmployeeDepartment> list = employeeDepartmentService.get(empJobid);
			//list
			List<Integer> deptIdList = new ArrayList<Integer>();
			List<String> deptNameList = new ArrayList<String>();
			for (EmployeeDepartment employeeDepartment : list) {
				//设置职工所属部门信息
				deptIdList.add(employeeDepartment.getDeptId());
				deptNameList.add(departmentService.get(employeeDepartment.getDeptId()).getDeptName());
			}
			//设置职工所属部门信息
			employee.setDeptIdList(deptIdList);
			employee.setDeptNameList(deptNameList);
			//设置职工状态名称
			Status status = statusService.get(1);
			employee.setStatusName(statusService.get(employee.getStatusId()).getStatusName());
			return new JsonCommonResult<Employee>("200", employee, "获取成功！");
		}
		return new JsonCommonResult<Employee>("100", null, "获取数据失败！");
	}
	
	/**
	 * 点击入职按钮后转至职工信息添加页面
	 * @param request
	 * @param pageRequest
	 * @param map
	 * @return
	 */
	@RequestMapping("toAddEmployeeInfo.do")
	public String toAddEmployeeInfo(HttpServletRequest request, ModelMap map){
		//获取到合同id
		String conIdStr = request.getParameter("conId");
		Contract contract = null;
		if (StringUtil.isNotEmpty(conIdStr)) {
			contract = contractService.get(Integer.valueOf(conIdStr));
		}
		setContractInfo(contract);
		String empBirthdayStr = com.lqs.hrm.util.StringUtil.getBirthday(contract.getEmpIdcard());
		
		List<Status> statusList = statusService.list(5);
		
		map.put("contract", contract);
		map.put("empBirthdayStr", empBirthdayStr);
		map.put("statusList", statusList);
		return "employee/addEmployeeInfo";
	}
	
	/**
	 * 设置查询出来的合同实体类信息
	 * @param departmentList
	 */
	public void setContractInfo(Contract contract) {
		if (contract != null) {
			//设置职工性别描述
			contract.setEmpSexName(contract.getEmpSex()==0?"女":"男");
			//设置所属部门名称
			contract.setDeptName(departmentService.get(contract.getDeptId()).getDeptName());
			//设置所属职位名称
			contract.setPositionName(positionService.get(contract.getPositionId()).getPositionName());
			//设置状态名称
			contract.setStatusName(statusService.get(contract.getStatusId()).getStatusName());
			//设置录入人名称
			if (StringUtil.isNotEmpty(contract.getAddEmpjobid())) {
				contract.setAddEmpName(employeeService.get(contract.getAddEmpjobid()).getEmpName());
			}
			//设置审批人名称
			if (StringUtil.isNotEmpty(contract.getCheckEmpjobid())) {
				contract.setAddEmpName(employeeService.get(contract.getCheckEmpjobid()).getEmpName());
			}
		}
	}
	
	/**
	 * 职工信息添加
	 * @param request
	 * @param pageRequest
	 * @param map
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("addEmployeeInfo.do")
	@ResponseBody
	public JsonCommonResult<Object> toAddContract(HttpServletRequest request, ModelMap map) throws ParseException{
		//获取到合同id
		String conIdStr = request.getParameter("conId");
		//职工姓名
		String empNameStr = request.getParameter("empName");
		//职工性别
		String empSexStr = request.getParameter("empSex");
		//职工所属部门
		String deptIdStr = request.getParameter("deptId");
		//职工所属职位
		String positionIdStr = request.getParameter("positionId");
		//职工出生日期
		String empBirthdayStr = request.getParameter("empBirthday");
		//职工身份证号码
		String empIdcardStr = request.getParameter("empIdcard");
		//职工联系电话
		String empPhoneStr = request.getParameter("empPhone");
		//职工邮箱
		String empEmailStr = request.getParameter("empEmail");
		//职工学历
		String empEducationStr = request.getParameter("empEducation");
		//职工家庭住址
		String empAddressStr = request.getParameter("empAddress");
		//职工状态
		String statusIdStr = request.getParameter("statusId");
		//备注
		String empNoteStr = request.getParameter("empNote");
		
		//获取当前职工是今日第几个入职的职工
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
		//00:00:00
		Date zeroDate = format.parse(format2.format(date)+" 00:00:00");
		//23:59:59
		Date twentyFourDate = format.parse(format2.format(date)+" 23:59:59");
		EmployeeEntry employeeEntry = employeeEntryService.get(zeroDate, twentyFourDate).get(0);
		//今日入职员工数量
		int entryEmpnum = employeeEntry.getEntryEmpnum();	
		//生成职工工号
		String empJobid = com.lqs.hrm.util.StringUtil.getEmpJobId(new Date(), entryEmpnum+1);
		
		Employee employee = new Employee();
		employee.setEmpJobid(empJobid);
		employee.setEmpName(empNameStr);
		employee.setEmpSex(Integer.valueOf(empSexStr));
		employee.setEmpBirthday(format2.parse(empBirthdayStr));
		employee.setEmpIdcard(empIdcardStr);
		employee.setEmpPhone(empPhoneStr);
		employee.setEmpEmail(empEmailStr);
		employee.setEmpEducation(empEducationStr);
		employee.setEmpAddress(empAddressStr);
		employee.setEntryTime(new Date());
		employee.setStatusId(Integer.valueOf(statusIdStr));
		employee.setEmpNote(empNoteStr);
		employee.setLastOperatorDate(new Date());
		//获取当前登录系统人工号
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("session_loginUser");
		employee.setOperatorEmpjobid(user.getUserAccount());
		int result1 = employeeService.add(employee);
		int result2, result3, result4, result5, result6;
		if (result1 != 0) {
			//更新合同信息
			Contract contract = contractService.get(Integer.valueOf(conIdStr));
			//设置合同状态从待入职变为正常状态
			contract.setStatusId(14);
			result2 = contractService.update(contract);
			if (result2 != 0) {
				//录入职工-合同信息
				EmployeeContract employeeContract = new EmployeeContract();
				employeeContract.setConId(Integer.valueOf(conIdStr));
				employeeContract.setEmpJobid(empJobid);
				result3 = employeeContractService.add(employeeContract);
				if (result3 != 0) {
					//录入职工-部门信息
					EmployeeDepartment employeeDepartment = new EmployeeDepartment();
					employeeDepartment.setDeptId(Integer.valueOf(deptIdStr));
					employeeDepartment.setEmpJobid(empJobid);
					result4 = employeeDepartmentService.add(employeeDepartment);
					if (result4 != 0) {
						//录入职工-职位信息
						EmployeePosition employeePosition = new EmployeePosition();
						employeePosition.setEmpJobid(empJobid);
						employeePosition.setPositionId(Integer.valueOf(positionIdStr));
						result5 = employeePositionService.add(employeePosition);
						if (result5 != 0) {
							//更新职工入职信息
							employeeEntry.setEntryEmpnum(employeeEntry.getEntryEmpnum()+1);
							result6 = employeeEntryService.update(employeeEntry);
							if (result6 != 0) {
								return new JsonCommonResult<Object>("200", null, "添加职工信息成功！");
							}
						}
					}
				}
			}
		}
		return new JsonCommonResult<Object>("100", null, "添加职工信息失败！");
	}
	
	
}
