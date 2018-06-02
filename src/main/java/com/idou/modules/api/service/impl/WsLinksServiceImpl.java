package com.idou.modules.api.service.impl;

import com.idou.modules.api.dao.WsLinksDao;
import com.idou.modules.api.domain.WsLinksEntity;
import com.idou.modules.api.service.WsLinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service("wsLinksService")
public class WsLinksServiceImpl implements WsLinksService {
	@Autowired
	private WsLinksDao wsLinksDao;
	
	@Override
	public WsLinksEntity queryObject(Long id){
		return wsLinksDao.queryObject(id);
	}
	
	@Override
	public List<WsLinksEntity> queryList(Map<String, Object> map){
		return wsLinksDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return wsLinksDao.queryTotal(map);
	}
	
	@Override
	public void save(WsLinksEntity wsLinks){
		wsLinksDao.save(wsLinks);
	}
	
	@Override
	public void update(WsLinksEntity wsLinks){
		wsLinksDao.update(wsLinks);
	}
	
	@Override
	public void delete(Long id){
		wsLinksDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		wsLinksDao.deleteBatch(ids);
	}

	@Override
	public List<WsLinksEntity> queryList() {
		return wsLinksDao.queryAllList();
	}

}
