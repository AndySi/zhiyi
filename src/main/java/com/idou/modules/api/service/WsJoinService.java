package com.idou.modules.api.service;

import com.idou.modules.api.domain.WsJoinEntity;

/**
 * @author zhangSi
 * @email andy_si@163.com
 * @date 2018-05-29 16:21:07
 */
public interface WsJoinService {
    WsJoinEntity queryObject();

    void save(WsJoinEntity wsJoin);
}
