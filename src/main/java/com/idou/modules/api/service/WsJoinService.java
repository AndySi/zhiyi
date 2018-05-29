package com.idou.modules.api.service;

import com.idou.modules.api.domain.WsJoinEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author zhangSi
 * @email andy_si@163.com
 * @date 2018-05-29 16:21:07
 */
public interface WsJoinService {
	
	WsJoinEntity queryObject(Long id);
	
	List<WsJoinEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(WsJoinEntity wsJoin);
	
	void update(WsJoinEntity wsJoin);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
