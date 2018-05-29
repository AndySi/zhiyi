package com.idou.modules.api.dao;

import com.idou.modules.api.entity.ApiBannerEntity;
import com.idou.modules.sysBs.dao.BaseDao;

import java.util.List;

/**
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-11-23 下午 4:03
 **/
public interface BannerDao extends BaseDao<ApiBannerEntity> {
    /**
     * 查询所有列表
     *
     * @return
     */
    List<ApiBannerEntity> queryListByStatu();
}
