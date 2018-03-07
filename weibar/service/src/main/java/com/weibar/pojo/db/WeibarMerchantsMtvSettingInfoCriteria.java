package com.weibar.pojo.db;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WeibarMerchantsMtvSettingInfoCriteria {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table weibar_merchants_mtv_setting_info
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table weibar_merchants_mtv_setting_info
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table weibar_merchants_mtv_setting_info
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_mtv_setting_info
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    public WeibarMerchantsMtvSettingInfoCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_mtv_setting_info
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_mtv_setting_info
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_mtv_setting_info
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_mtv_setting_info
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_mtv_setting_info
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_mtv_setting_info
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_mtv_setting_info
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_mtv_setting_info
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
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
     * This method corresponds to the database table weibar_merchants_mtv_setting_info
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_mtv_setting_info
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
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
     * This class corresponds to the database table weibar_merchants_mtv_setting_info
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
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

        public Criteria andMtvNameIsNull() {
            addCriterion("mtv_name is null");
            return (Criteria) this;
        }

        public Criteria andMtvNameIsNotNull() {
            addCriterion("mtv_name is not null");
            return (Criteria) this;
        }

        public Criteria andMtvNameEqualTo(String value) {
            addCriterion("mtv_name =", value, "mtvName");
            return (Criteria) this;
        }

        public Criteria andMtvNameNotEqualTo(String value) {
            addCriterion("mtv_name <>", value, "mtvName");
            return (Criteria) this;
        }

        public Criteria andMtvNameGreaterThan(String value) {
            addCriterion("mtv_name >", value, "mtvName");
            return (Criteria) this;
        }

        public Criteria andMtvNameGreaterThanOrEqualTo(String value) {
            addCriterion("mtv_name >=", value, "mtvName");
            return (Criteria) this;
        }

        public Criteria andMtvNameLessThan(String value) {
            addCriterion("mtv_name <", value, "mtvName");
            return (Criteria) this;
        }

        public Criteria andMtvNameLessThanOrEqualTo(String value) {
            addCriterion("mtv_name <=", value, "mtvName");
            return (Criteria) this;
        }

        public Criteria andMtvNameLike(String value) {
            addCriterion("mtv_name like", value, "mtvName");
            return (Criteria) this;
        }

        public Criteria andMtvNameNotLike(String value) {
            addCriterion("mtv_name not like", value, "mtvName");
            return (Criteria) this;
        }

        public Criteria andMtvNameIn(List<String> values) {
            addCriterion("mtv_name in", values, "mtvName");
            return (Criteria) this;
        }

        public Criteria andMtvNameNotIn(List<String> values) {
            addCriterion("mtv_name not in", values, "mtvName");
            return (Criteria) this;
        }

        public Criteria andMtvNameBetween(String value1, String value2) {
            addCriterion("mtv_name between", value1, value2, "mtvName");
            return (Criteria) this;
        }

        public Criteria andMtvNameNotBetween(String value1, String value2) {
            addCriterion("mtv_name not between", value1, value2, "mtvName");
            return (Criteria) this;
        }

        public Criteria andMtvSytleIsNull() {
            addCriterion("mtv_sytle is null");
            return (Criteria) this;
        }

        public Criteria andMtvSytleIsNotNull() {
            addCriterion("mtv_sytle is not null");
            return (Criteria) this;
        }

        public Criteria andMtvSytleEqualTo(String value) {
            addCriterion("mtv_sytle =", value, "mtvSytle");
            return (Criteria) this;
        }

        public Criteria andMtvSytleNotEqualTo(String value) {
            addCriterion("mtv_sytle <>", value, "mtvSytle");
            return (Criteria) this;
        }

        public Criteria andMtvSytleGreaterThan(String value) {
            addCriterion("mtv_sytle >", value, "mtvSytle");
            return (Criteria) this;
        }

        public Criteria andMtvSytleGreaterThanOrEqualTo(String value) {
            addCriterion("mtv_sytle >=", value, "mtvSytle");
            return (Criteria) this;
        }

        public Criteria andMtvSytleLessThan(String value) {
            addCriterion("mtv_sytle <", value, "mtvSytle");
            return (Criteria) this;
        }

        public Criteria andMtvSytleLessThanOrEqualTo(String value) {
            addCriterion("mtv_sytle <=", value, "mtvSytle");
            return (Criteria) this;
        }

        public Criteria andMtvSytleLike(String value) {
            addCriterion("mtv_sytle like", value, "mtvSytle");
            return (Criteria) this;
        }

        public Criteria andMtvSytleNotLike(String value) {
            addCriterion("mtv_sytle not like", value, "mtvSytle");
            return (Criteria) this;
        }

        public Criteria andMtvSytleIn(List<String> values) {
            addCriterion("mtv_sytle in", values, "mtvSytle");
            return (Criteria) this;
        }

        public Criteria andMtvSytleNotIn(List<String> values) {
            addCriterion("mtv_sytle not in", values, "mtvSytle");
            return (Criteria) this;
        }

        public Criteria andMtvSytleBetween(String value1, String value2) {
            addCriterion("mtv_sytle between", value1, value2, "mtvSytle");
            return (Criteria) this;
        }

        public Criteria andMtvSytleNotBetween(String value1, String value2) {
            addCriterion("mtv_sytle not between", value1, value2, "mtvSytle");
            return (Criteria) this;
        }

        public Criteria andMtvUrlIsNull() {
            addCriterion("mtv_url is null");
            return (Criteria) this;
        }

        public Criteria andMtvUrlIsNotNull() {
            addCriterion("mtv_url is not null");
            return (Criteria) this;
        }

        public Criteria andMtvUrlEqualTo(String value) {
            addCriterion("mtv_url =", value, "mtvUrl");
            return (Criteria) this;
        }

        public Criteria andMtvUrlNotEqualTo(String value) {
            addCriterion("mtv_url <>", value, "mtvUrl");
            return (Criteria) this;
        }

        public Criteria andMtvUrlGreaterThan(String value) {
            addCriterion("mtv_url >", value, "mtvUrl");
            return (Criteria) this;
        }

        public Criteria andMtvUrlGreaterThanOrEqualTo(String value) {
            addCriterion("mtv_url >=", value, "mtvUrl");
            return (Criteria) this;
        }

        public Criteria andMtvUrlLessThan(String value) {
            addCriterion("mtv_url <", value, "mtvUrl");
            return (Criteria) this;
        }

        public Criteria andMtvUrlLessThanOrEqualTo(String value) {
            addCriterion("mtv_url <=", value, "mtvUrl");
            return (Criteria) this;
        }

        public Criteria andMtvUrlLike(String value) {
            addCriterion("mtv_url like", value, "mtvUrl");
            return (Criteria) this;
        }

        public Criteria andMtvUrlNotLike(String value) {
            addCriterion("mtv_url not like", value, "mtvUrl");
            return (Criteria) this;
        }

        public Criteria andMtvUrlIn(List<String> values) {
            addCriterion("mtv_url in", values, "mtvUrl");
            return (Criteria) this;
        }

        public Criteria andMtvUrlNotIn(List<String> values) {
            addCriterion("mtv_url not in", values, "mtvUrl");
            return (Criteria) this;
        }

        public Criteria andMtvUrlBetween(String value1, String value2) {
            addCriterion("mtv_url between", value1, value2, "mtvUrl");
            return (Criteria) this;
        }

        public Criteria andMtvUrlNotBetween(String value1, String value2) {
            addCriterion("mtv_url not between", value1, value2, "mtvUrl");
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

        public Criteria andMtvNameLikeInsensitive(String value) {
            addCriterion("upper(mtv_name) like", value.toUpperCase(), "mtvName");
            return (Criteria) this;
        }

        public Criteria andMtvSytleLikeInsensitive(String value) {
            addCriterion("upper(mtv_sytle) like", value.toUpperCase(), "mtvSytle");
            return (Criteria) this;
        }

        public Criteria andMtvUrlLikeInsensitive(String value) {
            addCriterion("upper(mtv_url) like", value.toUpperCase(), "mtvUrl");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table weibar_merchants_mtv_setting_info
     *
     * @mbggenerated do_not_delete_during_merge Wed Mar 07 18:00:33 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table weibar_merchants_mtv_setting_info
     *
     * @mbggenerated Wed Mar 07 18:00:33 CST 2018
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