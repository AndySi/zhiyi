package com.idou.modules.app.dao;

import com.idou.modules.app.dto.ApiItemVo;
import com.idou.modules.app.entity.ApiItemEntity;
import com.idou.modules.sys.dao.BaseDao;

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
