package com.idou.modules.api.dao;

import com.idou.modules.api.domain.WsActivityTypeEntity;
import com.idou.modules.sysBs.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author zhangSi
 * @email andy_si@163.com
 * @date 2018-05-29 16:21:07
 */
@Mapper
public interface WsActivityTypeDao extends BaseDao<WsActivityTypeEntity> {

    List<WsActivityTypeEntity> queryAllList();
}
