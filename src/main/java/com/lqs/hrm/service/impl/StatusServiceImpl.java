package com.lqs.hrm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lqs.hrm.entity.Status;
import com.lqs.hrm.entity.StatusExample;
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
	
	/**
	 * 返回指定状态id的状态
	 */
	@Override
	public Status get(Integer statusId) {
		Status status = statusMapper.selectByPrimaryKey(statusId);
		if (status == null) {
			return null;
		}
		return status;
	}

	/**
	 * 返回所有部门状态信息
	 */
	@Override
	public List<Status> list() {
		StatusExample example = new StatusExample();
		//部门状态类型为4
		example.or().andStatusTypeEqualTo(4);
		return statusMapper.selectByExample(example);
	}

}
