package com.lqs.hrm.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.lqs.hrm.entity.AttendanceEmployee;
import com.lqs.hrm.entity.AttendanceTime;
import com.lqs.hrm.entity.Contract;
import com.lqs.hrm.entity.CountAttendanceDepartmant;
import com.lqs.hrm.entity.Department;
import com.lqs.hrm.entity.Employee;
import com.lqs.hrm.entity.EmployeePosition;
import com.lqs.hrm.entity.EmployeeResign;
import com.lqs.hrm.entity.Position;
import com.lqs.hrm.entity.Status;
import com.lqs.hrm.entity.User;
import com.lqs.hrm.json.JsonCommonResult;
import com.lqs.hrm.service.PositionService;
import com.lqs.hrm.service.impl.AttendanceEmployeeServiceImpl;
import com.lqs.hrm.service.impl.AttendanceTimeServiceImpl;
import com.lqs.hrm.service.impl.CountAttendanceDepartmentServiceImpl;
import com.lqs.hrm.service.impl.DepartmentServiceImpl;
import com.lqs.hrm.service.impl.EmployeePositionServiceImpl;
import com.lqs.hrm.service.impl.StatusServiceImpl;
import com.lqs.hrm.util.PageRequest;
import com.lqs.hrm.util.PageResult;
import com.lqs.hrm.util.PageResultUtil;
import com.lqs.hrm.util.entity.AttendanceEmployeeInfoUtil;
import com.lqs.hrm.util.entity.CountAttendanceDepartmantUtil;
import com.lqs.hrm.util.entity.DepartmentInfoUtil;

/**
 * 职工考勤信息Controller
 * @author luckyliuqs
 *
 */
@Controller
@RequestMapping("attendanceEmployee")
public class AttendanceEmployeeController {
	@Autowired
	private AttendanceEmployeeServiceImpl attendanceEmployeeService;
	@Autowired
	private DepartmentServiceImpl departmentService;
	@Autowired
	private AttendanceEmployeeInfoUtil attendanceEmployeeInfoUtil;
	@Autowired
	private DepartmentInfoUtil departmentInfoUtil;
	@Autowired
	private CountAttendanceDepartmantUtil countAttendanceDepartmantUtil;
	@Autowired
	private StatusServiceImpl statusService;
	@Autowired
	private EmployeePositionServiceImpl employeePositionService;
	@Autowired
	private AttendanceTimeServiceImpl attendanceTimeService;
	@Autowired
	private PositionService positionService;
	@Autowired
	private CountAttendanceDepartmentServiceImpl countAttendanceDepartmentService;
	
	
	/**
	 * 跳转至所有职工考勤信息列表页面
	 * @param request
	 * @param pageRequest
	 * @param map
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("toAttendanceEmployeeList.do")
	public String toAttendanceEmployeeList(HttpServletRequest request, PageRequest pageRequest, ModelMap map) throws ParseException{
		//查询条件信息
		//职工工号
		String empJobIdStr = request.getParameter("empJobId");
		//考勤日期
		String dateStr = request.getParameter("date");
		Date date = null;
		if (StringUtil.isNotEmpty(dateStr)) {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
		}
		//考勤状态
		String statusIdStr = request.getParameter("statusId");
		//分页
		PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
		List<AttendanceEmployee> attendanceEmployeeList = new ArrayList<>();
		
		//查询条件判断
		if (StringUtil.isEmpty(empJobIdStr) && StringUtil.isEmpty(dateStr) && StringUtil.isEmpty(statusIdStr)) {
			//如果查询的条件全部为空，则查询出所有职工考勤信息
			attendanceEmployeeList = attendanceEmployeeService.listByNo();
		}else if(StringUtil.isEmpty(dateStr) && StringUtil.isEmpty(statusIdStr)) {
			//则根据职工工号查询
			attendanceEmployeeList = attendanceEmployeeService.listByEmpJobId(empJobIdStr);
		}else if(StringUtil.isEmpty(empJobIdStr) && StringUtil.isEmpty(statusIdStr)){
			//则根据考勤日期查询
			attendanceEmployeeList = attendanceEmployeeService.listByDate(date);
		}else if(StringUtil.isEmpty(empJobIdStr) && StringUtil.isEmpty(dateStr)) {
			//根据考勤状态查询
			attendanceEmployeeList = attendanceEmployeeService.listByStatusId(Integer.valueOf(statusIdStr));
		}else if(StringUtil.isEmpty(statusIdStr)) {
			//根据职工工号,考勤日期查询
			attendanceEmployeeList = attendanceEmployeeService.listByEmpJobIdDate(empJobIdStr, date);
		}else if(StringUtil.isEmpty(empJobIdStr)) {
			//根据职工工号，考勤状态查询
			attendanceEmployeeList = attendanceEmployeeService.listByEmpJobIdStatusId(empJobIdStr, Integer.valueOf(statusIdStr));
		}else if(StringUtil.isEmpty(statusIdStr)) {
			//根据考勤日期，考勤状态查询
			attendanceEmployeeList = attendanceEmployeeService.listByDateStatusId(date, Integer.valueOf(statusIdStr));
		}else {
			//根据职工工号,考勤日期，考勤状态查询
			attendanceEmployeeList = attendanceEmployeeService.listByEmpJobIdDateStatusId(empJobIdStr, date, Integer.valueOf(statusIdStr));
		}
		attendanceEmployeeInfoUtil.setAttendanceEmployeeInfo(attendanceEmployeeList);
		//设置分页查询结果
		PageResult pageResult = PageResultUtil.getPageResult(new PageInfo<>(attendanceEmployeeList));
		//返回查询的部门信息
		map.put("pageResult", pageResult);
		//回显查询条件
		map.put("empJobIdStr", empJobIdStr);
		map.put("dateStr", dateStr);
		map.put("statusIdStr", statusIdStr);
		
		//职工考勤状态信息:类型为10
		List<Status> statusList = statusService.list(10);
		//返回查询的职工状态信息
		map.put("statusList", statusList);
		//查询该职工所属的职位信息
		//Position position = employeePositionService.list
		return "attendance/attendanceEmployeeList";
	}
	
	/**
	 * 跳转至部门考勤信息统计页面
	 * @param request
	 * @param pageRequest
	 * @param map
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("countDepartmentAttendance.do")
	public String countDepartmentAttendance(HttpServletRequest request, PageRequest pageRequest, ModelMap map) throws ParseException{
		//查询条件信息
		//部门名称
		String deptNameStr = request.getParameter("deptName");
		//考勤日期
		String dateStr = request.getParameter("date");
		//部门级别
		String dlIdStr = request.getParameter("dlIdStr");
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
		if (StringUtil.isEmpty(dateStr)) {
			//日期字符串为空，则设置日期为今日
			dateStr = format.format(new Date()).substring(0, 10);
		}
		
		//分页
		PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
		//部门信息
		List<Department> departmentList = null;
		
		//查询条件判断
		if (StringUtil.isEmpty(deptNameStr) && StringUtil.isEmpty(dlIdStr)) {
			//如果查询的条件全部为空，则查询出今日所有部门考勤信息
			departmentList = departmentService.listByNo();
			System.out.println("===============   查询条件为null");
		}else if(StringUtil.isEmpty(dlIdStr)) {
			//则根据部门名称查询查询
			departmentList = departmentService.listByDeptName(deptNameStr);
		}else if(StringUtil.isEmpty(deptNameStr)){
			//则根据部门级别查询
			departmentList = departmentService.listByDlId(Integer.valueOf(dlIdStr));
		}else {
			//根据部门名称，部门级别查询
			departmentList = departmentService.listByDeptNameDlId(deptNameStr, Integer.valueOf(dlIdStr));
		}
		System.out.println("----------------------------");
		System.out.println("查询出来的所有部门信息大小："+departmentList.size());
		System.out.println("----------------------------");
		List<CountAttendanceDepartmant> countAttendanceDepartmantList = countAttendanceDepartmentService.listByNo();
		countAttendanceDepartmantUtil.setCountAttendanceDepartmantInfo(countAttendanceDepartmantList);
		//设置分页查询结果
		PageResult pageResult = PageResultUtil.getPageResult(new PageInfo<>(countAttendanceDepartmantList));
		//返回查询的部门信息
		map.put("pageResult", pageResult);
		//回显查询条件
		map.put("deptNameStr", deptNameStr);
		map.put("dateStr", dateStr);
		
		return "attendance/countDepartmentAttendance";
	}
	
	/**
	 * 跳转至我的考勤信息列表页面
	 * @param request
	 * @param pageRequest
	 * @param map
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("toMyAttendanceEmployeeList.do")
	public String toMyAttendanceEmployeeList(HttpServletRequest request, PageRequest pageRequest, ModelMap map) throws ParseException{
		//查询条件信息
		//考勤日期
		String dateStr = request.getParameter("date");
		Date date = null;
		if (StringUtil.isNotEmpty(dateStr)) {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
		}
		//考勤状态
		String statusIdStr = request.getParameter("statusId");
		//分页
		PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
		List<AttendanceEmployee> attendanceEmployeeList = new ArrayList<>();
		
		//获取当前登录系统人工号
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("session_loginUser");
		String myEmpJobId = user.getUserAccount();
		
		//查询条件判断
		if (StringUtil.isEmpty(dateStr) && StringUtil.isEmpty(statusIdStr)) {
			//如果查询的条件全部为空，则查询出当前登录职工所有考勤信息
			attendanceEmployeeList = attendanceEmployeeService.listByEmpJobId(myEmpJobId);
		}else if(StringUtil.isEmpty(statusIdStr)){
			//则根据考勤日期查询
			attendanceEmployeeList = attendanceEmployeeService.listByEmpJobIdDate(myEmpJobId, date);
		}else if(StringUtil.isEmpty(dateStr)) {
			//根据考勤状态查询
			attendanceEmployeeList = attendanceEmployeeService.listByEmpJobIdStatusId(myEmpJobId, Integer.valueOf(statusIdStr));
		}else {
			//根据考勤日期,考勤状态查询
			attendanceEmployeeList = attendanceEmployeeService.listByEmpJobIdDateStatusId(myEmpJobId,date, Integer.valueOf(statusIdStr));
		}
		attendanceEmployeeInfoUtil.setAttendanceEmployeeInfo(attendanceEmployeeList);
		//设置分页查询结果
		PageResult pageResult = PageResultUtil.getPageResult(new PageInfo<>(attendanceEmployeeList));
		//返回查询的部门信息
		map.put("pageResult", pageResult);
		//回显查询条件
		map.put("dateStr", dateStr);
		map.put("statusIdStr", statusIdStr);
		
		//职工考勤状态信息:类型为10
		List<Status> statusList = statusService.list(10);
		//返回查询的职工状态信息
		map.put("statusList", statusList);
		//查询该职工所属的职位信息
		//Position position = employeePositionService.list
		return "attendance/myAttendanceEmployeeList";
	}
	
	
	/**
	 * 职工考勤打卡：签到
	 * @param request
	 * @param response
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("sign.do")
	@ResponseBody
	public JsonCommonResult<Object> sign(HttpServletRequest request, HttpServletResponse response) throws ParseException {
		//创建一个职工考勤信息
		AttendanceEmployee attendanceEmployee = new AttendanceEmployee();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm");
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
		
		//设置考勤日期 2020-05-20
		attendanceEmployee.setDate(format2.parse(format.format(new Date()).substring(0, 10)));
		//设置签到时间
		Date nowDate = new Date();
		attendanceEmployee.setSignTime(format.parse(format.format(nowDate)));
		//设置签退时间为null
		attendanceEmployee.setLogoutTime(null);
		
		//获取考勤时间的上午最早签到时间
		AttendanceTime attendanceTime = attendanceTimeService.get();
		String morningEarlyStr = format.format(nowDate).substring(0,10) + " " + attendanceTime.getMorningEarly();
		Date morningEarlyDate = format.parse(morningEarlyStr);
		//获取考勤时间的上午最晚签到时间
		String morningLastStr = format.format(nowDate).substring(0,10) + " " + attendanceTime.getMorningEarly();
		Date morningLastDate = format.parse(morningLastStr);
		
		if (nowDate.getTime() < morningLastDate.getTime()) {
			//在规定的时间范围内签到,设置考勤状态为签到且未签退
			attendanceEmployee.setStatusId(21);
		}else {
			//迟到签到，设置考勤状态为迟到且未签退
			attendanceEmployee.setStatusId(23);
		}
		//获取当前登录系统人工号
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("session_loginUser");
		if (user == null) {
			return new JsonCommonResult<Object>("100", null, "请先登录！");
		}
		//设置签到人工号
		attendanceEmployee.setEmpJobid(user.getUserAccount());
		
		//添加职工考勤信息
		int result = attendanceEmployeeService.add(attendanceEmployee);
		if (result == 0) {
			return new JsonCommonResult<Object>("100", null, "签到失败");
		}
		//设置部门考勤信息
		//获取职工-职位信息
		List<EmployeePosition> employeePositionList = employeePositionService.listByEmpJobId(user.getUserAccount());
		for (EmployeePosition employeePosition : employeePositionList) {
			//找到职工所属职位信息
			Position position = positionService.get(employeePosition.getPositionId());
			//找到职工所属部门信息
			Department department = departmentService.get(position.getDeptId());
			//找到该部门的考勤统计信息
			List<CountAttendanceDepartmant> countAttendanceDepartmantList = countAttendanceDepartmentService.getByDeptId(department.getDeptId());
			if (countAttendanceDepartmantList == null || countAttendanceDepartmantList.size() == 0) {
				//生成一个该部门今日的考勤统计信息
				CountAttendanceDepartmant countAttendanceDepartmant = new CountAttendanceDepartmant();
				countAttendanceDepartmant.setSignDate(format2.parse(format.format(new Date()).substring(0, 10)));
				countAttendanceDepartmant.setDeptId(department.getDeptId());
				countAttendanceDepartmant.setDeptName(department.getDeptName());
				countAttendanceDepartmant.setDeptEmpNum(departmentInfoUtil.getDeptEmpNum(department));
				countAttendanceDepartmentService.add(countAttendanceDepartmant);
				
			}
			CountAttendanceDepartmant countAttendanceDepartmant = countAttendanceDepartmentService.getByDeptId(department.getDeptId()).get(0);
			
			//更新该部门的考勤信息
			//设置考勤状态人数
			if (attendanceEmployee.getStatusId() == 21) {
				//设置考勤状态为签到且未签退人数+1
				countAttendanceDepartmant.setSignNotLogoutNum(countAttendanceDepartmant.getSignNotLogoutNum() + 1);
			}else if(attendanceEmployee.getStatusId() == 22){
				//设置考勤状态为迟到且未签退人数+1
				countAttendanceDepartmant.setLateNotLeaveNum(countAttendanceDepartmant.getLateNotLeaveNum() + 1);
			}
			//更新数据
			countAttendanceDepartmentService.update(countAttendanceDepartmant);
			
			//更新该部门对应上级部门的考勤信息
			while (department != null  && department.getParentId() != null) {
				//设置为新的上级部门
				department = departmentService.get(department.getParentId());
				//找到此部门的考勤统计信息
				List<CountAttendanceDepartmant> countAttendanceParentDepartmantList = countAttendanceDepartmentService.getByDeptId(department.getDeptId());
				if (countAttendanceParentDepartmantList == null || countAttendanceParentDepartmantList.size() == 0) {
					//生成一个该部门今日的考勤统计信息
					CountAttendanceDepartmant countAttendanceParentDepartmant = new CountAttendanceDepartmant();
					countAttendanceParentDepartmant.setSignDate(format2.parse(format.format(new Date()).substring(0, 10)));
					countAttendanceParentDepartmant.setDeptId(department.getDeptId());
					countAttendanceParentDepartmant.setDeptName(department.getDeptName());
					countAttendanceParentDepartmant.setDeptEmpNum(departmentInfoUtil.getDeptEmpNum(department));
					countAttendanceDepartmentService.add(countAttendanceParentDepartmant);
				}
				//找到该部门的考勤统计信息
				CountAttendanceDepartmant countAttendanceParentDepartmant = countAttendanceDepartmentService.getByDeptId(department.getDeptId()).get(0);
				//更新该部门的考勤信息
				//设置考勤状态人数
				if (attendanceEmployee.getStatusId() == 21) {
					//设置考勤状态为签到且未签退人数+1
					countAttendanceParentDepartmant.setSignNotLogoutNum(countAttendanceParentDepartmant.getSignNotLogoutNum() + 1);
				}else if(attendanceEmployee.getStatusId() == 22){
					//设置考勤状态为迟到且未签退人数+1
					countAttendanceParentDepartmant.setLateNotLeaveNum(countAttendanceParentDepartmant.getLateNotLeaveNum() + 1);
				}
				//更新数据
				countAttendanceDepartmentService.update(countAttendanceParentDepartmant);
			}
			
		}
		
		return new JsonCommonResult<Object>("200", null, "签到成功");
	}
	
	
	
}
