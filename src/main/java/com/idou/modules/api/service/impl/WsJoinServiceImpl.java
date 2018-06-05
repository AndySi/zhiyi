package com.idou.modules.api.service.impl;

import com.idou.common.exception.RRException;
import com.idou.modules.api.dao.WsJoinDao;
import com.idou.modules.api.domain.WsJoinEntity;
import com.idou.modules.api.service.WsJoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("wsJoinService")
public class WsJoinServiceImpl implements WsJoinService {
    @Autowired
    private WsJoinDao wsJoinDao;

    @Override
    public WsJoinEntity queryObject() {
        return wsJoinDao.queryInfo();
    }

    @Transactional
    @Override
    public void save(WsJoinEntity wsJoin) {
        try {
            wsJoinDao.del();
            wsJoinDao.save(wsJoin);
        }catch (Exception e){
            throw new RRException(e.getLocalizedMessage());
        }
    }
}
