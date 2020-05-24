package com.lqs.hrm.service;

import java.util.Date;
import java.util.List;

import com.lqs.hrm.entity.Employee;
import com.lqs.hrm.entity.EmployeeResign;

/**
 * 职工离职Service接口
 * @author luckyliuqs
 *
 */
public interface EmployeeResignService {
	/**
	 * 根据id查询
	 * @param 
	 * @return 
	 */
	EmployeeResign get(Integer resignId);
	/**
	 * 根据职工工号查询
	 * @param empName
	 * @param deptId
	 * @return
	 */
	List<EmployeeResign> listByEmpJobId(String empJobId);
	/**
	 * 根据职工状态id查询
	 * @param statusId
	 * @return
	 */
	List<EmployeeResign> listByStatusId(Integer statusId);
	/**
	 * 根据id和职工工号查询
	 * @param resignId
	 * @param empJobId
	 * @return
	 */
	List<EmployeeResign> listByResignIdEmpJobId(Integer resignId, String empJobId);
	/**
	 * 根据id和状态id查询
	 * @param resignId
	 * @param statusId
	 * @return
	 */
	List<EmployeeResign> listByResignIdStatusId(Integer resignId, Integer statusId);
	/**
	 * 根据职工工号和状态id查询
	 * @param empJobId
	 * @param statusId
	 * @return
	 */
	List<EmployeeResign> listByEmpJobIdStatusId(String empJobId, Integer statusId);
	/**
	 * /**
	 * 根据id，职工工号和状态id查询
	 * @param empJobId
	 * @param statusId
	 * @return
	 */
	List<EmployeeResign> listByResignIdEmpJobIdStatusId(Integer resignId, String empJobId, Integer statusId);
	/**
	 * 查询出所有职工离职信息
	 * @return
	 */
	List<EmployeeResign> listByNo();
	
	/**
	 * 添加职工离职信息
	 * @param employee
	 * @return
	 */
	int add(EmployeeResign employeeResign);
	
	/**
	 * 修改职工离职信息
	 * @param employee
	 * @return
	 */
	int update(EmployeeResign employeeResign);
	
	
}
