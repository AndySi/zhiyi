package com.idou.modules.app.service;

import com.idou.modules.app.entity.ApiItemTypeEntity;

import java.util.List;
import java.util.Map;

/**
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-12-05 下午 4:09
 **/

public interface ItemTypeService {
    /**
     * b-查询列表
     *
     * @param map
     * @return
     */
    List<ApiItemTypeEntity> queryList(Map<String, Object> map);

    /**
     * b-查询总数
     */
    int queryTotal(Map<String, Object> map);

    /**
     * b-查询所有列表
     *
     * @return
     */
    List<ApiItemTypeEntity> queryAllList();

    /**
     * b-新增
     *
     * @param itemType
     */
    void add(ApiItemTypeEntity itemType);

    /**
     * b-修改
     *
     * @param itemType
     */
    void update(ApiItemTypeEntity itemType);

    /**
     * b-删除
     *
     * @param ids
     */
    void deleteBatch(Long[] ids);
}
