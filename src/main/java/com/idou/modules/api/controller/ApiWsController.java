package com.idou.modules.api.controller;

import com.idou.common.exception.RRException;
import com.idou.common.utils.Query;
import com.idou.common.utils.R;
import com.idou.modules.api.domain.WsAboutEntity;
import com.idou.modules.api.domain.WsAboutListEntity;
import com.idou.modules.api.domain.WsCaseEntity;
import com.idou.modules.api.domain.WsNewsEntity;
import com.idou.modules.api.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
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
    @Autowired
    private WsServerService wsServerService;
    @Autowired
    private WsAboutService wsAboutService;
    @Autowired
    private WsNewsService wsNewsService;
    @Autowired
    private WsJoinService wsJoinService;
    @Autowired
    private WsNewsTypeService wsNewsTypeService;
    @Autowired
    private WsContactService wsContactService;

    @PostMapping("/contact/getInfo")
    @ApiOperation(value = "联系", notes = "获取联系内容")
    public R getContactInfo() {
        return R.ok().put("data", wsContactService.queryObject());
    }


    @PostMapping("/join/getInfo")
    @ApiOperation(value = "加入", notes = "获取加入内容")
    public R getJoinInfo() {
        return R.ok().put("data", wsJoinService.queryObject());
    }

    @PostMapping("/news/getInfo")
    @ApiOperation(value = "获取动态详情", notes = "根据动态ID获取案例详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ID", dataType = "long", paramType = "query")
    })
    public R getNewsByTid(@RequestParam("id") long id) {
        return R.ok().put("data", wsNewsService.queryObject(id));
    }

    @PostMapping("/news/getList")
    @ApiOperation(value = "根据类型获取动态展示列表", notes = "动态分页展示")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "每页多少条", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "typeId", value = "类型ID", dataType = "String", paramType = "query")
    })
    public R getNewsListByTid(@RequestParam("page") int page, @RequestParam("limit") int limit, @RequestParam("typeId")  long typeId) {
        if (page >= 0 && limit >= 0) {
            Query query = new Query(page == 0 ? 1 : page, limit == 0 ? 5 : limit);
            query.put("typeid", typeId);
            List<WsNewsEntity> list = wsNewsService.queryList(query);
            return R.ok().put("data", list);
        }
        return R.error("参数错误");
    }

    @PostMapping("/news/getTypeList")
    @ApiOperation(value = "获取动态类型列表", notes = "获取动态类型列表")
    public R getNewsTypeList() {
        return R.ok().put("data", wsNewsTypeService.queryList());
    }

    @PostMapping("/about/getInfo")
    @ApiOperation(value = "关于", notes = "获取关于内容")
    public R getAboutInfo() {
        WsAboutEntity entity = wsAboutService.queryObject();
        List<WsAboutListEntity> list = wsAboutService.queryList();
        entity.setAboutList(list);
        return R.ok().put("data", entity);
    }

    @PostMapping("/server/getInfo")
    @ApiOperation(value = "服务", notes = "获取服务内容")
    public R getServerInfo() {
        return R.ok().put("data", wsServerService.queryObject());
    }


    @PostMapping("/base/getLinks")
    @ApiOperation(value = "友情链接", notes = "获取友情链接")
    public R getLinks() {
        return R.ok().put("data", wsLinksService.queryList());
    }


    @PostMapping("/base/getInfo")
    @ApiOperation(value = "基本信息", notes = "网站的基本信息")
    public R getInfo() {
        return R.ok().put("data", wsBaseInfoService.queryObject());
    }

    @PostMapping("/banner/getList")
    @ApiOperation(value = "banner列表", notes = "首页banner展示")
    public R getBannerList() {
        return R.ok().put("data", wsBannerService.queryListLimit());
    }

    @PostMapping("/case/getList")
    @ApiOperation(value = "根据类型获取案例展示列表", notes = "案例分页展示")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "每页多少条", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "typeId", value = "类型ID", dataType = "String", paramType = "query")
    })
    public R getCaseListByTid(@RequestParam("page") int page, @RequestParam("limit") int limit, @RequestParam(value = "typeId", required = false)  String typeId) {
        if (page >= 0 && limit >= 0) {
            Query query = new Query(page == 0 ? 1 : page, limit == 0 ? 5 : limit);
            if(!StringUtils.isEmpty(typeId)){
                try {
                    query.put("typeid", Long.parseLong(typeId));
                }catch (Exception e){
                    throw new RRException("参数格式错误");
                }
            }
            List<WsCaseEntity> list = wsCaseService.queryList(query);
            return R.ok().put("data", list);
        }
        return R.error("参数错误");
    }

    @PostMapping("/case/getInfo")
    @ApiOperation(value = "获取案例详情", notes = "根据案例ID获取案例详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ID", dataType = "long", paramType = "query")
    })
    public R getCaseByTid(@RequestParam("id") long id) {
        return R.ok().put("data", wsCaseService.queryObject(id));
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
