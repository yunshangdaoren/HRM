package com.lqs.hrm.util.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.pagehelper.util.StringUtil;
import com.lqs.hrm.entity.Contract;
import com.lqs.hrm.entity.Department;
import com.lqs.hrm.entity.Employee;
import com.lqs.hrm.entity.EmployeePosition;
import com.lqs.hrm.entity.Position;
import com.lqs.hrm.service.impl.ContractServiceImpl;
import com.lqs.hrm.service.impl.DepartmentLevelServiceImpl;
import com.lqs.hrm.service.impl.DepartmentServiceImpl;
import com.lqs.hrm.service.impl.EmployeeContractServiceImpl;
import com.lqs.hrm.service.impl.EmployeePositionServiceImpl;
import com.lqs.hrm.service.impl.EmployeeServiceImpl;
import com.lqs.hrm.service.impl.EntryCountServiceImpl;
import com.lqs.hrm.service.impl.PositionServiceImpl;
import com.lqs.hrm.service.impl.StatusServiceImpl;

/**
 * 合同实体信息封装工具类
 * @author luckyliuqs
 *
 */
@Component
public class ContractInfoUtil {
	@Autowired
	private EmployeeServiceImpl employeeService;
	@Autowired
	private DepartmentServiceImpl departmentService;
	@Autowired
	private StatusServiceImpl statusService;
	@Autowired
	private PositionServiceImpl positionService;
	@Autowired
	private EmployeePositionServiceImpl employeePositionService;
	@Autowired
	private DepartmentLevelServiceImpl departmentLevelService;
	
	/**
	 * 设置查询出来的合同实体类信息
	 * @param departmentList
	 */
	public void setContractInfo(List<Contract> list) {
		if (list.size() != 0 || list != null) {
			for (int i = 0; i < list.size(); i++) {
				//设置职工性别描述
				list.get(i).setEmpSexName(list.get(i).getEmpSex()==0?"女":"男");
				//设置所属部门名称
				list.get(i).setDeptName(departmentService.get(list.get(i).getDeptId()).getDeptName());
				//设置所属职位名称
				list.get(i).setPositionName(positionService.get(list.get(i).getPositionId()).getPositionName());
				//设置状态名称
				list.get(i).setStatusName(statusService.get(list.get(i).getStatusId()).getStatusName());
				//设置录入人名称
				if (StringUtil.isNotEmpty(list.get(i).getAddEmpjobid())) {
					Employee employee = employeeService.get(list.get(i).getAddEmpjobid());
					if (employee != null) {
						list.get(i).setAddEmpName(employee.getEmpName());
					}
				}
				//设置入职审批人名称
				if (StringUtil.isNotEmpty(list.get(i).getEntryCheckEmpjobid())) {
					Employee employee = employeeService.get(list.get(i).getEntryCheckEmpjobid());
					if (employee != null) {
						list.get(i).setEntryCheckEmpName(employee.getEmpName());
					}
				}
				
				//设置离职审批人名称
				if (StringUtil.isNotEmpty(list.get(i).getResignCheckEmpjobid())) {
					Employee employee = employeeService.get(list.get(i).getResignCheckEmpjobid());
					if (employee != null) {
						list.get(i).setResignCheckEmpName(employee.getEmpName());
					}
				}
			}
		}
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
				Employee employee = employeeService.get(contract.getAddEmpjobid());
				if (employee != null) {
					contract.setAddEmpName(employee.getEmpName());
				}
			}
			//设置入职审批人名称
			if (StringUtil.isNotEmpty(contract.getEntryCheckEmpjobid())) {
				Employee employee = employeeService.get(contract.getEntryCheckEmpjobid());
				if (employee != null) {
					contract.setEntryCheckEmpName(employee.getEmpName());
				}
			}
			
			//设置离职审批人名称
			if (StringUtil.isNotEmpty(contract.getResignCheckEmpjobid())) {
				Employee employee = employeeService.get(contract.getResignCheckEmpjobid());
				if (employee != null) {
					contract.setResignCheckEmpName(employee.getEmpName());
				}
			}
		}
	}
}
