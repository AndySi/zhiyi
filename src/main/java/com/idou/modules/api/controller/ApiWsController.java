package com.idou.modules.api.controller;

import com.idou.common.utils.Query;
import com.idou.common.utils.R;
import com.idou.modules.api.domain.WsCaseEntity;
import com.idou.modules.api.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2018-06-01 上午 9:36
 **/
@RestController
@RequestMapping("/api/ws")
@Api("网站接口")
public class ApiWsController {
    @Autowired
    private WsBaseInfoService wsBaseInfoService;
    @Autowired
    private WsBannerService wsBannerService;
    @Autowired
    private WsCaseService wsCaseService;
    @Autowired
    private WsCaseTypeService wsCaseTypeService;
    @Autowired
    private WsMenuService wsMenuService;
    @Autowired
    private WsLinksService wsLinksService;

    @PostMapping("/base/getLinks")
    @ApiOperation(value = "获取友情链接", notes = "获取友情链接")
    public R getLinks() {
        return R.ok().put("data", wsLinksService.queryList());
    }


    @PostMapping("/base/getInfo")
    @ApiOperation(value = "获取基本信息", notes = "网站的基本信息")
    public R getInfo() {
        return R.ok().put("data", wsBaseInfoService.queryObject());
    }

    @PostMapping("/banner/getList")
    @ApiOperation(value = "获取banner列表", notes = "首页banner展示")
    public R getBannerList() {
        return R.ok().put("data", wsBannerService.queryListLimit());
    }

    @PostMapping("/case/getList")
    @ApiOperation(value = "获取案例展示列表", notes = "案例展示")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "每页多少条", dataType = "String", paramType = "query")
    })
    public R getInfoByTid(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        if (page >= 0 && limit >= 0) {
            Query query = new Query(page == 0 ? 1 : page, limit == 0 ? 5 : limit);
            List<WsCaseEntity> list = wsCaseService.queryList(query);
            return R.ok().put("data", list);
        }
        return R.error("参数错误");
    }

    @PostMapping("/case/getTypeList")
    @ApiOperation(value = "获取案例类型列表", notes = "获取案例类型列表")
    public R getCaseTypeList() {
        return R.ok().put("data", wsCaseTypeService.queryList());
    }


    @PostMapping("/menu/getList")
    @ApiOperation(value = "获取菜单列表", notes = "获取菜单列表")
    public R getMenuList() {
        return R.ok().put("data", wsMenuService.queryList());
    }
}
