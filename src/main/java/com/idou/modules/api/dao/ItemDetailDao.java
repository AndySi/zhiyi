package com.idou.modules.api.dao;

import com.idou.modules.api.entity.ApiItemDetailEntity;
import com.idou.modules.sysBs.dao.BaseDao;

import java.util.List;

/**
 * @author:ZhangSi
 * @email:andy_si@163.com
 * @date:2017/12/6
 */
public interface ItemDetailDao extends BaseDao<ApiItemDetailEntity>{
    List<ApiItemDetailEntity> queryListByItemId(Long itemId);
}
