package com.idou.modules.api.service.impl;

import com.idou.modules.api.dao.WsJoinDao;
import com.idou.modules.api.domain.WsJoinEntity;
import com.idou.modules.api.service.WsJoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service("wsJoinService")
public class WsJoinServiceImpl implements WsJoinService {
	@Autowired
	private WsJoinDao wsJoinDao;
	
	@Override
	public WsJoinEntity queryObject(Long id){
		return wsJoinDao.queryObject(id);
	}
	
	@Override
	public List<WsJoinEntity> queryList(Map<String, Object> map){
		return wsJoinDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return wsJoinDao.queryTotal(map);
	}
	
	@Override
	public void save(WsJoinEntity wsJoin){
		wsJoinDao.save(wsJoin);
	}
	
	@Override
	public void update(WsJoinEntity wsJoin){
		wsJoinDao.update(wsJoin);
	}
	
	@Override
	public void delete(Long id){
		wsJoinDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		wsJoinDao.deleteBatch(ids);
	}
	
}
