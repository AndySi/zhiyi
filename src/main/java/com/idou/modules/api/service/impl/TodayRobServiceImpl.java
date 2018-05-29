package com.idou.modules.api.service.impl;

import com.idou.common.constant.WebConstant;
import com.idou.common.exception.RRException;
import com.idou.common.utils.RedisUtils;
import com.idou.modules.api.dao.ActivityItemDao;
import com.idou.modules.api.dto.ApiTotayRobEntity;
import com.idou.modules.api.dto.SaltEntity;
import com.idou.modules.api.entity.ApiUserEntity;
import com.idou.modules.api.service.TodayRobService;
import com.idou.modules.api.utils.EncryptUtils;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 今日必抢
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-11-24 下午 3:55
 **/
@Service("todayRobService")
public class TodayRobServiceImpl implements TodayRobService {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private ActivityItemDao activityItemDao;

    @Autowired
    private SaltEntity saltEntity;

    @Autowired
    private RedisUtils redisUtil;

    @Override
    public ApiTotayRobEntity queryDetailByItemId(Long itemId) {
        return activityItemDao.queryDetailByItemId(itemId);
    }

    @Override
    public List<ApiUserEntity> queryRobUserByItemId(Map<String, Object> map) {
        return activityItemDao.queryRobUserByItemId(map);
    }

    @Override
    public String todayRobUrl(Long itemId) {
        // 访问redis
        ApiTotayRobEntity entity = (ApiTotayRobEntity) redisUtil.get(WebConstant.REDIS_CACHE_ROB_VAL);

        if (entity == null) {
            entity = activityItemDao.queryRobByItemId(itemId);
            if (entity == null) {
                throw new RRException("该商品不属于此次活动");
            }
            redisUtil.set(WebConstant.REDIS_CACHE_ROB_VAL, entity, 3600L);
        }
        //系统当前时间
        Date nowTime = new Date();
        if (nowTime.getTime() < entity.getStartTime().getTime() || nowTime.getTime() > entity.getEndTime().getTime()) {
            throw new RRException("活动未开启");
        }
        //盐值加密，转化特定字符串的过程，不可逆
        return EncryptUtils.EncoderByMd5(saltEntity.getFigure() + itemId);
    }

    @Override
    public List<ApiTotayRobEntity> queryList(Map<String, Object> map) {
        List<ApiTotayRobEntity> list = activityItemDao.queryTodayRobList(map);
        if (list.size() > 0) {
            Map<String, Object> queryParam = new HashedMap();
            for (ApiTotayRobEntity entity : list) {
                // 根据活动商品编号查询购买用户列表
                queryParam.put("itemActivityId", entity.getId());
                queryParam.put("limit", 3);
                List<ApiUserEntity> userList = activityItemDao.queryRobUserByItemId(queryParam);
                entity.setUserList(userList);
            }
        }
        return list;
    }
}
