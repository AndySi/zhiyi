package com.idou.modules.api.service.impl;

import com.idou.modules.api.dao.ItemDetailDao;
import com.idou.modules.api.entity.ApiItemDetailEntity;
import com.idou.modules.api.service.ItemDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:ZhangSi
 * @email:andy_si@163.com
 * @date:2017/12/6
 */
@Service("itemDetailService")
public class ItemDetailServiceImpl implements ItemDetailService {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private ItemDetailDao itemDetailDao;

    @Override
    public List<ApiItemDetailEntity> queryListByItemId(Long itemId) {
        return itemDetailDao.queryListByItemId(itemId);
    }
}
