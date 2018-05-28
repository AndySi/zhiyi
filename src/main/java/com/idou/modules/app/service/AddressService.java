package com.idou.modules.app.service;

import com.idou.modules.app.entity.ApiAddressEntity;

import java.util.List;
import java.util.Map;

/**
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-12-04 下午 4:51
 **/

public interface AddressService {
    /**
     * b
     *
     * @param map
     * @return
     */
    List<ApiAddressEntity> queryList(Map<String, Object> map);

    /**
     * b
     *
     * @param map
     * @return
     */
    int queryTotal(Map<String, Object> map);

    /**
     * f-根据地址ID查询地址详情
     *
     * @param id
     * @return
     */
    ApiAddressEntity queryInfoById(Long id);

    /**
     * f-根据用户ID查询地址列表
     *
     * @param userId
     * @return
     */
    List<ApiAddressEntity> queryListByUid(Long userId);

    /**
     * f-用户添加地址
     *
     * @param entity
     */
    void save(ApiAddressEntity entity);

    /**
     * f-修改添加地址
     *
     * @param addressEntity
     */
    void update(ApiAddressEntity addressEntity);

    /**
     * f-用户删除地址
     *
     * @param map
     * @return
     */
    void delete(Map<String, Object> map);
}
