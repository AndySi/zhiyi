package com.idou.modules.api.service.impl;

import com.idou.common.exception.RRException;
import com.idou.modules.api.dao.WsBaseInfoDao;
import com.idou.modules.api.domain.WsBaseInfoEntity;
import com.idou.modules.api.service.WsBaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WsBaseInfoServiceImpl implements WsBaseInfoService {
    @Autowired
    private WsBaseInfoDao wsBaseinfoDao;

    @Override
    public WsBaseInfoEntity queryObject() {
        return wsBaseinfoDao.queryInfo();
    }

    @Transactional
    @Override
    public void save(WsBaseInfoEntity wsBaseinfo) {
        try {
            wsBaseinfoDao.delete();
            wsBaseinfoDao.save(wsBaseinfo);
        } catch (Exception e) {
            throw new RRException(e.getLocalizedMessage());
        }
    }
}
