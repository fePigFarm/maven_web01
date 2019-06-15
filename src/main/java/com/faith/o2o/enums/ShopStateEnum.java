package com.faith.o2o.enums;

/**
 * @Auther: yangguoqiang01
 * @Date: 2019-06-16
 * @Description: 店铺枚举  只能通过内部使用构造函数创建 外部访问
 * @version: 1.0
 */
public enum ShopStateEnum {
    // 状态枚举
    CHECK(0, "审核中"),
    OFFLINE(-1, "非法商铺"),
    SUCCESS(1, "操作成功"),
    PASS(2, "通过认证"),
    INNER_ERROR(-1001, "操作失败"),
    NULL_SHOPID(-1002, "ShopId为空"),
    NULL_SHOP_INFO(-1003, "传入了空的信息");

    // 私用状态
    private int state;

    // 状态描述
    private String stateInfo;

    // 构造函数
    private ShopStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    // 依据传入的状态码返回对应的值 TODO:
    public static ShopStateEnum stateOf(int state) {
        for(ShopStateEnum stateEnum : values()) {
            if(stateEnum.getState() == state) {
                return stateEnum;
            }
        }
        return null;
    }
}
