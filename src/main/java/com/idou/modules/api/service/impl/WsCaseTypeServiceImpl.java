package com.idou.modules.api.service.impl;

import com.idou.modules.api.dao.WsCaseTypeDao;
import com.idou.modules.api.domain.WsCaseTypeEntity;
import com.idou.modules.api.service.WsCaseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service("wsCaseTypeService")
public class WsCaseTypeServiceImpl implements WsCaseTypeService {
	@Autowired
	private WsCaseTypeDao wsCaseTypeDao;
	
	@Override
	public WsCaseTypeEntity queryObject(Long id){
		return wsCaseTypeDao.queryObject(id);
	}
	
	@Override
	public List<WsCaseTypeEntity> queryList(Map<String, Object> map){
		return wsCaseTypeDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return wsCaseTypeDao.queryTotal(map);
	}
	
	@Override
	public void save(WsCaseTypeEntity wsCaseType){
		wsCaseTypeDao.save(wsCaseType);
	}
	
	@Override
	public void update(WsCaseTypeEntity wsCaseType){
		wsCaseTypeDao.update(wsCaseType);
	}
	
	@Override
	public void delete(Long id){
		wsCaseTypeDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		wsCaseTypeDao.deleteBatch(ids);
	}
	
}
