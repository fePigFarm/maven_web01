package com.faith.o2o.exceptions;

/**
 * @Auther: yangguoqiang01
 * @Date: 2019-06-21
 * @Description: 店铺的异常类（运行异常）
 * @version: 1.0
 */
public class ShopOperationException extends RuntimeException {
    // 自动生成的serialVersionUID  随机序列化id
    private static final long serialVersionUID = -5920872895737732177L;

    public ShopOperationException(String msg) {
        // super代表父类，向上传递
        super(msg);
    }
}
