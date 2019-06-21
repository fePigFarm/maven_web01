package com.faith.o2o.Service;

import com.faith.o2o.BaseTest;
import com.faith.o2o.dto.ShopExecution;
import com.faith.o2o.entity.Area;
import com.faith.o2o.entity.PersonInfo;
import com.faith.o2o.entity.Shop;
import com.faith.o2o.entity.ShopCategory;
import com.faith.o2o.enums.ShopStateEnum;
import com.faith.o2o.service.ShopService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.Date;

/**
 * @Auther: yangguoqiang01
 * @Date: 2019-06-21
 * @Description: com.faith.o2o.Service
 * @version: 1.0
 */
public class ShopServiceTest extends BaseTest {
    @Autowired
    private ShopService shopService;

    @Test
    public void testAddShop() {
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

        shop.setShopName("测试的店铺名称22");
        shop.setShopDesc("测试test22");
        shop.setShopAddr("测试地址22");
        shop.setPhone("2222");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setAdvice("审核中");

        File shopImg = new File("/java/images/shopImg-01.jpeg");
        ShopExecution se = shopService.addShop(shop, shopImg);
        Assert.assertEquals(se.getState(), ShopStateEnum.CHECK.getState());
    }
}
