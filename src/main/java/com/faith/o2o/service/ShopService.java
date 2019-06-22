package com.faith.o2o.service;

import com.faith.o2o.dto.ShopExecution;
import com.faith.o2o.entity.Shop;
import com.faith.o2o.exceptions.ShopOperationException;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.InputStream;

/**
 * @Auther: yangguoqiang01
 * @Date: 2019-06-17
 * @Description: com.faith.o2o.service
 * @version: 1.0
 */
public interface ShopService {
    ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationException;
}
