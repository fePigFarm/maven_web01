package com.faith.o2o.web.shopadmin;

import com.faith.o2o.entity.Shop;
import com.faith.o2o.util.HttpServletRequestUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
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

    @RequestMapping(value = "registershop", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> registerShop(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 1、接收并转化相应的参数，包括店铺信息以及图片信息
        // shopStr这个键是和前端约定好的接口,将其转化为shop实体类
        String shopStr = HttpServletRequestUtil.getString(request, "shopStr");
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
            shopImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("shopImg")
        } else {
            modelMap.put("sucess", false);
            modelMap.put("errMsg", "上传图片不能为空");
            return modelMap;
        }
        // 2、注册店铺

        if (shop != null && shopImg != null) {

        } else {
            modelMap.put("sucess", false);
            modelMap.put("errMsg", "请输入店铺信息");
            return modelMap;
        }
        // 3、返回结果
    }
}
