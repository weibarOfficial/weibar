package com.weibar.pojo.db;

import java.util.Date;

public class WeibarPayAttach {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_pay_attach.id
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_pay_attach.attach
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    private String attach;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_pay_attach.create_time
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column weibar_pay_attach.update_time
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_pay_attach.id
     *
     * @return the value of weibar_pay_attach.id
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_pay_attach.id
     *
     * @param id the value for weibar_pay_attach.id
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_pay_attach.attach
     *
     * @return the value of weibar_pay_attach.attach
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public String getAttach() {
        return attach;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_pay_attach.attach
     *
     * @param attach the value for weibar_pay_attach.attach
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public void setAttach(String attach) {
        this.attach = attach == null ? null : attach.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_pay_attach.create_time
     *
     * @return the value of weibar_pay_attach.create_time
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_pay_attach.create_time
     *
     * @param createTime the value for weibar_pay_attach.create_time
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column weibar_pay_attach.update_time
     *
     * @return the value of weibar_pay_attach.update_time
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column weibar_pay_attach.update_time
     *
     * @param updateTime the value for weibar_pay_attach.update_time
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}