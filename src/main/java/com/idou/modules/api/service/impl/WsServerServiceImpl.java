package com.idou.modules.api.service.impl;

import com.idou.modules.api.dao.WsServerDao;
import com.idou.modules.api.domain.WsServerEntity;
import com.idou.modules.api.service.WsServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service("wsServerService")
public class WsServerServiceImpl implements WsServerService {
	@Autowired
	private WsServerDao wsServerDao;
	
	@Override
	public WsServerEntity queryObject(Long id){
		return wsServerDao.queryObject(id);
	}
	
	@Override
	public List<WsServerEntity> queryList(Map<String, Object> map){
		return wsServerDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return wsServerDao.queryTotal(map);
	}
	
	@Override
	public void save(WsServerEntity wsServer){
		wsServerDao.save(wsServer);
	}
	
	@Override
	public void update(WsServerEntity wsServer){
		wsServerDao.update(wsServer);
	}
	
	@Override
	public void delete(Long id){
		wsServerDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		wsServerDao.deleteBatch(ids);
	}
	
}
