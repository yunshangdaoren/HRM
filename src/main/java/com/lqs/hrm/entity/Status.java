package com.lqs.hrm.entity;

/**
 * 状态实体类
 * @author Administrator
 *
 */
public class Status {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column status.status_id
     *
     * @mbg.generated Tue Mar 31 16:19:01 CST 2020
     */
    private Integer statusId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column status.status_name
     *
     * @mbg.generated Tue Mar 31 16:19:01 CST 2020
     */
    private String statusName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column status.status_desc
     *
     * @mbg.generated Tue Mar 31 16:19:01 CST 2020
     */
    private String statusDesc;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column status.status_id
     *
     * @return the value of status.status_id
     *
     * @mbg.generated Tue Mar 31 16:19:01 CST 2020
     */
    public Integer getStatusId() {
        return statusId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column status.status_id
     *
     * @param statusId the value for status.status_id
     *
     * @mbg.generated Tue Mar 31 16:19:01 CST 2020
     */
    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column status.status_name
     *
     * @return the value of status.status_name
     *
     * @mbg.generated Tue Mar 31 16:19:01 CST 2020
     */
    public String getStatusName() {
        return statusName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column status.status_name
     *
     * @param statusName the value for status.status_name
     *
     * @mbg.generated Tue Mar 31 16:19:01 CST 2020
     */
    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column status.status_desc
     *
     * @return the value of status.status_desc
     *
     * @mbg.generated Tue Mar 31 16:19:01 CST 2020
     */
    public String getStatusDesc() {
        return statusDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column status.status_desc
     *
     * @param statusDesc the value for status.status_desc
     *
     * @mbg.generated Tue Mar 31 16:19:01 CST 2020
     */
    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }
}