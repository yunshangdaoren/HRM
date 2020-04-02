package com.lqs.hrm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lqs.hrm.entity.Status;
import com.lqs.hrm.mapper.StatusMapper;
import com.lqs.hrm.service.StatusService;

/**
 * 状态Service
 * @author Administrator
 *
 */
@Service
public class StatusServiceImpl implements StatusService{
	@Autowired
	private StatusMapper statusMapper;
	
	@Override
	public Status get(int statusId) {
		return statusMapper.selectByPrimaryKey(statusId);
	}

}
