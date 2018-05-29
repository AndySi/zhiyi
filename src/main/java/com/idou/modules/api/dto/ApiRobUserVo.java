package com.idou.modules.api.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-12-02 上午 9:59
 **/

public class ApiRobUserVo implements Serializable {
    private static final long serialVersionUID = 8534747923801736637L;
    private String headimgurl;
    private Date createTime;
    private Integer orderNum;

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }
}
