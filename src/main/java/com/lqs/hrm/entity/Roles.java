package com.lqs.hrm.entity;

/**
 * 角色实体类
 * @author luckyliuqs
 *
 */
public class Roles {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column roles.role_id
     *
     * @mbg.generated Mon May 25 12:26:33 CST 2020
     */
    private Integer roleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column roles.role_name
     *
     * @mbg.generated Mon May 25 12:26:33 CST 2020
     */
    private String roleName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column roles.role_desc
     *
     * @mbg.generated Mon May 25 12:26:33 CST 2020
     */
    private String roleDesc;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column roles.role_id
     *
     * @return the value of roles.role_id
     *
     * @mbg.generated Mon May 25 12:26:33 CST 2020
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column roles.role_id
     *
     * @param roleId the value for roles.role_id
     *
     * @mbg.generated Mon May 25 12:26:33 CST 2020
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column roles.role_name
     *
     * @return the value of roles.role_name
     *
     * @mbg.generated Mon May 25 12:26:33 CST 2020
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column roles.role_name
     *
     * @param roleName the value for roles.role_name
     *
     * @mbg.generated Mon May 25 12:26:33 CST 2020
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column roles.role_desc
     *
     * @return the value of roles.role_desc
     *
     * @mbg.generated Mon May 25 12:26:33 CST 2020
     */
    public String getRoleDesc() {
        return roleDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column roles.role_desc
     *
     * @param roleDesc the value for roles.role_desc
     *
     * @mbg.generated Mon May 25 12:26:33 CST 2020
     */
    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

	@Override
	public String toString() {
		return "Roles [roleId=" + roleId + ", roleName=" + roleName + ", roleDesc=" + roleDesc + "]";
	}
    
}