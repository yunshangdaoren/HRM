package com.lqs.hrm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lqs.hrm.entity.Contract;
import com.lqs.hrm.entity.ContractExample;
import com.lqs.hrm.mapper.ContractMapper;
import com.lqs.hrm.service.ContractService;

/**
 * 合同Service实现类
 * @author luckyliuqs
 *
 */
@Service
public class ContractServiceImpl implements ContractService{
	@Autowired
	private ContractMapper contractMapper;
	
	/**
	 * 根据合同id查询
	 */
	@Override
	public Contract get(Integer conId) {
		return contractMapper.selectByPrimaryKey(conId);
	}
	
	/**
	 * 根据合同所属部门id查询
	 */
	@Override
	public List<Contract> listBydeptId(Integer deptId) {
		ContractExample example = new ContractExample();
		example.or().andDeptIdEqualTo(deptId);
		return contractMapper.selectByExample(example);
	}

	/**
	 * 根据合同所属职位id查询
	 */
	@Override
	public List<Contract> listByPositionId(Integer positionId) {
		ContractExample example = new ContractExample();
		example.or().andPositionIdEqualTo(positionId);
		return contractMapper.selectByExample(example);
	}

	/**
	 * 根据合同所属状态id查询
	 */
	@Override
	public List<Contract> listByStatusId(Integer statusId) {
		ContractExample example = new ContractExample();
		example.or().andStatusIdEqualTo(statusId);
		return contractMapper.selectByExample(example);
	}

	/**
	 * 根据合同id、所属部门id查询
	 */
	@Override
	public List<Contract> listByConIdDeptId(Integer conId, Integer deptId) {
		ContractExample example = new ContractExample();
		example.or().andConIdEqualTo(conId).andDeptIdEqualTo(deptId);
		return contractMapper.selectByExample(example);
	}

	/**
	 * 根据合同id、所属职位id查询
	 */
	@Override
	public List<Contract> listByConIdPositionId(Integer conId, Integer positionId) {
		ContractExample example = new ContractExample();
		example.or().andConIdEqualTo(conId).andPositionIdEqualTo(positionId);
		return contractMapper.selectByExample(example);
	}

	/**
	 * 根据合同id、所属状态id查询
	 */
	@Override
	public List<Contract> listByConIdStatusId(Integer conId, Integer statusId) {
		ContractExample example = new ContractExample();
		example.or().andConIdEqualTo(conId).andStatusIdEqualTo(statusId);
		return contractMapper.selectByExample(example);
	}

	/**
	 * 根据合同所属部门id、所属职位id查询
	 */
	@Override
	public List<Contract> listByDeptIdPositionId(Integer deptId, Integer positionId) {
		ContractExample example = new ContractExample();
		example.or().andDeptIdEqualTo(deptId).andPositionIdEqualTo(positionId);
		return contractMapper.selectByExample(example);
	}

	/**
	 * 根据合同所属部门id、状态id查询
	 */
	@Override
	public List<Contract> listByDeptIdStatusId(Integer deptId, Integer statusId) {
		ContractExample example = new ContractExample();
		example.or().andDeptIdEqualTo(deptId).andStatusIdEqualTo(statusId);
		return contractMapper.selectByExample(example);
	}

	/**
	 * 根据合同所属职位id、所属状态id查询
	 */
	@Override
	public List<Contract> listByPositionIdStatusId(Integer positionId, Integer statusId) {
		ContractExample example = new ContractExample();
		example.or().andPositionIdEqualTo(positionId).andStatusIdEqualTo(statusId);
		return contractMapper.selectByExample(example);
	}

	/**
	 * 根据合同id、所属部门id、所属职位id查询
	 */
	@Override
	public List<Contract> listByConIdDeptIdPositionId(Integer conId, Integer deptId, Integer positionId) {
		ContractExample example = new ContractExample();
		example.or().andConIdEqualTo(conId).andDeptIdEqualTo(deptId).andPositionIdEqualTo(positionId);
		return contractMapper.selectByExample(example);
	}

	/**
	 * 根据合同id、所属部门id、状态id查询
	 */
	@Override
	public List<Contract> listByConIdDeptIdStatusId(Integer conId, Integer deptId, Integer statusId) {
		ContractExample example = new ContractExample();
		example.or().andConIdEqualTo(conId).andDeptIdEqualTo(deptId).andStatusIdEqualTo(statusId);
		return contractMapper.selectByExample(example);
	}

	/**
	 * 根据合同id、所属职位id、状态id查询
	 */
	@Override
	public List<Contract> listByConIdPositionIdStatusId(Integer conId, Integer positionId, Integer statusId) {
		ContractExample example = new ContractExample();
		example.or().andConIdEqualTo(conId).andPositionIdEqualTo(positionId).andStatusIdEqualTo(statusId);
		return contractMapper.selectByExample(example);
	}
	
	/**
	 * 根据合同所属部门id、所属职位id、状态id查询
	 */
	@Override
	public List<Contract> listByDeptIdPositionIdStatusId(Integer deptId, Integer positionId, Integer statusId) {
		ContractExample example = new ContractExample();
		example.or().andDeptIdEqualTo(deptId).andPositionIdEqualTo(positionId).andStatusIdEqualTo(statusId);
		return contractMapper.selectByExample(example);
	}

	/**
	 * 根据合同id、所属部门id、所属职位id、所属状态id查询
	 */
	@Override
	public List<Contract> listByConIdDeptIdPositionStatusId(Integer conId, Integer deptId, Integer positionId,
			Integer statusId) {
		ContractExample example = new ContractExample();
		example.or().andConIdEqualTo(conId).andDeptIdEqualTo(deptId).andPositionIdEqualTo(positionId).andStatusIdEqualTo(statusId);
		return contractMapper.selectByExample(example);
	}
	
	/**
	 * 查询出所有合同信息
	 */
	@Override
	public List<Contract> listByNo() {
		ContractExample example = new ContractExample();
		example.or().andConIdIsNotNull();
		return contractMapper.selectByExample(example);
	}
	
	/**
	 * 添加合同
	 */
	@Override
	public int insert(Contract contract) {
		return contractMapper.insertSelective(contract);
	}

	/**
	 * 更新合同
	 */
	@Override
	public int update(Contract contract) {
		return contractMapper.updateByPrimaryKeySelective(contract);
	}

	/**
	 * 删除合同
	 */
	@Override
	public int delte(Integer conId) {
		return contractMapper.deleteByPrimaryKey(conId);
	}

	/**
	 * 根据职工姓名查询
	 */
	@Override
	public List<Contract> listByEmpName(String empName) {
		ContractExample example = new ContractExample();
		example.or().andEmpNameEqualTo(empName);
		return contractMapper.selectByExample(example);
	}
	
	/**
	 * 根据职工姓名、状态id查询
	 */
	@Override
	public List<Contract> listByEmpNameStatusId(String empName, Integer statusId) {
		ContractExample example = new ContractExample();
		example.or().andEmpNameEqualTo(empName).andStatusIdEqualTo(statusId);
		return contractMapper.selectByExample(example);
	}

}
