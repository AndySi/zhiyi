package com.idou.modules.api.service.impl;

import com.idou.common.exception.RRException;
import com.idou.modules.api.dao.WsServerDao;
import com.idou.modules.api.domain.WsServerEntity;
import com.idou.modules.api.service.WsServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("wsServerService")
public class WsServerServiceImpl implements WsServerService {
	@Autowired
	private WsServerDao wsServerDao;
	
	@Override
	public WsServerEntity queryObject(){
		return wsServerDao.queryInfo();
	}

	@Transactional
	@Override
	public void save(WsServerEntity wsServer){
		try {
			wsServerDao.del();
			wsServerDao.save(wsServer);
		} catch (Exception e){
			throw new RRException(e.getLocalizedMessage());
		}
	}
	
	@Override
	public void delete(Long id){
		wsServerDao.delete(id);
	}
	
}
