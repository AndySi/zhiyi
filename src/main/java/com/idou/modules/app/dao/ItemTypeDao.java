package com.idou.modules.app.dao;

import com.idou.modules.app.entity.ApiItemTypeEntity;
import com.idou.modules.sys.dao.BaseDao;

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
