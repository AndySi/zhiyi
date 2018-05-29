package com.idou.modules.api.dao;

import com.idou.modules.api.entity.ApiItemAttrEntity;
import com.idou.modules.sysBs.dao.BaseDao;

import java.util.List;

/**
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-12-21 上午 11:46
 **/
public interface ItemAttrDao extends BaseDao<ApiItemAttrEntity>{
    List<ApiItemAttrEntity> queryListByItemId(Long itemId);
    List<ApiItemAttrEntity> queryListByIds(List ids);
    int add(ApiItemAttrEntity t);
}
