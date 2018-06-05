package com.idou.modules.api.service;

import com.idou.modules.api.domain.WsActivityTypeEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author zhangSi
 * @email andy_si@163.com
 * @date 2018-05-29 16:21:07
 */
public interface WsActivityTypeService {
	
	WsActivityTypeEntity queryObject(Long id);
	
	List<WsActivityTypeEntity> queryList(Map<String, Object> map);

	List<WsActivityTypeEntity> queryList();
	
	int queryTotal(Map<String, Object> map);
	
	void save(WsActivityTypeEntity wsNewsType);
	
	void update(WsActivityTypeEntity wsNewsType);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
