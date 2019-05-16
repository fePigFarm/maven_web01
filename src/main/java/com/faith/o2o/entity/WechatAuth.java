package com.faith.o2o.entity;

import java.util.Date;

/**
 * @Auther: yangguoqiang01
 * @Date: 2019-05-15
 * @Description: 微信账号实体类
 * @version: 1.0
 */
public class WechatAuth {
    // 微信账号id
    private Long wechatAuthId;
    // 微信openId
    private String openId;
    // 创建时间
    private Date createTime;
    // 用户信息
    private PersonInfo personInfo;

    public long getWechatAuthId() {
        return wechatAuthId;
    }

    public void setWechatAuthId(long wechatAuthId) {
        this.wechatAuthId = wechatAuthId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }
}
