package com.idou.modules.api.controller;

import com.idou.common.utils.R;
import com.idou.modules.api.utils.ParamsValid;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 短信
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2018-01-04 下午 3:43
 **/

@RestController
@RequestMapping("/api/sms")
@Api("短信接口")
public class ApiSmsController {
    @PostMapping("/getCode")
    @ApiOperation(value = "获取短信验证码", notes = "点击发送短信，手机接收短信")
    @ApiImplicitParam(name = "tel", value = "手机号码", dataType = "String", paramType = "query", required = true)
    public R getCode(@RequestParam("tel") String tel){
        // TODO 测试模拟返回值，正式的从手机获取
        if (ParamsValid.validTel(tel)) {
            int code = (int) ((Math.random() * 9 + 1) * 100000);
            return R.ok().put("data", code);
        }
        // TODO 跟短信平台做对接
        return R.ok();
    }
}
