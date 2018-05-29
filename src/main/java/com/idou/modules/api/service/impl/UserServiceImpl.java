package com.idou.modules.api.service.impl;

import com.idou.modules.api.dao.UserDao;
import com.idou.modules.api.entity.ApiUserEntity;
import com.idou.modules.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-08-08 上午 9:29
 **/
@Service("userService")
public class UserServiceImpl implements UserService {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private UserDao userDao;

    @Override
    public void updateStatu(Map<String, Object> map) {
        userDao.updateStatu(map);
    }

    @Override
    public List<ApiUserEntity> queryList(Map<String, Object> map) {
        return userDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return userDao.queryTotal(map);
    }

    @Override
    public ApiUserEntity saveOrUpdate(ApiUserEntity entity) {
        userDao.saveOrUpdate(entity);
        return entity;
    }

    @Override
    public ApiUserEntity queryObject(Long userId) {
        return userDao.queryObject(userId);
    }

}
