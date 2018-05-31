package com.idou.modules.sysEx.controller;


import com.alibaba.fastjson.JSONObject;
import com.idou.common.constant.CodeMsg;
import com.idou.common.utils.Query;
import com.idou.common.utils.R;
import com.idou.modules.api.domain.WsCaseEntity;
import com.idou.modules.api.service.WsCaseService;
import com.idou.modules.sysEx.utils.DateUtils;
import com.idou.modules.sysEx.utils.ImageUtils;
import com.idou.modules.sysEx.utils.KeyBuilder;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @author zhangSi
 * @email andy_si@163.com
 * @date 2018-05-29 16:21:07
 */
@RestController
@RequestMapping("/sysWs/wscase")
public class WsCaseController {
    private static Logger logger = LoggerFactory.getLogger(WsCaseController.class);
    @Autowired
    private WsCaseService wsCaseService;

    /**
     * 封面图片上传
     *
     * @param mf
     * @return
     */
    @RequestMapping(value = "/uploadCover", method = RequestMethod.POST)
    public R uploadImg(@RequestParam(value = "file") MultipartFile mf) {
        return ImageUtils.uploadSave(mf, "case");
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sysWs:wscase:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<WsCaseEntity> list = wsCaseService.queryList(query);
        int total = wsCaseService.queryTotal(query);

        return R.page(total, list);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sysWs:wscase:info")
    public R info(@PathVariable("id") Long id) {
        WsCaseEntity wsCase = wsCaseService.queryObject(id);

        return R.ok().put("data", wsCase);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sysWs:wscase:add")
    public R save(@RequestBody WsCaseEntity wsCase) {
        wsCaseService.save(wsCase);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sysWs:wscase:update")
    public R update(@RequestBody WsCaseEntity wsCase) {
        wsCaseService.update(wsCase);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sysWs:wscase:delete")
    public R delete(@RequestBody Long[] ids) {
        wsCaseService.deleteBatch(ids);

        return R.ok();
    }

}
