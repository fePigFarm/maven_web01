package com.faith.o2o.service.impl;

import com.faith.o2o.dao.AreaDao;
import com.faith.o2o.entity.Area;
import com.faith.o2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: yangguoqiang01
 * @Date: 2019-06-11
 * @Description: com.faith.o2o.service.impl
 * @version: 1.0
 */

// IOC注入
@Service
public class AreaServiceImpl implements AreaService {
    // Service层依赖Dao层
    // 自动注入到Dao
    @Autowired
    private AreaDao areaDao;

    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }
}
