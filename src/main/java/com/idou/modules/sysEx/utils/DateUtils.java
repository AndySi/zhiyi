package com.idou.modules.sysEx.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2018-05-31 上午 9:54
 **/

public class DateUtils {
    public static String getYmd(){
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
        return sf.format(new Date());
    }
}
