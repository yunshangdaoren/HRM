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
	
	/**
	 * 通过部门id查询部门信息
	 */
	@Override
	public Department get(Integer deptId) {
		return departmentMapper.selectByPrimaryKey(deptId);
	}

	/**
	 * 通过部门名称获取部门信息
	 */
	@Override
	public Department get(String deptName) {
		DepartmentExample example = new DepartmentExample();
		example.createCriteria().andDeptNameEqualTo(deptName);
		if(departmentMapper.selectByExample(example).size() == 0) {
			return null;
		}else {
			return departmentMapper.selectByExample(example).get(0);
		}
	}

	/**
	 * 新增指定部门信息
	 */
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
	
	/**
	 * 获取所有部门信息
	 */
	@Override
	public List<Department> list() {
		DepartmentExample example = new DepartmentExample();
		//按照日期排序
		example.setOrderByClause("last_operator_date desc");
		example.createCriteria().andDeptIdIsNotNull();
		return departmentMapper.selectByExample(example);
	}

	@Override
	public List<Department> listByManageEmpJobId(String manageEmpjobid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> listByDlId(Integer dlId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> listByDeptIdName(Integer deptId, String deptName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> listByDeptIdManageEmpJobId(Integer deptId, String manageEmpjobid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> listByDeptIdDlId(Integer deptId, Integer dlId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> listByDeptNameManageEmpJobId(String deptName, String manageEmpjobid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> listByDeptNameDlId(String deptName, Integer dlId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> listByManageEmpJobIdDlId(String manageEmpjobid, Integer dlId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> listByDeptIdNameManageEmpJobId(Integer deptId, String deptName, String manageEmpjobid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> listByDeptIdManageEmpJonIdDlId(Integer deptId, String manageEmpjobid, Integer dlId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> listByDeptNameManageEmpJonIdDlId(String deptName, String manageEmpjobid, Integer dlId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 根据部门id、部门名称、部门主管工号、部门级别查询
	 */
	@Override
	public List<Department> listByAll(Integer deptId, String deptName, String manageEmpjobid, Integer dlId) {
		DepartmentExample example = new DepartmentExample();
		example.or().andDeptIdEqualTo(deptId).andDeptNameEqualTo(deptName).andManageEmpjobidEqualTo(manageEmpjobid).andDlIdEqualTo(dlId);
		return departmentMapper.selectByExample(example);
	}

}
