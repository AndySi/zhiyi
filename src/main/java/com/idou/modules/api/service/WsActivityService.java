package com.idou.modules.api.service;

import com.idou.modules.api.domain.WsActivityEntity;

import java.util.List;
import java.util.Map;

/**
 * @author zhangSi
 * @email andy_si@163.com
 * @date 2018-05-29 16:21:07
 */
public interface WsActivityService {

    WsActivityEntity queryObject(Long id);

    List<WsActivityEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(WsActivityEntity wsNews);

    void update(WsActivityEntity wsNews);

    void delete(Long id);

    void deleteBatch(Long[] ids);

    boolean doPoll(Long id, String ip);
}
