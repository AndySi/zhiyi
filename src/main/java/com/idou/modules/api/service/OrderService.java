package com.idou.modules.api.service;

import com.idou.modules.api.dto.ActivityExecutionVo;
import com.idou.modules.api.dto.ApiOrderVo;
import com.idou.modules.api.entity.ApiOrderEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-11-28 下午 5:14
 **/

public interface OrderService {
    /**
     * b
     *
     * @param map
     * @return
     */
    List<ApiOrderVo> queryList(Map<String, Object> map);

    /**
     * b
     *
     * @param map
     * @return
     */
    int queryTotal(Map<String, Object> map);

    /**
     * b
     *
     * @param vo
     */
    void modify(ApiOrderVo vo);

    /**
     * f-今日必抢活动下单
     *
     * @param itemId
     * @param orderNum
     * @param orderMoney
     * @param addressId
     * @param receiver
     * @param tel
     * @param userId
     * @return
     */
    ActivityExecutionVo saveTodayRobOrderProduce(Long itemId, int orderNum, BigDecimal orderMoney, Long addressId, String receiver, String tel, Long userId);

    /**
     * f - 根据用户ID查询订单列表
     *
     * @param userId
     * @return
     */
    List<ApiOrderVo> queryListByUserId(Long userId, int page, int limit);

    /**
     * f - 查询详情
     *
     * @param userId
     * @param orderNo
     * @return
     */
    ApiOrderVo queryDetail(Long userId, String orderNo);

    /**
     * f - 查询订单是否过期
     *
     * @param orderNo
     * @return
     */
    boolean queryOverdue(Long userId, String orderNo);

    /**
     * 订单支付成功后修改状态
     *
     * @param entity
     */
    void updateState(ApiOrderEntity entity);
}
