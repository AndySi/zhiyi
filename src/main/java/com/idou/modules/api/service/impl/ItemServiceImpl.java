package com.idou.modules.api.service.impl;

import com.idou.common.exception.RRException;
import com.idou.modules.api.dao.ItemDao;
import com.idou.modules.api.dao.ItemDetailDao;
import com.idou.modules.api.dto.ApiItemVo;
import com.idou.modules.api.entity.ApiItemEntity;
import com.idou.modules.api.service.ItemService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-11-30 下午 3:08
 **/
@Service("itemService")
public class ItemServiceImpl implements ItemService {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private ItemDao itemDao;
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private ItemDetailDao itemDetailDao;

    @Override
    public List<ApiItemEntity> queryAllList() {
        return itemDao.queryAllList();
    }

    @Override
    public ApiItemVo queryInfo(Long id) {
        return itemDao.queryInfo(id);
    }

    @Override
    public List<ApiItemVo> queryList(Map<String, Object> map) {
        return itemDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return itemDao.queryTotal(map);
    }

    @Transactional(noRollbackFor = RuntimeException.class)
    @Override
    public void add(ApiItemVo vo) {
        try {
            itemDao.save(vo);
            Map<String, Object> map = new HashMap<>();
            map.put("itemId", vo.getId());
            map.put("imgUrlList", vo.getDetailArr());
            itemDetailDao.save(map);
        } catch (Exception e) {
            Logger.getLogger(getClass()).info(e.getMessage());
            throw new RRException(e.getMessage());
        }
    }

    @Transactional(noRollbackFor = RuntimeException.class)
    @Override
    public void update(ApiItemVo vo) {
        try {
            itemDao.update(vo);
            if (vo.getDetailArr() != null) {
                // 详情列表不为空，先删除再添加
                itemDetailDao.delete(vo.getId());
                Map<String, Object> map = new HashMap<>();
                map.put("itemId", vo.getId());
                map.put("imgUrlList", vo.getDetailArr());
                itemDetailDao.save(map);
            }
        } catch (Exception e) {
            Logger.getLogger(getClass()).info(e.getMessage());
            throw new RRException(e.getMessage());
        }
    }

    @Override
    public void deleteBatch(Long[] ids) {
        itemDao.deleteBatch(ids);
    }
}
