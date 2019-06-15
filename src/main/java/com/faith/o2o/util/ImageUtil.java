package com.faith.o2o.util;

import ch.qos.logback.core.util.FileUtil;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Position;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Auther: yangguoqiang01
 * @Date: 2019-06-15
 * @Description: 图片处理工具
 * @version: 1.0
 */
public class ImageUtil {
    // 获取资源路径根路径
    String basePath = Thread.currentThread()
            .getContextClassLoader().getResource("").getPath();


    // CommonsMultipartFile thumbnail 传入的文件流
    // 获取缩略图方法类
    public static String generateThumbnail(CommonsMultipartFile thumbnail, String targetAddr) {
        String realFileName = PathUtil.getRandomFileName();
        String extension = getFileExtension(thumbnail);
        makeDirPath(targetAddr);
        String relativeAddr = targetAddr + realFileName + extension;
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
        try {
            Thumbnails.of(thumbnail.getInputStream()).size(200, 200).outputQuality(0.25f).toFile(dest);
        } catch (IOException e) {
            throw new RuntimeException("创建缩略图失败：" + e.toString());
        }
        return relativeAddr;
    }

    // 获取文件夹的全路径
    private static void makeDirPath(String targetAddr) {
        String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
        File dirPath = new File(realFileParentPath);
        if (!dirPath.exists()) {
            // 递归创建
            dirPath.mkdirs();
        }
    }

    // 获取拓展名
    private static String getFileExtension(CommonsMultipartFile cFile) {
        String originalFileName = cFile.getOriginalFilename();
        return originalFileName.substring(originalFileName.lastIndexOf("."));
    }

    public static void main(String[] args) throws IOException {

//        Thumbnails.of(new File("/java/images/javalearn.jpg"))
//                .size(1200, 700).watermark(Positions.BOTTOM_RIGHT,
//                ImageIO.read(new File(basePath + "/waterprint.jpg")), 0.2f).outputQuality(0.8f)
//                .toFile("/java/images/javalearn-01.jpg");
    }
}
