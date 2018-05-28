package com.idou.modules.app.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 盐值
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-10-25 下午 1:46
 **/
@Component
@ConfigurationProperties(prefix = "flat")
public class SaltEntity {
    private String figure;

    public String getFigure() {
        return figure;
    }

    public void setFigure(String figure) {
        this.figure = figure;
    }
}
