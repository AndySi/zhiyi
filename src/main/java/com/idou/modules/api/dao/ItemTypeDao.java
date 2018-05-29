package com.idou.modules.api.dao;

import com.idou.modules.api.entity.ApiItemTypeEntity;
import com.idou.modules.sysBs.dao.BaseDao;

import java.util.List;

/**
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-12-05 下午 4:04
 **/
public interface ItemTypeDao extends BaseDao<ApiItemTypeEntity> {
    List<ApiItemTypeEntity> queryTypeListByPid(Long pid);

    int deleteBatch(List ids);
}
