package com.idou.modules.api.service.impl;

import com.idou.common.exception.RRException;
import com.idou.modules.api.dao.WsContactDao;
import com.idou.modules.api.domain.WsContactEntity;
import com.idou.modules.api.service.WsContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("wsContactService")
public class WsContactServiceImpl implements WsContactService {
    @Autowired
    private WsContactDao wsContactDao;

    @Override
    public WsContactEntity queryObject() {
        return wsContactDao.queryInfo();
    }

    @Transactional
    @Override
    public void save(WsContactEntity wsContact) {
        try {
            wsContactDao.del();
            wsContactDao.save(wsContact);
        } catch (Exception e) {
            throw new RRException(e.getLocalizedMessage());
        }

    }
}
