package com.idou.modules.api.service.impl;

import com.idou.modules.api.dao.WsNewsDao;
import com.idou.modules.api.domain.WsNewsEntity;
import com.idou.modules.api.service.WsNewsService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("wsNewsService")
public class WsNewsServiceImpl implements WsNewsService {
    @Autowired
    private WsNewsDao wsNewsDao;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public WsNewsEntity queryObject(Long id) {
        WsNewsEntity ret = wsNewsDao.queryObject(id);
        if (ret != null) {
            int redisPv = Integer.valueOf(stringRedisTemplate.opsForValue().get("redis_news_pv_" + id));
            int pv = ret.getPv() + redisPv;
            // 访问大于20，写入DB
            if (redisPv > 20) {
                WsNewsEntity entity = new WsNewsEntity();
                entity.setId(id);
                entity.setPv(pv);
                wsNewsDao.update(entity);
                // 清空缓存
                stringRedisTemplate.delete("redis_news_pv_" + id);
            }
            ret.setPv(pv);
        }
        return ret;
    }

    @Override
    public List<WsNewsEntity> queryList(Map<String, Object> map) {
        List<WsNewsEntity> list = wsNewsDao.queryList(map);
        for (WsNewsEntity entity : list) {
            String pv = stringRedisTemplate.opsForValue().get("redis_news_pv_" + entity.getId());
            if (!StringUtils.isEmpty(pv)) {
                entity.setPv(entity.getPv() + Integer.valueOf(pv));
            }
        }
        return list;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return wsNewsDao.queryTotal(map);
    }

    @Override
    public void save(WsNewsEntity wsNews) {
        wsNewsDao.save(wsNews);
    }

    @Override
    public void update(WsNewsEntity wsNews) {
        wsNewsDao.update(wsNews);
    }

    @Override
    public void delete(Long id) {
        wsNewsDao.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        wsNewsDao.deleteBatch(ids);
    }

}
