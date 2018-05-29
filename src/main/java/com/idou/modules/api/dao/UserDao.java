package com.idou.modules.api.dao;

import com.idou.modules.api.entity.ApiUserEntity;
import com.idou.modules.sysBs.dao.BaseDao;

import java.util.Map;

/**
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-11-23 下午 3:47
 **/
public interface UserDao extends BaseDao<ApiUserEntity> {
    int saveOrUpdate(ApiUserEntity entity);
    int updateStatu(Map<String, Object> map);
}
