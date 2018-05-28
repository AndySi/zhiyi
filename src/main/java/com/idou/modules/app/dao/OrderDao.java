package com.idou.modules.app.dao;

import com.idou.modules.app.dto.ApiOrderVo;
import com.idou.modules.app.entity.ApiOrderEntity;
import com.idou.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-11-28 下午 4:54
 **/
public interface OrderDao extends BaseDao<ApiOrderVo> {
    List<ApiOrderVo> queryListByUserId(@Param("userId") Long userId, @Param("offset") int offset, @Param("limit") int limit);

    ApiOrderVo queryDetail(@Param("userId") Long userId, @Param("orderNo") String orderNo);

    ApiOrderEntity queryInfo(@Param("userId") Long userId, @Param("orderNo") String orderNo);

    void saveRobByProcedure(Map<String, Object> map);

    int updateState(ApiOrderEntity entity);
}
