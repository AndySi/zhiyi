package com.idou.modules.api.service.impl;

import com.idou.common.exception.RRException;
import com.idou.modules.api.dao.WsAboutDao;
import com.idou.modules.api.domain.WsAboutEntity;
import com.idou.modules.api.domain.WsAboutListEntity;
import com.idou.modules.api.service.WsAboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2018-06-04 上午 11:11
 **/
@Service
public class WsAboutServiceImpl implements WsAboutService {
    @Autowired
    private WsAboutDao wsAboutDao;

    @Override
    public WsAboutEntity queryObject() {
        return wsAboutDao.queryObject();
    }

    @Override
    public List<WsAboutListEntity> queryList() {
        return wsAboutDao.queryList();
    }

    @Transactional
    @Override
    public void save(WsAboutEntity entity) {
        try {
            wsAboutDao.delete();
            wsAboutDao.save(entity);
        } catch (Exception e) {
            throw new RRException(e.getLocalizedMessage());
        }
    }

    @Override
    public void saveList(WsAboutListEntity entity) {
        wsAboutDao.saveList(entity);
    }

    @Override
    public void update(WsAboutListEntity entity) {
        wsAboutDao.update(entity);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        wsAboutDao.deleteBatch(ids);
    }
}
