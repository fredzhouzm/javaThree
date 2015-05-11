package com.javaThree.mybatis.model;

import java.util.ArrayList;
import java.util.List;

public class PfmsSysExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pfmsdb_sys
     *
     * @mbggenerated Sun May 10 17:19:46 CST 2015
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pfmsdb_sys
     *
     * @mbggenerated Sun May 10 17:19:46 CST 2015
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pfmsdb_sys
     *
     * @mbggenerated Sun May 10 17:19:46 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pfmsdb_sys
     *
     * @mbggenerated Sun May 10 17:19:46 CST 2015
     */
    public PfmsSysExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pfmsdb_sys
     *
     * @mbggenerated Sun May 10 17:19:46 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pfmsdb_sys
     *
     * @mbggenerated Sun May 10 17:19:46 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pfmsdb_sys
     *
     * @mbggenerated Sun May 10 17:19:46 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pfmsdb_sys
     *
     * @mbggenerated Sun May 10 17:19:46 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pfmsdb_sys
     *
     * @mbggenerated Sun May 10 17:19:46 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pfmsdb_sys
     *
     * @mbggenerated Sun May 10 17:19:46 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pfmsdb_sys
     *
     * @mbggenerated Sun May 10 17:19:46 CST 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pfmsdb_sys
     *
     * @mbggenerated Sun May 10 17:19:46 CST 2015
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
     * This method corresponds to the database table pfmsdb_sys
     *
     * @mbggenerated Sun May 10 17:19:46 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pfmsdb_sys
     *
     * @mbggenerated Sun May 10 17:19:46 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table pfmsdb_sys
     *
     * @mbggenerated Sun May 10 17:19:46 CST 2015
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

        public Criteria andSysIdIsNull() {
            addCriterion("SYS_ID is null");
            return (Criteria) this;
        }

        public Criteria andSysIdIsNotNull() {
            addCriterion("SYS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSysIdEqualTo(String value) {
            addCriterion("SYS_ID =", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdNotEqualTo(String value) {
            addCriterion("SYS_ID <>", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdGreaterThan(String value) {
            addCriterion("SYS_ID >", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdGreaterThanOrEqualTo(String value) {
            addCriterion("SYS_ID >=", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdLessThan(String value) {
            addCriterion("SYS_ID <", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdLessThanOrEqualTo(String value) {
            addCriterion("SYS_ID <=", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdLike(String value) {
            addCriterion("SYS_ID like", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdNotLike(String value) {
            addCriterion("SYS_ID not like", value, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdIn(List<String> values) {
            addCriterion("SYS_ID in", values, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdNotIn(List<String> values) {
            addCriterion("SYS_ID not in", values, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdBetween(String value1, String value2) {
            addCriterion("SYS_ID between", value1, value2, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysIdNotBetween(String value1, String value2) {
            addCriterion("SYS_ID not between", value1, value2, "sysId");
            return (Criteria) this;
        }

        public Criteria andSysNameIsNull() {
            addCriterion("SYS_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSysNameIsNotNull() {
            addCriterion("SYS_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSysNameEqualTo(String value) {
            addCriterion("SYS_NAME =", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameNotEqualTo(String value) {
            addCriterion("SYS_NAME <>", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameGreaterThan(String value) {
            addCriterion("SYS_NAME >", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameGreaterThanOrEqualTo(String value) {
            addCriterion("SYS_NAME >=", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameLessThan(String value) {
            addCriterion("SYS_NAME <", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameLessThanOrEqualTo(String value) {
            addCriterion("SYS_NAME <=", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameLike(String value) {
            addCriterion("SYS_NAME like", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameNotLike(String value) {
            addCriterion("SYS_NAME not like", value, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameIn(List<String> values) {
            addCriterion("SYS_NAME in", values, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameNotIn(List<String> values) {
            addCriterion("SYS_NAME not in", values, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameBetween(String value1, String value2) {
            addCriterion("SYS_NAME between", value1, value2, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysNameNotBetween(String value1, String value2) {
            addCriterion("SYS_NAME not between", value1, value2, "sysName");
            return (Criteria) this;
        }

        public Criteria andSysValueIsNull() {
            addCriterion("SYS_VALUE is null");
            return (Criteria) this;
        }

        public Criteria andSysValueIsNotNull() {
            addCriterion("SYS_VALUE is not null");
            return (Criteria) this;
        }

        public Criteria andSysValueEqualTo(String value) {
            addCriterion("SYS_VALUE =", value, "sysValue");
            return (Criteria) this;
        }

        public Criteria andSysValueNotEqualTo(String value) {
            addCriterion("SYS_VALUE <>", value, "sysValue");
            return (Criteria) this;
        }

        public Criteria andSysValueGreaterThan(String value) {
            addCriterion("SYS_VALUE >", value, "sysValue");
            return (Criteria) this;
        }

        public Criteria andSysValueGreaterThanOrEqualTo(String value) {
            addCriterion("SYS_VALUE >=", value, "sysValue");
            return (Criteria) this;
        }

        public Criteria andSysValueLessThan(String value) {
            addCriterion("SYS_VALUE <", value, "sysValue");
            return (Criteria) this;
        }

        public Criteria andSysValueLessThanOrEqualTo(String value) {
            addCriterion("SYS_VALUE <=", value, "sysValue");
            return (Criteria) this;
        }

        public Criteria andSysValueLike(String value) {
            addCriterion("SYS_VALUE like", value, "sysValue");
            return (Criteria) this;
        }

        public Criteria andSysValueNotLike(String value) {
            addCriterion("SYS_VALUE not like", value, "sysValue");
            return (Criteria) this;
        }

        public Criteria andSysValueIn(List<String> values) {
            addCriterion("SYS_VALUE in", values, "sysValue");
            return (Criteria) this;
        }

        public Criteria andSysValueNotIn(List<String> values) {
            addCriterion("SYS_VALUE not in", values, "sysValue");
            return (Criteria) this;
        }

        public Criteria andSysValueBetween(String value1, String value2) {
            addCriterion("SYS_VALUE between", value1, value2, "sysValue");
            return (Criteria) this;
        }

        public Criteria andSysValueNotBetween(String value1, String value2) {
            addCriterion("SYS_VALUE not between", value1, value2, "sysValue");
            return (Criteria) this;
        }

        public Criteria andSysDescIsNull() {
            addCriterion("SYS_DESC is null");
            return (Criteria) this;
        }

        public Criteria andSysDescIsNotNull() {
            addCriterion("SYS_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andSysDescEqualTo(String value) {
            addCriterion("SYS_DESC =", value, "sysDesc");
            return (Criteria) this;
        }

        public Criteria andSysDescNotEqualTo(String value) {
            addCriterion("SYS_DESC <>", value, "sysDesc");
            return (Criteria) this;
        }

        public Criteria andSysDescGreaterThan(String value) {
            addCriterion("SYS_DESC >", value, "sysDesc");
            return (Criteria) this;
        }

        public Criteria andSysDescGreaterThanOrEqualTo(String value) {
            addCriterion("SYS_DESC >=", value, "sysDesc");
            return (Criteria) this;
        }

        public Criteria andSysDescLessThan(String value) {
            addCriterion("SYS_DESC <", value, "sysDesc");
            return (Criteria) this;
        }

        public Criteria andSysDescLessThanOrEqualTo(String value) {
            addCriterion("SYS_DESC <=", value, "sysDesc");
            return (Criteria) this;
        }

        public Criteria andSysDescLike(String value) {
            addCriterion("SYS_DESC like", value, "sysDesc");
            return (Criteria) this;
        }

        public Criteria andSysDescNotLike(String value) {
            addCriterion("SYS_DESC not like", value, "sysDesc");
            return (Criteria) this;
        }

        public Criteria andSysDescIn(List<String> values) {
            addCriterion("SYS_DESC in", values, "sysDesc");
            return (Criteria) this;
        }

        public Criteria andSysDescNotIn(List<String> values) {
            addCriterion("SYS_DESC not in", values, "sysDesc");
            return (Criteria) this;
        }

        public Criteria andSysDescBetween(String value1, String value2) {
            addCriterion("SYS_DESC between", value1, value2, "sysDesc");
            return (Criteria) this;
        }

        public Criteria andSysDescNotBetween(String value1, String value2) {
            addCriterion("SYS_DESC not between", value1, value2, "sysDesc");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table pfmsdb_sys
     *
     * @mbggenerated do_not_delete_during_merge Sun May 10 17:19:46 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table pfmsdb_sys
     *
     * @mbggenerated Sun May 10 17:19:46 CST 2015
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