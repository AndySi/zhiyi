package com.idou.modules.api.service;

import com.idou.modules.api.domain.WsMenuEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author zhangSi
 * @email andy_si@163.com
 * @date 2018-05-29 11:27:30
 */
public interface WsMenuService {
	List<WsMenuEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void update(long id, boolean val);
}
