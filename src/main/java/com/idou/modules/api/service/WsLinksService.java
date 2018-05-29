package com.idou.modules.api.service;

import com.idou.modules.api.domain.WsLinksEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author zhangSi
 * @email andy_si@163.com
 * @date 2018-05-29 16:21:07
 */
public interface WsLinksService {
	
	WsLinksEntity queryObject(Long id);
	
	List<WsLinksEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(WsLinksEntity wsLinks);
	
	void update(WsLinksEntity wsLinks);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
