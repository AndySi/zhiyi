package com.idou.modules.api.service.impl;

import com.idou.common.exception.RRException;
import com.idou.modules.api.dao.ItemDao;
import com.idou.modules.api.dao.ItemTypeDao;
import com.idou.modules.api.entity.ApiItemTypeEntity;
import com.idou.modules.api.service.ItemTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-12-05 下午 4:10
 **/
@Service("itemTypeService")
public class ItemTypeServiceImpl implements ItemTypeService {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private ItemTypeDao itemTypeDao;
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private ItemDao itemDao;

    @Override
    public List<ApiItemTypeEntity> queryList(Map<String, Object> map) {
        return itemTypeDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return itemTypeDao.queryTotal(map);
    }

    @Override
    public List<ApiItemTypeEntity> queryAllList() {
        // 查询根类型列表
        List<ApiItemTypeEntity> list = queryListParentId(0L);
        // 递归获取子分类信息
        getTreeList(list);
        return list;
    }

    @Override
    public void add(ApiItemTypeEntity itemType) {
        itemTypeDao.save(itemType);
    }

    @Override
    public void update(ApiItemTypeEntity itemType) {
        itemTypeDao.update(itemType);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        // 删除之前判断是否跟商品关联
        List<Long> idsArr = new ArrayList<>();
        for (Long id : ids) {
            int r = itemDao.queryListByTid(id);
            if (r > 0) {
                throw new RRException("类型ID为"+id+"已有商品关联，不能删除");
            }
            idsArr.add(id);
        }
        if (idsArr.size() > 0) {
            itemTypeDao.deleteBatch(idsArr);
        }
    }

    private List<ApiItemTypeEntity> queryListParentId(Long pid) {
        return itemTypeDao.queryTypeListByPid(pid);
    }

    private List<ApiItemTypeEntity> getTreeList(List<ApiItemTypeEntity> rootType) {
        List<ApiItemTypeEntity> subList = new ArrayList();
        for (ApiItemTypeEntity entity : rootType) {
            entity.setList(getTreeList(queryListParentId(entity.getId())));
            subList.add(entity);
        }
        return subList;
    }
}
