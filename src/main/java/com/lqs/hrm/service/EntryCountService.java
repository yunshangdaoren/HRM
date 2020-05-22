package com.lqs.hrm.service;

import java.util.Date;
import java.util.List;
import com.lqs.hrm.entity.EntryCount;

/**
 * 入职统计Service接口
 * @author Administrator
 *
 */
public interface EntryCountService {
	/**
	 * 根据入职统计id查询
	 * @param ecId
	 * @return
	 */
	EntryCount get(Integer ecId);
	
	/**
	 * 根据入职统计日期查询
	 * @param conId
	 * @return
	 */
	List<EntryCount> get(Date beginDate, Date endDate);
	
	/**
	 * 更新入职统计信息
	 * @param entryCount
	 * @return
	 */
	int update(EntryCount entryCount);

	/**
	 * 新增入职统计信息
	 * @param entryCount
	 * @return
	 */
	int add(EntryCount entryCount);
}
