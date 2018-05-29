package com.idou.modules.api.service.impl;

import com.idou.modules.api.dao.WsNewsTypeDao;
import com.idou.modules.api.domain.WsNewsTypeEntity;
import com.idou.modules.api.service.WsNewsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service("wsNewsTypeService")
public class WsNewsTypeServiceImpl implements WsNewsTypeService {
	@Autowired
	private WsNewsTypeDao wsNewsTypeDao;
	
	@Override
	public WsNewsTypeEntity queryObject(Long id){
		return wsNewsTypeDao.queryObject(id);
	}
	
	@Override
	public List<WsNewsTypeEntity> queryList(Map<String, Object> map){
		return wsNewsTypeDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return wsNewsTypeDao.queryTotal(map);
	}
	
	@Override
	public void save(WsNewsTypeEntity wsNewsType){
		wsNewsTypeDao.save(wsNewsType);
	}
	
	@Override
	public void update(WsNewsTypeEntity wsNewsType){
		wsNewsTypeDao.update(wsNewsType);
	}
	
	@Override
	public void delete(Long id){
		wsNewsTypeDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		wsNewsTypeDao.deleteBatch(ids);
	}
	
}
