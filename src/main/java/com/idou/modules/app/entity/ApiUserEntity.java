package com.idou.modules.app.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 微信用户
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-10-23 下午 5:16
 **/
public class ApiUserEntity implements Serializable {
    private static final long serialVersionUID = 8981091591758842550L;
    private Long id;
    private String openId;
    private String nickName;
    private String utel;
    private int gender;
    private String province;
    private String country;
    private String headimgurl;
    private boolean isSubscribe;
    private Date subscribeTime;
    private Date lastLoginTime;
    private String source;
    private int uStatu;
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUtel() {
        return utel;
    }

    public void setUtel(String utel) {
        this.utel = utel;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public boolean isSubscribe() {
        return isSubscribe;
    }

    public void setSubscribe(boolean subscribe) {
        isSubscribe = subscribe;
    }

    public Date getSubscribeTime() {
        return subscribeTime;
    }

    public void setSubscribeTime(Date subscribeTime) {
        this.subscribeTime = subscribeTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getuStatu() {
        return uStatu;
    }

    public void setuStatu(int uStatu) {
        this.uStatu = uStatu;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ApiUserEntity{" +
                "id=" + id +
                ", openId='" + openId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", utel='" + utel + '\'' +
                ", gender=" + gender +
                ", province='" + province + '\'' +
                ", country='" + country + '\'' +
                ", headimgurl='" + headimgurl + '\'' +
                ", isSubscribe=" + isSubscribe +
                ", subscribeTime=" + subscribeTime +
                ", lastLoginTime=" + lastLoginTime +
                ", source='" + source + '\'' +
                ", uStatu=" + uStatu +
                ", createTime=" + createTime +
                '}';
    }
}
