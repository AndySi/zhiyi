package com.idou.modules.app.config;

import com.alibaba.fastjson.JSONObject;
import com.foxinmy.weixin4j.model.WeixinPayAccount;
import com.foxinmy.weixin4j.payment.WeixinPayProxy;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2018-01-03 下午 4:30
 **/
@Configuration
@ConfigurationProperties(prefix = "weixin4j")
@PropertySource("classpath:/weixin4j.properties")
public class WeixinPayProxyConfig {
    private String account;

    @Bean
    public WeixinPayProxy weixinPayProxy() {
        JSONObject obj = JSONObject.parseObject(account);
        WeixinPayAccount weixinPayAccount = new WeixinPayAccount(obj.getString("id"), obj.getString("paySignKey"), obj.getString("mchId"));
        return new WeixinPayProxy(weixinPayAccount);
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
