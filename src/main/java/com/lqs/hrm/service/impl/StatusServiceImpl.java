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
	 * 返回指定状态类型的状态信息
	 * 1：系统用户状态
	   2：系统权限状态
	   3：系统角色状态
	   4：部门状态
	   5：职工状态
	   6：职位状态
	   7：合同状态
	   8：消息状态
	   9：工资状态
	   10：考勤状态
	   11：考评状态
	 */
	@Override
	public List<Status> list(int statusType) {
		StatusExample example = new StatusExample();
		example.or().andStatusTypeEqualTo(statusType);
		return statusMapper.selectByExample(example);
	}

}
