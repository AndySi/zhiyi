package com.idou.modules.wechat.controller;

import com.idou.common.utils.Query;
import com.idou.common.utils.R;
import com.idou.modules.app.entity.ApiAddressEntity;
import com.idou.modules.app.service.AddressService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 地址管理
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-12-29 上午 10:29
 **/
@RestController
@RequestMapping("/sysWx/address")
public class WxAddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/list")
    @RequiresPermissions("wx:activity:list")
    public R queryList(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<ApiAddressEntity> list = addressService.queryList(query);
        int total = addressService.queryTotal(query);
        return R.page(total, list);
    }
}
