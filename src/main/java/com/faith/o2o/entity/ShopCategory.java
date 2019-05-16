package com.faith.o2o.entity;

import java.util.Date;

/**
 * @Auther: yangguoqiang01
 * @Date: 2019-05-15
 * @Description: 店铺分类
 * @version: 1.0
 */
public class ShopCategory {
    // 店铺id
    private Long shopCategoryId;
    // 店铺名称
    private String shopCategoryName;
    // 店铺描述
    private String shopCategoryDesc;
    // 店铺图片
    private String shopCategoryImg;
    // 优先级
    private Integer priority;
    // 创建时间
    private Date createTime;
    // 修改时间
    private Date lastEditTime;
    // 父级分类
    private ShopCategory parent;

    public Long getShopCategoryId() {
        return shopCategoryId;
    }

    public void setShopCategoryId(Long shopCategoryId) {
        this.shopCategoryId = shopCategoryId;
    }

    public String getShopCategoryName() {
        return shopCategoryName;
    }

    public void setShopCategoryName(String shopCategoryName) {
        this.shopCategoryName = shopCategoryName;
    }

    public String getShopCategoryDesc() {
        return shopCategoryDesc;
    }

    public void setShopCategoryDesc(String shopCategoryDesc) {
        this.shopCategoryDesc = shopCategoryDesc;
    }

    public String getShopCategoryImg() {
        return shopCategoryImg;
    }

    public void setShopCategoryImg(String shopCategoryImg) {
        this.shopCategoryImg = shopCategoryImg;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    public ShopCategory getParent() {
        return parent;
    }

    public void setParent(ShopCategory parent) {
        this.parent = parent;
    }
}
