package com.lqs.hrm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lqs.hrm.entity.DepartmentLevel;
import com.lqs.hrm.entity.DepartmentLevelExample;
import com.lqs.hrm.entity.PositionLevel;
import com.lqs.hrm.entity.PositionLevelExample;
import com.lqs.hrm.mapper.DepartmentLevelMapper;
import com.lqs.hrm.mapper.PositionLevelMapper;
import com.lqs.hrm.service.DepartmentLevelService;
import com.lqs.hrm.service.PositionLevelService;

/**
 * 职位级别Service
 * @author luckyliuqs
 *
 */
@Service
public class PositionLevelServiceImpl implements PositionLevelService{
	@Autowired
	private PositionLevelMapper positionLevelMapper;

	/**
	 * 指定的职位级别信息
	 */
	@Override
	public PositionLevel get(Integer plId) {
		return positionLevelMapper.selectByPrimaryKey(plId);
	}

	/**
	 * 职位级别列表
	 */
	@Override
	public List<PositionLevel> list() {
		PositionLevelExample example = new PositionLevelExample();
		example.createCriteria().andPlIdIsNotNull();
		return positionLevelMapper.selectByExample(example);
	}

}
