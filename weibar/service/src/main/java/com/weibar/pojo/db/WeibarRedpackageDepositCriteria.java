package com.weibar.pojo.db;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WeibarRedpackageDepositCriteria {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table weibar_redpackage_deposit
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table weibar_redpackage_deposit
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table weibar_redpackage_deposit
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_redpackage_deposit
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public WeibarRedpackageDepositCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_redpackage_deposit
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_redpackage_deposit
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_redpackage_deposit
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_redpackage_deposit
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_redpackage_deposit
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_redpackage_deposit
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_redpackage_deposit
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_redpackage_deposit
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_redpackage_deposit
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_redpackage_deposit
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table weibar_redpackage_deposit
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRedpackageidIsNull() {
            addCriterion("redpackageid is null");
            return (Criteria) this;
        }

        public Criteria andRedpackageidIsNotNull() {
            addCriterion("redpackageid is not null");
            return (Criteria) this;
        }

        public Criteria andRedpackageidEqualTo(Long value) {
            addCriterion("redpackageid =", value, "redpackageid");
            return (Criteria) this;
        }

        public Criteria andRedpackageidNotEqualTo(Long value) {
            addCriterion("redpackageid <>", value, "redpackageid");
            return (Criteria) this;
        }

        public Criteria andRedpackageidGreaterThan(Long value) {
            addCriterion("redpackageid >", value, "redpackageid");
            return (Criteria) this;
        }

        public Criteria andRedpackageidGreaterThanOrEqualTo(Long value) {
            addCriterion("redpackageid >=", value, "redpackageid");
            return (Criteria) this;
        }

        public Criteria andRedpackageidLessThan(Long value) {
            addCriterion("redpackageid <", value, "redpackageid");
            return (Criteria) this;
        }

        public Criteria andRedpackageidLessThanOrEqualTo(Long value) {
            addCriterion("redpackageid <=", value, "redpackageid");
            return (Criteria) this;
        }

        public Criteria andRedpackageidIn(List<Long> values) {
            addCriterion("redpackageid in", values, "redpackageid");
            return (Criteria) this;
        }

        public Criteria andRedpackageidNotIn(List<Long> values) {
            addCriterion("redpackageid not in", values, "redpackageid");
            return (Criteria) this;
        }

        public Criteria andRedpackageidBetween(Long value1, Long value2) {
            addCriterion("redpackageid between", value1, value2, "redpackageid");
            return (Criteria) this;
        }

        public Criteria andRedpackageidNotBetween(Long value1, Long value2) {
            addCriterion("redpackageid not between", value1, value2, "redpackageid");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNull() {
            addCriterion("openid is null");
            return (Criteria) this;
        }

        public Criteria andOpenidIsNotNull() {
            addCriterion("openid is not null");
            return (Criteria) this;
        }

        public Criteria andOpenidEqualTo(String value) {
            addCriterion("openid =", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotEqualTo(String value) {
            addCriterion("openid <>", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThan(String value) {
            addCriterion("openid >", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("openid >=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThan(String value) {
            addCriterion("openid <", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLessThanOrEqualTo(String value) {
            addCriterion("openid <=", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidLike(String value) {
            addCriterion("openid like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotLike(String value) {
            addCriterion("openid not like", value, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidIn(List<String> values) {
            addCriterion("openid in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotIn(List<String> values) {
            addCriterion("openid not in", values, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidBetween(String value1, String value2) {
            addCriterion("openid between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andOpenidNotBetween(String value1, String value2) {
            addCriterion("openid not between", value1, value2, "openid");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(BigDecimal value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(BigDecimal value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(BigDecimal value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(BigDecimal value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<BigDecimal> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<BigDecimal> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andSendnumberIsNull() {
            addCriterion("sendnumber is null");
            return (Criteria) this;
        }

        public Criteria andSendnumberIsNotNull() {
            addCriterion("sendnumber is not null");
            return (Criteria) this;
        }

        public Criteria andSendnumberEqualTo(Integer value) {
            addCriterion("sendnumber =", value, "sendnumber");
            return (Criteria) this;
        }

        public Criteria andSendnumberNotEqualTo(Integer value) {
            addCriterion("sendnumber <>", value, "sendnumber");
            return (Criteria) this;
        }

        public Criteria andSendnumberGreaterThan(Integer value) {
            addCriterion("sendnumber >", value, "sendnumber");
            return (Criteria) this;
        }

        public Criteria andSendnumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("sendnumber >=", value, "sendnumber");
            return (Criteria) this;
        }

        public Criteria andSendnumberLessThan(Integer value) {
            addCriterion("sendnumber <", value, "sendnumber");
            return (Criteria) this;
        }

        public Criteria andSendnumberLessThanOrEqualTo(Integer value) {
            addCriterion("sendnumber <=", value, "sendnumber");
            return (Criteria) this;
        }

        public Criteria andSendnumberIn(List<Integer> values) {
            addCriterion("sendnumber in", values, "sendnumber");
            return (Criteria) this;
        }

        public Criteria andSendnumberNotIn(List<Integer> values) {
            addCriterion("sendnumber not in", values, "sendnumber");
            return (Criteria) this;
        }

        public Criteria andSendnumberBetween(Integer value1, Integer value2) {
            addCriterion("sendnumber between", value1, value2, "sendnumber");
            return (Criteria) this;
        }

        public Criteria andSendnumberNotBetween(Integer value1, Integer value2) {
            addCriterion("sendnumber not between", value1, value2, "sendnumber");
            return (Criteria) this;
        }

        public Criteria andGetnumberIsNull() {
            addCriterion("getnumber is null");
            return (Criteria) this;
        }

        public Criteria andGetnumberIsNotNull() {
            addCriterion("getnumber is not null");
            return (Criteria) this;
        }

        public Criteria andGetnumberEqualTo(Integer value) {
            addCriterion("getnumber =", value, "getnumber");
            return (Criteria) this;
        }

        public Criteria andGetnumberNotEqualTo(Integer value) {
            addCriterion("getnumber <>", value, "getnumber");
            return (Criteria) this;
        }

        public Criteria andGetnumberGreaterThan(Integer value) {
            addCriterion("getnumber >", value, "getnumber");
            return (Criteria) this;
        }

        public Criteria andGetnumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("getnumber >=", value, "getnumber");
            return (Criteria) this;
        }

        public Criteria andGetnumberLessThan(Integer value) {
            addCriterion("getnumber <", value, "getnumber");
            return (Criteria) this;
        }

        public Criteria andGetnumberLessThanOrEqualTo(Integer value) {
            addCriterion("getnumber <=", value, "getnumber");
            return (Criteria) this;
        }

        public Criteria andGetnumberIn(List<Integer> values) {
            addCriterion("getnumber in", values, "getnumber");
            return (Criteria) this;
        }

        public Criteria andGetnumberNotIn(List<Integer> values) {
            addCriterion("getnumber not in", values, "getnumber");
            return (Criteria) this;
        }

        public Criteria andGetnumberBetween(Integer value1, Integer value2) {
            addCriterion("getnumber between", value1, value2, "getnumber");
            return (Criteria) this;
        }

        public Criteria andGetnumberNotBetween(Integer value1, Integer value2) {
            addCriterion("getnumber not between", value1, value2, "getnumber");
            return (Criteria) this;
        }

        public Criteria andRedpackettitleIsNull() {
            addCriterion("redPacketTitle is null");
            return (Criteria) this;
        }

        public Criteria andRedpackettitleIsNotNull() {
            addCriterion("redPacketTitle is not null");
            return (Criteria) this;
        }

        public Criteria andRedpackettitleEqualTo(String value) {
            addCriterion("redPacketTitle =", value, "redpackettitle");
            return (Criteria) this;
        }

        public Criteria andRedpackettitleNotEqualTo(String value) {
            addCriterion("redPacketTitle <>", value, "redpackettitle");
            return (Criteria) this;
        }

        public Criteria andRedpackettitleGreaterThan(String value) {
            addCriterion("redPacketTitle >", value, "redpackettitle");
            return (Criteria) this;
        }

        public Criteria andRedpackettitleGreaterThanOrEqualTo(String value) {
            addCriterion("redPacketTitle >=", value, "redpackettitle");
            return (Criteria) this;
        }

        public Criteria andRedpackettitleLessThan(String value) {
            addCriterion("redPacketTitle <", value, "redpackettitle");
            return (Criteria) this;
        }

        public Criteria andRedpackettitleLessThanOrEqualTo(String value) {
            addCriterion("redPacketTitle <=", value, "redpackettitle");
            return (Criteria) this;
        }

        public Criteria andRedpackettitleLike(String value) {
            addCriterion("redPacketTitle like", value, "redpackettitle");
            return (Criteria) this;
        }

        public Criteria andRedpackettitleNotLike(String value) {
            addCriterion("redPacketTitle not like", value, "redpackettitle");
            return (Criteria) this;
        }

        public Criteria andRedpackettitleIn(List<String> values) {
            addCriterion("redPacketTitle in", values, "redpackettitle");
            return (Criteria) this;
        }

        public Criteria andRedpackettitleNotIn(List<String> values) {
            addCriterion("redPacketTitle not in", values, "redpackettitle");
            return (Criteria) this;
        }

        public Criteria andRedpackettitleBetween(String value1, String value2) {
            addCriterion("redPacketTitle between", value1, value2, "redpackettitle");
            return (Criteria) this;
        }

        public Criteria andRedpackettitleNotBetween(String value1, String value2) {
            addCriterion("redPacketTitle not between", value1, value2, "redpackettitle");
            return (Criteria) this;
        }

        public Criteria andMerchantidIsNull() {
            addCriterion("merchantid is null");
            return (Criteria) this;
        }

        public Criteria andMerchantidIsNotNull() {
            addCriterion("merchantid is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantidEqualTo(Long value) {
            addCriterion("merchantid =", value, "merchantid");
            return (Criteria) this;
        }

        public Criteria andMerchantidNotEqualTo(Long value) {
            addCriterion("merchantid <>", value, "merchantid");
            return (Criteria) this;
        }

        public Criteria andMerchantidGreaterThan(Long value) {
            addCriterion("merchantid >", value, "merchantid");
            return (Criteria) this;
        }

        public Criteria andMerchantidGreaterThanOrEqualTo(Long value) {
            addCriterion("merchantid >=", value, "merchantid");
            return (Criteria) this;
        }

        public Criteria andMerchantidLessThan(Long value) {
            addCriterion("merchantid <", value, "merchantid");
            return (Criteria) this;
        }

        public Criteria andMerchantidLessThanOrEqualTo(Long value) {
            addCriterion("merchantid <=", value, "merchantid");
            return (Criteria) this;
        }

        public Criteria andMerchantidIn(List<Long> values) {
            addCriterion("merchantid in", values, "merchantid");
            return (Criteria) this;
        }

        public Criteria andMerchantidNotIn(List<Long> values) {
            addCriterion("merchantid not in", values, "merchantid");
            return (Criteria) this;
        }

        public Criteria andMerchantidBetween(Long value1, Long value2) {
            addCriterion("merchantid between", value1, value2, "merchantid");
            return (Criteria) this;
        }

        public Criteria andMerchantidNotBetween(Long value1, Long value2) {
            addCriterion("merchantid not between", value1, value2, "merchantid");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andOpenidLikeInsensitive(String value) {
            addCriterion("upper(openid) like", value.toUpperCase(), "openid");
            return (Criteria) this;
        }

        public Criteria andRedpackettitleLikeInsensitive(String value) {
            addCriterion("upper(redPacketTitle) like", value.toUpperCase(), "redpackettitle");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table weibar_redpackage_deposit
     *
     * @mbggenerated do_not_delete_during_merge Tue Apr 17 15:03:14 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table weibar_redpackage_deposit
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}