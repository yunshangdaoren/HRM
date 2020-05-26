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
import com.lqs.hrm.entity.DepartmentAttendanceCount;
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
public class DepartmentAttendanceCountUtil {
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
	private DepartmentInfoUtil departmentInfoUtil;
	
	/**
	 * 设置查询出来的部门考勤实体类信息
	 * @param departmentList
	 * @throws ParseException 
	 */
	public List<DepartmentAttendanceCount> setDepartmentAttendanceCount(List<Department> departmentList, Date signDate) throws ParseException {
		List<DepartmentAttendanceCount> departmentAttendanceCountList = new ArrayList<>(departmentList.size());
		
		System.out.println("**************************");
		System.out.println("传入的部门数量为："+departmentList.size());
		System.out.println("**************************");
		if (departmentList.size() != 0 || departmentList != null) {
			for (int i = 0; i < departmentList.size(); i++) {
				DepartmentAttendanceCount departmentAttendanceCount = new DepartmentAttendanceCount();
				//设置部门ID
				departmentAttendanceCount.setDeptId(departmentList.get(i).getDeptId());
				//设置部门名称
				departmentAttendanceCount.setDeptName(departmentList.get(i).getDeptName());
				//设置考勤日期
				departmentAttendanceCount.setSignDate(signDate);
				
				//当前部门下所有职工数量
				Integer currentDeptEmpNum = 0;
				
				//未签到职工数量
			    Integer notSignEmployeeNum = 0;
			    //签到且未签退职工数量
			    Integer signNotLogoutEmployeeNum = 0;
			    //签到且早退职工数量
			    Integer signLeaveEarlyEmployeeNum = 0;
			    //迟到且未签退职工数量
			    Integer lateNotLeaveEmployeeNum = 0;
			    //迟到且早退职工数量
			    Integer lateLeaveEarlyEmployeeNum = 0;
			    //到勤职工数量
			    Integer normalEmployeeNum = 0;
			    
			    //得到该部门下的所有子部门及自身部门信息
			    List<Department> allDepartmentList = null;
			    allDepartmentList.add(departmentList.get(i));
			    //遍历该部门下的所有子部门及自身部门信息
			    for (Department department : allDepartmentList) {
			    	DepartmentAttendanceCount d1 = new DepartmentAttendanceCount();
			    	//设置部门ID
					d1.setDeptId(departmentList.get(i).getDeptId());
					//设置部门名称
					d1.setDeptName(departmentList.get(i).getDeptName());
					//设置考勤日期
					d1.setSignDate(signDate);
					
					//部门下所有职工数量
					Integer deptEmpNum = 0;
					
					//未签到职工数量
				    Integer notSignEmployeeNum1 = 0;
				    //签到且未签退职工数量
				    Integer signNotLogoutEmployeeNum1 = 0;
				    //签到且早退职工数量
				    Integer signLeaveEarlyEmployeeNum1 = 0;
				    //迟到且未签退职工数量
				    Integer lateNotLeaveEmployeeNum1 = 0;
				    //迟到且早退职工数量
				    Integer lateLeaveEarlyEmployeeNum1 = 0;
				    //到勤职工数量
				    Integer normalEmployeeNum1 = 0;
				    
			    	//得到对应部门下的所有职位信息
			    	 List<Position> positionList = positionService.listByDeptId(department.getDeptId());
			    	 //遍历所有职位信息
			    	 for (Position position : positionList) {
			    		 	//得到职工-职位信息
							List<EmployeePosition> employeePositionList = employeePositionService.listByPositionId(position.getPositionId());
							//要查询的部门的所有职工数量增加
							currentDeptEmpNum += employeePositionList.size();
							
							for (EmployeePosition employeePosition : employeePositionList) {
								Employee employee = employeeService.get(employeePosition.getEmpJobid());
								//获取该职工的考勤信息
								SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
								//2020-05-20 13:22:10
								List<AttendanceEmployee> attendanceEmployeeList = attendanceEmployeeService.listByEmpJobIdDate(employee.getEmpJobid(), signDate);
								
								if (attendanceEmployeeList.get(0).getStatusId()== 20) {
									//该职工状态为未签到
									notSignEmployeeNum += 1;
									notSignEmployeeNum1 += 1;
								}else if(attendanceEmployeeList.get(0).getStatusId() == 21 ) {
									//该职工状态为签到且未签退
									signNotLogoutEmployeeNum += 1;
									signNotLogoutEmployeeNum1 += 1;
								}else if(attendanceEmployeeList.get(0).getStatusId() == 22 ) {
									//该职工状态为签到且早退
									signLeaveEarlyEmployeeNum += 1;
									signLeaveEarlyEmployeeNum1 += 1;
								}else if(attendanceEmployeeList.get(0).getStatusId() == 23 ) {
									//该职工状态为迟到且未签退
									lateNotLeaveEmployeeNum += 1;
									lateNotLeaveEmployeeNum1 += 1;
								}else if(attendanceEmployeeList.get(0).getStatusId() == 24 ) {
									//该职工状态为迟到且早退
									lateLeaveEarlyEmployeeNum += 1;
									lateLeaveEarlyEmployeeNum1 += 1;
								}else if(attendanceEmployeeList.get(0).getStatusId() == 25 ) {
									//该职工状态为到勤
									normalEmployeeNum += 1;
									normalEmployeeNum1 += 1;
								}
							}
						}
						//设置部门职工数量
			    	 	d1.setDeptEmpnum(deptEmpNum);
						//设置部门职工考勤信息
			    	 	d1.setNotSignEmployeeNum(notSignEmployeeNum);
			    	 	d1.setSignNotLogoutEmployeeNum(signNotLogoutEmployeeNum);
			    	 	d1.setSignLeaveEarlyEmployeeNum(signLeaveEarlyEmployeeNum);
			    	 	d1.setLateNotLeaveEmployeeNum(lateNotLeaveEmployeeNum);
			    	 	d1.setLateLeaveEarlyEmployeeNum(lateLeaveEarlyEmployeeNum);
			    	 	d1.setNormalEmployeeNum(normalEmployeeNum);
			    	 	
			    	 	departmentAttendanceCountList.add(d1);
					}
			    
			    //设置部门职工数量
	    	 	departmentAttendanceCount.setDeptEmpnum(currentDeptEmpNum);
				//设置部门职工考勤信息
	    	 	departmentAttendanceCount.setNotSignEmployeeNum(notSignEmployeeNum);
	    	 	departmentAttendanceCount.setSignNotLogoutEmployeeNum(signNotLogoutEmployeeNum);
	    	 	departmentAttendanceCount.setSignLeaveEarlyEmployeeNum(signLeaveEarlyEmployeeNum);
	    	 	departmentAttendanceCount.setLateNotLeaveEmployeeNum(lateNotLeaveEmployeeNum);
	    	 	departmentAttendanceCount.setLateLeaveEarlyEmployeeNum(lateLeaveEarlyEmployeeNum);
	    	 	departmentAttendanceCount.setNormalEmployeeNum(normalEmployeeNum);
	    	 	
	    	 	departmentAttendanceCountList.add(departmentAttendanceCount);
				}
		}
		return departmentAttendanceCountList;
	}
	
	
	/**
	 * 设置查询出来的部门实体类信息
	 * @param departmentList
	 */
	public void setDepartmentInfo(Department department) {
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
		}
	}
}
