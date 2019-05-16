package com.faith.o2o.entity;

import java.util.Date;

/**
 * @Auther: yangguoqiang01
 * @Date: 2019-05-15
 * @Description: 本地账号实体类
 * @version: 1.0
 */
public class LocalAuth {
    // 本地账号id
    private Long localAuthId;
    // 用户名
    private String username;
    // 密码
    private String password;
    // 创建时间
    private Date createTime;
    // 修改时间
    private Date lastEditTime;
    // 用户信息
    private PersonInfo personInfo;

    public long getLocalAuthId() {
        return localAuthId;
    }

    public void setLocalAuthId(long localAuthId) {
        this.localAuthId = localAuthId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public PersonInfo getPersonInfo() {
        return personInfo;
    }

    public void setPersonInfo(PersonInfo personInfo) {
        this.personInfo = personInfo;
    }
}
