package com.idou.modules.api.config;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Properties;

/**
 * 自定义配置信息读取
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2018-01-04 下午 4:05
 **/
@Component
public class Weixin4jConfig {
    private static Properties props;

    public Weixin4jConfig() {
        Resource resource = new ClassPathResource("/weixin4j.properties");
        try {
            props = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取属性
     *
     * @param key
     * @return
     */
    public static String getProperty(String key) {
        return props == null ? null : props.getProperty(key);
    }

    /**
     * 获取属性
     *
     * @param key          属性key
     * @param defaultValue 属性value
     * @return
     */
    public static String getProperty(String key, String defaultValue) {
        return props == null ? null : props.getProperty(key, defaultValue);
    }

    /**
     * 获取properyies属性
     *
     * @return
     */
    public static Properties getProperties() {
        return props;
    }
}
