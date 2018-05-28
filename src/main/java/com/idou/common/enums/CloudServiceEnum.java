package com.idou.common.enums;

/**
 * 云服务商
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-11-29 下午 3:26
 **/

public enum CloudServiceEnum {
    /**
     * 七牛云
     */
    QINIU(1),
    /**
     * 阿里云
     */
    ALIYUN(2),
    /**
     * 腾讯云
     */
    QCLOUD(3);

    private int value;

    private CloudServiceEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
