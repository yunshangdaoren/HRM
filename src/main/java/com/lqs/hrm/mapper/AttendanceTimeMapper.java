package com.lqs.hrm.mapper;

import com.lqs.hrm.entity.AttendanceTime;
import com.lqs.hrm.entity.AttendanceTimeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AttendanceTimeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attendance_time
     *
     * @mbg.generated Mon May 25 19:32:58 CST 2020
     */
    long countByExample(AttendanceTimeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attendance_time
     *
     * @mbg.generated Mon May 25 19:32:58 CST 2020
     */
    int deleteByExample(AttendanceTimeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attendance_time
     *
     * @mbg.generated Mon May 25 19:32:58 CST 2020
     */
    int deleteByPrimaryKey(Integer atId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attendance_time
     *
     * @mbg.generated Mon May 25 19:32:58 CST 2020
     */
    int insert(AttendanceTime record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attendance_time
     *
     * @mbg.generated Mon May 25 19:32:58 CST 2020
     */
    int insertSelective(AttendanceTime record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attendance_time
     *
     * @mbg.generated Mon May 25 19:32:58 CST 2020
     */
    List<AttendanceTime> selectByExample(AttendanceTimeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attendance_time
     *
     * @mbg.generated Mon May 25 19:32:58 CST 2020
     */
    AttendanceTime selectByPrimaryKey(Integer atId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attendance_time
     *
     * @mbg.generated Mon May 25 19:32:58 CST 2020
     */
    int updateByExampleSelective(@Param("record") AttendanceTime record, @Param("example") AttendanceTimeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attendance_time
     *
     * @mbg.generated Mon May 25 19:32:58 CST 2020
     */
    int updateByExample(@Param("record") AttendanceTime record, @Param("example") AttendanceTimeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attendance_time
     *
     * @mbg.generated Mon May 25 19:32:58 CST 2020
     */
    int updateByPrimaryKeySelective(AttendanceTime record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attendance_time
     *
     * @mbg.generated Mon May 25 19:32:58 CST 2020
     */
    int updateByPrimaryKey(AttendanceTime record);
}