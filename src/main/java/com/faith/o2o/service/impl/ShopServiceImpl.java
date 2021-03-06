package com.faith.o2o.service.impl;

import com.faith.o2o.dao.ShopDao;
import com.faith.o2o.dto.ShopExecution;
import com.faith.o2o.entity.Shop;
import com.faith.o2o.enums.ShopStateEnum;
import com.faith.o2o.exceptions.ShopOperationException;
import com.faith.o2o.service.ShopService;
import com.faith.o2o.util.ImageUtil;
import com.faith.o2o.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.InputStream;
import java.util.Date;

/**
 * @Auther: yangguoqiang01
 * @Date: 2019-06-17
 * @Description: com.faith.o2o.service.impl
 * @version: 1.0
 */
@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;

    @Transactional
    public ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) {
        // 空值判断
        if (shop == null) {
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }
        try {
            // 给店铺信息赋值一些初始值 外面不能改变的
            shop.setEnableStatus(0);
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());
            // 数据库插入店铺信息 返回数字
            int effectedNum = shopDao.insertShop(shop);
            if (effectedNum <= 0) {
                // 返回runtimeExcepiton或者子类 ShopOperationException 会致使事物回滚 Error不会回滚
                throw new ShopOperationException("店铺创建失败");
            } else {
                // 如果有图片那么插入图片
                if (shopImgInputStream != null) {
                    try {
                        addShopImg(shop, shopImgInputStream, fileName);
                    } catch (Exception e) {
                        throw new ShopOperationException("addShop error:" + e.getMessage());
                    }
                }

                // 更新店铺的图片地址  因为经过此时的修改 shop实体里面有了图片信息
                effectedNum = shopDao.updateShop(shop);
                if (effectedNum <= 0) {
                    throw new ShopOperationException("更新图片地址失败");
                }
            }
        } catch (Exception e) {
            throw new ShopOperationException("addShop error:" + e.getMessage());
        }
        // 最后事物结束返回下一步的标志位待审核和最近的shop实体
        return new ShopExecution(ShopStateEnum.CHECK, shop);
    }

    /**
     * 实现获取接口
     * @param shopId
     * @return
     */
    @Override
    public Shop getByShopId(long shopId) {
        return shopDao.queryByShopId(shopId);
    }


    /**
     * 实现修改接口
     * @param shop
     * @param shopImgInputStream
     * @param fileName
     * @return
     * @throws ShopOperationException
     */
    @Override
    public ShopExecution modifyShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationException {

        if (shop == null || shop.getShopId() == null) {
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        } else {
            // 1、判断是否要处理图片
            try {
                if(shopImgInputStream != null && fileName != null && !"".equals(fileName)) {
                    // 把这个shopId的shop关联的图片删除
                    Shop tempShop = shopDao.queryByShopId(shop.getShopId());
                    if(tempShop.getShopImg() != null) {
                        ImageUtil.deleteFileOrPath(tempShop.getShopImg());
                    }
                    // 生成新的图片
                    addShopImg(shop, shopImgInputStream, fileName);
                }
                // 2、更新店铺信息
                shop.setLastEditTime(new Date());
                int effectedNum = shopDao.updateShop(shop);
                if(effectedNum <= 0) {
                    return new ShopExecution(ShopStateEnum.INNER_ERROR);
                } else {
                    shop = shopDao.queryByShopId(shop.getShopId());
                    return new ShopExecution(ShopStateEnum.SUCCESS, shop);
                }
            } catch (Exception e) {
                throw new ShopOperationException("修改店铺信息出错：" + e.getMessage());
            }
        }
    }

    // 给shop添加图片的方法
    private void addShopImg(Shop shop, InputStream shopImgInputStream, String fileName) {
        // 获取shop图片目录的相对值路径
        String dest = PathUtil.getShopImagePath(shop.getShopId());
        String shopImgAddr = ImageUtil.generateThumbnail(shopImgInputStream, fileName, dest);
        // 设置图片
        shop.setShopImg(shopImgAddr);
    }


}
