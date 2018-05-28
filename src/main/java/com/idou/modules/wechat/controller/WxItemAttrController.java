package com.idou.modules.wechat.controller;

import com.idou.common.annotation.SysLog;
import com.idou.common.utils.Query;
import com.idou.common.utils.R;
import com.idou.common.validator.ValidatorUtils;
import com.idou.common.validator.group.AddGroup;
import com.idou.common.validator.group.UpdateGroup;
import com.idou.modules.app.entity.ApiItemAttrEntity;
import com.idou.modules.app.service.ItemAttrService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 商品属性
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-12-21 下午 1:44
 **/
@RestController
@RequestMapping("/sysWx/itemAttr")
public class WxItemAttrController {
    @Autowired
    private ItemAttrService itemAttrService;

    @SysLog("添加商品属性")
    @PostMapping("/add")
    @RequiresPermissions("wx:itemattr:add")
    public R add(@RequestBody ApiItemAttrEntity entity) {
        ValidatorUtils.validateEntity(entity, AddGroup.class);
        itemAttrService.add(entity);
        return R.ok();
    }

    @SysLog("删除商品属性")
    @PostMapping("/delete")
    @RequiresPermissions("wx:itemattr:delete")
    public R delete(@RequestBody Long[] ids) {
        itemAttrService.removeBatch(ids);
        return R.ok();
    }

    @SysLog("修改商品属性")
    @PostMapping("/update")
    @RequiresPermissions("wx:itemattr:update")
    public R update(@RequestBody ApiItemAttrEntity entity) {
        ValidatorUtils.validateEntity(entity, UpdateGroup.class);
        itemAttrService.modify(entity);
        return R.ok();
    }

    @GetMapping("/list")
    @RequiresPermissions("wx:itemattr:list")
    public R queryList(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<ApiItemAttrEntity> list = itemAttrService.queryList(query);
        int total = itemAttrService.queryTotal(query);
        return R.page(total, list);
    }

    /**
     * 根据产品ID查询相关属性列表
     *
     * @param itemId
     * @return
     */
    @GetMapping("/queryListByItemId")
    @RequiresPermissions("wx:itemattr:list")
    public R queryListByItemId(@RequestParam Long itemId) {
        List<ApiItemAttrEntity> data = itemAttrService.queryListByItemId(itemId);
        return R.ok().put("data", data);
    }
}
