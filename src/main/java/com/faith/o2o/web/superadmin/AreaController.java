package com.faith.o2o.web.superadmin;

import com.faith.o2o.entity.Area;
import com.faith.o2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: yangguoqiang01
 * @Date: 2019-06-12
 * @Description: com.faith.o2o.web.superadmin
 * @version: 1.0
 */

@Controller
@RequestMapping("/superadmin")
public class AreaController {

    @Autowired
    private AreaService areaService;  // 创建Service实体类

    @RequestMapping(value = "/listareas", method = RequestMethod.GET)
    @ResponseBody  // 返回json
    private Map<String, Object> listArea() {
        // 存储返回值
        Map<String, Object> modelMap = new HashMap<String, Object>();

        // 获取Service层返回的区域列表
        List<Area> list = new ArrayList<Area>();

        try {
            list = areaService.getAreaList();
            modelMap.put("rows", list);
            modelMap.put("total", list.size());
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errMsg", e.toString());
        }
        return modelMap;
    }
}
