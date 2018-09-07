package com.rechenggit.core.dal.mapper;

import com.rechenggit.core.dal.dataobject.Store;

public interface StoreMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tm_store
     *
     * @mbggenerated Fri Sep 07 14:27:06 CST 2018
     */
    int deleteByPrimaryKey(String storeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tm_store
     *
     * @mbggenerated Fri Sep 07 14:27:06 CST 2018
     */
    int insert(Store record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tm_store
     *
     * @mbggenerated Fri Sep 07 14:27:06 CST 2018
     */
    int insertSelective(Store record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tm_store
     *
     * @mbggenerated Fri Sep 07 14:27:06 CST 2018
     */
    Store selectByPrimaryKey(String storeId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tm_store
     *
     * @mbggenerated Fri Sep 07 14:27:06 CST 2018
     */
    int updateByPrimaryKeySelective(Store record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tm_store
     *
     * @mbggenerated Fri Sep 07 14:27:06 CST 2018
     */
    int updateByPrimaryKey(Store record);
}