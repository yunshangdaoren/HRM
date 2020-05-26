package com.lqs.hrm.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lqs.hrm.entity.AttendanceEmployee;
import com.lqs.hrm.entity.AttendanceEmployeeExample;
import com.lqs.hrm.mapper.AttendanceEmployeeMapper;
import com.lqs.hrm.service.AttendanceEmployeeService;
import com.lqs.hrm.service.AttendanceTimeService;

/**
 * 职工考勤信息Service实现类
 * @author luckyliuqs
 *
 */
@Service
public class AttendanceEmployeeServiceImpl implements AttendanceEmployeeService{
	@Autowired
	private AttendanceEmployeeMapper attendanceEmployeeMapper;
	
	/**
	 * 根据id查询
	 */
	@Override
	public AttendanceEmployee get(Integer aeId) {
		return attendanceEmployeeMapper.selectByPrimaryKey(aeId);
	}

	/**
	 * 根据考勤日期查询
	 */
	@Override
	public List<AttendanceEmployee> listByDate(Date date) {
		AttendanceEmployeeExample example = new AttendanceEmployeeExample();
		example.or().andDateEqualTo(date);
		return attendanceEmployeeMapper.selectByExample(example);
	}

	/**
	 * 根据指定开始日期和结束日期查询
	 */
	@Override
	public List<AttendanceEmployee> listByDate(Date beginDate, Date endDate) {
		AttendanceEmployeeExample example = new AttendanceEmployeeExample();
		example.or().andDateBetween(beginDate, endDate);
		return attendanceEmployeeMapper.selectByExample(example);
	}

	/**
	 * 根据职工工号查询
	 */
	@Override
	public List<AttendanceEmployee> listByEmpJobId(String empJobId) {
		AttendanceEmployeeExample example = new AttendanceEmployeeExample();
		example.or().andEmpJobidEqualTo(empJobId);
		return attendanceEmployeeMapper.selectByExample(example);
	}

	/**
	 * 根据考勤状态id查询
	 */
	@Override
	public List<AttendanceEmployee> listByStatusId(Integer statusId) {
		AttendanceEmployeeExample example = new AttendanceEmployeeExample();
		example.or().andStatusIdEqualTo(statusId);
		return attendanceEmployeeMapper.selectByExample(example);
	}

	/**
	 * 根据职工工号，考勤日期查询
	 */
	@Override
	public List<AttendanceEmployee> listByEmpJobIdDate(String empJobId, Date date) {
		AttendanceEmployeeExample example = new AttendanceEmployeeExample();
		example.or().andEmpJobidEqualTo(empJobId).andDateEqualTo(date);
		return attendanceEmployeeMapper.selectByExample(example);
	}

	/**
	 * 根据职工工号和状态id查询
	 */
	@Override
	public List<AttendanceEmployee> listByEmpJobIdStatusId(String empJobId, Integer statusId) {
		AttendanceEmployeeExample example = new AttendanceEmployeeExample();
		example.or().andEmpJobidEqualTo(empJobId).andStatusIdEqualTo(statusId);
		return attendanceEmployeeMapper.selectByExample(example);
	}

	/**
	 * 根据考勤日期和状态id查询
	 */
	@Override
	public List<AttendanceEmployee> listByDateStatusId(Date date, Integer statusId) {
		AttendanceEmployeeExample example = new AttendanceEmployeeExample();
		example.or().andDateEqualTo(date).andStatusIdEqualTo(statusId);
		return attendanceEmployeeMapper.selectByExample(example);
	}

	/**
	 * 根据职工工号，考勤日期，状态id查询
	 */
	@Override
	public List<AttendanceEmployee> listByEmpJobIdDateStatusId(String empJobId, Date date, Integer statusId) {
		AttendanceEmployeeExample example = new AttendanceEmployeeExample();
		example.or().andEmpJobidEqualTo(empJobId).andDateEqualTo(date).andStatusIdEqualTo(statusId);
		return attendanceEmployeeMapper.selectByExample(example);
	}
	
	/**
	 * 查询出所有职工考勤信息
	 */
	@Override
	public List<AttendanceEmployee> listByNo() {
		AttendanceEmployeeExample example = new AttendanceEmployeeExample();
		example.or().andAeIdIsNotNull();
		return attendanceEmployeeMapper.selectByExample(example);
	}
	
	/**
	 * 添加职工考勤信息
	 */
	@Override
	public int add(AttendanceEmployee attendanceEmployee) {
		return attendanceEmployeeMapper.insert(attendanceEmployee);
	}

	/**
	 * 删除职工考勤信息
	 */
	@Override
	public int update(AttendanceEmployee attendanceEmployee) {
		return attendanceEmployeeMapper.updateByPrimaryKeySelective(attendanceEmployee);
	}


}
