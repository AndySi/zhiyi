package com.idou.modules.api.dao;

import com.idou.modules.api.dto.ApiItemVo;
import com.idou.modules.api.entity.ApiItemEntity;
import com.idou.modules.sysBs.dao.BaseDao;

import java.util.List;

/**
 * 商品
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-11-23 下午 5:29
 **/
public interface ItemDao extends BaseDao<ApiItemVo>{
    int queryListByTid(Long typeId);
    ApiItemVo queryInfo(Long id);

    List<ApiItemEntity> queryAllList();
}
