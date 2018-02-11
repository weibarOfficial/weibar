package com.weibar.pojo.db;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WeibarWsCacheCriteria {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table weibar_ws_cache
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table weibar_ws_cache
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table weibar_ws_cache
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_ws_cache
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public WeibarWsCacheCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_ws_cache
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_ws_cache
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_ws_cache
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_ws_cache
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_ws_cache
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_ws_cache
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_ws_cache
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_ws_cache
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
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
     * This method corresponds to the database table weibar_ws_cache
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_ws_cache
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
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
     * This class corresponds to the database table weibar_ws_cache
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
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

        public Criteria andSubUrlIsNull() {
            addCriterion("sub_url is null");
            return (Criteria) this;
        }

        public Criteria andSubUrlIsNotNull() {
            addCriterion("sub_url is not null");
            return (Criteria) this;
        }

        public Criteria andSubUrlEqualTo(String value) {
            addCriterion("sub_url =", value, "subUrl");
            return (Criteria) this;
        }

        public Criteria andSubUrlNotEqualTo(String value) {
            addCriterion("sub_url <>", value, "subUrl");
            return (Criteria) this;
        }

        public Criteria andSubUrlGreaterThan(String value) {
            addCriterion("sub_url >", value, "subUrl");
            return (Criteria) this;
        }

        public Criteria andSubUrlGreaterThanOrEqualTo(String value) {
            addCriterion("sub_url >=", value, "subUrl");
            return (Criteria) this;
        }

        public Criteria andSubUrlLessThan(String value) {
            addCriterion("sub_url <", value, "subUrl");
            return (Criteria) this;
        }

        public Criteria andSubUrlLessThanOrEqualTo(String value) {
            addCriterion("sub_url <=", value, "subUrl");
            return (Criteria) this;
        }

        public Criteria andSubUrlLike(String value) {
            addCriterion("sub_url like", value, "subUrl");
            return (Criteria) this;
        }

        public Criteria andSubUrlNotLike(String value) {
            addCriterion("sub_url not like", value, "subUrl");
            return (Criteria) this;
        }

        public Criteria andSubUrlIn(List<String> values) {
            addCriterion("sub_url in", values, "subUrl");
            return (Criteria) this;
        }

        public Criteria andSubUrlNotIn(List<String> values) {
            addCriterion("sub_url not in", values, "subUrl");
            return (Criteria) this;
        }

        public Criteria andSubUrlBetween(String value1, String value2) {
            addCriterion("sub_url between", value1, value2, "subUrl");
            return (Criteria) this;
        }

        public Criteria andSubUrlNotBetween(String value1, String value2) {
            addCriterion("sub_url not between", value1, value2, "subUrl");
            return (Criteria) this;
        }

        public Criteria andResIsNull() {
            addCriterion("res is null");
            return (Criteria) this;
        }

        public Criteria andResIsNotNull() {
            addCriterion("res is not null");
            return (Criteria) this;
        }

        public Criteria andResEqualTo(String value) {
            addCriterion("res =", value, "res");
            return (Criteria) this;
        }

        public Criteria andResNotEqualTo(String value) {
            addCriterion("res <>", value, "res");
            return (Criteria) this;
        }

        public Criteria andResGreaterThan(String value) {
            addCriterion("res >", value, "res");
            return (Criteria) this;
        }

        public Criteria andResGreaterThanOrEqualTo(String value) {
            addCriterion("res >=", value, "res");
            return (Criteria) this;
        }

        public Criteria andResLessThan(String value) {
            addCriterion("res <", value, "res");
            return (Criteria) this;
        }

        public Criteria andResLessThanOrEqualTo(String value) {
            addCriterion("res <=", value, "res");
            return (Criteria) this;
        }

        public Criteria andResLike(String value) {
            addCriterion("res like", value, "res");
            return (Criteria) this;
        }

        public Criteria andResNotLike(String value) {
            addCriterion("res not like", value, "res");
            return (Criteria) this;
        }

        public Criteria andResIn(List<String> values) {
            addCriterion("res in", values, "res");
            return (Criteria) this;
        }

        public Criteria andResNotIn(List<String> values) {
            addCriterion("res not in", values, "res");
            return (Criteria) this;
        }

        public Criteria andResBetween(String value1, String value2) {
            addCriterion("res between", value1, value2, "res");
            return (Criteria) this;
        }

        public Criteria andResNotBetween(String value1, String value2) {
            addCriterion("res not between", value1, value2, "res");
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

        public Criteria andSubUrlLikeInsensitive(String value) {
            addCriterion("upper(sub_url) like", value.toUpperCase(), "subUrl");
            return (Criteria) this;
        }

        public Criteria andResLikeInsensitive(String value) {
            addCriterion("upper(res) like", value.toUpperCase(), "res");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table weibar_ws_cache
     *
     * @mbggenerated do_not_delete_during_merge Sun Feb 11 16:12:00 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table weibar_ws_cache
     *
     * @mbggenerated Sun Feb 11 16:12:00 CST 2018
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