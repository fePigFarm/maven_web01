package com.faith.o2o.dao;

import com.faith.o2o.entity.Shop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: yangguoqiang01
 * @Date: 2019-06-12
 * @Description: 店铺DAO
 * @version: 1.0
 */
public interface ShopDao {
    /**
     * 功能描述: 分页查询店铺 条件：店铺名（模糊） 店铺状态 店铺类别，区域Id， owner
     * @param:
     *      shopCondition 查询条件
     *      rowIndex 起始页码
     *      pageSize 每页条数
     * @return:
     * @auther:
     * @date:
     */
    List<Shop> queryShopList(@Param("shopCondition") Shop shopCondition, @Param("rowIndex") int rowIndex,
                             @Param("pageSize") int PageSize);

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
