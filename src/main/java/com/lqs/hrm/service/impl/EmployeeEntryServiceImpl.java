package com.lqs.hrm.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lqs.hrm.entity.EmployeeEntry;
import com.lqs.hrm.entity.EmployeeEntryExample;
import com.lqs.hrm.mapper.EmployeeEntryMapper;
import com.lqs.hrm.mapper.EmployeeMapper;
import com.lqs.hrm.service.EmployeeEntryService;

/**
 * 职工入职Service实现类
 * @author luckyliuqs
 *
 */
@Service
public class EmployeeEntryServiceImpl implements EmployeeEntryService{
	@Autowired
	private EmployeeEntryMapper employeeEntryMapper;
	
	/**
	 * 根据职工入职id查询
	 */
	@Override
	public EmployeeEntry get(Integer eeId) {
		return employeeEntryMapper.selectByPrimaryKey(eeId);
	}

	/**
	 * 根据入职日期查询
	 */
	@Override
	public List<EmployeeEntry> get(Date beginDate, Date endDate) {
		EmployeeEntryExample example = new EmployeeEntryExample();
		example.or().andEntryDateBetween(beginDate, endDate);
		return employeeEntryMapper.selectByExample(example);
	}

	/**
	 * 更新职工入职信息
	 */
	@Override
	public int update(EmployeeEntry employeeEntry) {
		return employeeEntryMapper.updateByPrimaryKeySelective(employeeEntry);
	}

}
