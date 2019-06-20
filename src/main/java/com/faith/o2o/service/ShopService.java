package com.faith.o2o.service;

import com.faith.o2o.dto.ShopExecution;
import com.faith.o2o.entity.Shop;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;

/**
 * @Auther: yangguoqiang01
 * @Date: 2019-06-17
 * @Description: com.faith.o2o.service
 * @version: 1.0
 */
public interface ShopService {
    ShopExecution addShop(Shop shop, CommonsMultipartFile shopImg);
}
