package com.idou.modules.app.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 活动 - 商品
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-11-23 下午 3:33
 **/

public class ApiActivityItemEntity implements Serializable {
    private static final long serialVersionUID = 7464997704025731456L;
    //
    private Long id;
    //
    private Long activityId;
    private String activityName;
    //
    private Long itemId;
    private String itemName;

    private Date createTime;

    // 额外字段
    private List<Long> itemIdList;

    public List<Long> getItemIdList() {
        return itemIdList;
    }

    public void setItemIdList(List<Long> itemIdList) {
        this.itemIdList = itemIdList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
