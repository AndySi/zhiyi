package com.idou.modules.app.service.impl;

import com.idou.modules.app.dao.ActivityItemDao;
import com.idou.modules.app.entity.ApiActivityItemEntity;
import com.idou.modules.app.service.ActivityItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 活动-商品
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-12-29 下午 4:15
 **/
@Service("activityItemService")
public class ActivityItemServiceImpl implements ActivityItemService {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private ActivityItemDao activityItemDao;

    @Override
    public void add(ApiActivityItemEntity entity) {
        Map<String, Object> map = new HashMap<>();
        map.put("activityId", entity.getActivityId());
        map.put("itemIdList", entity.getItemIdList());
        activityItemDao.save(map);
    }

    @Override
    public void removeBatch(Long[] ids) {
        activityItemDao.deleteBatch(ids);
    }

    @Override
    public List<ApiActivityItemEntity> queryList(Map<String, Object> map) {
        return activityItemDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return activityItemDao.queryTotal(map);
    }
}
