package com.javaThree.mybatis.dao;

import com.javaThree.mybatis.model.PfmsUsageOne;
import com.javaThree.mybatis.model.PfmsUsageOneExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PfmsUsageOneMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pfmsdb_usage1
     *
     * @mbggenerated Sun May 10 17:19:46 CST 2015
     */
    int countByExample(PfmsUsageOneExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pfmsdb_usage1
     *
     * @mbggenerated Sun May 10 17:19:46 CST 2015
     */
    int deleteByExample(PfmsUsageOneExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pfmsdb_usage1
     *
     * @mbggenerated Sun May 10 17:19:46 CST 2015
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pfmsdb_usage1
     *
     * @mbggenerated Sun May 10 17:19:46 CST 2015
     */
    int insert(PfmsUsageOne record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pfmsdb_usage1
     *
     * @mbggenerated Sun May 10 17:19:46 CST 2015
     */
    int insertSelective(PfmsUsageOne record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pfmsdb_usage1
     *
     * @mbggenerated Sun May 10 17:19:46 CST 2015
     */
    List<PfmsUsageOne> selectByExample(PfmsUsageOneExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pfmsdb_usage1
     *
     * @mbggenerated Sun May 10 17:19:46 CST 2015
     */
    PfmsUsageOne selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pfmsdb_usage1
     *
     * @mbggenerated Sun May 10 17:19:46 CST 2015
     */
    int updateByExampleSelective(@Param("record") PfmsUsageOne record, @Param("example") PfmsUsageOneExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pfmsdb_usage1
     *
     * @mbggenerated Sun May 10 17:19:46 CST 2015
     */
    int updateByExample(@Param("record") PfmsUsageOne record, @Param("example") PfmsUsageOneExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pfmsdb_usage1
     *
     * @mbggenerated Sun May 10 17:19:46 CST 2015
     */
    int updateByPrimaryKeySelective(PfmsUsageOne record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pfmsdb_usage1
     *
     * @mbggenerated Sun May 10 17:19:46 CST 2015
     */
    int updateByPrimaryKey(PfmsUsageOne record);
}