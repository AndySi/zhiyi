package com.idou.modules.sysEx.controller;

import com.idou.common.utils.Query;
import com.idou.common.utils.R;
import com.idou.modules.api.domain.WsBannerEntity;
import com.idou.modules.api.service.WsBannerService;
import com.idou.modules.api.service.WsCaseService;
import com.idou.modules.sysEx.utils.ImageUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;


/**
 * @author zhangSi
 * @email andy_si@163.com
 * @date 2018-05-29 16:21:07
 */
@RestController
@RequestMapping("/sysWs/wsbanner")
public class WsBannerController {
    @Autowired
    private WsBannerService wsBannerService;
    @Autowired
    private WsCaseService wsCaseService;

    /**
     * 查询所有的案例
     *
     * @return
     */
    @RequestMapping("/getCaseList")
    public R getCaseList() {
        return R.ok().put("data", wsCaseService.queryALlList());
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sysWs:banner:info")
    public R info(@PathVariable("id") Long id) {
        WsBannerEntity wb = wsBannerService.queryObject(id);
        return R.ok().put("data", wb);
    }

    /**
     * 图片上传
     *
     * @param mf
     * @return
     */
    @RequestMapping(value = "/uploadImg", method = RequestMethod.POST)
    public R uploadImg(@RequestParam(value = "file") MultipartFile mf) {
        return ImageUtils.uploadSave(mf, "banner");
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sysWs:banner:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<WsBannerEntity> list = wsBannerService.queryList(query);
        int total = wsBannerService.queryTotal(query);
        return R.page(total, list);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sysWs:banner:add")
    public R save(@RequestBody WsBannerEntity wsBanner) {
        wsBannerService.save(wsBanner);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sysWs:banner:update")
    public R update(@RequestBody WsBannerEntity wsBanner) {
        wsBannerService.update(wsBanner);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sysWs:banner:del")
    public R delete(@RequestBody Long[] ids) {
        wsBannerService.deleteBatch(ids);
        return R.ok();
    }
}
