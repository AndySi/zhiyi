package com.idou.modules.api.service;


import com.idou.modules.api.domain.WsBannerEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author zhangSi
 * @email andy_si@163.com
 * @date 2018-05-29 16:21:07
 */
public interface WsBannerService {
	List<WsBannerEntity> queryListLimit();

	WsBannerEntity queryObject(Long id);
	
	List<WsBannerEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(WsBannerEntity wsBanner);
	
	void update(WsBannerEntity wsBanner);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
