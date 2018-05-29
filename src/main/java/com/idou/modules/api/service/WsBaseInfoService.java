package com.idou.modules.api.service;


import com.idou.modules.api.domain.WsBaseInfoEntity;

/**
 * @author zhangSi
 * @email andy_si@163.com
 * @date 2018-05-29 11:27:30
 */
public interface WsBaseInfoService {
    WsBaseInfoEntity queryObject();

    void save(WsBaseInfoEntity wsBaseinfo);
}
