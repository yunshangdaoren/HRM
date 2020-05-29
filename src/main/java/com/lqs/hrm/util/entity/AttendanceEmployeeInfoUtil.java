package com.lqs.hrm.util.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.pagehelper.util.StringUtil;
import com.lqs.hrm.entity.AttendanceEmployee;
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
 * 职工考勤实体信息封装工具类
 * @author luckyliuqs
 *
 */
@Component
public class AttendanceEmployeeInfoUtil {
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
	 * 设置查询出来的职工考勤实体类信息
	 * @param departmentList
	 */
	public void setAttendanceEmployeeInfo(List<AttendanceEmployee> list) {
		if (list.size() != 0 || list != null) {
			for (int i = 0; i < list.size(); i++) {
				//设置职工姓名
				list.get(i).setEmpName(employeeService.get(list.get(i).getEmpJobid()).getEmpName());
				//设置状态名称
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
			}
		}
	}
	
	/**
	 * 设置查询出来的职工实体类信息
	 * @param departmentList
	 */
	public void setAttendanceEmployeeInfo(AttendanceEmployee attendanceEmployee) {
		if (attendanceEmployee != null && StringUtil.isNotEmpty(attendanceEmployee.getEmpJobid())) {
			//设置职工姓名
			attendanceEmployee.setEmpName(employeeService.get(attendanceEmployee.getEmpJobid()).getEmpName());
			//设置状态名称
			attendanceEmployee.setStatusName(statusService.get(attendanceEmployee.getStatusId()).getStatusName());
			
			//职工所属部门List
		    List<Department> departmentList = new ArrayList<>();
		    //职工所属部门名称List的Str形式
		    String deptNameListStr = "";
			//职工所属职位List
		    List<Position> positionList = new ArrayList<>();
		    //职工所属部门名称List的Str形式
		    String positionNameListStr = "";
		    
			if (attendanceEmployee != null &&StringUtil.isNotEmpty(attendanceEmployee.getEmpJobid())) {
				List<EmployeePosition> employeePositionList = employeePositionService.listByEmpJobId(attendanceEmployee.getEmpJobid());
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
				attendanceEmployee.setDepartmentList(departmentList);
				attendanceEmployee.setDeptNameListStr(deptNameListStr);
				
				//设置职工所属职位信息
				attendanceEmployee.setPositionList(positionList);
				attendanceEmployee.setPositionNameListStr(positionNameListStr);
			}
		}
	}
}
