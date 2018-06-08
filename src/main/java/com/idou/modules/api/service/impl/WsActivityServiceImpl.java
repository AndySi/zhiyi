package com.idou.modules.api.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.idou.modules.api.dao.WsActivityDao;
import com.idou.modules.api.domain.WsActivityEntity;
import com.idou.modules.api.service.WsActivityService;
import com.idou.modules.sysEx.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


@Service
public class WsActivityServiceImpl implements WsActivityService {
    @Autowired
    private WsActivityDao wsActivityDao;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private String REDIS_ACTIVITY_KEY = "activity_id_";

    @Override
    public WsActivityEntity queryObject(Long id) {
        WsActivityEntity entity = wsActivityDao.queryObject(id);
        if (!StringUtils.isEmpty(stringRedisTemplate.opsForValue().get(REDIS_ACTIVITY_KEY + id))) {
            entity.setPoll(entity.getPoll() + Integer.valueOf(stringRedisTemplate.opsForValue().get(REDIS_ACTIVITY_KEY + id)));
        }
        return entity;
    }

    @Override
    public List<WsActivityEntity> queryList(Map<String, Object> map) {
        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        List<WsActivityEntity> list = wsActivityDao.queryList(map);
        for (WsActivityEntity entity : list) {
            if (!StringUtils.isEmpty(opsForValue.get(REDIS_ACTIVITY_KEY + entity.getId()))) {
                entity.setPoll(entity.getPoll() + Integer.valueOf(opsForValue.get(REDIS_ACTIVITY_KEY + entity.getId())));
            }
        }
        return list;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return wsActivityDao.queryTotal(map);
    }

    @Override
    public void save(WsActivityEntity wsNews) {
        wsActivityDao.save(wsNews);
    }

    @Override
    public void update(WsActivityEntity wsNews) {
        wsActivityDao.update(wsNews);
    }

    @Override
    public void delete(Long id) {
        wsActivityDao.delete(id);
    }

    @Override
    public void deleteBatch(Long[] ids) {
        wsActivityDao.deleteBatch(ids);
    }


    @Override
    public boolean doPoll(Long id, String ip) {
        boolean b = false;
        // 规则：活动ID+当前年月日+IP
        String key = id + DateUtils.getYmd() + ip;
        String ipNum = stringRedisTemplate.opsForValue().get(key);
        if(!StringUtils.isEmpty(ipNum)){
            b = true;
        }
        // 用户同一IP每天投票数存入redis，设置生命周期为一天
        stringRedisTemplate.opsForValue().set(key, "1");
        // 此活动投票数累计+1
        stringRedisTemplate.opsForValue().increment(REDIS_ACTIVITY_KEY + id, 1);
        stringRedisTemplate.expire(key, 1, TimeUnit.DAYS);

        String pollNum = stringRedisTemplate.opsForValue().get(REDIS_ACTIVITY_KEY + id);
        if(!StringUtils.isEmpty(pollNum)){
            // 投票数大于10加入数据库
            int poll = Integer.valueOf(pollNum);
            if (poll > 10) {
                WsActivityEntity entity = new WsActivityEntity();
                entity.setId(id);
                entity.setPoll(poll);
                wsActivityDao.updatePoll(entity);
                // 清空缓存数据
                stringRedisTemplate.delete(REDIS_ACTIVITY_KEY + id);
            }
        }

        return b;
    }

}
