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
import com.lqs.hrm.entity.User;
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
 * 账户实体信息封装工具类
 * @author luckyliuqs
 *
 */
@Component
public class UserInfoUtil {
	@Autowired
	private EmployeeServiceImpl employeeService;
	@Autowired
	private RolesServiceImpl rolesService;
	@Autowired
	private StatusServiceImpl statusService;
	
	
	/**
	 * 设置查询出来的账户实体类信息
	 * @param departmentList
	 */
	public void setUserInfo(List<User> list) {
		if (list.size() != 0 || list != null) {
			for (int i = 0; i < list.size(); i++) {
				//设置账户创建人姓名
				list.get(i).setCreateEmpName(employeeService.get(list.get(i).getCreateEmpjobid()).getEmpName());
				//设置最后一次操作人姓名
				list.get(i).setOperatorEmpName(employeeService.get(list.get(i).getOperatorEmpjobid()).getEmpName());
				//设置状态名称
				list.get(i).setStatusName(statusService.get(list.get(i).getStatusId()).getStatusName());
			}
		}
	}
	
	/**
	 * 设置查询出来的账户实体类信息
	 * @param departmentList
	 */
	public void setUserInfo(User user) {
		if (user != null) {
			//设置账户创建人姓名
			user.setCreateEmpName(employeeService.get(user.getCreateEmpjobid()).getEmpName());
			//设置最后一次操作人姓名
			user.setOperatorEmpName(employeeService.get(user.getOperatorEmpjobid()).getEmpName());
			//设置状态名称
			user.setStatusName(statusService.get(user.getStatusId()).getStatusName());
		}
	}
}
