package com.idou.modules.app.dao;

import com.idou.modules.app.dto.ApiTotayRobEntity;
import com.idou.modules.app.entity.ApiActivityItemEntity;
import com.idou.modules.app.entity.ApiUserEntity;
import com.idou.modules.sys.dao.BaseDao;

import java.util.List;
import java.util.Map;

/**
 * 商品活动
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-11-24 下午 3:35
 **/
public interface ActivityItemDao extends BaseDao<ApiActivityItemEntity>{
    ApiTotayRobEntity queryDetailByItemId(Long itemId);
    ApiTotayRobEntity queryRobByItemId(Long itemId);
    List<ApiTotayRobEntity> queryTodayRobList(Map<String, Object> map);
    List<ApiUserEntity> queryRobUserByItemId(Map<String, Object> map);
}
