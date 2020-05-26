package com.lqs.hrm.service;

import java.util.List;

import com.lqs.hrm.entity.AttendanceTime;

/**
 * 签到时间设置信息Service接口
 * @author luckyliuqs
 *
 */
public interface AttendanceTimeService {
	
	/**
	 * 查询签到时间信息
	 * @param atId
	 * @return
	 */
	AttendanceTime get();
	
	/**
	 * 修改签到时间信息
	 * @param attendanceTime
	 * @return
	 */
	int update(AttendanceTime attendanceTime);
	
}
