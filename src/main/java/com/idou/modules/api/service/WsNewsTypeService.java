package com.idou.modules.api.service;

import com.idou.modules.api.domain.WsNewsTypeEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author zhangSi
 * @email andy_si@163.com
 * @date 2018-05-29 16:21:07
 */
public interface WsNewsTypeService {
	
	WsNewsTypeEntity queryObject(Long id);
	
	List<WsNewsTypeEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(WsNewsTypeEntity wsNewsType);
	
	void update(WsNewsTypeEntity wsNewsType);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
