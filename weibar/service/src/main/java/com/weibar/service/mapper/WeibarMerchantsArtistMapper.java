package com.weibar.service.mapper;

import com.weibar.pojo.db.WeibarMerchantsArtist;
import com.weibar.pojo.db.WeibarMerchantsArtistCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeibarMerchantsArtistMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_artist
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int countByExample(WeibarMerchantsArtistCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_artist
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int deleteByExample(WeibarMerchantsArtistCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_artist
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_artist
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int insert(WeibarMerchantsArtist record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_artist
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int insertSelective(WeibarMerchantsArtist record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_artist
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    List<WeibarMerchantsArtist> selectByExample(WeibarMerchantsArtistCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_artist
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    WeibarMerchantsArtist selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_artist
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int updateByExampleSelective(@Param("record") WeibarMerchantsArtist record, @Param("example") WeibarMerchantsArtistCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_artist
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int updateByExample(@Param("record") WeibarMerchantsArtist record, @Param("example") WeibarMerchantsArtistCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_artist
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int updateByPrimaryKeySelective(WeibarMerchantsArtist record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weibar_merchants_artist
     *
     * @mbggenerated Tue Apr 17 15:03:14 CST 2018
     */
    int updateByPrimaryKey(WeibarMerchantsArtist record);
}