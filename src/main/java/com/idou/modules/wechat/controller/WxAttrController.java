package com.idou.modules.wechat.controller;

import com.idou.common.annotation.SysLog;
import com.idou.common.utils.Query;
import com.idou.common.utils.R;
import com.idou.common.validator.ValidatorUtils;
import com.idou.common.validator.group.AddGroup;
import com.idou.common.validator.group.UpdateGroup;
import com.idou.modules.api.entity.ApiAttrNameEntity;
import com.idou.modules.api.entity.ApiAttrValueEntity;
import com.idou.modules.api.service.AttrService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-12-01 上午 9:28
 **/
@RestController
@RequestMapping("/sysWx/attr")
public class WxAttrController {
    @Autowired
    private AttrService attrService;

    @SysLog("添加属性名")
    @PostMapping("/addName")
    @RequiresPermissions("wx:attrname:add")
    public R addName(@RequestBody ApiAttrNameEntity entity) {
        ValidatorUtils.validateEntity(entity, AddGroup.class);
        attrService.addName(entity);
        return R.ok();
    }

    @SysLog("删除属性名")
    @PostMapping("/deleteName")
    @RequiresPermissions("wx:attrname:delete")
    public R deleteName(@RequestBody Long[] ids) {
        attrService.removeName(ids);
        return R.ok();
    }

    @SysLog("修改属性名")
    @PostMapping("/updateName")
    @RequiresPermissions("wx:attrname:update")
    public R updateName(@RequestBody ApiAttrNameEntity entity) {
        ValidatorUtils.validateEntity(entity, UpdateGroup.class);
        attrService.modifyName(entity);
        return R.ok();
    }

    @GetMapping("/nameList")
    @RequiresPermissions("wx:attrname:list")
    public R nameList(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<ApiAttrNameEntity> list = attrService.queryNameList(query);
        int total = attrService.queryNameCount(query);
        return R.page(total, list);
    }

    /**
     * 属性名树数据
     *
     * @return
     */
    @GetMapping("/queryAllList")
    @RequiresPermissions("wx:attrname:list")
    public R queryAllList() {
        List<ApiAttrNameEntity> list = attrService.queryAllNameList();
        ApiAttrNameEntity entity = new ApiAttrNameEntity();
        entity.setId(0L);
        entity.setName("一级属性");
        entity.setOpen(true);
        entity.setPid(-1L);
        list.add(0, entity);
        return R.ok().put("data", list);
    }

    /**
     * 根据商品ID查询属性名列表
     *
     * @param itemId
     * @return
     */
    @GetMapping("/queryNameListByItemId")
    @RequiresPermissions("wx:attrname:list")
    public R queryNameListByItemId(@RequestParam("itemId") Long itemId) {
        List<ApiAttrNameEntity> list = attrService.queryNameListByItemId(itemId);
        return R.ok().put("data", list);
    }

    /****************************************************************************************/

    /**
     * 根据属性名ID查询属性值列表
     *
     * @return
     */
    @GetMapping("/queryValueListByNameId")
    @RequiresPermissions("wx:attrvalue:list")
    public R queryValueListByNameId(@RequestParam("nameId") Long nameId) {
        List<ApiAttrValueEntity> list = attrService.queryValueListByNameId(nameId);
        return R.ok().put("data", list);
    }

    /**
     * 值列表
     *
     * @param params
     * @return
     */
    @GetMapping("/valueList")
    @RequiresPermissions("wx:attrvalue:list")
    public R valueList(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<ApiAttrValueEntity> list = attrService.queryValueList(query);
        int total = attrService.queryValueCount(query);
        return R.page(total, list);
    }

    @SysLog("添加属性值")
    @PostMapping("/addValue")
    @RequiresPermissions("wx:attrvalue:add")
    public R addValue(@RequestBody ApiAttrValueEntity entity) {
        ValidatorUtils.validateEntity(entity, AddGroup.class);
        attrService.addValue(entity);
        return R.ok();
    }

    @SysLog("删除属性值")
    @PostMapping("/deleteValue")
    @RequiresPermissions("wx:attrvalue:delete")
    public R deleteValue(@RequestBody Long[] ids) {
        attrService.removeValue(ids);
        return R.ok();
    }

    @SysLog("修改属性值")
    @PostMapping("/updateValue")
    @RequiresPermissions("wx:attrvalue:update")
    public R updateValue(@RequestBody ApiAttrValueEntity entity) {
        ValidatorUtils.validateEntity(entity, UpdateGroup.class);
        attrService.modifyValue(entity);
        return R.ok();
    }
}
