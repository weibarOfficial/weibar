package com.weibar.pojo.db;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WeibarMerchantsGameSettingInfoCriteria {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table weibar_merchants_game_setting_info
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table weibar_merchants_game_setting_info
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table weibar_merchants_game_setting_info
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_game_setting_info
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    public WeibarMerchantsGameSettingInfoCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_game_setting_info
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_game_setting_info
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_game_setting_info
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_game_setting_info
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_game_setting_info
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_game_setting_info
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_game_setting_info
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_game_setting_info
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
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
     * This method corresponds to the database table weibar_merchants_game_setting_info
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_game_setting_info
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
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
     * This class corresponds to the database table weibar_merchants_game_setting_info
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
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

        public Criteria andGameidIsNull() {
            addCriterion("gameid is null");
            return (Criteria) this;
        }

        public Criteria andGameidIsNotNull() {
            addCriterion("gameid is not null");
            return (Criteria) this;
        }

        public Criteria andGameidEqualTo(String value) {
            addCriterion("gameid =", value, "gameid");
            return (Criteria) this;
        }

        public Criteria andGameidNotEqualTo(String value) {
            addCriterion("gameid <>", value, "gameid");
            return (Criteria) this;
        }

        public Criteria andGameidGreaterThan(String value) {
            addCriterion("gameid >", value, "gameid");
            return (Criteria) this;
        }

        public Criteria andGameidGreaterThanOrEqualTo(String value) {
            addCriterion("gameid >=", value, "gameid");
            return (Criteria) this;
        }

        public Criteria andGameidLessThan(String value) {
            addCriterion("gameid <", value, "gameid");
            return (Criteria) this;
        }

        public Criteria andGameidLessThanOrEqualTo(String value) {
            addCriterion("gameid <=", value, "gameid");
            return (Criteria) this;
        }

        public Criteria andGameidLike(String value) {
            addCriterion("gameid like", value, "gameid");
            return (Criteria) this;
        }

        public Criteria andGameidNotLike(String value) {
            addCriterion("gameid not like", value, "gameid");
            return (Criteria) this;
        }

        public Criteria andGameidIn(List<String> values) {
            addCriterion("gameid in", values, "gameid");
            return (Criteria) this;
        }

        public Criteria andGameidNotIn(List<String> values) {
            addCriterion("gameid not in", values, "gameid");
            return (Criteria) this;
        }

        public Criteria andGameidBetween(String value1, String value2) {
            addCriterion("gameid between", value1, value2, "gameid");
            return (Criteria) this;
        }

        public Criteria andGameidNotBetween(String value1, String value2) {
            addCriterion("gameid not between", value1, value2, "gameid");
            return (Criteria) this;
        }

        public Criteria andGamenameIsNull() {
            addCriterion("gamename is null");
            return (Criteria) this;
        }

        public Criteria andGamenameIsNotNull() {
            addCriterion("gamename is not null");
            return (Criteria) this;
        }

        public Criteria andGamenameEqualTo(String value) {
            addCriterion("gamename =", value, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameNotEqualTo(String value) {
            addCriterion("gamename <>", value, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameGreaterThan(String value) {
            addCriterion("gamename >", value, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameGreaterThanOrEqualTo(String value) {
            addCriterion("gamename >=", value, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameLessThan(String value) {
            addCriterion("gamename <", value, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameLessThanOrEqualTo(String value) {
            addCriterion("gamename <=", value, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameLike(String value) {
            addCriterion("gamename like", value, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameNotLike(String value) {
            addCriterion("gamename not like", value, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameIn(List<String> values) {
            addCriterion("gamename in", values, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameNotIn(List<String> values) {
            addCriterion("gamename not in", values, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameBetween(String value1, String value2) {
            addCriterion("gamename between", value1, value2, "gamename");
            return (Criteria) this;
        }

        public Criteria andGamenameNotBetween(String value1, String value2) {
            addCriterion("gamename not between", value1, value2, "gamename");
            return (Criteria) this;
        }

        public Criteria andGameImgUrlIsNull() {
            addCriterion("game_img_url is null");
            return (Criteria) this;
        }

        public Criteria andGameImgUrlIsNotNull() {
            addCriterion("game_img_url is not null");
            return (Criteria) this;
        }

        public Criteria andGameImgUrlEqualTo(String value) {
            addCriterion("game_img_url =", value, "gameImgUrl");
            return (Criteria) this;
        }

        public Criteria andGameImgUrlNotEqualTo(String value) {
            addCriterion("game_img_url <>", value, "gameImgUrl");
            return (Criteria) this;
        }

        public Criteria andGameImgUrlGreaterThan(String value) {
            addCriterion("game_img_url >", value, "gameImgUrl");
            return (Criteria) this;
        }

        public Criteria andGameImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("game_img_url >=", value, "gameImgUrl");
            return (Criteria) this;
        }

        public Criteria andGameImgUrlLessThan(String value) {
            addCriterion("game_img_url <", value, "gameImgUrl");
            return (Criteria) this;
        }

        public Criteria andGameImgUrlLessThanOrEqualTo(String value) {
            addCriterion("game_img_url <=", value, "gameImgUrl");
            return (Criteria) this;
        }

        public Criteria andGameImgUrlLike(String value) {
            addCriterion("game_img_url like", value, "gameImgUrl");
            return (Criteria) this;
        }

        public Criteria andGameImgUrlNotLike(String value) {
            addCriterion("game_img_url not like", value, "gameImgUrl");
            return (Criteria) this;
        }

        public Criteria andGameImgUrlIn(List<String> values) {
            addCriterion("game_img_url in", values, "gameImgUrl");
            return (Criteria) this;
        }

        public Criteria andGameImgUrlNotIn(List<String> values) {
            addCriterion("game_img_url not in", values, "gameImgUrl");
            return (Criteria) this;
        }

        public Criteria andGameImgUrlBetween(String value1, String value2) {
            addCriterion("game_img_url between", value1, value2, "gameImgUrl");
            return (Criteria) this;
        }

        public Criteria andGameImgUrlNotBetween(String value1, String value2) {
            addCriterion("game_img_url not between", value1, value2, "gameImgUrl");
            return (Criteria) this;
        }

        public Criteria andGameUrlIsNull() {
            addCriterion("game_url is null");
            return (Criteria) this;
        }

        public Criteria andGameUrlIsNotNull() {
            addCriterion("game_url is not null");
            return (Criteria) this;
        }

        public Criteria andGameUrlEqualTo(String value) {
            addCriterion("game_url =", value, "gameUrl");
            return (Criteria) this;
        }

        public Criteria andGameUrlNotEqualTo(String value) {
            addCriterion("game_url <>", value, "gameUrl");
            return (Criteria) this;
        }

        public Criteria andGameUrlGreaterThan(String value) {
            addCriterion("game_url >", value, "gameUrl");
            return (Criteria) this;
        }

        public Criteria andGameUrlGreaterThanOrEqualTo(String value) {
            addCriterion("game_url >=", value, "gameUrl");
            return (Criteria) this;
        }

        public Criteria andGameUrlLessThan(String value) {
            addCriterion("game_url <", value, "gameUrl");
            return (Criteria) this;
        }

        public Criteria andGameUrlLessThanOrEqualTo(String value) {
            addCriterion("game_url <=", value, "gameUrl");
            return (Criteria) this;
        }

        public Criteria andGameUrlLike(String value) {
            addCriterion("game_url like", value, "gameUrl");
            return (Criteria) this;
        }

        public Criteria andGameUrlNotLike(String value) {
            addCriterion("game_url not like", value, "gameUrl");
            return (Criteria) this;
        }

        public Criteria andGameUrlIn(List<String> values) {
            addCriterion("game_url in", values, "gameUrl");
            return (Criteria) this;
        }

        public Criteria andGameUrlNotIn(List<String> values) {
            addCriterion("game_url not in", values, "gameUrl");
            return (Criteria) this;
        }

        public Criteria andGameUrlBetween(String value1, String value2) {
            addCriterion("game_url between", value1, value2, "gameUrl");
            return (Criteria) this;
        }

        public Criteria andGameUrlNotBetween(String value1, String value2) {
            addCriterion("game_url not between", value1, value2, "gameUrl");
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

        public Criteria andGameidLikeInsensitive(String value) {
            addCriterion("upper(gameid) like", value.toUpperCase(), "gameid");
            return (Criteria) this;
        }

        public Criteria andGamenameLikeInsensitive(String value) {
            addCriterion("upper(gamename) like", value.toUpperCase(), "gamename");
            return (Criteria) this;
        }

        public Criteria andGameImgUrlLikeInsensitive(String value) {
            addCriterion("upper(game_img_url) like", value.toUpperCase(), "gameImgUrl");
            return (Criteria) this;
        }

        public Criteria andGameUrlLikeInsensitive(String value) {
            addCriterion("upper(game_url) like", value.toUpperCase(), "gameUrl");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table weibar_merchants_game_setting_info
     *
     * @mbggenerated do_not_delete_during_merge Tue Mar 27 18:15:48 CST 2018
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table weibar_merchants_game_setting_info
     *
     * @mbggenerated Tue Mar 27 18:15:48 CST 2018
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