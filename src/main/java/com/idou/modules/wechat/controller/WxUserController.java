package com.idou.modules.wechat.controller;

import com.idou.common.annotation.SysLog;
import com.idou.common.utils.Query;
import com.idou.common.utils.R;
import com.idou.modules.app.entity.ApiUserEntity;
import com.idou.modules.app.service.UserService;
import com.idou.modules.sys.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 后台app用户管理
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-11-06 下午 5:17
 **/
@RestController
@RequestMapping("/sysWx/user")
public class WxUserController extends AbstractController {
    @Autowired
    private UserService userService;

    /**
     * 修改用户状态（注销-锁定-正常）
     *
     * @return
     */
    @SysLog("修改wx用户状态")
    @PostMapping("/updateStatu")
    @RequiresPermissions("wx:user:audit")
    public R updateStatu(@RequestParam Map<String, Object> params) {
        userService.updateStatu(params);
        return R.ok();
    }

    /**
     * 用户列表
     *
     * @param params
     * @return
     */
    @GetMapping("/list")
    @RequiresPermissions("wx:user:list")
    public R queryUserList(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<ApiUserEntity> list = userService.queryList(query);
        int total = userService.queryTotal(query);
        return R.page(total, list);
    }
}
