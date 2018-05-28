package com.idou.modules.app.service.impl;

import com.idou.modules.app.dao.ActivityDao;
import com.idou.modules.app.entity.ApiActivityEntity;
import com.idou.modules.app.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-12-29 上午 10:47
 **/
@Service("activityService")
public class ActivityServiceImpl implements ActivityService {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private ActivityDao activityDao;

    @Override
    public void add(ApiActivityEntity entity) {
        activityDao.save(entity);
    }

    @Override
    public void modify(ApiActivityEntity entity) {
        activityDao.update(entity);
    }

    @Override
    public void removeBatch(Long[] ids) {
        activityDao.deleteBatch(ids);
    }

    @Override
    public List<ApiActivityEntity> queryList(Map<String, Object> map) {
        return activityDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return activityDao.queryTotal(map);
    }

    @Override
    public List<ApiActivityEntity> queryAllList() {
        return activityDao.queryALlList();
    }
}
