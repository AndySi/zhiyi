package com.idou.modules.wechat.controller;

import com.alibaba.fastjson.JSON;
import com.idou.common.annotation.SysLog;
import com.idou.common.utils.Query;
import com.idou.common.utils.R;
import com.idou.common.validator.ValidatorUtils;
import com.idou.common.validator.group.AddGroup;
import com.idou.common.validator.group.UpdateGroup;
import com.idou.modules.api.entity.ApiActivityEntity;
import com.idou.modules.api.service.ActivityService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 活动管理
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-12-29 上午 10:29
 **/
@RestController
@RequestMapping("/sysWx/activity")
public class WxActivityController {
    @Autowired
    private ActivityService activityService;

    @SysLog("添加活动")
    @PostMapping("/add")
    @RequiresPermissions("wx:activity:add")
    public R add(@RequestParam("params") String params) {
        ApiActivityEntity entity = JSON.parseObject(params, ApiActivityEntity.class);
        ValidatorUtils.validateEntity(entity, AddGroup.class);
        activityService.add(entity);
        return R.ok();
    }

    @SysLog("删除活动")
    @RequestMapping("/delete")
    @RequiresPermissions("wx:activity:delete")
    public R delete(@RequestBody Long[] ids) {
        activityService.removeBatch(ids);
        return R.ok();
    }

    @SysLog("修改活动信息")
    @RequestMapping("/update")
    @RequiresPermissions("wx:activity:update")
    public R update(@RequestParam("params") String params) {
        ApiActivityEntity entity = JSON.parseObject(params, ApiActivityEntity.class);
        ValidatorUtils.validateEntity(entity, UpdateGroup.class);
        activityService.modify(entity);
        return R.ok();
    }

    @GetMapping("/list")
    @RequiresPermissions("wx:activity:list")
    public R queryList(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<ApiActivityEntity> list = activityService.queryList(query);
        int total = activityService.queryTotal(query);
        return R.page(total, list);
    }

    @GetMapping("/queryAllList")
    @RequiresPermissions("wx:activity:list")
    public R queryAllList() {
        List<ApiActivityEntity> list = activityService.queryAllList();
        return R.ok().put("data", list);
    }
}
