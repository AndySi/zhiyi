package com.idou.common.enums;

/**
 * 使用枚举表述常量数据字段
 * Created by ZhangSi on 2016/10/18.
 */
public enum TodayRobStatuEnum {
    SUCCESS(1, "抢购成功"),
    END(0, "抢购结束"),
    REPEAT_KILL(-1, "重复下单"),
    INNER_ERROR(-2, "系统异常"),
    DATA_REWRITE(-3, "数据篡改");

    private int state;
    private String stateInfo;

    TodayRobStatuEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static TodayRobStatuEnum stateOf(int index) {
        for (TodayRobStatuEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TodayRobStatuEnum seckillStatuEnum = TodayRobStatuEnum.stateOf(1);
        System.out.println(seckillStatuEnum.getStateInfo());
    }
}
