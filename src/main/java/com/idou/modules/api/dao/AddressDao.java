package com.idou.modules.api.dao;

import com.idou.modules.api.entity.ApiAddressEntity;
import com.idou.modules.sysBs.dao.BaseDao;

import java.util.List;

/**
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-12-04 下午 4:12
 **/
public interface AddressDao extends BaseDao<ApiAddressEntity>{
    ApiAddressEntity queryInfoById(Long userId);
    List<ApiAddressEntity> queryListByUid(Long userId);
    int updateByInfo(ApiAddressEntity addressEntity);
    int updateIsDefault(ApiAddressEntity addressEntity);
}
