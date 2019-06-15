package com.faith.o2o.dto;

import com.faith.o2o.entity.Shop;
import com.faith.o2o.enums.ShopStateEnum;

import java.util.List;

/**
 * @Auther: yangguoqiang01
 * @Date: 2019-06-16
 * @Description: 存储状态
 * @version: 1.0
 */
public class ShopExecution {

    // 结果状态
    private int state;

    // 状态标识 解释state
    private String stateInfo;

    // 店铺数量
    private int count;

    // 操作的店铺 增删店铺的时候用
    private Shop shop;

    // 店铺列表 查询店铺的时候使用
    private List<Shop> shopList;

    public ShopExecution() {
    }

    // 店铺操作失败的时候 使用的构造器
    public ShopExecution(ShopStateEnum stateEnum) {
        // 获取状态码
        this.state = stateEnum.getState();
        // 获取状态描述
        this.stateInfo = stateEnum.getStateInfo();
    }

    // 店铺操作成功返回单个对象
    public ShopExecution(ShopStateEnum stateEnum, Shop shop) {
        // 获取状态码
        this.state = stateEnum.getState();
        // 获取状态描述
        this.stateInfo = stateEnum.getStateInfo();
        // 目标
        this.shop = shop;
    }

    // 店铺操作成功返回对象列表
    public ShopExecution(ShopStateEnum stateEnum, List<Shop> shopList) {
        // 获取状态码
        this.state = stateEnum.getState();
        // 获取状态描述
        this.stateInfo = stateEnum.getStateInfo();
        // 目标组的list
        this.shopList = shopList;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<Shop> getShopList() {
        return shopList;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }
}
