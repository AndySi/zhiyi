package com.idou.modules.api.service;

import com.idou.modules.api.entity.ApiAttrNameEntity;
import com.idou.modules.api.entity.ApiAttrValueEntity;

import java.util.List;
import java.util.Map;

/**
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-12-19 下午 2:54
 **/

public interface AttrService {
    /**
     * b-添加
     *
     * @param entity
     */
    void addName(ApiAttrNameEntity entity);

    /**
     * b-修改
     *
     * @param entity
     */
    void modifyName(ApiAttrNameEntity entity);

    /**
     * b-删除
     *
     * @param ids
     */
    void removeName(Long[] ids);

    /**
     * b-根据父ID查询列表
     *
     * @return
     */
    List<ApiAttrNameEntity> queryAllNameList();

    /**
     * b-根据商品类型查询属性名列表
     *
     * @param itemId
     * @return
     */
    List<ApiAttrNameEntity> queryNameListByItemId(Long itemId);

    /**
     * b-属性名
     *
     * @param map
     * @return
     */
    List<ApiAttrNameEntity> queryNameList(Map<String, Object> map);

    /**
     * b
     *
     * @param map
     * @return
     */
    int queryNameCount(Map<String, Object> map);

    /**
     * b-添加
     *
     * @param entity
     */
    void addValue(ApiAttrValueEntity entity);

    /**
     * b-修改
     *
     * @param entity
     */
    void modifyValue(ApiAttrValueEntity entity);

    /**
     * b-删除
     *
     * @param ids
     */
    void removeValue(Long[] ids);

    /**
     * b-属性值
     *
     * @param map
     * @return
     */
    List<ApiAttrValueEntity> queryValueList(Map<String, Object> map);

    /**
     * b
     *
     * @param map
     * @return
     */
    int queryValueCount(Map<String, Object> map);

    /**
     * b-根据属性名ID查询属性值列表
     *
     * @param nameId
     * @return
     */
    List<ApiAttrValueEntity> queryValueListByNameId(Long nameId);
}
