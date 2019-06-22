package com.faith.o2o.web.shopadmin;

import com.faith.o2o.dto.ShopExecution;
import com.faith.o2o.entity.Area;
import com.faith.o2o.entity.PersonInfo;
import com.faith.o2o.entity.Shop;
import com.faith.o2o.entity.ShopCategory;
import com.faith.o2o.enums.ShopStateEnum;
import com.faith.o2o.service.AreaService;
import com.faith.o2o.service.ShopCategoryService;
import com.faith.o2o.service.ShopService;
import com.faith.o2o.util.HttpServletRequestUtil;
import com.faith.o2o.util.ImageUtil;
import com.faith.o2o.util.PathUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: yangguoqiang01
 * @Date: 2019-06-21
 * @Description: com.faith.o2o.web.shopadmin
 * @version: 1.0
 */
@Controller
@RequestMapping("/shopadmin")
public class ShopManagementController {
    @Autowired
    private ShopService shopService;
    @Autowired
    private ShopCategoryService shopCategoryService;
    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/getshopinitinfo", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> getShopInitInfo() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<ShopCategory> shopCategoryList = new ArrayList<ShopCategory>();
        List<Area> areaList = new ArrayList<Area>();
        try {
            shopCategoryList = shopCategoryService.getShopCategoryList(new ShopCategory());
            areaList = areaService.getAreaList();
            modelMap.put("shopCategoryList", shopCategoryList);
            modelMap.put("areaList", areaList);
            modelMap.put("success", true);
        } catch (Exception e) {
            modelMap.put("success", false);
            modelMap.put("errMsg", e.getMessage());
        }
        return modelMap;
    }

    @RequestMapping(value = "/registershop", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> registerShop(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 1、接收并转化相应的参数，包括店铺信息以及图片信息
        // shopStr这个键是和前端约定好的接口,将其转化为shop实体类
        String shopStr = HttpServletRequestUtil.getString(request, "shopStr");
        // jackson的用法
        ObjectMapper mapper = new ObjectMapper();
        Shop shop = null;

        try {
            shop = mapper.readValue(shopStr, Shop.class);
        } catch (Exception e) {
            modelMap.put("sucess", false);
            modelMap.put("errMsg", e.getMessage());
            return modelMap;
        }

        // 上传的文件流
        CommonsMultipartFile shopImg = null;
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(
               request.getSession().getServletContext()
        );

        if (commonsMultipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            shopImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("shopImg");
        } else {
            modelMap.put("sucess", false);
            modelMap.put("errMsg", "上传图片不能为空");
            return modelMap;
        }
        // 2、注册店铺

        if (shop != null && shopImg != null) {
            PersonInfo owner = new PersonInfo();
            owner.setUserId(1L);
            shop.setOwner(owner);

            // 随机创建一个文件 然后删除
            File shopImgFile = new File(PathUtil.getImgBasePath() + ImageUtil.getRandomFileName());
            try {
                shopImgFile.createNewFile();
            } catch (IOException e) {
                modelMap.put("sucess", false);
                modelMap.put("errMsg", e.getMessage());
                return modelMap;
            }
            try {
                inputStreamToFile(shopImg.getInputStream(), shopImgFile);
            } catch (IOException e) {
                modelMap.put("sucess", false);
                modelMap.put("errMsg", e.getMessage());
                return modelMap;
            }

            // 上面主要是把CommonsMultipartFile 转为 File文件
            ShopExecution se = shopService.addShop(shop, shopImgFile);
            if (se.getState() == ShopStateEnum.CHECK.getState()) {
                modelMap.put("sucess", true);
            } else {
                modelMap.put("sucess", false);
                modelMap.put("errMsg", se.getStateInfo());
            }
            return modelMap;
        } else {
            modelMap.put("sucess", false);
            modelMap.put("errMsg", "请输入店铺信息");
            return modelMap;
        }
        // 3、返回结果 已经在各个结果中了，此处略

    }
    private static void inputStreamToFile(InputStream ins, File file) {
        FileOutputStream os = null;
        try {
            os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[1024];
            // 读满1024字节输出一次
            while ((bytesRead = ins.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
        } catch (Exception e) {
            throw new RuntimeException("调用inputStreamToFile产生异常，原因：" + e.getMessage());
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
                if (ins != null) {
                    ins.close();
                }
            } catch (IOException e) {
                throw new RuntimeException("inputStreamToFile关闭异常，原因：" + e.getMessage());
            }
        }
    }
}
