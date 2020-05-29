package com.lqs.hrm.util.entity;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lqs.hrm.entity.CountAttendanceDepartmant;
import com.lqs.hrm.service.impl.DepartmentServiceImpl;


/**
 * 部门考勤信息统计实体信息封装工具类
 * @author luckyliuqs
 *
 */
@Component
public class CountAttendanceDepartmantUtil {
	@Autowired
	private DepartmentServiceImpl departmentService;
	
	/**
	 * 设置查询出来的部门考勤实体类信息
	 * @param departmentList
	 * @throws ParseException 
	 */
	public void setCountAttendanceDepartmantInfo(List<CountAttendanceDepartmant> countAttendanceDepartmantList) throws ParseException {
		
		if (countAttendanceDepartmantList.size() != 0 || countAttendanceDepartmantList != null) {
			for (int i = 0; i < countAttendanceDepartmantList.size(); i++) {
				//设置部门名称
				countAttendanceDepartmantList.get(i).setDeptName(departmentService.get(countAttendanceDepartmantList.get(i).getDeptId()).getDeptName());
			}
		}
				
	}
	
	
	/**
	 * 设置查询出来的部门实体类信息
	 * @param departmentList
	 */
	public void setCountAttendanceDepartmantInfo(CountAttendanceDepartmant countAttendanceDepartmant) {
		if (countAttendanceDepartmant != null) {
			//设置部门名称
			countAttendanceDepartmant.setDeptName(departmentService.get(countAttendanceDepartmant.getDeptId()).getDeptName());
		}
	}
}
