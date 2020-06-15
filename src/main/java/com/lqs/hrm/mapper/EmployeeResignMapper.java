package com.lqs.hrm.mapper;

import com.lqs.hrm.entity.EmployeeResign;
import com.lqs.hrm.entity.EmployeeResignExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmployeeResignMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee_resign
     *
     * @mbg.generated Mon May 25 00:12:19 CST 2020
     */
    long countByExample(EmployeeResignExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee_resign
     *
     * @mbg.generated Mon May 25 00:12:19 CST 2020
     */
    int deleteByExample(EmployeeResignExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee_resign
     *
     * @mbg.generated Mon May 25 00:12:19 CST 2020
     */
    int deleteByPrimaryKey(Integer resignId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee_resign
     *
     * @mbg.generated Mon May 25 00:12:19 CST 2020
     */
    int insert(EmployeeResign record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee_resign
     *
     * @mbg.generated Mon May 25 00:12:19 CST 2020
     */
    int insertSelective(EmployeeResign record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee_resign
     *
     * @mbg.generated Mon May 25 00:12:19 CST 2020
     */
    List<EmployeeResign> selectByExample(EmployeeResignExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee_resign
     *
     * @mbg.generated Mon May 25 00:12:19 CST 2020
     */
    EmployeeResign selectByPrimaryKey(Integer resignId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee_resign
     *
     * @mbg.generated Mon May 25 00:12:19 CST 2020
     */
    int updateByExampleSelective(@Param("record") EmployeeResign record, @Param("example") EmployeeResignExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee_resign
     *
     * @mbg.generated Mon May 25 00:12:19 CST 2020
     */
    int updateByExample(@Param("record") EmployeeResign record, @Param("example") EmployeeResignExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee_resign
     *
     * @mbg.generated Mon May 25 00:12:19 CST 2020
     */
    int updateByPrimaryKeySelective(EmployeeResign record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table employee_resign
     *
     * @mbg.generated Mon May 25 00:12:19 CST 2020
     */
    int updateByPrimaryKey(EmployeeResign record);
}