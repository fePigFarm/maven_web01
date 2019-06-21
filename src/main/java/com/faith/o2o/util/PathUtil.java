package com.faith.o2o.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Auther: yangguoqiang01
 * @Date: 2019-06-16
 * @Description: 关于路径的工具类
 * @version: 1.0
 */
public class PathUtil {

    private static String separator = System.getProperty("file.separator");

    /**
     * 功能描述: 返回项目图片的根路径
     * @param:
     * @return:
     * @auther:
     * @date:
     */
    public static String getImgBasePath() {
        String os = System.getProperty("os.name");
        String basePath;

        if(os.toLowerCase().startsWith("win")) {
            basePath = "D:/yang/images/";
        } else {
            basePath = "/java/images/";
        }
        basePath = basePath.replace("/", separator);
        return basePath;
    }

    /**
     * 功能描述: 返回项目图片的子路径
     * @param:
     * @return:
     * @auther:
     * @date:
     */
    public static String getShopImagePath(long shopId) {
        String imagePath = "upload/item/shop/" + shopId + "/";
        return imagePath.replace("/", separator);
    }
}
