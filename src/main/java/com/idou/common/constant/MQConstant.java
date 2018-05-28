package com.idou.common.constant;

/**
 * Rabbit消息队列相关常量
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2018-01-09 下午 7:34
 **/

public final class MQConstant {
    private MQConstant() {
    }

    //交换机名称
    public static final String DEFAULT_EXCHANGE = "IDOULOAN";

    //消息队列名称
    public static final String ORDER_QUEUE_NAME = "ORDER";
}
