package com.lqs.hrm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lqs.hrm.entity.CountAttendanceDepartmant;
import com.lqs.hrm.entity.CountAttendanceDepartmantExample;
import com.lqs.hrm.mapper.CountAttendanceDepartmantMapper;

/**
 * 部门考勤统计Service接口实现类
 * @author luckyliuqs
 *
 */
@Service
public class CountAttendanceDepartmentServiceImpl implements CountAttendanceDepartmentService{
	@Autowired
	private CountAttendanceDepartmantMapper countAttendanceDepartmantMapper;

	/**
	 * 通过部门Id查询
	 */
	@Override
	public List<CountAttendanceDepartmant> getByDeptId(Integer deptId) {
		CountAttendanceDepartmantExample example = new CountAttendanceDepartmantExample();
		example.or().andDeptIdEqualTo(deptId);
		return countAttendanceDepartmantMapper.selectByExample(example);
	}
	
	/**
	 * 查询出所有的部门考勤统计信息
	 */
	@Override
	public List<CountAttendanceDepartmant> listByNo() {
		CountAttendanceDepartmantExample example = new CountAttendanceDepartmantExample();
		example.or().andCadIdIsNotNull();
		return countAttendanceDepartmantMapper.selectByExample(example);
	}

	/**
	 * 添加部门考勤统计信息
	 */
	@Override
	public int add(CountAttendanceDepartmant countAttendanceDepartmant) {
		return countAttendanceDepartmantMapper.insertSelective(countAttendanceDepartmant);
	}

	/**
	 * 修改部门考勤统计信息
	 */
	@Override
	public int update(CountAttendanceDepartmant countAttendanceDepartmant) {
		return countAttendanceDepartmantMapper.updateByPrimaryKeySelective(countAttendanceDepartmant);
	}


}
