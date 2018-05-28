package com.idou.modules.wechat.controller;

import com.idou.common.annotation.SysLog;
import com.idou.common.utils.Query;
import com.idou.common.utils.R;
import com.idou.common.validator.ValidatorUtils;
import com.idou.common.validator.group.AddGroup;
import com.idou.common.validator.group.UpdateGroup;
import com.idou.modules.app.dto.ApiItemVo;
import com.idou.modules.app.entity.ApiItemDetailEntity;
import com.idou.modules.app.entity.ApiItemEntity;
import com.idou.modules.app.service.ItemDetailService;
import com.idou.modules.app.service.ItemService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 商品管理
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-11-30 下午 3:00
 **/
@RestController
@RequestMapping("/sysWx/item")
public class WxItemController {
    @Autowired
    private ItemService itemService;
    @Autowired
    private ItemDetailService itemDetailService;

    /**
     * 产品添加
     *
     * @return
     */
    @SysLog("添加产品")
    @PostMapping("/add")
    @RequiresPermissions("wx:item:add")
    public R add(@RequestBody ApiItemVo vo) {
        ValidatorUtils.validateEntity(vo, AddGroup.class);
        itemService.add(vo);
        return R.ok();
    }

    /**
     * 删除
     *
     * @param ids
     * @return
     */
    @SysLog("删除产品信息")
    @RequestMapping("/delete")
    @RequiresPermissions("wx:item:delete")
    public R delete(@RequestBody Long[] ids) {
        itemService.deleteBatch(ids);
        return R.ok();
    }

    /**
     * 修改产品信息
     */
    @SysLog("修改产品信息")
    @RequestMapping("/update")
    @RequiresPermissions("wx:item:update")
    public R update(@RequestBody ApiItemVo vo) {
        ValidatorUtils.validateEntity(vo, UpdateGroup.class);
        itemService.update(vo);
        return R.ok();
    }

    /**
     * 产品列表
     *
     * @param params
     * @return
     */
    @GetMapping("/list")
    @RequiresPermissions("wx:item:list")
    public R queryItemList(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<ApiItemVo> list = itemService.queryList(query);
        int total = itemService.queryTotal(query);
        return R.page(total, list);
    }

    /**
     * 产品详情
     *
     * @param id
     * @return
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("wx:item:info")
    public R queryInfo(@PathVariable("id") Long id) {
        ApiItemVo apiItemVo = itemService.queryInfo(id);
        return R.ok().put("data", apiItemVo);
    }

    /**
     * 查询产品详情
     *
     * @param itemId
     * @return
     */
    @GetMapping("/queryDetailList")
    @RequiresPermissions("wx:item:list")
    public R queryDetailList(@RequestParam("itemId") Long itemId) {
        List<ApiItemDetailEntity> data = itemDetailService.queryListByItemId(itemId);
        return R.ok().put("data", data);
    }

    @GetMapping("/queryAllList")
    @RequiresPermissions("wx:item:list")
    public R queryAllList() {
        List<ApiItemEntity> list = itemService.queryAllList();
        return R.ok().put("data", list);
    }
}
