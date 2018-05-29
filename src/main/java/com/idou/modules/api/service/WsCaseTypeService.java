package com.idou.modules.api.service;


import com.idou.modules.api.domain.WsCaseTypeEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author zhangSi
 * @email andy_si@163.com
 * @date 2018-05-29 16:21:07
 */
public interface WsCaseTypeService {
	
	WsCaseTypeEntity queryObject(Long id);
	
	List<WsCaseTypeEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(WsCaseTypeEntity wsCaseType);
	
	void update(WsCaseTypeEntity wsCaseType);
	
	void delete(Long id);
	
	void deleteBatch(Long[] ids);
}
