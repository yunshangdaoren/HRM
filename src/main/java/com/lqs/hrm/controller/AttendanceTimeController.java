package com.lqs.hrm.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lqs.hrm.entity.AttendanceEmployee;
import com.lqs.hrm.entity.Contract;
import com.lqs.hrm.entity.User;
import com.lqs.hrm.json.JsonCommonResult;
import com.lqs.hrm.service.impl.AttendanceEmployeeServiceImpl;

/**
 * 签到时间设置信息Controller
 * @author luckyliuqs
 *
 */
@Controller
@RequestMapping("attendance")
public class AttendanceTimeController {
	@Autowired
	private AttendanceEmployeeServiceImpl attendanceEmployeeService;
	
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
		//设置签到时间
		attendanceEmployee.setSignTime(new Date());
		//设置考勤信息状态:未签退
		attendanceEmployee.setStatusId(20);
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
		return new JsonCommonResult<Object>("200", null, "签到成功");
	}
	
	
	
}
