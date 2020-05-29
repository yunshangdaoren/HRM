package com.lqs.hrm.util.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.pagehelper.util.StringUtil;
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
 * 职工实体信息封装工具类
 * @author luckyliuqs
 *
 */
@Component
public class EmployeeInfoUtil {
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
	 * 设置查询出来的职工实体类信息
	 * @param departmentList
	 */
	public void setEmployeeInfo(List<Employee> list) {
		if (list.size() != 0 || list != null) {
			for (int i = 0; i < list.size(); i++) {
				//设置职工性别名称
				list.get(i).setEmpSexName(list.get(i).getEmpSex() == 0 ? "女":"男");
				//设置职工状态名称
				list.get(i).setStatusName(statusService.get(list.get(i).getStatusId()).getStatusName());

				//职工所属部门List
			    List<Department> departmentList = new ArrayList<>();
			    //职工所属部门名称List的Str形式
			    String deptNameListStr = "";
			    
			    //职工所属职位List
			    List<Position> positionList = new ArrayList<>();
			    //职工所属部门名称List的Str形式
			    String positionNameListStr = "";
			    
				if (list.get(i) != null &&StringUtil.isNotEmpty(list.get(i).getEmpJobid())) {
					List<EmployeePosition> employeePositionList = employeePositionService.listByEmpJobId(list.get(i).getEmpJobid());
					if (employeePositionList != null && employeePositionList.size() != 0) {
						for (EmployeePosition employeePosition : employeePositionList) {
							//设置部门信息
							Department department = departmentService.get(positionService.get(employeePosition.getPositionId()).getDeptId());
							departmentList.add(department);
							if (deptNameListStr.length() > 0) {
								deptNameListStr += ","+department.getDeptName();
							}else {
								deptNameListStr += department.getDeptName();
							}
							
							//设置职位信息
							Position position = positionService.get(employeePosition.getPositionId());
							positionList.add(position);
							if (positionNameListStr.length() > 0) {
								positionNameListStr += ","+position.getPositionName();
							}else {
								positionNameListStr += position.getPositionName();
							}
						}
					}
					//设置职工所属部门信息
					list.get(i).setDepartmentList(departmentList);
					list.get(i).setDeptNameListStr(deptNameListStr);
					
					//设置职工所属职位信息
					list.get(i).setPositionList(positionList);
					list.get(i).setPositionNameListStr(positionNameListStr);
				}
				
				//设置最后一次操作人名称
				if(list.get(i).getOperatorEmpjobid() != null && StringUtil.isNotEmpty(list.get(i).getOperatorEmpjobid())) {
					list.get(i).setOperatorEmpName(employeeService.get(list.get(i).getOperatorEmpjobid()).getEmpName());
				}
			}
		}
	}
	
	/**
	 * 设置查询出来的职工实体类信息
	 * @param departmentList
	 */
	public void setEmployeeInfo(Employee employee) {
		if (employee != null && StringUtil.isNotEmpty(employee.getEmpJobid())) {
			//设置职工性别名称
			employee.setEmpSexName(employee.getEmpSex() == 0 ? "女":"男");
			//设置职工状态名称
			employee.setStatusName(statusService.get(employee.getStatusId()).getStatusName());

			//职工所属部门List
		    List<Department> departmentList = new ArrayList<>();
		    //职工所属部门名称List的Str形式
		    String deptNameListStr = "";
		    
		    //职工所属职位List
		    List<Position> positionList = new ArrayList<>();
		    //职工所属部门名称List的Str形式
		    String positionNameListStr = "";
		    
			if (employee != null &&StringUtil.isNotEmpty(employee.getEmpJobid())) {
				List<EmployeePosition> employeePositionList = employeePositionService.listByEmpJobId(employee.getEmpJobid());
				if (employeePositionList != null && employeePositionList.size() != 0) {
					for (EmployeePosition employeePosition : employeePositionList) {
						//设置部门信息
						Department department = departmentService.get(positionService.get(employeePosition.getPositionId()).getDeptId());
						System.out.println("----部门名称："+department.getDeptName());
						departmentList.add(department);
						if (deptNameListStr.length() > 0) {
							deptNameListStr += ","+department.getDeptName();
						}else {
							deptNameListStr += department.getDeptName();
						}
						
						//设置职位信息
						Position position = positionService.get(employeePosition.getPositionId());
						positionList.add(position);
						if (positionNameListStr.length() > 0) {
							positionNameListStr += ","+position.getPositionName();
						}else {
							positionNameListStr += position.getPositionName();
						}
					}
				}
				//设置职工所属部门信息
				employee.setDepartmentList(departmentList);
				employee.setDeptNameListStr(deptNameListStr);
				
				//设置职工所属职位信息
				employee.setPositionList(positionList);
				employee.setPositionNameListStr(positionNameListStr);
			}
			
			//设置最后一次操作人名称
			if(employee.getOperatorEmpjobid() != null && StringUtil.isNotEmpty(employee.getOperatorEmpjobid())) {
				employee.setOperatorEmpName(employeeService.get(employee.getOperatorEmpjobid()).getEmpName());
			}
		}
	}
	
	/**
	 * 去除重复数据
	 * @param employeeList
	 */
	public List<Employee> deleteRepeat(List<Employee> employeeList) {
		return employeeList.stream().distinct().collect(Collectors.toList()); 
	}
}
