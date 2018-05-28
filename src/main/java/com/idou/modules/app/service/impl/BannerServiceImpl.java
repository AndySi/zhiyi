package com.idou.modules.app.service.impl;

import com.idou.modules.app.dao.BannerDao;
import com.idou.modules.app.entity.ApiBannerEntity;
import com.idou.modules.app.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-11-23 下午 4:09
 **/
@Service("bannerService")
public class BannerServiceImpl implements BannerService {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private BannerDao bannerDao;

    @Override
    public List<ApiBannerEntity> queryList() {
        return bannerDao.queryListByStatu();
    }
}
