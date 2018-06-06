package com.idou.modules.api.service;

import com.idou.modules.api.domain.WsNewsEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author zhangSi
 * @email andy_si@163.com
 * @date 2018-05-29 16:21:07
 */
public interface WsNewsService {
	WsNewsEntity queryObject(Long id);
	
	List<WsNewsEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(WsNewsEntity wsNews);
	
	void update(WsNewsEntity wsNews);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
