package com.faith.o2o.entity;

import java.util.Date;

/**
 * @Auther: yangguoqiang01
 * @Date: 2019-05-15
 * @Description: com.faith.o2o.entity 区域类
 * @version: 1.0
 */
public class Area {
    // 区域id
    private Integer areaId;
    // 区域名称
    private String areaName;
    // 区域排序
    private Integer priority;
    // 创建时间
    private Date createTime;
    // 修改时间
    private Date lastEditTime;

    // 构造函数
    public Area() {
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }
}
