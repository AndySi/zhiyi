package com.idou.modules.api.service;

import com.idou.modules.api.domain.WsContactEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author zhangSi
 * @email andy_si@163.com
 * @date 2018-05-29 16:21:07
 */
public interface WsContactService {
	
	WsContactEntity queryObject(Long id);
	
	List<WsContactEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(WsContactEntity wsContact);
	
	void update(WsContactEntity wsContact);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
