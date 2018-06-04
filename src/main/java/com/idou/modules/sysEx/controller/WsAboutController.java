package com.idou.modules.sysEx.controller;

import com.alibaba.fastjson.JSONObject;
import com.idou.common.exception.RRException;
import com.idou.common.utils.R;
import com.idou.modules.api.domain.WsAboutEntity;
import com.idou.modules.api.domain.WsAboutListEntity;
import com.idou.modules.api.service.WsAboutService;
import com.idou.modules.sysEx.utils.ImageUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author:ZhangSi
 * @email:andy_si@163.com
 * @date:2018/6/2
 */
@RestController
@RequestMapping("/sysWs/wsabout")
public class WsAboutController {
    private static Logger logger = LoggerFactory.getLogger(WsAboutController.class);

    @Autowired
    private WsAboutService wsAboutService;

    /**
     * 图片上传
     *
     * @param mf
     * @return
     */
    @RequestMapping(value = "/uploadImg", method = RequestMethod.POST)
    @RequiresPermissions("sysWs:wsabout:add")
    public R uploadImg(@RequestParam(value = "file") MultipartFile mf) {
        try {
            R r = ImageUtils.uploadSave(mf, "about");
            JSONObject jsonObject = JSONObject.parseObject(r.get("data").toString());
            WsAboutEntity entity = new WsAboutEntity();
            entity.setCover(jsonObject.getString("src"));
            wsAboutService.save(entity);
            return r;
        } catch (Exception e) {
            throw new RRException(e.getLocalizedMessage());
        }
    }

    @RequestMapping(value = "/uploadContent", method = RequestMethod.POST)
    @RequiresPermissions("sysWs:wsabout:add")
    public R uploadContent(@RequestParam(value = "file") MultipartFile mf) {
           return ImageUtils.uploadSave(mf, "about");
    }

    @RequestMapping("/getInfo")
    @RequiresPermissions("sysWs:wsabout:info")
    public R getInfo() {
        return R.ok().put("data", wsAboutService.queryObject());
    }

    @RequestMapping("/getList")
    @RequiresPermissions("sysWs:wsabout:list")
    public R getList() {
        return R.page(0, wsAboutService.queryList());
    }

    @RequestMapping("/save")
    @RequiresPermissions("sysWs:wsabout:add")
    public R save(@RequestBody WsAboutListEntity entity) {
        wsAboutService.saveList(entity);
        return R.ok();
    }

    /**
     * 修改
     *
     * @param entity
     * @return
     */
    @RequestMapping("/update")
    @RequiresPermissions("sysWs:banner:update")
    public R update(@RequestBody WsAboutListEntity entity) {
        wsAboutService.update(entity);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sysWs:banner:del")
    public R delete(@RequestBody Long[] ids) {
        wsAboutService.deleteBatch(ids);
        return R.ok();
    }
}
