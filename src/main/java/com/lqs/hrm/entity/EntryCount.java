package com.lqs.hrm.entity;

import java.util.Date;

/**
 * 每日职工入职数量统计实体类
 * @author luckyliuqs
 *
 */
public class EntryCount {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column entry_count.ec_id
	 * @mbg.generated  Mon May 25 00:12:07 CST 2020
	 */
	private Integer ecId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column entry_count.entry_empNum
	 * @mbg.generated  Mon May 25 00:12:07 CST 2020
	 */
	private Integer entryEmpnum;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column entry_count.entry_date
	 * @mbg.generated  Mon May 25 00:12:07 CST 2020
	 */
	private Date entryDate;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column entry_count.ec_id
	 * @return  the value of entry_count.ec_id
	 * @mbg.generated  Mon May 25 00:12:07 CST 2020
	 */
	public Integer getEcId() {
		return ecId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column entry_count.ec_id
	 * @param ecId  the value for entry_count.ec_id
	 * @mbg.generated  Mon May 25 00:12:07 CST 2020
	 */
	public void setEcId(Integer ecId) {
		this.ecId = ecId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column entry_count.entry_empNum
	 * @return  the value of entry_count.entry_empNum
	 * @mbg.generated  Mon May 25 00:12:07 CST 2020
	 */
	public Integer getEntryEmpnum() {
		return entryEmpnum;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column entry_count.entry_empNum
	 * @param entryEmpnum  the value for entry_count.entry_empNum
	 * @mbg.generated  Mon May 25 00:12:07 CST 2020
	 */
	public void setEntryEmpnum(Integer entryEmpnum) {
		this.entryEmpnum = entryEmpnum;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column entry_count.entry_date
	 * @return  the value of entry_count.entry_date
	 * @mbg.generated  Mon May 25 00:12:07 CST 2020
	 */
	public Date getEntryDate() {
		return entryDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column entry_count.entry_date
	 * @param entryDate  the value for entry_count.entry_date
	 * @mbg.generated  Mon May 25 00:12:07 CST 2020
	 */
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
}