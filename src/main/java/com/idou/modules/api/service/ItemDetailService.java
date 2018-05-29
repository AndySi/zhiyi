package com.idou.modules.api.service;

import com.idou.modules.api.entity.ApiItemDetailEntity;

import java.util.List;

/**
 * @author:ZhangSi
 * @email:andy_si@163.com
 * @date:2017/12/6
 */
public interface ItemDetailService {
    List<ApiItemDetailEntity> queryListByItemId(Long itemId);
}
