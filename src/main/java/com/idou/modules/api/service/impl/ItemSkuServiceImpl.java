package com.idou.modules.api.service.impl;

import com.idou.common.exception.RRException;
import com.idou.modules.api.dao.ItemAttrDao;
import com.idou.modules.api.dao.ItemSkuDao;
import com.idou.modules.api.entity.ApiItemAttrEntity;
import com.idou.modules.api.entity.ApiItemSkuEntity;
import com.idou.modules.api.service.ItemSkuService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-12-22 上午 11:07
 **/
@Service("itemSkuService")
public class ItemSkuServiceImpl implements ItemSkuService {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private ItemAttrDao itemAttrDao;
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private ItemSkuDao itemSkuDao;

    @Override
    public List<ApiItemSkuEntity> queryList(Map<String, Object> map) {
        List<ApiItemSkuEntity> list = itemSkuDao.queryList(map);
        for (ApiItemSkuEntity entity : list) {
            List ids = Arrays.asList(StringUtils.split(entity.getAttr(),","));
            StringBuilder sb = new StringBuilder();
            for (ApiItemAttrEntity bean : itemAttrDao.queryListByIds(ids)){
                sb.append(bean.getAttrName()+":"+bean.getAttrValue());
                sb.append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            entity.setAttrInfo(sb.toString());
        }
        return list;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return itemSkuDao.queryTotal(map);
    }

    @Override
    public void add(ApiItemSkuEntity entity) {
        int i = itemSkuDao.add(entity);
        if(i == 0){
            throw new RRException("不能重复添加");
        }
    }

    @Override
    public void modify(ApiItemSkuEntity entity) {
        // TODO 需要判断
        itemSkuDao.update(entity);
    }

    @Override
    public void removeBatch(Long[] ids) {
        itemSkuDao.deleteBatch(ids);
    }


    @Override
    public List<ApiItemSkuEntity> queryActivityList() {
        return itemSkuDao.queryActivityList();
    }
}
