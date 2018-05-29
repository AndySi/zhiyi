package com.idou.modules.wechat.controller;

import com.idou.common.annotation.SysLog;
import com.idou.common.utils.Query;
import com.idou.common.utils.R;
import com.idou.common.validator.ValidatorUtils;
import com.idou.common.validator.group.UpdateGroup;
import com.idou.modules.api.dto.ApiOrderVo;
import com.idou.modules.api.service.OrderService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2018-01-02 下午 1:22
 **/
@RequestMapping("/sysWx/order")
@RestController
public class WxOrderController {
    @Autowired
    private OrderService orderService;
    /**
     * 订单列表
     *
     * @param params
     * @return
     */
    @GetMapping("/list")
    @RequiresPermissions("wx:order:list")
    public R queryItemList(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<ApiOrderVo> list = orderService.queryList(query);
        int total = orderService.queryTotal(query);
        return R.page(total, list);
    }

    /**
     * 修改订单信息
     */
    @SysLog("修改订单信息")
    @RequestMapping("/update")
    @RequiresPermissions("wx:order:update")
    public R update(@RequestBody ApiOrderVo vo) {
        ValidatorUtils.validateEntity(vo, UpdateGroup.class);
        orderService.modify(vo);
        return R.ok();
    }


}
