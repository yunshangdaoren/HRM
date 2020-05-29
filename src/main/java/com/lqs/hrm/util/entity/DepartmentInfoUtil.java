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
import com.lqs.hrm.service.impl.AttendanceEmployeeServiceImpl;
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
 * 部门实体信息封装工具类
 * @author luckyliuqs
 *
 */
@Component
public class DepartmentInfoUtil {
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
	
	/**
	 * 设置查询出来的部门实体类信息
	 * @param departmentList
	 * @throws ParseException 
	 */
	public void setDepartmentInfo(List<Department> list) {
		if (list.size() != 0 || list != null) {
			for (int i = 0; i < list.size(); i++) {
				//System.out.print("================ 部门名称："+list.get(i).getDeptName()+"===================\n");
				//设置部门级别
				list.get(i).setDlLeve(departmentLevelService.get(list.get(i).getDlId()).getLevel());
				//设置部门主管职位名称
				if (list.get(i).getManagePositionid() != null && list.get(i).getManagePositionid().intValue()!= 0) {
					list.get(i).setManagePositionName(positionService.get(list.get(i).getManagePositionid()).getPositionName());
				}
				//设置部门主管人工号和姓名
				if(list.get(i).getManagePositionid() != null && list.get(i).getManagePositionid() != 0) {
					//设置部门主管职位名称
					list.get(i).setManagePositionName(positionService.get(list.get(i).getManagePositionid()).getPositionName());
					//获取部门主管职位
					List<EmployeePosition> employeePositionList = employeePositionService.listByPositionId(list.get(i).getManagePositionid());
					if (employeePositionList == null || employeePositionList.size() == 0) {
						//该部门主管职位还未分配给职工
						list.get(i).setManageEmpName("");
					}else {
						//该部门主管职位还已分配给职工，则查找该职工信息
						Employee employee = employeeService.get(employeePositionList.get(0).getEmpJobid());
						//设置部门主管人工号和姓名
						list.get(i).setManageEmpJobId(employee.getEmpJobid());
						list.get(i).setManageEmpName(employee.getEmpName());
					}
				}
				//设置上级部门名称
				if (list.get(i).getParentId() != null && list.get(i).getParentId() !=0) {
					list.get(i).setParentDeptName(departmentService.get(list.get(i).getParentId()).getDeptName());
				} 
				//设置部门状态名称
				list.get(i).setStatusName(statusService.get(list.get(i).getStatusId()).getStatusName());
				//设置操作人名称
				if(list.get(i).getOperatorEmpjobid() != null && !list.get(i).getOperatorEmpjobid().isEmpty()) {
					list.get(i).setOperatorEmpName(employeeService.get(list.get(i).getOperatorEmpjobid()).getEmpName());
				}
				
				//部门职工数量
				Integer deptEmpNum = 0;
			    List<Department> childDepartmentList = listChildDeptByDeptId(list.get(i).getDeptId());
			    childDepartmentList.add(list.get(i));
			    for (Department d : childDepartmentList) {
			    	//System.out.print("子部门名称："+d.getDeptName());
			    	 List<Position> positionList = positionService.listByDeptId(d.getDeptId());
						for (Position position : positionList) {
							List<EmployeePosition> employeePositionList = employeePositionService.listByPositionId(position.getPositionId());
							deptEmpNum += employeePositionList.size();
						}
					//System.out.println();
				}
				//设置部门职工数量
				list.get(i).setDeptEmpnum(deptEmpNum);
				//System.out.print("    部门人数："+deptEmpNum +"\n");
			}
		}
	}
	
	/**
	 * 设置查询出来的部门实体类信息
	 * @param departmentList
	 * @throws ParseException 
	 */
	public void setDepartmentInfo(Department department) throws ParseException {
		if (department != null) {
			//设置部门级别
			department.setDlLeve(departmentLevelService.get(department.getDlId()).getLevel());
			//设置部门主管人工号和姓名
			if(department.getManagePositionid() != null && department.getManagePositionid() != 0) {
				//设置部门主管职位名称
				department.setManagePositionName(positionService.get(department.getManagePositionid()).getPositionName());
				//获取部门主管职位
				List<EmployeePosition> employeePositionList = employeePositionService.listByPositionId(department.getManagePositionid());
				if (employeePositionList == null || employeePositionList.size() == 0) {
					//该部门主管职位还未分配给职工
					department.setManageEmpName("");
				}else {
					//该部门主管职位还已分配给职工，则查找该职工信息
					Employee employee = employeeService.get(employeePositionList.get(0).getEmpJobid());
					//设置部门主管人工号和姓名
					department.setManageEmpJobId(employee.getEmpJobid());
					department.setManageEmpName(employee.getEmpName());
				}
			}
			//设置上级部门名称
			if (department.getParentId() != null && department.getParentId() != 0) {
				department.setParentDeptName(departmentService.get(department.getParentId()).getDeptName());
			} 
			//设置部门状态名称
			department.setStatusName(statusService.get(department.getStatusId()).getStatusName());
			//设置操作人名称
			if(department.getOperatorEmpjobid() != null && !department.getOperatorEmpjobid().isEmpty()) {
				department.setOperatorEmpName(employeeService.get(department.getOperatorEmpjobid()).getEmpName());
			}
			
			//部门职工数量
			Integer deptEmpNum = 0;
		    List<Department> childDepartmentList = listChildDeptByDeptId(department.getDeptId());
		    childDepartmentList.add(department);
		    for (Department d : childDepartmentList) {
		    	 List<Position> positionList = positionService.listByDeptId(d.getDeptId());
					for (Position position : positionList) {
						List<EmployeePosition> employeePositionList = employeePositionService.listByPositionId(position.getPositionId());
						deptEmpNum += employeePositionList.size();
					}
			}
			//设置部门职工数量
		    department.setDeptEmpnum(deptEmpNum);
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
