package com.idou.modules.api.service;

import com.idou.modules.api.domain.WsAboutEntity;
import com.idou.modules.api.domain.WsAboutListEntity;

import java.util.List;

/**
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2018-06-04 上午 11:10
 **/

public interface WsAboutService {
    WsAboutEntity queryObject();

    List<WsAboutListEntity> queryList();

    void save(WsAboutEntity entity);

    void saveList(WsAboutListEntity entity);

    void update(WsAboutListEntity entity);

    void deleteBatch(Long[] ids);
}
