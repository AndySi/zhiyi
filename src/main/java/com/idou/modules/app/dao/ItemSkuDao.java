package com.idou.modules.app.dao;

import com.idou.modules.app.entity.ApiItemSkuEntity;
import com.idou.modules.sys.dao.BaseDao;

import java.util.List;

/**
 * 商品库存
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-12-22 上午 10:36
 **/
public interface ItemSkuDao extends BaseDao<ApiItemSkuEntity> {
    int add(ApiItemSkuEntity entity);

    List<ApiItemSkuEntity> queryActivityList();
}
