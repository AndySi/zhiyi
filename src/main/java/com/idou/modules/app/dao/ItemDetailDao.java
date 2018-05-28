package com.idou.modules.app.dao;

import com.idou.modules.app.entity.ApiItemDetailEntity;
import com.idou.modules.sys.dao.BaseDao;

import java.util.List;

/**
 * @author:ZhangSi
 * @email:andy_si@163.com
 * @date:2017/12/6
 */
public interface ItemDetailDao extends BaseDao<ApiItemDetailEntity>{
    List<ApiItemDetailEntity> queryListByItemId(Long itemId);
}
