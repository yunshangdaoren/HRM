package com.lqs.hrm.service;

import com.lqs.hrm.entity.Status;

/**
 * 状态Service接口
 * @author Administrator
 *
 */
public interface StatusService {
	
	/**
	 * 获取指定状态id的状态
	 * @param statusId
	 * @return
	 */
	Status get(int statusId);
}
