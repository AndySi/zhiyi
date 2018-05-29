package com.idou.modules.api.service.impl;

import com.idou.common.exception.RRException;
import com.idou.modules.api.dao.AttrDao;
import com.idou.modules.api.entity.ApiAttrNameEntity;
import com.idou.modules.api.entity.ApiAttrValueEntity;
import com.idou.modules.api.service.AttrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-12-19 下午 3:37
 **/
@Service("attrService")
public class AttrServiceImpl implements AttrService {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private AttrDao attrDao;

    @Override
    public void addName(ApiAttrNameEntity entity) {
        // 检查是否重复添加
        int c = attrDao.queryNameCountBy(entity);
        if (c > 0) {
            throw new RRException("不能重复添加");
        }
        attrDao.saveName(entity);
    }

    @Override
    public void modifyName(ApiAttrNameEntity entity) {
        attrDao.updateName(entity);
    }

    @Override
    public void removeName(Long[] ids) {
        attrDao.deleteBatchName(ids);
    }

    @Override
    public List<ApiAttrNameEntity> queryAllNameList() {
        List<ApiAttrNameEntity> list = queryNameListByPid(0L);
        getTreeList(list);
        return list;
    }

    @Override
    public List<ApiAttrNameEntity> queryNameListByItemId(Long itemId) {
        return attrDao.queryNameListByItemId(itemId);
    }

    @Override
    public List<ApiAttrNameEntity> queryNameList(Map<String, Object> map) {
        return attrDao.queryNameList(map);
    }

    @Override
    public int queryNameCount(Map<String, Object> map) {
        return attrDao.queryNameTotal(map);
    }

    @Override
    public void addValue(ApiAttrValueEntity entity) {
        int c = attrDao.queryValueCountBy(entity);
        if (c > 0) {
            throw new RRException("不能重复添加");
        }
        attrDao.saveValue(entity);
    }

    @Override
    public void modifyValue(ApiAttrValueEntity entity) {
        attrDao.updateValue(entity);
    }

    @Override
    public void removeValue(Long[] ids) {
        attrDao.deleteBatchValue(ids);
    }

    @Override
    public List<ApiAttrValueEntity> queryValueList(Map<String, Object> map) {
        return attrDao.queryValueList(map);
    }

    @Override
    public int queryValueCount(Map<String, Object> map) {
        return attrDao.queryValueTotal(map);
    }

    @Override
    public List<ApiAttrValueEntity> queryValueListByNameId(Long nameId) {
        return attrDao.queryValueListByNameId(nameId);
    }

    private List<ApiAttrNameEntity> queryNameListByPid(Long pid) {
        return attrDao.queryNameListByPid(pid);
    }

    private List<ApiAttrNameEntity> getTreeList(List<ApiAttrNameEntity> rootList) {
        List<ApiAttrNameEntity> subList = new ArrayList<>();
        for (ApiAttrNameEntity entity : rootList) {
            entity.setList(getTreeList(queryNameListByPid(entity.getId())));
            subList.add(entity);
        }
        return subList;
    }
}
