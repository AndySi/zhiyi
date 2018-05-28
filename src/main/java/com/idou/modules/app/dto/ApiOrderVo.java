package com.idou.modules.app.dto;

import com.idou.modules.app.entity.ApiOrderEntity;

/**
 * 订单VO
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2018-01-02 下午 1:23
 **/

public class ApiOrderVo extends ApiOrderEntity {
    private String nickName;
    private String itemName;
    private String coverUrl;
    private String describe;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
