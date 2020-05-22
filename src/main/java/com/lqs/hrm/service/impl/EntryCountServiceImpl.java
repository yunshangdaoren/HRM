package com.lqs.hrm.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lqs.hrm.entity.EntryCount;
import com.lqs.hrm.entity.EntryCountExample;
import com.lqs.hrm.mapper.EmployeeMapper;
import com.lqs.hrm.mapper.EntryCountMapper;
import com.lqs.hrm.service.EntryCountService;

/**
 * 入职统计Service实现类
 * @author luckyliuqs
 *
 */
@Service
public class EntryCountServiceImpl implements EntryCountService{
	@Autowired
	private EntryCountMapper entryCountMapper;
	
	/**
	 * 根据入职统计id查询
	 */
	@Override
	public EntryCount get(Integer ecId) {
		return entryCountMapper.selectByPrimaryKey(ecId);
	}

	/**
	 * 根据入职统计日期查询
	 */
	@Override
	public List<EntryCount> get(Date beginDate, Date endDate) {
		EntryCountExample example = new EntryCountExample();
		example.or().andEntryDateBetween(beginDate, endDate);
		return entryCountMapper.selectByExample(example);
	}

	/**
	 * 更新入职统计信息
	 */
	@Override
	public int update(EntryCount entryCount) {
		return entryCountMapper.updateByPrimaryKeySelective(entryCount);
	}

	/**
	 * 新增入职统计信息
	 */
	@Override
	public int add(EntryCount entryCount) {
		return entryCountMapper.insert(entryCount);
	}

}
