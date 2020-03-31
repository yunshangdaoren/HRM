package com.lqs.hrm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lqs.hrm.entity.Department;
import com.lqs.hrm.entity.DepartmentExample;
import com.lqs.hrm.mapper.DepartmentMapper;
import com.lqs.hrm.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
	private DepartmentMapper departmentMapper;
	
	@Override
	public Department get(Integer deptId) {
		return departmentMapper.selectByPrimaryKey(deptId);
	}

	@Override
	public List<Department> list() {
		DepartmentExample example = new DepartmentExample();
		example.createCriteria().andDeptIdIsNotNull();
		return departmentMapper.selectByExample(example);
	}

	@Override
	public Department get(String deptName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> listByManageEmpJobId(Integer manageEmpjobid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> list(String deptName, Integer manageEmpjobid, Integer deptLevel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> list(Integer deptLevel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Department department) {
		return departmentMapper.insertSelective(department);
	}

	@Override
	public int update(Department department) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delte(Integer deptId) {
		// TODO Auto-generated method stub
		return 0;
	}
	


}
