package com.idou.modules.sysBs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2018-01-23 下午 4:12
 **/
@Controller
public class SysPageController {
    @RequestMapping("/modules/{directory}/{url}.html")
    public String toRoute(@PathVariable("directory") String directory, @PathVariable("url") String url) {
        return "modules/"+directory+"/" + url;
    }
}
