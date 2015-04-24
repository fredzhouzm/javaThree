package com.javaThree.mybatis.dao;

import com.javaThree.mybatis.model.PfmsUsageTwo;
import com.javaThree.mybatis.model.PfmsUsageTwoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PfmsUsageTwoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pfmsdb_usage2
     *
     * @mbggenerated Thu Apr 23 22:21:56 CST 2015
     */
    int countByExample(PfmsUsageTwoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pfmsdb_usage2
     *
     * @mbggenerated Thu Apr 23 22:21:56 CST 2015
     */
    int deleteByExample(PfmsUsageTwoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pfmsdb_usage2
     *
     * @mbggenerated Thu Apr 23 22:21:56 CST 2015
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pfmsdb_usage2
     *
     * @mbggenerated Thu Apr 23 22:21:56 CST 2015
     */
    int insert(PfmsUsageTwo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pfmsdb_usage2
     *
     * @mbggenerated Thu Apr 23 22:21:56 CST 2015
     */
    int insertSelective(PfmsUsageTwo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pfmsdb_usage2
     *
     * @mbggenerated Thu Apr 23 22:21:56 CST 2015
     */
    List<PfmsUsageTwo> selectByExample(PfmsUsageTwoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pfmsdb_usage2
     *
     * @mbggenerated Thu Apr 23 22:21:56 CST 2015
     */
    PfmsUsageTwo selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pfmsdb_usage2
     *
     * @mbggenerated Thu Apr 23 22:21:56 CST 2015
     */
    int updateByExampleSelective(@Param("record") PfmsUsageTwo record, @Param("example") PfmsUsageTwoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pfmsdb_usage2
     *
     * @mbggenerated Thu Apr 23 22:21:56 CST 2015
     */
    int updateByExample(@Param("record") PfmsUsageTwo record, @Param("example") PfmsUsageTwoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pfmsdb_usage2
     *
     * @mbggenerated Thu Apr 23 22:21:56 CST 2015
     */
    int updateByPrimaryKeySelective(PfmsUsageTwo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pfmsdb_usage2
     *
     * @mbggenerated Thu Apr 23 22:21:56 CST 2015
     */
    int updateByPrimaryKey(PfmsUsageTwo record);
}