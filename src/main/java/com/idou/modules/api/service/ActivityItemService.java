package com.idou.modules.api.service;

import com.idou.modules.api.entity.ApiActivityItemEntity;

import java.util.List;
import java.util.Map;

/**
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-12-29 下午 4:13
 **/

public interface ActivityItemService {
    void add(ApiActivityItemEntity entity);

    void removeBatch(Long[] ids);

    List<ApiActivityItemEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);
}
