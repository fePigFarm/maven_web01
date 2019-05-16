package com.faith.o2o.entity;

import java.util.Date;

/**
 * @Auther: yangguoqiang01
 * @Date: 2019-05-15
 * @Description: 商品类别
 * @version: 1.0
 */
public class ProductCategory {
    // 商品类别id
    private Long productCategoryId;
    // 关联店铺id
    private Long shopId;
    // 商品类别名称
    private String productCategoryName;
    // 优先级
    private Integer priority;
    // 创建时间
    private Date createTime;

    public Long getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
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
}
