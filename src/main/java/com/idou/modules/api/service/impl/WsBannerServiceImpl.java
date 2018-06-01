package com.idou.modules.api.service.impl;

import com.idou.modules.api.dao.WsBannerDao;
import com.idou.modules.api.domain.WsBannerEntity;
import com.idou.modules.api.service.WsBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service("wsBannerService")
public class WsBannerServiceImpl implements WsBannerService {
	@Autowired
	private WsBannerDao wsBannerDao;

	@Override
	public List<WsBannerEntity> queryListLimit() {
		return wsBannerDao.queryListLimit();
	}

	@Override
	public WsBannerEntity queryObject(Long id){
		return wsBannerDao.queryObject(id);
	}
	
	@Override
	public List<WsBannerEntity> queryList(Map<String, Object> map){
		return wsBannerDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return wsBannerDao.queryTotal(map);
	}
	
	@Override
	public void save(WsBannerEntity wsBanner){
		wsBannerDao.save(wsBanner);
	}
	
	@Override
	public void update(WsBannerEntity wsBanner){
		wsBannerDao.update(wsBanner);
	}
	
	@Override
	public void delete(Long id){
		wsBannerDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Long[] ids){
		wsBannerDao.deleteBatch(ids);
	}
	
}
