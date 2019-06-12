package com.faith.o2o.dao;

import com.faith.o2o.BaseTest;
import com.faith.o2o.entity.Area;
import com.faith.o2o.entity.PersonInfo;
import com.faith.o2o.entity.Shop;
import com.faith.o2o.entity.ShopCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @Auther: yangguoqiang01
 * @Date: 2019-06-13
 * @Description: com.faith.o2o.dao
 * @version: 1.0
 */


public class ShopDaoTest extends BaseTest {
    @Autowired
    private ShopDao shopDao;

    @Test
    public void testInsertShop() {
        Shop shop = new Shop();
        Area area = new Area();
        PersonInfo owner = new PersonInfo();
        ShopCategory shopCategory = new ShopCategory();

        owner.setUserId(1L);
        area.setAreaId(2);
        shopCategory.setShopCategoryId(1L);

        shop.setArea(area);
        shop.setOwner(owner);
        shop.setShopCategory(shopCategory);

        shop.setShopName("测试的店铺名称");
        shop.setShopDesc("测试test");
        shop.setShopAddr("测试地址");
        shop.setPhone("123456543");
        shop.setShopImg("test");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(1);
        shop.setAdvice("审核中");

        int effectedNum = shopDao.insertShop(shop);
        Assert.assertEquals(1, effectedNum);
    }
}
