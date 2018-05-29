package com.idou.modules.api.service.impl;

import com.idou.modules.api.dao.AddressDao;
import com.idou.modules.api.entity.ApiAddressEntity;
import com.idou.modules.api.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 地址
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-12-04 下午 4:55
 **/
@Service("addressService")
public class AddressServiceImpl implements AddressService {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private AddressDao addressDao;

    @Override
    public List<ApiAddressEntity> queryList(Map<String, Object> map) {
        return addressDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return addressDao.queryTotal(map);
    }

    @Override
    public ApiAddressEntity queryInfoById(Long id) {
        return addressDao.queryInfoById(id);
    }

    @Transactional
    @Override
    public void save(ApiAddressEntity entity) {
        // 设置默认
        if (entity.getIsDefault() == 0) {
            addressDao.updateIsDefault(entity);
        }
        addressDao.save(entity);
    }

    @Override
    public List<ApiAddressEntity> queryListByUid(Long userId) {
        return addressDao.queryListByUid(userId);
    }

    @Transactional
    @Override
    public void update(ApiAddressEntity addressEntity) {
        // 设置默认
        if (addressEntity.getIsDefault() == 0) {
            addressDao.updateIsDefault(addressEntity);
        }
        addressDao.updateByInfo(addressEntity);
    }

    @Override
    public void delete(Map<String, Object> map) {
        addressDao.delete(map);
    }
}
