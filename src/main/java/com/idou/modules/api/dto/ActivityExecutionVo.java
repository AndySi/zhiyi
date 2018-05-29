package com.idou.modules.api.dto;

import com.idou.common.enums.TodayRobStatuEnum;
import com.idou.modules.api.entity.ApiItemEntity;

/**
 * 活动抢购执行后的结果
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2018-01-03 下午 3:24
 **/

public class ActivityExecutionVo {
    private long itemId;
    //秒杀执行结果状态
    private int state;
    //状态标识
    private String stateInfo;
    //秒杀成功对象
    private ApiItemEntity apiItemEntity;

    public ActivityExecutionVo(long itemId, TodayRobStatuEnum statuEnum, ApiItemEntity apiItemEntity) {
        this.itemId = itemId;
        this.state = statuEnum.getState();
        this.stateInfo = statuEnum.getStateInfo();
        this.apiItemEntity = apiItemEntity;
    }

    public ActivityExecutionVo(long itemId, TodayRobStatuEnum statuEnum){
        this.itemId = itemId;
        this.state = statuEnum.getState();
        this.stateInfo = statuEnum.getStateInfo();
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public ApiItemEntity getApiItemEntity() {
        return apiItemEntity;
    }

    public void setApiItemEntity(ApiItemEntity apiItemEntity) {
        this.apiItemEntity = apiItemEntity;
    }
}
