package com.idou.modules.api.service.impl;

import com.idou.modules.api.dao.WsActivityTypeDao;
import com.idou.modules.api.domain.WsActivityTypeEntity;
import com.idou.modules.api.service.WsActivityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("wsActivityTypeService")
public class WsActivityTypeServiceImpl implements WsActivityTypeService {
	@Autowired
	private WsActivityTypeDao wsActivityTypeDao;
	
	@Override
	public WsActivityTypeEntity queryObject(Long id){
		return wsActivityTypeDao.queryObject(id);
	}
	
	@Override
	public List<WsActivityTypeEntity> queryList(Map<String, Object> map){
		return wsActivityTypeDao.queryList(map);
	}

	@Override
	public List<WsActivityTypeEntity> queryList() {
		return wsActivityTypeDao.queryAllList();
	}

	@Override
	public int queryTotal(Map<String, Object> map){
		return wsActivityTypeDao.queryTotal(map);
	}
	
	@Override
	public void save(WsActivityTypeEntity wsNewsType){
		wsActivityTypeDao.save(wsNewsType);
	}
	
	@Override
	public void update(WsActivityTypeEntity wsNewsType){
		wsActivityTypeDao.update(wsNewsType);
	}
	
	@Override
	public void delete(Long id){
		wsActivityTypeDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		wsActivityTypeDao.deleteBatch(ids);
	}
	
}
