package com.faith.o2o.dao;

import com.faith.o2o.BaseTest;
import com.faith.o2o.entity.Area;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Auther: yangguoqiang01
 * @Date: 2019-06-11
 * @Description: com.faith.o2o.dao
 * @version: 1.0
 */
public class AreaDaoTest extends BaseTest {
    @Autowired
    private AreaDao areaDao;

    @Test
    public void testQueryArea() {
        List<Area> areaList = areaDao.queryArea();
        Assert.assertEquals(3, areaList.size());
    }
}
