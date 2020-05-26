package com.lqs.hrm;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.lqs.hrm.entity.Department;
import com.lqs.hrm.service.DepartmentService;
import com.lqs.hrm.service.impl.DepartmentServiceImpl;

public class DepartmentTest {
	@Autowired 
	private DepartmentServiceImpl departmentService;
	
	@Test
	void add() {
		Department department = departmentService.get(3);
		System.out.println("部门名称是："+department.getDeptName());
		
//		List<Department> departmentList = listChildDeptByDeptId(3);
//		for(Department department : departmentList) {
//			System.out.println("部门名称是："+department.getDeptName());
//		}
	}
	
	
	/**
	 * 获取到指定部门id的部门的所有子部门
	 */
	public List<Department> listChildDeptByDeptId(Integer deptd) {
		//所有子部门信息
		List<Department> allDepartmentList = new ArrayList<>();
		//获取到所有部门信息
		List<Department> childDepartmentList = departmentService.listByParentId(deptd);
		System.out.println("===================子部门数量："+childDepartmentList.size());
		for (Department department : childDepartmentList) {
			if (department.getParentId() == deptd) {
				for (Department d : listChildDeptByDeptId(department.getDeptId())) {
					allDepartmentList.add(d);
				}
			}
		}
		return allDepartmentList;
	}
}
