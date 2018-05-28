package com.idou.modules.app.controller;

import com.idou.common.utils.R;
import com.idou.modules.app.entity.ApiBannerEntity;
import com.idou.modules.app.service.BannerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 图片管理
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-11-23 下午 4:10
 **/
@RestController
@RequestMapping("/api/pic")
@Api("图片接口")
public class ApiPicController {
    @Autowired
    private BannerService bannerService;

    /**
     * 查询首页banner列表
     *
     * @return
     */
    @PostMapping("/banner/queryList")
    @ApiOperation(value = "查询首页Banner图片列表", notes = "响应字段说明【id：编码，imgUrl：图片OSS地址】")
    public R queryBannerList() {
        List<ApiBannerEntity> list = bannerService.queryList();
        return R.ok().put("data", list);
    }
}
