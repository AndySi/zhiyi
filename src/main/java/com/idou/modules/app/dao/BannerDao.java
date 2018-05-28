package com.idou.modules.app.dao;

import com.idou.modules.app.entity.ApiBannerEntity;
import com.idou.modules.sys.dao.BaseDao;

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
