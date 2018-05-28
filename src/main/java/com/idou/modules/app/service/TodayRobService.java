package com.idou.modules.app.service;

import com.idou.modules.app.dto.ApiTotayRobEntity;
import com.idou.modules.app.entity.ApiUserEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品活动
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-11-24 下午 3:38
 **/

public interface TodayRobService {
    /**
     * 根据商品ID查询今日必抢活动商品详情
     *
     * @param itemId
     * @return
     */
    ApiTotayRobEntity queryDetailByItemId(Long itemId);

    /**
     * 查询用户列表根据商品活动ID
     *
     * @return
     */
    List<ApiUserEntity> queryRobUserByItemId(Map<String, Object> map);

    /**
     * 获取今日必抢活动接口地址
     *
     * @param itemId
     * @return
     */
    String todayRobUrl(Long itemId);

    /**
     * 获取今日必抢活动列表
     *
     * @return
     */
    List<ApiTotayRobEntity> queryList(Map<String, Object> map);
}
