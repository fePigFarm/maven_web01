package com.faith.o2o.service.impl;

import com.faith.o2o.dao.ShopCategoryDao;
import com.faith.o2o.entity.ShopCategory;
import com.faith.o2o.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: yangguoqiang01
 * @Date: 2019-06-22
 * @Description: com.faith.o2o.service.impl
 * @version: 1.0
 */
@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {
    @Autowired
    private ShopCategoryDao shopCategoryDao;
    public List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition) {
        return shopCategoryDao.queryShopCategory(shopCategoryCondition);
    };

}
