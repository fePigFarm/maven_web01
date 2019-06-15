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

    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat(
            "yyyyMMddHHmmss"); // 时间格式化的格式
    private static final Random r = new Random();

    /**
     * 功能描述: 返回随机文件名
     * @param:
     * @return:
     * @auther:
     * @date:
     */
    public static String getRandomFileName() {
        // 生成随机文件名：当前年月日时分秒+五位随机数（为了在实际项目中防止文件同名而进行的处理）
        int rannum = (int) (r.nextDouble() * (99999 - 10000 + 1)) + 10000; // 获取随机数
        String nowTimeStr = sDateFormat.format(new Date()); // 当前时间
        return nowTimeStr + rannum;
    }

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
        String imagePath = "/upload/item/shop" + shopId + "/";
        return imagePath.replace("/", separator);
    }
}
