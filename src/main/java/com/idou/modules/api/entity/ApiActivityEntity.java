package com.idou.modules.api.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 活动
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-11-23 下午 3:30
 **/

public class ApiActivityEntity implements Serializable {
    private static final long serialVersionUID = -7225778315850784673L;

    private Long id;
    //活动名称
    private String name;

    private Date startTime;

    private Date createTime;

    private Date sendTime;
    //活动结束时间
    private Date endTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "ApiActivityEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startTime=" + startTime +
                ", createTime=" + createTime +
                ", sendTime=" + sendTime +
                ", endTime=" + endTime +
                '}';
    }
}
