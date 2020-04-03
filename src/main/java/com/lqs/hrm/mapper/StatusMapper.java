package com.lqs.hrm.mapper;

import com.lqs.hrm.entity.Status;
import com.lqs.hrm.entity.StatusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StatusMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table status
     *
     * @mbg.generated Tue Mar 31 16:19:01 CST 2020
     */
    long countByExample(StatusExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table status
     *
     * @mbg.generated Tue Mar 31 16:19:01 CST 2020
     */
    int deleteByExample(StatusExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table status
     *
     * @mbg.generated Tue Mar 31 16:19:01 CST 2020
     */
    int deleteByPrimaryKey(Integer statusId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table status
     *
     * @mbg.generated Tue Mar 31 16:19:01 CST 2020
     */
    int insert(Status record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table status
     *
     * @mbg.generated Tue Mar 31 16:19:01 CST 2020
     */
    int insertSelective(Status record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table status
     *
     * @mbg.generated Tue Mar 31 16:19:01 CST 2020
     */
    List<Status> selectByExample(StatusExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table status
     *
     * @mbg.generated Tue Mar 31 16:19:01 CST 2020
     */
    Status selectByPrimaryKey(Integer statusId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table status
     *
     * @mbg.generated Tue Mar 31 16:19:01 CST 2020
     */
    int updateByExampleSelective(@Param("record") Status record, @Param("example") StatusExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table status
     *
     * @mbg.generated Tue Mar 31 16:19:01 CST 2020
     */
    int updateByExample(@Param("record") Status record, @Param("example") StatusExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table status
     *
     * @mbg.generated Tue Mar 31 16:19:01 CST 2020
     */
    int updateByPrimaryKeySelective(Status record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table status
     *
     * @mbg.generated Tue Mar 31 16:19:01 CST 2020
     */
    int updateByPrimaryKey(Status record);
}