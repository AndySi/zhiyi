package com.idou.modules.api.dao;

import com.idou.modules.api.domain.WsBaseInfoEntity;
import com.idou.modules.sysBs.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;
/**
 * 
 * 
 * @author zhangSi
 * @email andy_si@163.com
 * @date 2018-05-29 11:27:30
 */
@Mapper
public interface WsBaseInfoDao extends BaseDao<WsBaseInfoEntity> {
	int delete();
	WsBaseInfoEntity queryInfo();
}
