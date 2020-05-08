package com.lqs.hrm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lqs.hrm.entity.Department;
import com.lqs.hrm.entity.DepartmentExample;
import com.lqs.hrm.entity.Employee;
import com.lqs.hrm.mapper.DepartmentMapper;
import com.lqs.hrm.service.DepartmentService;

/**
 * 部门信息Service
 * @author luckyliuqs
 *
 */
@Service
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
	private DepartmentMapper departmentMapper;
	@Autowired
	private EmployeeServiceImpl employeeService;
	@Override
	
	/**
	 * 根据部门id查询
	 */
	public Department get(Integer deptId) {
		return departmentMapper.selectByPrimaryKey(deptId);
	}
	/**
	 * 根据部门名称查询
	 */
	@Override
	public List<Department> listByDeptName(String deptName) {
		DepartmentExample example = new DepartmentExample();
		//按照日期排序
		example.setOrderByClause("last_operator_date desc");
		example.createCriteria().andDeptNameEqualTo(deptName);
		return departmentMapper.selectByExample(example);
	}
	/**
	 * 根据部门主管id查询
	 */
	@Override
	public List<Department> listBymanageEmpjobid(String manageEmpjobid) {
		DepartmentExample example = new DepartmentExample();
		//按照日期排序
		example.setOrderByClause("last_operator_date desc");
		example.createCriteria().andManageEmpjobidEqualTo(manageEmpjobid);
		return departmentMapper.selectByExample(example);
	}
	
	/**
	 * 根据部门级别id查询
	 */
	@Override
	public List<Department> listByDlId(Integer dlId) {
		DepartmentExample example = new DepartmentExample();
		//按照日期排序
		example.setOrderByClause("last_operator_date desc");
		example.or().andDlIdEqualTo(dlId);
		return departmentMapper.selectByExample(example);
	}
	
	/**
	 * 根据部门id，部门名称查询
	 */
	@Override
	public List<Department> listByDeptIdName(Integer deptId, String deptName) {
		DepartmentExample example = new DepartmentExample();
		//按照日期排序
		example.setOrderByClause("last_operator_date desc");
		example.createCriteria().andDeptIdEqualTo(deptId).andDeptNameEqualTo(deptName);
		return departmentMapper.selectByExample(example);
	}
	
	/**
	 * 根据id，部门主管id查询
	 */
	@Override
	public List<Department> listByDeptIdManageEmpJobId(Integer deptId, String manageEmpjobid) {
		DepartmentExample example = new DepartmentExample();
		//按照日期排序
		example.setOrderByClause("last_operator_date desc");
		example.createCriteria().andDeptIdEqualTo(deptId).andManageEmpjobidEqualTo(manageEmpjobid);
		return departmentMapper.selectByExample(example);
	}
	
	/**
	 * 根据部门id，部门级别id查询
	 */
	@Override
	public List<Department> listByDeptIdDlId(Integer deptId, Integer dlId) {
		DepartmentExample example = new DepartmentExample();
		//按照日期排序
		example.setOrderByClause("last_operator_date desc");
		example.createCriteria().andDeptIdEqualTo(deptId).andDlIdEqualTo(dlId);
		return departmentMapper.selectByExample(example);
	}
	
	/**
	 * 根据部门名称，部门主管id查询
	 */
	@Override
	public List<Department> listByDeptNameManageEmpJobId(String deptName, String manageEmpjobid) {
		DepartmentExample example = new DepartmentExample();
		//按照日期排序
		example.setOrderByClause("last_operator_date desc");
		example.createCriteria().andDeptNameEqualTo(deptName).andManageEmpjobidEqualTo(manageEmpjobid);
		return departmentMapper.selectByExample(example);
	}
	
	/**
	 * 根据部门名称，部门级别id查询
	 */
	@Override
	public List<Department> listByDeptNameDlId(String deptName, Integer dlId) {
		DepartmentExample example = new DepartmentExample();
		//按照日期排序
		example.setOrderByClause("last_operator_date desc");
		example.createCriteria().andDeptNameEqualTo(deptName).andDlIdEqualTo(dlId);
		return departmentMapper.selectByExample(example);
	}
	
	/**
	 * 根据部门主管id，部门级别查询
	 */
	@Override
	public List<Department> listByManageEmpJobIdDlId(String manageEmpjobid, Integer dlId) {
		DepartmentExample example = new DepartmentExample();
		//按照日期排序
		example.setOrderByClause("last_operator_date desc");
		example.createCriteria().andManageEmpjobidEqualTo(manageEmpjobid).andDlIdEqualTo(dlId);
		return departmentMapper.selectByExample(example);
	}
	
	/**
	 * 根据部门id，部门名称，部门主管id查询
	 */
	@Override
	public List<Department> listByDeptIdNameManageEmpJobId(Integer deptId, String deptName, String manageEmpjobid) {
		DepartmentExample example = new DepartmentExample();
		//按照日期排序
		example.setOrderByClause("last_operator_date desc");
		example.createCriteria().andDeptIdEqualTo(deptId).andDeptNameEqualTo(deptName).andManageEmpjobidEqualTo(manageEmpjobid);
		return departmentMapper.selectByExample(example);
	}
	/**
	 * 根据部门id，部门名称，部门级别查询
	 */
	@Override
	public List<Department> listByDeptIdNameDlId(Integer deptId, String deptName, Integer dlId) {
		DepartmentExample example = new DepartmentExample();
		//按照日期排序
		example.setOrderByClause("last_operator_date desc");
		example.createCriteria().andDeptIdEqualTo(deptId).andDeptNameEqualTo(deptName).andDlIdEqualTo(dlId);
		return departmentMapper.selectByExample(example);
	}
	/**
	 * 根据部门id，部门主管id，部门级别查询
	 */
	@Override
	public List<Department> listByDeptIdManageEmpJonIdDlId(Integer deptId, String manageEmpjobid, Integer dlId) {
		DepartmentExample example = new DepartmentExample();
		//按照日期排序
		example.setOrderByClause("last_operator_date desc");
		example.createCriteria().andDeptIdEqualTo(deptId).andManageEmpjobidEqualTo(manageEmpjobid).andDlIdEqualTo(dlId);
		return departmentMapper.selectByExample(example);
	}
	
	/**
	 * 根据部门名称，部门主管id，部门级别查询
	 */
	@Override
	public List<Department> listByDeptNameManageEmpJonIdDlId(String deptName, String manageEmpjobid, Integer dlId) {
		DepartmentExample example = new DepartmentExample();
		//按照日期排序
		example.setOrderByClause("last_operator_date desc");
		example.createCriteria().andDeptNameEqualTo(deptName).andManageEmpjobidEqualTo(manageEmpjobid).andDlIdEqualTo(dlId);
		return departmentMapper.selectByExample(example);
	}
	
	/**
	 * 根据id，部门名称，部门主管id，部门级别id查询
	 */
	@Override
	public List<Department> listByAll(Integer deptId, String deptName, String manageEmpjobid, Integer dlId) {
		DepartmentExample example = new DepartmentExample();
		//按照日期排序
		example.setOrderByClause("last_operator_date desc");
		example.or().andDeptIdEqualTo(deptId).andDeptNameEqualTo(deptName).andManageEmpjobidEqualTo(manageEmpjobid).andDlIdEqualTo(dlId);
		return departmentMapper.selectByExample(example);
	}
	
	/**
	 * 查询出所有部门信息
	 */
	@Override
	public List<Department> listByNo() {
		DepartmentExample example = new DepartmentExample();
		//按照日期排序
		example.setOrderByClause("last_operator_date desc");
		example.createCriteria().andDeptIdIsNotNull();
		return departmentMapper.selectByExample(example);
	}
	
	/**
	 * 插入指定部门信息
	 */
	@Override
	public int insert(Department department) {
		return departmentMapper.insertSelective(department);
	}
	
	/**
	 * 更新指定部门信息
	 */
	@Override
	public int update(Department department) {
		return departmentMapper.updateByPrimaryKeySelective(department);
	}
	
	/**
	 * 删除指定部门信息
	 */
	@Override
	public int delte(Integer deptId) {
		return departmentMapper.deleteByPrimaryKey(deptId);
	}

	/**
	 * 根据部门名称模糊查询
	 */
	@Override
	public List<Department> listLikeDeptName(String deptName) {
		DepartmentExample example = new DepartmentExample();
		example.or().andDeptNameLike("%"+deptName+"%");
		return departmentMapper.selectByExample(example);
	}

}
