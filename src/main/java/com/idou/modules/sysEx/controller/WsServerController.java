package com.idou.modules.sysEx.controller;

import com.idou.common.utils.Query;
import com.idou.common.utils.R;
import com.idou.modules.api.domain.WsServerEntity;
import com.idou.modules.api.service.WsServerService;
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
@RequestMapping("/sysWs/wsserver")
public class WsServerController {
    @Autowired
    private WsServerService wsServerService;

    /**
     * 封面图片上传
     *
     * @param mf
     * @return
     */
    @RequestMapping(value = "/uploadImg", method = RequestMethod.POST)
    public R uploadImg(@RequestParam(value = "file") MultipartFile mf) {
        return ImageUtils.uploadSave(mf, "server");
    }

    /**
     * 信息
     */
    @RequestMapping("/info")
    @RequiresPermissions("sysWs:wsserver:info")
    public R info() {
        WsServerEntity wsServer = wsServerService.queryObject();

        return R.ok().put("data", wsServer);
    }

    /**
     * 保存
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @RequiresPermissions("sysWs:wsserver:add")
    public R save(@RequestBody WsServerEntity wsServer) {
        wsServerService.save(wsServer);
        return R.ok();
    }
}
