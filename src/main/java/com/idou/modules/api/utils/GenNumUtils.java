package com.idou.modules.api.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 号码生成器
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-11-02 下午 2:59
 **/

public class GenNumUtils {
    public static String getOrderIdByUUId() {
        int machineId = 1;//最大支持1-9个集群机器部署
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {//有可能是负数
            hashCodeV = -hashCodeV;
        }
        // 0 代表前面补充0
        // 4 代表长度为4
        // d 代表参数为正数型
        return machineId + String.format("%015d", hashCodeV);
    }

    /**
     * 订单号生成：年月日+用户ID+当前时间戳
     *
     * @return
     */
    public static String getOrderIdByMs(Long userId) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
        String date = sf.format(new Date());
        return date + userId+ System.currentTimeMillis();
    }
}
