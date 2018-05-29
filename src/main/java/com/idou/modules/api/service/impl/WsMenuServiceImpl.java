package com.idou.modules.api.service.impl;

import com.idou.modules.api.dao.WsMenuDao;
import com.idou.modules.api.domain.WsMenuEntity;
import com.idou.modules.api.service.WsMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("wsMenuService")
public class WsMenuServiceImpl implements WsMenuService {
	@Autowired
	private WsMenuDao wsMenuDao;
	
	@Override
	public WsMenuEntity queryObject(Long id){
		return wsMenuDao.queryObject(id);
	}
	
	@Override
	public List<WsMenuEntity> queryList(Map<String, Object> map){
		return wsMenuDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return wsMenuDao.queryTotal(map);
	}
	
	@Override
	public void save(WsMenuEntity wsMenu){
		wsMenuDao.save(wsMenu);
	}
	
	@Override
	public void update(WsMenuEntity wsMenu){
		wsMenuDao.update(wsMenu);
	}
	
	@Override
	public void delete(Long id){
		wsMenuDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		wsMenuDao.deleteBatch(ids);
	}
	
}
