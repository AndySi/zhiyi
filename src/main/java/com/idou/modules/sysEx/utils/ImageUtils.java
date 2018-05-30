package com.idou.modules.sysEx.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * img工具类
 *
 * @author:ZhangSi
 * @email:andy_si@163.com
 * @date:2018/5/30
 */
@ConfigurationProperties(prefix = "img")
@Component
public class ImageUtils {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
