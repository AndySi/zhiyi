package com.idou.modules.api.controller;

import com.idou.common.utils.Query;
import com.idou.common.utils.R;
import com.idou.common.validator.Assert;
import com.idou.modules.api.dto.ApiTotayRobEntity;
import com.idou.modules.api.entity.ApiUserEntity;
import com.idou.modules.api.service.TodayRobService;
import com.idou.modules.api.utils.ParamsValid;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-11-24 下午 4:47
 **/
@RestController
@RequestMapping("/api/activity")
@Api("活动接口")
public class ApiActivityController {
    @Autowired
    private TodayRobService todayRobService;

    /**
     * 获取今日必抢活动列表
     *
     * @return
     */
    @PostMapping("/todayRob/queryList")
    @ApiOperation(value = "[今日必抢活动]查询商品列表", notes = "获取首页活动商品列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "limit", value = "每页多少条", dataType = "String", paramType = "query")
    })
    public R getTodayRobList(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        if (page >= 0 && limit >= 0) {
            Query query = new Query(page == 0 ? 1 : page, limit == 0 ? 5 : limit);
            List<ApiTotayRobEntity> list = todayRobService.queryList(query);
            return R.ok().put("data", list);
        }
        return R.error("参数错误");
    }

    /**
     * 根据商品ID查询今日必抢活动商品详情
     *
     * @param itemId
     * @return
     */
    @PostMapping("/todayRob/queryDetailById")
    @ApiOperation(value = "[今日必抢活动]查询商品详情", notes = "根据商品ID(itemId)查询今日必抢活动商品详情")
    @ApiImplicitParam(name = "itemId", value = "商品编号", required = true, dataType = "Long", paramType = "query")
    public R queryDetailByItemId(@RequestParam("itemId") Long itemId) {
        return R.ok().put("data", todayRobService.queryDetailByItemId(itemId));
    }

    /**
     * 获取今日必抢活动接口地址
     *
     * @param id
     * @return
     */
    @PostMapping("/todayRob/queryUrl")
    @ApiOperation(value = "[今日必抢活动]查询商品MD5加密值", notes = "获取加密值")
    @ApiImplicitParam(name = "id", value = "活动商品编号", required = true, dataType = "int", paramType = "query")
    public R queryTodayRobUrl(@RequestParam("id") String id) {
        Long itemId = ParamsValid.validLong(id);
        String data = todayRobService.todayRobUrl(itemId);
        return R.ok().put("data", data);
    }

    /**
     * 查询今日必抢活动用户列表
     *
     * @return
     */
    @PostMapping("/todayRob/queryUserListById")
    @ApiOperation(value = "[今日必抢活动]查询用户列表", notes = "根据活动商品编号(id)获取购买此商品的用户列表")
    @ApiImplicitParam(name = "id", value = "活动商品编号", required = true, dataType = "int", paramType = "query")
    public R getUserList(String id) {
        Assert.isBlank(id, "活动商品编号不能为空");
        Long itemId = ParamsValid.validLong(id);
        Map<String, Object> params = new HashMap<>();
        params.put("itemId", itemId);
        params.put("limit", 6);
        List<ApiUserEntity> list = todayRobService.queryRobUserByItemId(params);
        return R.ok().put("data", list);
    }
}
