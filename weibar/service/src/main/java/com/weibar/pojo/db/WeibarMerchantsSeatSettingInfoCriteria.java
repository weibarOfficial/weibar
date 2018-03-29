package com.weibar.pojo.db;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WeibarMerchantsSeatSettingInfoCriteria {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table weibar_merchants_seat_setting_info
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table weibar_merchants_seat_setting_info
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table weibar_merchants_seat_setting_info
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_seat_setting_info
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public WeibarMerchantsSeatSettingInfoCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_seat_setting_info
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_seat_setting_info
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_seat_setting_info
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_seat_setting_info
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_seat_setting_info
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_seat_setting_info
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_seat_setting_info
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_seat_setting_info
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
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
     * This method corresponds to the database table weibar_merchants_seat_setting_info
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_seat_setting_info
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
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
     * This class corresponds to the database table weibar_merchants_seat_setting_info
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
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

        public Criteria andSeatNameIsNull() {
            addCriterion("seat_name is null");
            return (Criteria) this;
        }

        public Criteria andSeatNameIsNotNull() {
            addCriterion("seat_name is not null");
            return (Criteria) this;
        }

        public Criteria andSeatNameEqualTo(String value) {
            addCriterion("seat_name =", value, "seatName");
            return (Criteria) this;
        }

        public Criteria andSeatNameNotEqualTo(String value) {
            addCriterion("seat_name <>", value, "seatName");
            return (Criteria) this;
        }

        public Criteria andSeatNameGreaterThan(String value) {
            addCriterion("seat_name >", value, "seatName");
            return (Criteria) this;
        }

        public Criteria andSeatNameGreaterThanOrEqualTo(String value) {
            addCriterion("seat_name >=", value, "seatName");
            return (Criteria) this;
        }

        public Criteria andSeatNameLessThan(String value) {
            addCriterion("seat_name <", value, "seatName");
            return (Criteria) this;
        }

        public Criteria andSeatNameLessThanOrEqualTo(String value) {
            addCriterion("seat_name <=", value, "seatName");
            return (Criteria) this;
        }

        public Criteria andSeatNameLike(String value) {
            addCriterion("seat_name like", value, "seatName");
            return (Criteria) this;
        }

        public Criteria andSeatNameNotLike(String value) {
            addCriterion("seat_name not like", value, "seatName");
            return (Criteria) this;
        }

        public Criteria andSeatNameIn(List<String> values) {
            addCriterion("seat_name in", values, "seatName");
            return (Criteria) this;
        }

        public Criteria andSeatNameNotIn(List<String> values) {
            addCriterion("seat_name not in", values, "seatName");
            return (Criteria) this;
        }

        public Criteria andSeatNameBetween(String value1, String value2) {
            addCriterion("seat_name between", value1, value2, "seatName");
            return (Criteria) this;
        }

        public Criteria andSeatNameNotBetween(String value1, String value2) {
            addCriterion("seat_name not between", value1, value2, "seatName");
            return (Criteria) this;
        }

        public Criteria andSeatNoIsNull() {
            addCriterion("seat_no is null");
            return (Criteria) this;
        }

        public Criteria andSeatNoIsNotNull() {
            addCriterion("seat_no is not null");
            return (Criteria) this;
        }

        public Criteria andSeatNoEqualTo(String value) {
            addCriterion("seat_no =", value, "seatNo");
            return (Criteria) this;
        }

        public Criteria andSeatNoNotEqualTo(String value) {
            addCriterion("seat_no <>", value, "seatNo");
            return (Criteria) this;
        }

        public Criteria andSeatNoGreaterThan(String value) {
            addCriterion("seat_no >", value, "seatNo");
            return (Criteria) this;
        }

        public Criteria andSeatNoGreaterThanOrEqualTo(String value) {
            addCriterion("seat_no >=", value, "seatNo");
            return (Criteria) this;
        }

        public Criteria andSeatNoLessThan(String value) {
            addCriterion("seat_no <", value, "seatNo");
            return (Criteria) this;
        }

        public Criteria andSeatNoLessThanOrEqualTo(String value) {
            addCriterion("seat_no <=", value, "seatNo");
            return (Criteria) this;
        }

        public Criteria andSeatNoLike(String value) {
            addCriterion("seat_no like", value, "seatNo");
            return (Criteria) this;
        }

        public Criteria andSeatNoNotLike(String value) {
            addCriterion("seat_no not like", value, "seatNo");
            return (Criteria) this;
        }

        public Criteria andSeatNoIn(List<String> values) {
            addCriterion("seat_no in", values, "seatNo");
            return (Criteria) this;
        }

        public Criteria andSeatNoNotIn(List<String> values) {
            addCriterion("seat_no not in", values, "seatNo");
            return (Criteria) this;
        }

        public Criteria andSeatNoBetween(String value1, String value2) {
            addCriterion("seat_no between", value1, value2, "seatNo");
            return (Criteria) this;
        }

        public Criteria andSeatNoNotBetween(String value1, String value2) {
            addCriterion("seat_no not between", value1, value2, "seatNo");
            return (Criteria) this;
        }

        public Criteria andMinNumIsNull() {
            addCriterion("min_num is null");
            return (Criteria) this;
        }

        public Criteria andMinNumIsNotNull() {
            addCriterion("min_num is not null");
            return (Criteria) this;
        }

        public Criteria andMinNumEqualTo(Long value) {
            addCriterion("min_num =", value, "minNum");
            return (Criteria) this;
        }

        public Criteria andMinNumNotEqualTo(Long value) {
            addCriterion("min_num <>", value, "minNum");
            return (Criteria) this;
        }

        public Criteria andMinNumGreaterThan(Long value) {
            addCriterion("min_num >", value, "minNum");
            return (Criteria) this;
        }

        public Criteria andMinNumGreaterThanOrEqualTo(Long value) {
            addCriterion("min_num >=", value, "minNum");
            return (Criteria) this;
        }

        public Criteria andMinNumLessThan(Long value) {
            addCriterion("min_num <", value, "minNum");
            return (Criteria) this;
        }

        public Criteria andMinNumLessThanOrEqualTo(Long value) {
            addCriterion("min_num <=", value, "minNum");
            return (Criteria) this;
        }

        public Criteria andMinNumIn(List<Long> values) {
            addCriterion("min_num in", values, "minNum");
            return (Criteria) this;
        }

        public Criteria andMinNumNotIn(List<Long> values) {
            addCriterion("min_num not in", values, "minNum");
            return (Criteria) this;
        }

        public Criteria andMinNumBetween(Long value1, Long value2) {
            addCriterion("min_num between", value1, value2, "minNum");
            return (Criteria) this;
        }

        public Criteria andMinNumNotBetween(Long value1, Long value2) {
            addCriterion("min_num not between", value1, value2, "minNum");
            return (Criteria) this;
        }

        public Criteria andMaxNumIsNull() {
            addCriterion("max_num is null");
            return (Criteria) this;
        }

        public Criteria andMaxNumIsNotNull() {
            addCriterion("max_num is not null");
            return (Criteria) this;
        }

        public Criteria andMaxNumEqualTo(Long value) {
            addCriterion("max_num =", value, "maxNum");
            return (Criteria) this;
        }

        public Criteria andMaxNumNotEqualTo(Long value) {
            addCriterion("max_num <>", value, "maxNum");
            return (Criteria) this;
        }

        public Criteria andMaxNumGreaterThan(Long value) {
            addCriterion("max_num >", value, "maxNum");
            return (Criteria) this;
        }

        public Criteria andMaxNumGreaterThanOrEqualTo(Long value) {
            addCriterion("max_num >=", value, "maxNum");
            return (Criteria) this;
        }

        public Criteria andMaxNumLessThan(Long value) {
            addCriterion("max_num <", value, "maxNum");
            return (Criteria) this;
        }

        public Criteria andMaxNumLessThanOrEqualTo(Long value) {
            addCriterion("max_num <=", value, "maxNum");
            return (Criteria) this;
        }

        public Criteria andMaxNumIn(List<Long> values) {
            addCriterion("max_num in", values, "maxNum");
            return (Criteria) this;
        }

        public Criteria andMaxNumNotIn(List<Long> values) {
            addCriterion("max_num not in", values, "maxNum");
            return (Criteria) this;
        }

        public Criteria andMaxNumBetween(Long value1, Long value2) {
            addCriterion("max_num between", value1, value2, "maxNum");
            return (Criteria) this;
        }

        public Criteria andMaxNumNotBetween(Long value1, Long value2) {
            addCriterion("max_num not between", value1, value2, "maxNum");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
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

        public Criteria andSeatNameLikeInsensitive(String value) {
            addCriterion("upper(seat_name) like", value.toUpperCase(), "seatName");
            return (Criteria) this;
        }

        public Criteria andSeatNoLikeInsensitive(String value) {
            addCriterion("upper(seat_no) like", value.toUpperCase(), "seatNo");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table weibar_merchants_seat_setting_info
     *
     * @mbggenerated do_not_delete_during_merge Wed Mar 28 18:05:21 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table weibar_merchants_seat_setting_info
     *
     * @mbggenerated Wed Mar 28 18:05:21 CST 2018
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