package com.idou.modules.app.dao;

import com.idou.modules.app.entity.ApiAttrNameEntity;
import com.idou.modules.app.entity.ApiAttrValueEntity;

import java.util.List;
import java.util.Map;

/**
 * 属性
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-12-01 上午 9:43
 **/
public interface AttrDao {
    /**
     * b-名新增
     *
     * @param entity
     * @return
     */
    int saveName(ApiAttrNameEntity entity);

    /**
     * b-名修改
     *
     * @param entity
     * @return
     */
    int updateName(ApiAttrNameEntity entity);

    /**
     * b-名删除
     *
     * @param ids
     * @return
     */
    int deleteBatchName(Long[] ids);

    /**
     * b-根据父ID查询列表
     *
     * @param pid
     * @return
     */
    List<ApiAttrNameEntity> queryNameListByPid(Long pid);

    /**
     * b-查询属性名列表
     *
     * @param map
     * @return
     */
    List<ApiAttrNameEntity> queryNameList(Map<String, Object> map);

    /**
     * b-查询属性名数量
     *
     * @param map
     * @return
     */
    int queryNameTotal(Map<String, Object> map);

    /**
     * b-根据商品类型ID和属性名称判断查询是否有该数据
     *
     * @param entity
     * @return
     */
    int queryNameCountBy(ApiAttrNameEntity entity);

    /**
     * b-名新增
     *
     * @param entity
     * @return
     */
    int saveValue(ApiAttrValueEntity entity);

    /**
     * b-名修改
     *
     * @param entity
     * @return
     */
    int updateValue(ApiAttrValueEntity entity);

    /**
     * b-名删除
     *
     * @param ids
     * @return
     */
    int deleteBatchValue(Long[] ids);

    /**
     * b-查询属性值列表
     *
     * @param map
     * @return
     */
    List<ApiAttrValueEntity> queryValueList(Map<String, Object> map);

    /**
     * b-查询属性值数量
     *
     * @param map
     * @return
     */
    int queryValueTotal(Map<String, Object> map);

    /**
     * b-根据属性值+属性名ID查询是否有数据
     *
     * @param entity
     * @return
     */
    int queryValueCountBy(ApiAttrValueEntity entity);

    /**
     * b-根据商品ID查询属性名列表
     *
     * @param itemId
     * @return
     */
    List<ApiAttrNameEntity> queryNameListByItemId(Long itemId);

    /**
     * b-根据属性名ID查询属性值列表
     *
     * @param nameId
     * @return
     */
    List<ApiAttrValueEntity> queryValueListByNameId(Long nameId);
}
