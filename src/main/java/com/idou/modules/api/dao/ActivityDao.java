package com.idou.modules.api.dao;

import com.idou.modules.api.entity.ApiActivityEntity;
import com.idou.modules.sysBs.dao.BaseDao;

import java.util.List;

/**
 * 活动
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-11-24 下午 2:53
 **/
public interface ActivityDao extends BaseDao<ApiActivityEntity>{
    List<ApiActivityEntity> queryALlList();
}
