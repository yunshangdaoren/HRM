package com.lqs.hrm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lqs.hrm.entity.EmployeeResign;
import com.lqs.hrm.entity.EmployeeResignExample;
import com.lqs.hrm.mapper.EmployeeResignMapper;
import com.lqs.hrm.service.EmployeeResignService;

/**
 * 职工离职Service实现类
 * @author luckyliuqs
 *
 */
@Service
public class EmployeeResignServiceImpl implements EmployeeResignService{
	@Autowired
	private EmployeeResignMapper employeeResignMapper;

	/**
	 * 根据id查询
	 */
	@Override
	public EmployeeResign get(Integer resignId) {
		return employeeResignMapper.selectByPrimaryKey(resignId);
	}

	/**
	 * 根据职工工号查询
	 */
	@Override
	public List<EmployeeResign> listByEmpJobId(String empJobId) {
		EmployeeResignExample example = new EmployeeResignExample();
		//按照日期排序
		example.setOrderByClause("apply_date desc");
		example.or().andEmpJobidEqualTo(empJobId);
		return employeeResignMapper.selectByExample(example);
	}
	
	/**
	 * 根据职工状态id查询
	 */
	@Override
	public List<EmployeeResign> listByStatusId(Integer statusId) {
		EmployeeResignExample example = new EmployeeResignExample();
		//按照日期排序
		example.setOrderByClause("apply_date desc");
		example.or().andStatusIdEqualTo(statusId);
		return employeeResignMapper.selectByExample(example);
	}

	/**
	 * 根据id和职工工号查询
	 */
	@Override
	public List<EmployeeResign> listByResignIdEmpJobId(Integer resignId, String empJobId) {
		EmployeeResignExample example = new EmployeeResignExample();
		//按照日期排序
		example.setOrderByClause("apply_date desc");
		example.or().andResignIdEqualTo(resignId).andEmpJobidEqualTo(empJobId);
		return employeeResignMapper.selectByExample(example);
	}

	/**
	 * 根据id和状态id查询
	 */
	@Override
	public List<EmployeeResign> listByResignIdStatusId(Integer resignId, Integer statusId) {
		EmployeeResignExample example = new EmployeeResignExample();
		//按照日期排序
		example.setOrderByClause("apply_date desc");
		example.or().andResignIdEqualTo(resignId).andStatusIdEqualTo(statusId);
		return employeeResignMapper.selectByExample(example);
	}

	/**
	 * 根据职工工号和状态id查询
	 */
	@Override
	public List<EmployeeResign> listByEmpJobIdStatusId(String empJobId, Integer statusId) {
		EmployeeResignExample example = new EmployeeResignExample();
		//按照日期排序
		example.setOrderByClause("apply_date desc");
		example.or().andEmpJobidEqualTo(empJobId).andStatusIdEqualTo(statusId);
		return employeeResignMapper.selectByExample(example);
	}
	
	/**
	 * 根据id，职工工号和状态id查询
	 */
	@Override
	public List<EmployeeResign> listByResignIdEmpJobIdStatusId(Integer resignId, String empJobId, Integer statusId) {
		EmployeeResignExample example = new EmployeeResignExample();
		//按照日期排序
		example.setOrderByClause("apply_date desc");
		example.or().andResignIdEqualTo(resignId).andEmpJobidEqualTo(empJobId).andStatusIdEqualTo(statusId);
		return employeeResignMapper.selectByExample(example);
	}
	
	/**
	 * 查询出所有职工离职信息
	 */
	@Override
	public List<EmployeeResign> listByNo() {
		EmployeeResignExample example = new EmployeeResignExample();
		//按照日期排序
		example.setOrderByClause("apply_date desc");
		example.or().andResignIdIsNotNull();
		return employeeResignMapper.selectByExample(example);
	}

	/**
	 * 添加职工离职信息
	 */
	@Override
	public int add(EmployeeResign employeeResign) {
		return employeeResignMapper.insertSelective(employeeResign);
	}

	/**
	 * 修改职工离职信息
	 */
	@Override
	public int update(EmployeeResign employeeResign) {
		return employeeResignMapper.updateByPrimaryKeySelective(employeeResign);
	}


}
