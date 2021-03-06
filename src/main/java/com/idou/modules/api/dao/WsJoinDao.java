package com.idou.modules.api.dao;

import com.idou.modules.api.domain.WsJoinEntity;
import com.idou.modules.sysBs.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author zhangSi
 * @email andy_si@163.com
 * @date 2018-05-29 16:21:07
 */
@Mapper
public interface WsJoinDao extends BaseDao<WsJoinEntity> {

    WsJoinEntity queryInfo();

    int del();
}
