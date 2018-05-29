package com.idou.modules.api.service.impl;

import com.idou.modules.api.dao.WsNewsDao;
import com.idou.modules.api.domain.WsNewsEntity;
import com.idou.modules.api.service.WsNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service("wsNewsService")
public class WsNewsServiceImpl implements WsNewsService {
	@Autowired
	private WsNewsDao wsNewsDao;
	
	@Override
	public WsNewsEntity queryObject(Long id){
		return wsNewsDao.queryObject(id);
	}
	
	@Override
	public List<WsNewsEntity> queryList(Map<String, Object> map){
		return wsNewsDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return wsNewsDao.queryTotal(map);
	}
	
	@Override
	public void save(WsNewsEntity wsNews){
		wsNewsDao.save(wsNews);
	}
	
	@Override
	public void update(WsNewsEntity wsNews){
		wsNewsDao.update(wsNews);
	}
	
	@Override
	public void delete(Long id){
		wsNewsDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		wsNewsDao.deleteBatch(ids);
	}
	
}
