package com.idou.modules.api.service;


import com.idou.modules.api.domain.WsCaseEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author zhangSi
 * @email andy_si@163.com
 * @date 2018-05-29 16:21:07
 */
public interface WsCaseService {
	
	WsCaseEntity queryObject(Long id);
	
	List<WsCaseEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(WsCaseEntity wsCase);
	
	void update(WsCaseEntity wsCase);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);

	List<WsCaseEntity> queryALlList();
}
