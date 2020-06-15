package com.lqs.hrm.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lqs.hrm.entity.Employee;
import com.lqs.hrm.entity.EmployeeExample;
import com.lqs.hrm.mapper.EmployeeMapper;
import com.lqs.hrm.service.EmployeeService;

/**
 * 员工信息Service
 * @author Administrator
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	EmployeeMapper employeeMapper;
	
	/**
	 * 根据职工工号查询
	 */
	@Override
	public Employee get(String empJobId) {
		return employeeMapper.selectByPrimaryKey(empJobId);
	}
	
	/**
	 * 根据职工名称查询
	 */
	@Override
	public List<Employee> listByEmpName(String empName) {
		EmployeeExample example = new EmployeeExample();
		//按照日期排序
		example.setOrderByClause("entry_time desc");
		example.or().andEmpNameEqualTo(empName).andEmpJobidNotEqualTo("1");
		return employeeMapper.selectByExample(example);
	}
	
	/**
	 * 根据职工状态id查询
	 */
	@Override
	public List<Employee> listByStatusId(Integer statusId) {
		EmployeeExample example = new EmployeeExample();
		//按照日期排序
		example.setOrderByClause("entry_time desc");
		example.or().andStatusIdEqualTo(statusId).andEmpJobidNotEqualTo("1");
		return employeeMapper.selectByExample(example);
	}
	
	/**
	 * 根据职工工号和姓名查询
	 */
	@Override
	public List<Employee> listByEmpJobIdEmpName(String empJobId, String empName) {
		EmployeeExample example = new EmployeeExample();
		//按照日期排序
		example.setOrderByClause("entry_time desc");
		example.or().andEmpJobidEqualTo(empJobId).andEmpNameEqualTo(empName).andEmpJobidNotEqualTo("1");
		return employeeMapper.selectByExample(example);
	}
	
	/**
	 * 根据职工工号，状态id查询
	 */
	@Override
	public List<Employee> listByEmpJobIdStatusId(String empJobId, Integer statusId) {
		EmployeeExample example = new EmployeeExample();
		//按照日期排序
		example.setOrderByClause("entry_time desc");
		example.or().andEmpJobidEqualTo(empJobId).andStatusIdEqualTo(statusId).andEmpJobidNotEqualTo("1");
		return employeeMapper.selectByExample(example);
	}
	
	/**
	 * 根据职工姓名，状态id查询
	 */
	@Override
	public List<Employee> listByEmpNameStatusId(String empName, Integer statusId) {
		EmployeeExample example = new EmployeeExample();
		//按照日期排序
		example.setOrderByClause("entry_time desc");
		example.or().andEmpNameEqualTo(empName).andStatusIdEqualTo(statusId).andEmpJobidNotEqualTo("1");
		return employeeMapper.selectByExample(example);
	}
	
	/**
	 * 根据职工工号，姓名，状态id查询
	 */
	@Override
	public List<Employee> listByEmpJobIdEmpNameStatusId(String empJobId, String empName, Integer statusId) {
		EmployeeExample example = new EmployeeExample();
		//按照日期排序
		example.setOrderByClause("entry_time desc");
		example.or().andEmpJobidEqualTo(empJobId).andEmpNameEqualTo(empName).andStatusIdEqualTo(statusId).andEmpJobidNotEqualTo("1");
		return employeeMapper.selectByExample(example);
	}
	
	/**
	 * 根据职工性别查询
	 */
	@Override
	public List<Employee> listByEmpSex(Integer empSex) {
		EmployeeExample example = new EmployeeExample();
		//按照日期排序
		example.setOrderByClause("entry_time desc");
		example.or().andEmpSexEqualTo(empSex).andEmpJobidNotEqualTo("1");
		return employeeMapper.selectByExample(example);
	}
	
	/**
	 * 查询出所有职工信息,处理超级管理员
	 */
	public List<Employee> listByNoExceptSuperManager(){
		EmployeeExample example = new EmployeeExample();
		//按照日期排序
		example.setOrderByClause("entry_time desc");
		example.or().andEmpJobidNotEqualTo("1");
		return employeeMapper.selectByExample(example);
	}

	/**
	 * 添加职工信息
	 */
	@Override
	public int add(Employee employee) {
		return employeeMapper.insertSelective(employee);
	}

	/**
	 * 修改职工信息
	 */
	@Override
	public int update(Employee employee) {
		return employeeMapper.updateByPrimaryKeySelective(employee);
	}

}
