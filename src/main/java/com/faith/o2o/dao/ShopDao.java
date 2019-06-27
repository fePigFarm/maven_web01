package com.faith.o2o.dao;

import com.faith.o2o.entity.Shop;

/**
 * @Auther: yangguoqiang01
 * @Date: 2019-06-12
 * @Description: 店铺DAO
 * @version: 1.0
 */
public interface ShopDao {
    /**
     * 根据id获取店铺信息
     * @param shopId
     * @return
     */
    Shop queryByShopId(long shopId);

    /**
     * 新增店铺
     * @param shop
     * @return 1或者-1
     */
    int insertShop(Shop shop);

    /**
     * 更新店铺信息
     * @param shop
     * @return 1、-1
     */
    int updateShop(Shop shop);
}
