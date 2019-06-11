package com.faith.o2o.Service;

import com.faith.o2o.BaseTest;
import com.faith.o2o.entity.Area;
import com.faith.o2o.service.AreaService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Auther: yangguoqiang01
 * @Date: 2019-06-11
 * @Description: 测试AreaService的类
 * @version: 1.0
 */
public class AreaServiceTest extends BaseTest {
    // AutoWired 当用到了对象变量时候就注入实现类
    @Autowired
    private AreaService areaService;
    @Test
    public void testGetAreaList() {
        List<Area> areaList = areaService.getAreaList();
        Assert.assertEquals("上地", areaList.get(0).getAreaName());
    }

}
