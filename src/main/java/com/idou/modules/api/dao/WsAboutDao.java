package com.idou.modules.api.dao;

import com.idou.modules.api.domain.WsAboutEntity;
import com.idou.modules.api.domain.WsAboutListEntity;

import java.util.List;

/**
 * 关于
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2018-06-04 上午 10:58
 **/
public interface WsAboutDao {
    WsAboutEntity queryObject();

    List<WsAboutListEntity> queryList();

    int save(WsAboutEntity entity);

    int saveList(WsAboutListEntity entity);

    int delete();

    int update(WsAboutListEntity entity);

    int deleteBatch(Object[] ids);
}
