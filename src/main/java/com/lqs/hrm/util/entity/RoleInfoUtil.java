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
import com.lqs.hrm.entity.Roles;
import com.lqs.hrm.entity.UserRole;
import com.lqs.hrm.service.impl.ContractServiceImpl;
import com.lqs.hrm.service.impl.DepartmentLevelServiceImpl;
import com.lqs.hrm.service.impl.DepartmentServiceImpl;
import com.lqs.hrm.service.impl.EmployeeContractServiceImpl;
import com.lqs.hrm.service.impl.EmployeePositionServiceImpl;
import com.lqs.hrm.service.impl.EmployeeServiceImpl;
import com.lqs.hrm.service.impl.EntryCountServiceImpl;
import com.lqs.hrm.service.impl.PositionServiceImpl;
import com.lqs.hrm.service.impl.RolesServiceImpl;
import com.lqs.hrm.service.impl.StatusServiceImpl;

/**
 * 角色实体信息封装工具类
 * @author luckyliuqs
 *
 */
@Component
public class RoleInfoUtil {
	@Autowired
	private EmployeeServiceImpl employeeService;
	@Autowired
	private RolesServiceImpl rolesService;
	
	/**
	 * 设置查询出来的角色实体类信息
	 * @param departmentList
	 */
	public void setRoleInfo(List<Roles> list) {
		if (list.size() != 0 || list != null) {
			for (int i = 0; i < list.size(); i++) {
				//设置最后一次操作人姓名
				list.get(i).setOperatorEmpName(employeeService.get(list.get(i).getOperatorEmpjobid()).getEmpName());
			}
		}
	}
	
	/**
	 * 设置查询出来的角色实体类信息
	 * @param departmentList
	 */
	public void setRoleInfo(Roles roles) {
		if (roles != null) {
			//设置最后一次操作人姓名
			roles.setOperatorEmpName(employeeService.get(roles.getOperatorEmpjobid()).getEmpName());
		}
	}
}
