package com.idou.modules.sys.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * MVC配置
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-07-05 下午 2:39
 **/
@Configuration
public class SysMvcConfig extends WebMvcConfigurerAdapter {
    /**
     * 设置spring-boot的默认首页
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index.html").setViewName("/index");
        registry.addViewController("/login.html").setViewName("/login");
        registry.addViewController("/main.html").setViewName("/main");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }
}
