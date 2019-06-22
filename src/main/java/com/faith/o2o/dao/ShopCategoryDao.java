package com.faith.o2o.dao;

import com.faith.o2o.entity.ShopCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: yangguoqiang01
 * @Date: 2019-06-22
 * @Description: 店铺类别的Dao层
 * @version: 1.0
 */
public interface ShopCategoryDao {
    List<ShopCategory> queryShopCategory(@Param("shopCategoryCondition")
                                                 ShopCategory shopCategoryCondition);
}
