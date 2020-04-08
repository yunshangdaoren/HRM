package com.lqs.hrm.service;

import java.util.List;

import com.lqs.hrm.entity.Status;

/**
 * 状态Service接口
 * @author Administrator
 *
 */
public interface StatusService {
	
	/**
	 * 返回指定状态id的状态
	 * @param statusId
	 * @return
	 */
	Status get(Integer statusId);
	
	/**
	 * 返回所有部门状态信息
	 * @return
	 */
	List<Status> list();
}
