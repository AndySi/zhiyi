package com.idou.common.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2018-01-02 下午 2:11
 **/

public enum OrderStateEnum {
    UNPAID(0, "未支付"),
    PAIDNOSEND(1, "已支付未发货"),
    PAIDSEND(2, "已支付已发货"),
    SIGNEDIN(3, "已签收"),
    DENY(3, "拒签");

    private int state;
    private String stateInfo;

    OrderStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
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

    public static List<String> getList(){
        List<String> list = new ArrayList<>();
        for (OrderStateEnum state : values()) {
            list.add(state.getStateInfo());
        }
        return list;
    }
}
