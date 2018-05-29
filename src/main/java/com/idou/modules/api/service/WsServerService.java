package com.idou.modules.api.service;

import com.idou.modules.api.domain.WsServerEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author zhangSi
 * @email andy_si@163.com
 * @date 2018-05-29 16:21:07
 */
public interface WsServerService {
	
	WsServerEntity queryObject(Long id);
	
	List<WsServerEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(WsServerEntity wsServer);
	
	void update(WsServerEntity wsServer);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
