package com.idou.modules.app.service;

import com.idou.modules.app.entity.ApiItemAttrEntity;

import java.util.List;
import java.util.Map;

/**
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-12-21 下午 1:38
 **/

public interface ItemAttrService {
    /**
     * b-根据产品ID查询相关属性列表
     *
     * @param itemId
     * @return
     */
    List<ApiItemAttrEntity> queryListByItemId(Long itemId);

    /**
     * b-添加
     *
     * @param entity
     */
    void add(ApiItemAttrEntity entity);

    /**
     * b-修改
     *
     * @param entity
     */
    void modify(ApiItemAttrEntity entity);

    /**
     * b-删除
     *
     * @param ids
     */
    void removeBatch(Long[] ids);

    /**
     * b-查询列表
     *
     * @param map
     * @return
     */
    List<ApiItemAttrEntity> queryList(Map<String, Object> map);

    /**
     * b-查询列表数量
     *
     * @param map
     * @return
     */
    int queryTotal(Map<String, Object> map);
}
