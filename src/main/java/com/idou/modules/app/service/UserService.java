package com.idou.modules.app.service;

import com.idou.modules.app.entity.ApiUserEntity;

import java.util.List;
import java.util.Map;

/**
 * 用户
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-08-08 上午 9:29
 **/

public interface UserService {
    /**
     * b-修改用户状态
     *
     * @param map
     */
    void updateStatu(Map<String, Object> map);

    /**
     * b-用户列表
     *
     * @param map
     * @return
     */
    List<ApiUserEntity> queryList(Map<String, Object> map);

    /**
     * b
     *
     * @param map
     * @return
     */
    int queryTotal(Map<String, Object> map);

    /************************************************************************************************/

    /**
     * f-更新or保存用户
     *
     * @param entity
     * @return
     */
    ApiUserEntity saveOrUpdate(ApiUserEntity entity);

    /**
     * f-根据用户ID查询用户详情
     *
     * @param userId
     * @return
     */
    ApiUserEntity queryObject(Long userId);
}
