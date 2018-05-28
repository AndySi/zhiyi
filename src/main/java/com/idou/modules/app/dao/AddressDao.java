package com.idou.modules.app.dao;

import com.idou.modules.app.entity.ApiAddressEntity;
import com.idou.modules.sys.dao.BaseDao;

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
