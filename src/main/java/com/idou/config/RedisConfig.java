package com.idou.config;

import com.foxinmy.weixin4j.cache.RedisCacheStorager;
import com.foxinmy.weixin4j.model.Token;
import com.foxinmy.weixin4j.mp.WeixinProxy;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import redis.clients.jedis.JedisPoolConfig;

import java.lang.reflect.Method;

/**
 * Redis配置
 *
 * @author zhangsi
 * @email 917661718@qq.com
 * @date 2017-07-70 19:22
 */
@Configuration
@EnableCaching  //启用缓存，这个注解很重要
@EnableRedisHttpSession
public class RedisConfig extends CachingConfigurerSupport {
    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.timeout}")
    private int timeout;

    @Value("${spring.redis.pool.max-idle}")
    private int maxIdle;

    @Value("${spring.redis.pool.max-wait}")
    private long maxWaitMillis;

    /**
     * 缓存管理器
     *
     * @param redisTemplate
     * @return
     */
    @Bean
    public CacheManager cacheManager(RedisTemplate<?, ?> redisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        //设置缓存过期时间
        //cacheManager.setDefaultExpiration(10000);
        return cacheManager;
    }

    /**
     * 自定义key
     * 此方法将会根据类名+方法名+所有参数的值生成唯一的一个key,即使@Cacheable中的value属性一样，key也会不一样。
     *
     * @return
     */
    @Override
    public KeyGenerator keyGenerator() {
        Logger.getLogger(getClass()).info("RedisConfig.keyGenerator()");
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                StringBuilder sb = new StringBuilder();
                sb.append(o.getClass().getName());
                sb.append(method.getName());
                for (Object obj : objects) {
                    sb.append(obj.toString());
                }
                Logger.getLogger(getClass()).info("自定义keyGenerator=" + sb.toString());
                return sb.toString();
            }
        };
    }

    @Bean
    public RedisCacheStorager<Token> redisCacheStorager() {
        Logger.getLogger(getClass()).info("JedisPool注入成功！！");
        Logger.getLogger(getClass()).info("redis地址：" + host + ":" + port);
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        return new RedisCacheStorager<Token>(host, port, timeout, (String) null, jedisPoolConfig);
    }

    @Bean
    public WeixinProxy mpWeixinProxy() {
        return new WeixinProxy(redisCacheStorager());
    }
}
