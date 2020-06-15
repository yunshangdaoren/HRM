package com.lqs.hrm.mapper;

import com.lqs.hrm.entity.EntryCount;
import com.lqs.hrm.entity.EntryCountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EntryCountMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table entry_count
     *
     * @mbg.generated Mon May 25 00:12:07 CST 2020
     */
    long countByExample(EntryCountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table entry_count
     *
     * @mbg.generated Mon May 25 00:12:07 CST 2020
     */
    int deleteByExample(EntryCountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table entry_count
     *
     * @mbg.generated Mon May 25 00:12:07 CST 2020
     */
    int deleteByPrimaryKey(Integer ecId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table entry_count
     *
     * @mbg.generated Mon May 25 00:12:07 CST 2020
     */
    int insert(EntryCount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table entry_count
     *
     * @mbg.generated Mon May 25 00:12:07 CST 2020
     */
    int insertSelective(EntryCount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table entry_count
     *
     * @mbg.generated Mon May 25 00:12:07 CST 2020
     */
    List<EntryCount> selectByExample(EntryCountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table entry_count
     *
     * @mbg.generated Mon May 25 00:12:07 CST 2020
     */
    EntryCount selectByPrimaryKey(Integer ecId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table entry_count
     *
     * @mbg.generated Mon May 25 00:12:07 CST 2020
     */
    int updateByExampleSelective(@Param("record") EntryCount record, @Param("example") EntryCountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table entry_count
     *
     * @mbg.generated Mon May 25 00:12:07 CST 2020
     */
    int updateByExample(@Param("record") EntryCount record, @Param("example") EntryCountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table entry_count
     *
     * @mbg.generated Mon May 25 00:12:07 CST 2020
     */
    int updateByPrimaryKeySelective(EntryCount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table entry_count
     *
     * @mbg.generated Mon May 25 00:12:07 CST 2020
     */
    int updateByPrimaryKey(EntryCount record);
}