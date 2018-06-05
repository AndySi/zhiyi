package com.idou.modules.api.service.impl;

import com.idou.modules.api.dao.WsActivityDao;
import com.idou.modules.api.domain.WsActivityEntity;
import com.idou.modules.api.service.WsActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class WsActivityServiceImpl implements WsActivityService {
	@Autowired
	private WsActivityDao wsActivityDao;
	
	@Override
	public WsActivityEntity queryObject(Long id){
		return wsActivityDao.queryObject(id);
	}
	
	@Override
	public List<WsActivityEntity> queryList(Map<String, Object> map){
		return wsActivityDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return wsActivityDao.queryTotal(map);
	}
	
	@Override
	public void save(WsActivityEntity wsNews){
		wsActivityDao.save(wsNews);
	}
	
	@Override
	public void update(WsActivityEntity wsNews){
		wsActivityDao.update(wsNews);
	}
	
	@Override
	public void delete(Long id){
		wsActivityDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		wsActivityDao.deleteBatch(ids);
	}
	
}
