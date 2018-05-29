package com.idou.modules.api.service;

import com.idou.modules.api.entity.ApiBannerEntity;

import java.util.List;

/**
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-11-23 下午 4:08
 **/

public interface BannerService {
    /**
     * 查询所有发布的列表
     *
     * @return
     */
    List<ApiBannerEntity> queryList();
}
