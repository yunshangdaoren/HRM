package com.lqs.hrm;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lqs.hrm.entity.Department;
import com.lqs.hrm.entity.Employee;
import com.lqs.hrm.entity.EmployeePosition;
import com.lqs.hrm.entity.Position;
import com.lqs.hrm.entity.User;
import com.lqs.hrm.service.PositionService;
import com.lqs.hrm.service.impl.DepartmentServiceImpl;
import com.lqs.hrm.service.impl.EmployeePositionServiceImpl;
import com.lqs.hrm.service.impl.EmployeeServiceImpl;
import com.lqs.hrm.service.impl.LoginServiceImpl;
import com.lqs.hrm.service.impl.MailServiceImpl;
import com.lqs.hrm.service.impl.UserServiceImpl;

@SpringBootTest
class HrmApplicationTests {
	@Autowired 
	private LoginServiceImpl service;
	@Autowired
	private MailServiceImpl mailService;
	@Autowired
	private DepartmentServiceImpl departmentService;
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private EmployeeServiceImpl employeeService;
	@Autowired
	private PositionService positionService;
	@Autowired
	private EmployeePositionServiceImpl employeePositionService;
	
	@Test
	void contextLoads() {
	}

	@Test
	void getUser() {
		User user = service.getUser("1", "123456");
		System.out.println("User信息如下：==========================");
		System.out.println("User信息如下：==========================");
		System.out.println("User信息如下：==========================");
		System.out.println("User信息如下：==========================");
		System.out.println("User信息如下：==========================");
		System.out.println("User信息如下：==========================");
		System.out.println("User信息如下：==========================");
		System.out.println("User信息如下：==========================");
		System.out.println(user.getUserAccount());
	}
	
	@Test
	void test() {
		mailService.sendSimpleMail("1396758907@qq.com", "测试邮件", "你好，收到测试邮件了吗？");
	}
	
	@Test
	void dateTest() {
		List<Department> departmentList = departmentService.listByNo();
		for (Department department : departmentList) {
			System.out.println("日期："+department.getLastOperatorDate());
		}
	}
	
	@Test
	void userTest() {
		User user = userService.get("1");
		System.out.println("====================");
		System.out.println("创建日期:"+user.getCreateDate());
		System.out.println("====================");
	}
	
	@Test
	void addDept() {
		Department department = new Department();
		department.setDlId(2);
		department.setStatusId(4);
		int code = departmentService.insert(department);
		System.out.println("==================================");
		System.out.println("code:" + code);
	}
	
	@Test
	void selectEmployee() {
		Employee employee = employeeService.get("1");
		System.out.println("查询工号为1的职工："+employee);
		//List<Employee> list = employeeService.list
		System.out.println("查询出所有职工信息：");
//		for (Employee e : list) {
//			System.out.println("工号:"+e.getEmpIdcard());
//		}
	}
	
	
	@Test
	void getDeptList() {
		//Department department = departmentService.get(3);
		System.out.println("====================");
		//System.out.println("部门名称是："+department.getDeptName());
		System.out.println("====================");
		
		List<Department> allChildDepartmentList = listChildDeptByDeptId(4);
		for(Department department : allChildDepartmentList) {
			System.out.println("子部门名称是："+department.getDeptName());
		}
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
			for (Department d : listChildDeptByDeptId(department.getDeptId())) {
				if (d != null) {
					allDepartmentList.add(d);
				}
			}
			allDepartmentList.add(department);
		}
		return allDepartmentList;
	}
	
	@Test
	void getDeptEmpNum() {
		Department department = departmentService.get(4);
		System.out.println("----------------====================");
		System.out.println("部门的职工数量："+getDeptEmpNum(department));
	}
	
	
	/**
	 * 获取指定部门下的所有职工数量
	 * @param department
	 * @return
	 */
	public int getDeptEmpNum(Department department) {
		//部门职工数量
		Integer deptEmpNum = 0;
	    List<Department> childDepartmentList = listChildDeptByDeptId(department.getDeptId());
	    childDepartmentList.add(department);
	    for (Department d : childDepartmentList) {
	    	//System.out.print("子部门名称："+d.getDeptName());
	    	 List<Position> positionList = positionService.listByDeptId(d.getDeptId());
				for (Position position : positionList) {
					List<EmployeePosition> employeePositionList = employeePositionService.listByPositionId(position.getPositionId());
					deptEmpNum += employeePositionList.size();
				}
			//System.out.println();
		}
		return deptEmpNum;
	}
	
}
