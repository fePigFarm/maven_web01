package com.faith.o2o.dao;

import com.faith.o2o.entity.Area;

import java.util.List;

/**
 * @Auther: yangguoqiang01
 * @Date: 2019-06-03
 * @Description: 地区接口
 * @version: 1.0
 */
public interface AreaDao {

    /**
     * 列出区域列表
     * @return
     */
    List<Area> queryArea();
}
