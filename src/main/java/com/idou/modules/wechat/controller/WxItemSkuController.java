package com.idou.modules.wechat.controller;

import com.idou.common.annotation.SysLog;
import com.idou.common.utils.Query;
import com.idou.common.utils.R;
import com.idou.common.validator.ValidatorUtils;
import com.idou.common.validator.group.AddGroup;
import com.idou.common.validator.group.UpdateGroup;
import com.idou.modules.app.entity.ApiItemSkuEntity;
import com.idou.modules.app.service.ItemSkuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-12-22 上午 11:29
 **/
@RequestMapping("/sysWx/itemSku")
@RestController
public class WxItemSkuController {
    @Autowired
    private ItemSkuService itemSkuService;

    @SysLog("新增产品库存")
    @PostMapping("/add")
    @RequiresPermissions("wx:itemsku:add")
    public R add(@RequestBody ApiItemSkuEntity entity) {
        ValidatorUtils.validateEntity(entity, AddGroup.class);
        itemSkuService.add(entity);
        return R.ok();
    }

    @SysLog("修改产品库存")
    @PostMapping("/update")
    @RequiresPermissions("wx:itemsku:update")
    public R update(@RequestBody ApiItemSkuEntity entity) {
        ValidatorUtils.validateEntity(entity, UpdateGroup.class);
        itemSkuService.modify(entity);
        return R.ok();
    }

    @SysLog("删除产品库存")
    @PostMapping("/delete")
    @RequiresPermissions("wx:itemsku:delete")
    public R deleteBatch(@RequestBody Long[] ids) {
        itemSkuService.removeBatch(ids);
        return R.ok();
    }
    /**
     * 产品列表
     *
     * @param params
     * @return
     */
    @GetMapping("/list")
    @RequiresPermissions("wx:itemsku:list")
    public R queryItemList(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<ApiItemSkuEntity> list = itemSkuService.queryList(query);
        int total = itemSkuService.queryTotal(query);
        return R.page(total, list);
    }
}
