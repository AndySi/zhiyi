package com.idou.modules.app.utils;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.Base64;

/**
 * 加密工具类
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-07-10 下午 2:14
 **/

public class EncryptUtils {
    /**
     * 获取base64位编码的MD5值
     *
     * @param str
     * @return
     */
    public static String EncoderByMd5(String str) {
        String md5Str = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] md5 = md.digest(str.getBytes("UTF-8"));
            BASE64Encoder base64en = new BASE64Encoder();
            md5Str = base64en.encode(md5);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return md5Str;
    }

    /**
     * base64加密
     *
     * @param value
     * @return
     */
    public static String Base64E(String value) {
        String base64Str = "";
        try {
            base64Str = Base64.getEncoder().encodeToString(value.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return base64Str;
    }

    /**
     * Base64解码
     *
     * @param value
     * @return
     */
    public static String Base64D(String value) {
        String str = "";
        try {
            byte[] asBytes = Base64.getDecoder().decode(value);
            str = new String(asBytes, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }
}
