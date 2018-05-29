package com.idou.modules.api.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 随机数
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2018-01-04 下午 4:29
 **/
@Component
@ConfigurationProperties(prefix = "my.random")
public class RandomEntity {
    private String value;
    private int number;
    private Long bignumber;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Long getBignumber() {
        return bignumber;
    }

    public void setBignumber(Long bignumber) {
        this.bignumber = bignumber;
    }
}
