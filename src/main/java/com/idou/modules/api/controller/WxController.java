package com.idou.modules.api.controller;

import com.idou.modules.api.utils.SignUtil;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;

/**
 * 微信接入
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-11-17 下午 3:59
 **/
@RestController
@RequestMapping("/wechat")
@ApiIgnore
public class WxController {
    /**
     * 验证是否来自微信服务器的消息
     *
     * @param signature
     * @param nonce
     * @param timestamp
     * @param echostr
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String doGet(@RequestParam(name = "signature", required = false) String signature,
                        @RequestParam(name = "nonce", required = false) String nonce,
                        @RequestParam(name = "timestamp", required = false) String timestamp,
                        @RequestParam(name = "echostr", required = false) String echostr) {
        if (SignUtil.validateSignature(signature, timestamp, nonce)) {
            Logger.getLogger(getClass()).info("微信接入成功");
            return echostr;
        }
        Logger.getLogger(getClass()).info("微信接入失败");
        return "";
    }

    /**
     * 调用核心业务类接收消息、处理消息跟推送消息
     *
     * @param request
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public String doPost(HttpServletRequest request) {
        return null;
    }
}