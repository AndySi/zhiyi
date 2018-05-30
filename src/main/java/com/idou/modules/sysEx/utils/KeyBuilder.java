package com.idou.modules.sysEx.utils;

import java.util.Random;
import java.util.UUID;

/**
 * @author:ZhangSi
 * @email:andy_si@163.com
 * @date:2018/5/30
 */
public class KeyBuilder {
    private static long uniqueID = System.currentTimeMillis();

    public static String generate() {
        uniqueID++;
        return String.valueOf(uniqueID * 1000L
                + (long) (new Random()).nextInt(999));
    }

    /**
     * 获得UUID
     *
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
