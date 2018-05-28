package com.idou.modules.app.service;

import com.idou.modules.app.entity.ApiItemSkuEntity;

import java.util.List;
import java.util.Map;

/**
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-12-22 上午 11:05
 **/

public interface ItemSkuService {
    /**
     * b
     *
     * @param map
     * @return
     */
    List<ApiItemSkuEntity> queryList(Map<String, Object> map);

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
     * @param entity
     */
    void add(ApiItemSkuEntity entity);

    /**
     * b
     *
     * @param entity
     */
    void modify(ApiItemSkuEntity entity);

    /**
     * b
     *
     * @param ids
     */
    void removeBatch(Long[] ids);

    /**
     * b - 活动商品
     *
     * @return
     */
    List<ApiItemSkuEntity> queryActivityList();
}
