package com.lqs.hrm.util.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.pagehelper.util.StringUtil;
import com.lqs.hrm.entity.Employee;
import com.lqs.hrm.entity.EmployeeResign;
import com.lqs.hrm.service.impl.DepartmentServiceImpl;
import com.lqs.hrm.service.impl.EmployeeServiceImpl;
import com.lqs.hrm.service.impl.PositionServiceImpl;
import com.lqs.hrm.service.impl.StatusServiceImpl;

/**
 * 职工实体信息封装工具类
 * @author luckyliuqs
 *
 */
@Component
public class EmployeeResignInfoUtil {
	@Autowired
	private EmployeeServiceImpl employeeService;
	@Autowired
	private DepartmentServiceImpl departmentService;
	@Autowired
	private StatusServiceImpl statusService;
	@Autowired
	private PositionServiceImpl positionService;
	
	/**
	 * 设置查询出来的离职实体类信息
	 * @param departmentList
	 */
	public void setEmployeeResignInfo(List<EmployeeResign> list) {
		if (list.size() != 0 || list != null) {
			for (int i = 0; i < list.size(); i++) {
				//设置离职职工姓名
				list.get(i).setEmpName(employeeService.get(list.get(i).getEmpJobid()).getEmpName());
				//设置离职部门名称
				list.get(i).setDeptName(departmentService.get(list.get(i).getDeptId()).getDeptName());
				//设置离职职位名称
				list.get(i).setPositionName(positionService.get(list.get(i).getPositionId()).getPositionName());
				//设置状态名称
				list.get(i).setStatusName(statusService.get(list.get(i).getStatusId()).getStatusName());
				
				//设置审批人姓名
				if(list.get(i).getCheckEmpjobid() != null && StringUtil.isNotEmpty(list.get(i).getCheckEmpjobid())) {
					Employee employee = employeeService.get(list.get(i).getEmpJobid());
					if (employee != null) {
						list.get(i).setCheckEmpName(employee.getEmpName());
					}
				}
			}
		}
	}
	
	/**
	 * 设置查询出来的离职实体类信息
	 * @param departmentList
	 */
	public void setEmployeeResignInfo(EmployeeResign employeeResign) {
		if (employeeResign != null) {
			//设置离职职工姓名
			employeeResign.setEmpName(employeeService.get(employeeResign.getEmpJobid()).getEmpName());
			//设置离职部门名称
			employeeResign.setDeptName(departmentService.get(employeeResign.getDeptId()).getDeptName());
			//设置离职职位名称
			employeeResign.setPositionName(positionService.get(employeeResign.getPositionId()).getPositionName());
			//设置状态名称
			employeeResign.setStatusName(statusService.get(employeeResign.getStatusId()).getStatusName());
			
			//设置审批人姓名
			if(employeeResign.getCheckEmpjobid() != null && StringUtil.isNotEmpty(employeeResign.getCheckEmpjobid())) {
				Employee employee = employeeService.get(employeeResign.getEmpJobid());
				if (employee != null) {
					employeeResign.setCheckEmpName(employee.getEmpName());
				}
			}
		}
	}
}
