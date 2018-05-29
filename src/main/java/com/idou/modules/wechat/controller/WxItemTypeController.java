package com.idou.modules.wechat.controller;

import com.idou.common.annotation.SysLog;
import com.idou.common.utils.Query;
import com.idou.common.utils.R;
import com.idou.common.validator.ValidatorUtils;
import com.idou.common.validator.group.AddGroup;
import com.idou.common.validator.group.UpdateGroup;
import com.idou.modules.api.entity.ApiItemTypeEntity;
import com.idou.modules.api.service.ItemTypeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 商品分类
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-12-05 下午 4:00
 **/
@RestController
@RequestMapping("/sysWx/itemType")
public class WxItemTypeController {
    @Autowired
    private ItemTypeService itemTypeService;

    @SysLog("新增产品类型")
    @PostMapping("/add")
    @RequiresPermissions("wx:itemtype:add")
    public R add(@RequestBody ApiItemTypeEntity itemType) {
        ValidatorUtils.validateEntity(itemType, AddGroup.class);
        itemTypeService.add(itemType);
        return R.ok();
    }

    @SysLog("修改产品类型")
    @PostMapping("/update")
    @RequiresPermissions("wx:itemtype:update")
    public R update(@RequestBody ApiItemTypeEntity itemType) {
        ValidatorUtils.validateEntity(itemType, UpdateGroup.class);
        itemTypeService.update(itemType);
        return R.ok();
    }

    @SysLog("删除产品类型")
    @PostMapping("/delete")
    @RequiresPermissions("wx:itemtype:delete")
    public R deleteBatch(@RequestBody Long[] ids) {
        itemTypeService.deleteBatch(ids);
        return R.ok();
    }

    /**
     * 产品分类列表-查询列表
     *
     * @param params
     * @return
     */
    @GetMapping("/list")
    @RequiresPermissions("wx:itemtype:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<ApiItemTypeEntity> list = itemTypeService.queryList(query);
        int total = itemTypeService.queryTotal(query);
        return R.page(total, list);
    }

    /**
     * 产品列表 - 查询分类列表
     *
     * @return
     */
    @RequestMapping("/queryAllList")
    @RequiresPermissions("wx:itemtype:list")
    public R queryAllList() {
        //查询列表数据
        List<ApiItemTypeEntity> list = itemTypeService.queryAllList();
        //添加顶级菜单
        ApiItemTypeEntity entity = new ApiItemTypeEntity();
        entity.setId(0L);
        entity.setName("一级分类");
        entity.setOpen(true);
        entity.setPid(-1L);

        list.add(0, entity);
        return R.ok().put("data", list);
    }

    /**
     * 属性名-商品类别选择
     *
     * @return
     */
    @GetMapping("/queryTreeList")
    @RequiresPermissions("wx:itemtype:list")
    public R queryTreeList() {
        //查询列表数据
        List<ApiItemTypeEntity> list = itemTypeService.queryAllList();
        return R.ok().put("data", list);
    }
}
