package com.idou.modules.app.service;

import com.idou.modules.app.entity.ApiActivityEntity;

import java.util.List;
import java.util.Map;

/**
 * 活动管理
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-12-29 上午 10:39
 **/

public interface ActivityService {
    void add(ApiActivityEntity entity);

    void modify(ApiActivityEntity entity);

    void removeBatch(Long[] ids);

    List<ApiActivityEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    List<ApiActivityEntity> queryAllList();
}
