package com.idou.modules.api.service.impl;

import com.idou.modules.api.dao.WsCaseDao;
import com.idou.modules.api.domain.WsCaseEntity;
import com.idou.modules.api.service.WsCaseService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("wsCaseService")
public class WsCaseServiceImpl implements WsCaseService {
    @Autowired
    private WsCaseDao wsCaseDao;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public WsCaseEntity queryObject(Long id) {
        WsCaseEntity ret = wsCaseDao.queryObject(id);
        int redisPv = Integer.valueOf(stringRedisTemplate.opsForValue().get("redis_case_pv_" + id));
        int pv = ret.getPv() + redisPv;
        // 访问大于20，写入DB
        if (redisPv > 20) {
            WsCaseEntity entity = new WsCaseEntity();
            entity.setId(id);
            entity.setPv(pv);
            wsCaseDao.update(entity);
            // 清空缓存
            stringRedisTemplate.delete("redis_case_pv_" + id);
        }
        ret.setPv(pv);
        return ret;
    }

    @Override
    public List<WsCaseEntity> queryList(Map<String, Object> map) {
        List<WsCaseEntity> list = wsCaseDao.queryList(map);
        for (WsCaseEntity entity : list) {
            String pv = stringRedisTemplate.opsForValue().get("redis_case_pv_" + entity.getId());
            if (!StringUtils.isEmpty(pv)) {
                entity.setPv(entity.getPv() + Integer.valueOf(pv));
            }
        }
        return list;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return wsCaseDao.queryTotal(map);
    }

    @Override
    public void save(WsCaseEntity wsCase) {
        wsCaseDao.save(wsCase);
    }

    @Override
    public void update(WsCaseEntity wsCase) {
        wsCaseDao.update(wsCase);
    }

    @Override
    public void delete(Long id) {
        wsCaseDao.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        wsCaseDao.deleteBatch(ids);
    }

    @Override
    public List<WsCaseEntity> queryALlList() {
        return wsCaseDao.queryAllList();
    }

}
