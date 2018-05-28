package com.idou.modules.app.service.impl;

import com.idou.common.enums.TodayRobStatuEnum;
import com.idou.common.exception.RRException;
import com.idou.modules.app.dao.OrderDao;
import com.idou.modules.app.dto.ActivityExecutionVo;
import com.idou.modules.app.dto.ApiOrderVo;
import com.idou.modules.app.entity.ApiOrderEntity;
import com.idou.modules.app.service.OrderService;
import com.idou.modules.app.utils.GenNumUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 订单
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-11-28 下午 5:19
 **/
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private OrderDao orderDao;

    @Override
    public List<ApiOrderVo> queryList(Map<String, Object> map) {
        return orderDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return orderDao.queryTotal(map);
    }

    @Override
    public void modify(ApiOrderVo vo) {
        orderDao.update(vo);
    }

    @Override
    public ActivityExecutionVo saveTodayRobOrderProduce(Long itemId, int orderNum, BigDecimal orderMoney, Long addressId, String receiver, String tel, Long userId) {
        Map<String, Object> map = new HashMap<>();
        map.put("itemId", itemId);
        map.put("orderNum", orderNum);
        map.put("orderMoney", orderMoney);
        map.put("addressId", addressId);
        map.put("orderNo", GenNumUtils.getOrderIdByMs(userId));
        map.put("userId", userId);
        map.put("receiver", receiver);
        map.put("tel", tel);
        map.put("payType", 0);
        Date now = new Date();
        Date afterDate = new Date(now.getTime()+900000);
        map.put("createTime", now);
        map.put("expireTime", afterDate);
        map.put("result", null);
        // 执行存储过程
        try {
            orderDao.saveRobByProcedure(map);
            // 获取result
            Integer result = MapUtils.getInteger(map, "result", -2);
            return new ActivityExecutionVo(itemId, TodayRobStatuEnum.stateOf(result));
        } catch (Exception e) {
            Logger.getLogger(getClass()).info(e.getMessage());
            throw new RRException(TodayRobStatuEnum.INNER_ERROR.getStateInfo());
        }

    }

    @Override
    public List<ApiOrderVo> queryListByUserId(Long userId, int page, int limit) {
        int offset = page == 0 ? 0 : (page - 1) * limit;
        return orderDao.queryListByUserId(userId, offset, limit == 0 ? 5 : limit);
    }

    @Override
    public ApiOrderVo queryDetail(Long userId, String orderNo) {
        return orderDao.queryDetail(userId, orderNo);
    }

    @Override
    public boolean queryOverdue(Long userId, String orderNo) {
        ApiOrderEntity entity = orderDao.queryInfo(userId, orderNo);
        if (entity != null) {
            //系统当前时间
            Date nowTime = new Date();
            if (nowTime.getTime() < entity.getExpireTime().getTime() || nowTime.getTime() > entity.getExpireTime().getTime()) {
                throw new RRException("订单失效");
            }
        } else {
            throw new RRException("订单不存在");
        }
        return true;
    }

    @Override
    public void updateState(ApiOrderEntity entity) {
        orderDao.updateState(entity);
    }
}
