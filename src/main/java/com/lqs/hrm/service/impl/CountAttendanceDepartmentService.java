package com.lqs.hrm.service.impl;

import java.util.List;

import com.lqs.hrm.entity.CountAttendanceDepartmant;

/**
 * 部门考勤统计Service接口
 * @author luckyliuqs
 *
 */
public interface CountAttendanceDepartmentService {
	
	/**
	 * 通过部门id查询
	 * @param deptId
	 * @return
	 */
	List<CountAttendanceDepartmant> getByDeptId(Integer deptId);
	
	/**
	 * 查询出所有的部门考勤统计信息
	 * @return
	 */
	List<CountAttendanceDepartmant> listByNo();
	
	/**
	 * 添加部门考勤统计信息
	 * @param countAttendanceDepartmant
	 * @return
	 */
	int add(CountAttendanceDepartmant countAttendanceDepartmant);
	
	/**
	 * 修改部门考勤统计信息
	 * @param countAttendanceDepartmant
	 * @return
	 */
	int update(CountAttendanceDepartmant countAttendanceDepartmant);

}
