package com.lqs.hrm.controller;

import java.util.ArrayList;
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
import com.lqs.hrm.entity.DepartmentLevel;
import com.lqs.hrm.entity.EmployeeContract;
import com.lqs.hrm.entity.Status;
import com.lqs.hrm.entity.User;
import com.lqs.hrm.json.JsonCommonResult;
import com.lqs.hrm.json.JsonPageResult;
import com.lqs.hrm.service.impl.ContractServiceImpl;
import com.lqs.hrm.service.impl.DepartmentLevelServiceImpl;
import com.lqs.hrm.service.impl.DepartmentServiceImpl;
import com.lqs.hrm.service.impl.EmployeeContractServiceImpl;
import com.lqs.hrm.service.impl.EmployeeServiceImpl;
import com.lqs.hrm.service.impl.StatusServiceImpl;
import com.lqs.hrm.service.impl.UserServiceImpl;
import com.lqs.hrm.util.PageRequest;
import com.lqs.hrm.util.PageResult;
import com.lqs.hrm.util.PageResultUtil;

/**
 * 职工合同Controller
 * @author luckyliuqs
 *
 */
@Controller
@RequestMapping("employeeContract")
public class EmployeeContractController {
	@Autowired
	private EmployeeContractServiceImpl employeeContractService;
	@Autowired
	private EmployeeServiceImpl employeeService;
	@Autowired
	private StatusServiceImpl statusService;
	@Autowired
	private ContractServiceImpl contractService;
	
	/**
	 * 转至我的合同页面
	 * @param request
	 * @param pageRequest
	 * @param map
	 * @return
	 */
	@RequestMapping("myContractList.do")
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
		
		setEmployeeContractInfo(employeeContractList);
		//设置分页查询结果
		PageResult pageResult = PageResultUtil.getPageResult(new PageInfo<>(employeeContractList));
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
		
	/**
	 * 设置查询出来的职工合同实体类信息
	 * @param departmentList
	 */
	public void setEmployeeContractInfo(List<EmployeeContract> list) {
		if (list.size() != 0 || list != null) {
			for (int i = 0; i < list.size(); i++) {
				//设置职工名称
				list.get(i).setEmpName(employeeService.get(list.get(i).getEmpJobid()).getEmpName());
			}
		}
	}
	
	/**
	 * 设置查询出来的职工合同实体类信息
	 * @param departmentList
	 */
	public void setEmployeeContractInfo(EmployeeContract employeeContract) {
		if (employeeContract != null) {
			//设置职工名称
			employeeContract.setEmpName(employeeService.get(employeeContract.getEmpJobid()).getEmpName());
		}
	}

	
}

