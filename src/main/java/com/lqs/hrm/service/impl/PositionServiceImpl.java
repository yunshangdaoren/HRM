package com.lqs.hrm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lqs.hrm.entity.Department;
import com.lqs.hrm.entity.DepartmentExample;
import com.lqs.hrm.entity.Employee;
import com.lqs.hrm.entity.Position;
import com.lqs.hrm.entity.PositionExample;
import com.lqs.hrm.mapper.DepartmentMapper;
import com.lqs.hrm.mapper.PositionMapper;
import com.lqs.hrm.service.DepartmentService;
import com.lqs.hrm.service.PositionService;

/**
 * 职位信息Service
 * @author luckyliuqs
 *
 */
@Service
public class PositionServiceImpl implements PositionService{
	@Autowired
	private PositionMapper positionMapper;
	

	@Override
	public Position get(Integer positionId) {
		return positionMapper.selectByPrimaryKey(positionId);
	}

	@Override
	public List<Position> listByPositionName(String positionName) {
		 PositionExample example  = new PositionExample();
		 //按照日期排序
		 example.setOrderByClause("last_operator_date desc");
		 example.createCriteria().andPositionNameLike("%"+positionName+"%");
		return positionMapper.selectByExample(example);
	}

	@Override
	public List<Position> listByDeptId(Integer deptId) {
		 PositionExample example  = new PositionExample();
		 //按照日期排序
		 example.setOrderByClause("last_operator_date desc");
		 example.or().andDeptIdEqualTo(deptId);
		return positionMapper.selectByExample(example);
	}

	@Override
	public List<Position> listByPlId(Integer plId) {
		 PositionExample example  = new PositionExample();
		 //按照日期排序
		 example.setOrderByClause("last_operator_date desc");
		 example.or().andPlIdEqualTo(plId);
		return positionMapper.selectByExample(example);
	}

	@Override
	public List<Position> listByPositionIdName(Integer positionId, String positionName) {
		PositionExample example  = new PositionExample();
		//按照日期排序
		example.setOrderByClause("last_operator_date desc");
		example.or().andPositionIdEqualTo(positionId).andPositionNameEqualTo(positionName);
		return positionMapper.selectByExample(example);
	}

	@Override
	public List<Position> listByPositionIdDeptId(Integer positionId, Integer deptId) {
		 PositionExample example  = new PositionExample();
		 //按照日期排序
		 example.setOrderByClause("last_operator_date desc");
		 example.or().andPositionIdEqualTo(positionId).andDeptIdEqualTo(deptId);
		return positionMapper.selectByExample(example);
	}

	@Override
	public List<Position> listByPositionIdPlId(Integer positionId, Integer plId) {
		PositionExample example  = new PositionExample(); //按照日期排序
		example.setOrderByClause("last_operator_date desc");
		example.or().andPositionIdEqualTo(positionId).andPlIdEqualTo(plId);
		return positionMapper.selectByExample(example);
	}

	@Override
	public List<Position> listByPositionNameDeptId(String positionName, Integer deptId) {
		PositionExample example  = new PositionExample();
		//按照日期排序
		example.setOrderByClause("last_operator_date desc");
		example.or().andPositionNameEqualTo(positionName).andDeptIdEqualTo(deptId);
		return positionMapper.selectByExample(example);
	}

	@Override
	public List<Position> listByPositionNamePlId(String positionName, Integer plId) {
		PositionExample example  = new PositionExample();
		//按照日期排序
		example.setOrderByClause("last_operator_date desc");
		example.or().andPositionNameEqualTo(positionName).andPlIdEqualTo(plId);
		return positionMapper.selectByExample(example);
	}

	@Override
	public List<Position> listByDeptIdPlId(Integer deptId, Integer plId) {
		PositionExample example  = new PositionExample();
		//按照日期排序
		example.setOrderByClause("last_operator_date desc");
		example.or().andDeptIdEqualTo(deptId).andPlIdEqualTo(plId);
		return positionMapper.selectByExample(example);
	}

	@Override
	public List<Position> listByPositionIdNameDeptId(Integer positionId, String positionName, Integer deptId) {
		PositionExample example  = new PositionExample();
		//按照日期排序
		example.setOrderByClause("last_operator_date desc");
		example.or().andPositionIdEqualTo(positionId).andPositionNameEqualTo(positionName).andDeptIdEqualTo(deptId);
		return positionMapper.selectByExample(example);
	}

	@Override
	public List<Position> listByPositionIdNamePlId(Integer positionId, String positionName, Integer plId) {
		PositionExample example  = new PositionExample();
		//按照日期排序
		example.setOrderByClause("last_operator_date desc");
		example.or().andPositionIdEqualTo(positionId).andPositionNameEqualTo(positionName).andPlIdEqualTo(plId);
		return positionMapper.selectByExample(example);
	}
	
	@Override
	public List<Position> listByPositionIdDeptIdPlId(Integer positionId, Integer deptId, Integer plId) {
		PositionExample example  = new PositionExample();
		//按照日期排序
		example.setOrderByClause("last_operator_date desc");
		example.or().andPositionIdEqualTo(positionId).andDeptIdEqualTo(deptId).andPlIdEqualTo(plId);
		return positionMapper.selectByExample(example);
	}
	
	
	@Override
	public List<Position> listByPositionNameDeptIdPlId(String positionName, Integer deptId, Integer plId) {
		PositionExample example  = new PositionExample();
		//按照日期排序
		example.setOrderByClause("last_operator_date desc");
		example.or().andPositionNameEqualTo(positionName).andDeptIdEqualTo(deptId).andPlIdEqualTo(plId);
		return positionMapper.selectByExample(example);
	}

	@Override
	public List<Position> listByAll(Integer positionId, String positionName, Integer deptId, Integer plId) {
		 PositionExample example  = new PositionExample();
		 //按照日期排序
		 example.setOrderByClause("last_operator_date desc");
		 example.or().andPositionIdEqualTo(positionId).andPositionNameEqualTo(positionName).andDeptIdEqualTo(deptId).andPlIdEqualTo(plId);
		return positionMapper.selectByExample(example);
	}

	@Override
	public List<Position> listByNo() {
		PositionExample example  = new PositionExample();
		//按照日期排序
		example.setOrderByClause("last_operator_date desc");
		example.or().andPositionIdIsNotNull();
		return positionMapper.selectByExample(example);
	}

	@Override
	public int insert(Position position) {
		return positionMapper.insertSelective(position);
	}

	@Override
	public int update(Position position) {
		return positionMapper.updateByPrimaryKeySelective(position);
	}

	@Override
	public int delte(Integer positionId) {
		return positionMapper.deleteByPrimaryKey(positionId);
	}


}
