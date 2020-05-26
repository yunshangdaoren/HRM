package com.lqs.hrm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lqs.hrm.entity.AttendanceTime;
import com.lqs.hrm.entity.AttendanceTimeExample;
import com.lqs.hrm.mapper.AttendanceTimeMapper;
import com.lqs.hrm.service.AttendanceTimeService;

/**
 * 签到时间设置信息Service实现类
 * @author luckyliuqs
 *
 */
@Service
public class AttendanceTimeServiceImpl implements AttendanceTimeService{
	@Autowired
	private AttendanceTimeMapper attendanceTimeMapper;
	
	/**
	 * 查询签到时间信息
	 */
	@Override
	public AttendanceTime get() {
		AttendanceTimeExample example = new AttendanceTimeExample();
		example.or().andAtIdIsNotNull();
		return attendanceTimeMapper.selectByExample(example).get(0);
	}

	/**
	 * 修改签到时间信息
	 */
	@Override
	public int update(AttendanceTime attendanceTime) {
		return attendanceTimeMapper.updateByPrimaryKeySelective(attendanceTime);
	}

}
