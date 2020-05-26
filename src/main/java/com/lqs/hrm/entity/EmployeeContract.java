package com.lqs.hrm.entity;

/**
 * 职工-合同关联表
 * @author luckyliuqs
 *
 */
public class EmployeeContract {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column employee_contract.ec_id
	 * @mbg.generated  Mon May 25 00:12:41 CST 2020
	 */
	private Integer ecId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column employee_contract.con_id
	 * @mbg.generated  Mon May 25 00:12:41 CST 2020
	 */
	private Integer conId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column employee_contract.emp_jobId
	 * @mbg.generated  Mon May 25 00:12:41 CST 2020
	 */
	private String empJobid;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column employee_contract.ec_id
	 * @return  the value of employee_contract.ec_id
	 * @mbg.generated  Mon May 25 00:12:41 CST 2020
	 */
	public Integer getEcId() {
		return ecId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column employee_contract.ec_id
	 * @param ecId  the value for employee_contract.ec_id
	 * @mbg.generated  Mon May 25 00:12:41 CST 2020
	 */
	public void setEcId(Integer ecId) {
		this.ecId = ecId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column employee_contract.con_id
	 * @return  the value of employee_contract.con_id
	 * @mbg.generated  Mon May 25 00:12:41 CST 2020
	 */
	public Integer getConId() {
		return conId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column employee_contract.con_id
	 * @param conId  the value for employee_contract.con_id
	 * @mbg.generated  Mon May 25 00:12:41 CST 2020
	 */
	public void setConId(Integer conId) {
		this.conId = conId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column employee_contract.emp_jobId
	 * @return  the value of employee_contract.emp_jobId
	 * @mbg.generated  Mon May 25 00:12:41 CST 2020
	 */
	public String getEmpJobid() {
		return empJobid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column employee_contract.emp_jobId
	 * @param empJobid  the value for employee_contract.emp_jobId
	 * @mbg.generated  Mon May 25 00:12:41 CST 2020
	 */
	public void setEmpJobid(String empJobid) {
		this.empJobid = empJobid;
	}

	/**
     * 职工姓名
     */
    private String empName;

    public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
    
}