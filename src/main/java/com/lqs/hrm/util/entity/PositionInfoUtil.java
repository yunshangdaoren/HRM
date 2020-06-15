package com.lqs.hrm.util.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.pagehelper.util.StringUtil;
import com.lqs.hrm.entity.AttendanceEmployee;
import com.lqs.hrm.entity.AttendanceTime;
import com.lqs.hrm.entity.Department;
import com.lqs.hrm.entity.Employee;
import com.lqs.hrm.entity.EmployeePosition;
import com.lqs.hrm.entity.Position;
import com.lqs.hrm.service.PositionLevelService;
import com.lqs.hrm.service.impl.AttendanceEmployeeServiceImpl;
import com.lqs.hrm.service.impl.ContractServiceImpl;
import com.lqs.hrm.service.impl.DepartmentLevelServiceImpl;
import com.lqs.hrm.service.impl.DepartmentServiceImpl;
import com.lqs.hrm.service.impl.EmployeeContractServiceImpl;
import com.lqs.hrm.service.impl.EmployeePositionServiceImpl;
import com.lqs.hrm.service.impl.EmployeeServiceImpl;
import com.lqs.hrm.service.impl.EntryCountServiceImpl;
import com.lqs.hrm.service.impl.PositionLevelServiceImpl;
import com.lqs.hrm.service.impl.PositionServiceImpl;
import com.lqs.hrm.service.impl.StatusServiceImpl;

/**
 * 职位实体信息封装工具类
 * @author luckyliuqs
 *
 */
@Component
public class PositionInfoUtil {
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
	@Autowired
	private AttendanceEmployeeServiceImpl attendanceEmployeeService;
	@Autowired
	private PositionLevelServiceImpl positionLevelService;
	
	/**
	 * 设置查询出来的职位实体类信息
	 * @param positionList
	 */
	public void setPositionInfo(List<Position> positionList) {
		if (positionList.size() != 0 || positionList != null) {
			for (int i = 0; i < positionList.size(); i++) {
				//设置职位级别
				positionList.get(i).setPlLeve(positionLevelService.get(positionList.get(i).getPlId()).getLevel());
				//设置职位级别描述
				positionList.get(i).setPlLevelDesc(positionLevelService.get(positionList.get(i).getPlId()).getLevelDesc());
				//设置职位上级职位名称
				if(positionList.get(i).getParentPositionid() != null && positionList.get(i).getParentPositionid() != 0) {
					System.out.println("上级部门id为空："+positionList.get(i).getParentPositionid());
					positionList.get(i).setParentPositionName(positionService.get(positionList.get(i).getParentPositionid()).getPositionName());
				}
				//设置职位所属部门名称
				if (positionList.get(i).getDeptId() != null && positionList.get(i).getDeptId() != 0) {
					positionList.get(i).setDeptName(departmentService.get(positionList.get(i).getDeptId()).getDeptName());
				} 
				//设置职位状态名称
				positionList.get(i).setStatusName(statusService.get(positionList.get(i).getStatusId()).getStatusName());
				//设置操作人名称
				if(positionList.get(i).getOperatorEmpjobid() != null && !positionList.get(i).getOperatorEmpjobid().isEmpty()) {
					Employee employee = employeeService.get(positionList.get(i).getOperatorEmpjobid());
					if (employee != null) {
						positionList.get(i).setOperatorEmpName(employee.getEmpName());
					}
				}
			}
		}
	}
	
	/**
	 * 设置查询出来的职位实体类信息
	 * @param departmentList
	 */
	public void setPositionInfo(Position position) {
		if (position != null) {
			//设置职位级别
			position.setPlLeve(positionLevelService.get(position.getPlId()).getLevel());
			//设置职位级别描述
			position.setPlLevelDesc(positionLevelService.get(position.getPlId()).getLevelDesc());
			//设置职位上级职位名称
			if(position.getParentPositionid() != null && position.getParentPositionid() != 0) {
				position.setParentPositionName(positionService.get(position.getParentPositionid()).getPositionName());
			}
			//设置职位所属部门名称
			if (position.getDeptId() != null && position.getDeptId() != 0) {
				position.setDeptName(departmentService.get(position.getDeptId()).getDeptName());
			} 
			//设置职位状态名称
			position.setStatusName(statusService.get(position.getStatusId()).getStatusName());
			//设置操作人名称
			if(position.getOperatorEmpjobid() != null && !position.getOperatorEmpjobid().isEmpty()) {
				Employee employee = employeeService.get(position.getOperatorEmpjobid());
				if (employee != null) {
					position.setOperatorEmpName(employee.getEmpName());
				}
			}
		}
	}
	
	/**
	 * 获取到指定部门id的部门的所有子部门
	 */
	public List<Department> listChildDeptByDeptId(Integer deptd) {
		//所有子部门信息
		List<Department> allDepartmentList = new ArrayList<>();
		//获取到所有部门信息
		List<Department> childDepartmentList = departmentService.listByParentId(deptd);
		for (Department department : childDepartmentList) {
			for (Department d : listChildDeptByDeptId(department.getDeptId())) {
				if (d != null) {
					allDepartmentList.add(d);
				}
			}
			allDepartmentList.add(department);
		}
		return allDepartmentList;
	}
	
	/**
	 * 获取指定部门下的所有职工数量
	 * @param department
	 * @return
	 */
	public int getDeptEmpNum(Department department) {
		//部门职工数量
		Integer deptEmpNum = 0;
	    List<Department> childDepartmentList = listChildDeptByDeptId(department.getDeptId());
	    childDepartmentList.add(department);
	    for (Department d : childDepartmentList) {
	    	//System.out.print("子部门名称："+d.getDeptName());
	    	 List<Position> positionList = positionService.listByDeptId(d.getDeptId());
				for (Position position : positionList) {
					List<EmployeePosition> employeePositionList = employeePositionService.listByPositionId(position.getPositionId());
					deptEmpNum += employeePositionList.size();
				}
			//System.out.println();
		}
		return deptEmpNum;
	}
}
