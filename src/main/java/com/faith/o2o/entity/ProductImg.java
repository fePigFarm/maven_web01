package com.faith.o2o.entity;

import java.util.Date;

/**
 * @Auther: yangguoqiang01
 * @Date: 2019-05-15
 * @Description: com.faith.o2o.entity
 * @version: 1.0
 */
public class ProductImg {
    // 图片id
    private Long productImgId;
    // 图片地址
    private String imgAddr;
    // 图片说明
    private String imgDescc;
    // 优先级
    private Integer priority;
    // 创建时间
    private Date createTime;
    // 关联的商品id
    private Long productId;

    public Long getProductImgId() {
        return productImgId;
    }

    public void setProductImgId(Long productImgId) {
        this.productImgId = productImgId;
    }

    public String getImgAddr() {
        return imgAddr;
    }

    public void setImgAddr(String imgAddr) {
        this.imgAddr = imgAddr;
    }

    public String getImgDescc() {
        return imgDescc;
    }

    public void setImgDescc(String imgDescc) {
        this.imgDescc = imgDescc;
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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
