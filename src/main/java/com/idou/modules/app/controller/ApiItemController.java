package com.idou.modules.app.controller;

import com.idou.common.utils.R;
import com.idou.modules.app.entity.ApiItemDetailEntity;
import com.idou.modules.app.service.ItemDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-11-23 下午 3:14
 **/
@RestController
@RequestMapping("/api/item")
@Api("商品接口")
public class ApiItemController {
    @Autowired
    private ItemDetailService itemDetailService;

    /**
     * 根据商品ID查询详情图片列表
     *
     * @param itemId
     * @return
     */
    @PostMapping("/queryDetailList")
    @ApiOperation(value = "查询详情图片列表", notes = "根据商品ID(itemId)获取详情列表(图片列表展现方式),响应字段说明【imgUrl：图片OSS地址】")
    @ApiImplicitParam(name = "itemId", value = "商品编号", required = true, dataType = "Long", paramType = "query")
    public R getDetailList(@RequestParam("itemId") Long itemId) {
        List<ApiItemDetailEntity> data = itemDetailService.queryListByItemId(itemId);
        return R.ok().put("data", data);
    }
}
