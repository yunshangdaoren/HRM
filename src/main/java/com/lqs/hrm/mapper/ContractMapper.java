package com.lqs.hrm.mapper;

import com.lqs.hrm.entity.Contract;
import com.lqs.hrm.entity.ContractExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContractMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table contract
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	long countByExample(ContractExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table contract
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	int deleteByExample(ContractExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table contract
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	int deleteByPrimaryKey(Integer conId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table contract
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	int insert(Contract record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table contract
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	int insertSelective(Contract record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table contract
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	List<Contract> selectByExample(ContractExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table contract
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	Contract selectByPrimaryKey(Integer conId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table contract
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	int updateByExampleSelective(@Param("record") Contract record, @Param("example") ContractExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table contract
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	int updateByExample(@Param("record") Contract record, @Param("example") ContractExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table contract
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	int updateByPrimaryKeySelective(Contract record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table contract
	 * @mbg.generated  Thu May 28 20:50:21 CST 2020
	 */
	int updateByPrimaryKey(Contract record);
}