package com.lqs.hrm.service;

import java.util.List;

import com.lqs.hrm.entity.Employee;
import com.lqs.hrm.entity.EmployeeContract;
import com.lqs.hrm.entity.Status;

/**
 * 职工-合同Service接口
 * @author Administrator
 *
 */
public interface EmployeeContractService {
	
	/**
	 * 返回指定id的职工合同信息
	 * @param statusId
	 * @return
	 */
	EmployeeContract get(Integer ecId);
	
	/**
	 * 返回指定合同id的职工合同信息
	 * @return
	 */
	List<EmployeeContract> getByConId(Integer conId);
	
	/**
	 * 返回指定职工id的职工合同信息
	 * @return
	 */
	List<EmployeeContract> getByEmpJobid(String empJobid);
	
	/**
	 * 返回指定合同id、职工id的职工合同信息
	 * @return
	 */
	List<EmployeeContract> getByConIdEmpJobid(Integer conId, String empJobid);
	
	/**
	 * 返回所有职工合同信息
	 * @return
	 */
	List<EmployeeContract> getAll();
	
}
