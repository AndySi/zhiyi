package com.idou.modules.wechat.controller;

import com.idou.common.annotation.SysLog;
import com.idou.common.utils.Query;
import com.idou.common.utils.R;
import com.idou.common.validator.ValidatorUtils;
import com.idou.common.validator.group.AddGroup;
import com.idou.modules.api.entity.ApiActivityItemEntity;
import com.idou.modules.api.entity.ApiItemSkuEntity;
import com.idou.modules.api.service.ActivityItemService;
import com.idou.modules.api.service.ItemSkuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 活动-商品管理
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-12-29 上午 10:29
 **/
@RestController
@RequestMapping("/sysWx/activityItem")
public class WxActivityItemController {
    @Autowired
    private ActivityItemService activityItemService;
    @Autowired
    private ItemSkuService itemSkuService;

    @SysLog("添加活动商品")
    @PostMapping("/add")
    @RequiresPermissions("wx:activityitem:add")
    public R add(@RequestBody ApiActivityItemEntity entity) {
        ValidatorUtils.validateEntity(entity, AddGroup.class);
        activityItemService.add(entity);
        return R.ok();
    }

    @SysLog("删除活动商品")
    @RequestMapping("/delete")
    @RequiresPermissions("wx:activityitem:delete")
    public R delete(@RequestBody Long[] ids) {
        activityItemService.removeBatch(ids);
        return R.ok();
    }

    @GetMapping("/list")
    @RequiresPermissions("wx:activityitem:list")
    public R queryList(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<ApiActivityItemEntity> list = activityItemService.queryList(query);
        int total = activityItemService.queryTotal(query);
        return R.page(total, list);
    }

    @GetMapping("/queryItemList")
    @RequiresPermissions("wx:item:list")
    public R queryItemList() {
        List<ApiItemSkuEntity> list = itemSkuService.queryActivityList();
        return R.ok().put("data", list);
    }
}
