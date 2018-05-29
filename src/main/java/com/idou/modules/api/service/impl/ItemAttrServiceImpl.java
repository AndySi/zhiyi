package com.idou.modules.api.service.impl;

import com.idou.common.exception.RRException;
import com.idou.modules.api.dao.ItemAttrDao;
import com.idou.modules.api.entity.ApiItemAttrEntity;
import com.idou.modules.api.service.ItemAttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 商品属性
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-12-21 下午 1:41
 **/
@Service("itemAttrService")
public class ItemAttrServiceImpl implements ItemAttrService {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private ItemAttrDao itemAttrDao;

    @Override
    public List<ApiItemAttrEntity> queryListByItemId(Long itemId) {
        return itemAttrDao.queryListByItemId(itemId);
    }

    @Override
    public void add(ApiItemAttrEntity entity) {
        int r = itemAttrDao.add(entity);
        if (r == 0) {
            throw new RRException("不能重复添加");
        }
    }

    @Override
    public void modify(ApiItemAttrEntity entity) {
        itemAttrDao.update(entity);
    }

    @Override
    public void removeBatch(Long[] ids) {
        itemAttrDao.deleteBatch(ids);
    }

    @Override
    public List<ApiItemAttrEntity> queryList(Map<String, Object> map) {
        return itemAttrDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return itemAttrDao.queryTotal(map);
    }
}
