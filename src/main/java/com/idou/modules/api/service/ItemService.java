package com.idou.modules.api.service;

import com.idou.modules.api.dto.ApiItemVo;
import com.idou.modules.api.entity.ApiItemEntity;

import java.util.List;
import java.util.Map;

/**
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-11-30 下午 3:07
 **/

public interface ItemService {
    /**
     * b-查询所有数量
     *
     * @return
     */
    List<ApiItemEntity> queryAllList();

    /**
     * b-详情
     *
     * @param id
     * @return
     */
    ApiItemVo queryInfo(Long id);

    /**
     * b-列表
     *
     * @param map
     * @return
     */
    List<ApiItemVo> queryList(Map<String, Object> map);

    /**
     * b
     *
     * @param map
     * @return
     */
    int queryTotal(Map<String, Object> map);

    /**
     * b-添加产品
     */
    void add(ApiItemVo vo);

    /**
     * b-修改产品
     *
     * @param vo
     */
    void update(ApiItemVo vo);

    /**
     * b-删除产品
     *
     * @param ids
     */
    void deleteBatch(Long[] ids);
}
