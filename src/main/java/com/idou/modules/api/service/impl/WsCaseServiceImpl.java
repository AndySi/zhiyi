package com.idou.modules.api.service.impl;

import com.idou.modules.api.dao.WsCaseDao;
import com.idou.modules.api.domain.WsCaseEntity;
import com.idou.modules.api.service.WsCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service("wsCaseService")
public class WsCaseServiceImpl implements WsCaseService {
	@Autowired
	private WsCaseDao wsCaseDao;
	
	@Override
	public WsCaseEntity queryObject(Long id){
		return wsCaseDao.queryObject(id);
	}
	
	@Override
	public List<WsCaseEntity> queryList(Map<String, Object> map){
		return wsCaseDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return wsCaseDao.queryTotal(map);
	}
	
	@Override
	public void save(WsCaseEntity wsCase){
		wsCaseDao.save(wsCase);
	}
	
	@Override
	public void update(WsCaseEntity wsCase){
		wsCaseDao.update(wsCase);
	}
	
	@Override
	public void delete(Long id){
		wsCaseDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		wsCaseDao.deleteBatch(ids);
	}

	@Override
	public List<WsCaseEntity> queryALlList() {
		return wsCaseDao.queryAllList();
	}

}
