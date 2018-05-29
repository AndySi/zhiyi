package com.idou.modules.api.service.impl;

import com.idou.modules.api.dao.WsContactDao;
import com.idou.modules.api.domain.WsContactEntity;
import com.idou.modules.api.service.WsContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service("wsContactService")
public class WsContactServiceImpl implements WsContactService {
	@Autowired
	private WsContactDao wsContactDao;
	
	@Override
	public WsContactEntity queryObject(Long id){
		return wsContactDao.queryObject(id);
	}
	
	@Override
	public List<WsContactEntity> queryList(Map<String, Object> map){
		return wsContactDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return wsContactDao.queryTotal(map);
	}
	
	@Override
	public void save(WsContactEntity wsContact){
		wsContactDao.save(wsContact);
	}
	
	@Override
	public void update(WsContactEntity wsContact){
		wsContactDao.update(wsContact);
	}
	
	@Override
	public void delete(Long id){
		wsContactDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		wsContactDao.deleteBatch(ids);
	}
	
}
