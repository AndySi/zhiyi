package com.idou.modules.sysEx.controller;

import com.idou.common.utils.R;
import com.idou.modules.api.domain.WsJoinEntity;
import com.idou.modules.api.service.WsJoinService;
import com.idou.modules.sysEx.utils.ImageUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * @author zhangSi
 * @email andy_si@163.com
 * @date 2018-05-29 16:21:07
 */
@RestController
@RequestMapping("/sysWs/wsjoin")
public class WsJoinController {
    @Autowired
    private WsJoinService wsJoinService;

    /**
     * 图片上传
     *
     * @param mf
     * @return
     */
    @RequestMapping(value = "/uploadImg", method = RequestMethod.POST)
    @RequiresPermissions("sysWs:wsjoin:add")
    public R uploadImg(@RequestParam(value = "file") MultipartFile mf) {
        return ImageUtils.uploadSave(mf, "join");
    }

    /**
     * 信息
     */
    @RequestMapping("/info")
    @RequiresPermissions("sysWs:wsjoin:info")
    public R info() {
        WsJoinEntity wsJoin = wsJoinService.queryObject();

        return R.ok().put("data", wsJoin);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions(value = {"sysWs:wsjoin:add","sysWs:wsjoin:delete"}, logical = Logical.AND)
    public R save(@RequestBody WsJoinEntity wsJoin) {
        wsJoinService.save(wsJoin);

        return R.ok();
    }
}
