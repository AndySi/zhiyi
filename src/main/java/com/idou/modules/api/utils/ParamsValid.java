package com.idou.modules.api.utils;

import com.idou.common.exception.RRException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 请求基本参数验证
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-11-06 上午 11:21
 **/

public class ParamsValid {
    /**
     * 验证是否为Long类型
     *
     * @param str
     * @return
     */
    public static Long validLong(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            throw new RRException("参数类型错误");
        }
    }

    /**
     * 验证是否为int类型
     *
     * @param str
     * @return
     */
    public static int validInt(String str) {
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            throw new RRException("参数类型错误");
        }
        return Integer.parseInt(str);
    }

    /**
     * 手机号码验证
     *
     * @param str
     * @return
     */
    public static boolean validTel(String str) {
        String pattern = "0?(13|14|15|18)[0-9]{9}";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        if (!m.matches()) {
            throw new RRException("手机号码格式错误");
        }
        return true;
    }
}
