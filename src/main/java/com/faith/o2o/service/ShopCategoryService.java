package com.faith.o2o.service;

import com.faith.o2o.entity.ShopCategory;

import java.util.List;

/**
 * @Auther: yangguoqiang01
 * @Date: 2019-06-22
 * @Description: com.faith.o2o.service
 * @version: 1.0
 */
public interface ShopCategoryService {
    List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition);
}
