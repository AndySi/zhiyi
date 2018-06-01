package com.idou.modules.sysBs.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.MultipartConfigElement;

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
     * 在配置文件中配置的文件保存路径
     */
    @Value("${img.location}")
    private String tmpLocation;
    /**
     * 设置spring-boot的默认首页
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/login.html").setViewName("login");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }

    /**
     * 配置本地临时目录
     *
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation(tmpLocation);
        return factory.createMultipartConfig();
    }
}
