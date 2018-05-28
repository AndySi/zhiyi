package com.idou.modules.app.controller;

import com.foxinmy.weixin4j.cache.FileCacheStorager;
import com.foxinmy.weixin4j.http.weixin.ApiResult;
import com.foxinmy.weixin4j.model.Button;
import com.foxinmy.weixin4j.model.WeixinAccount;
import com.foxinmy.weixin4j.mp.WeixinProxy;
import com.foxinmy.weixin4j.type.ButtonType;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * 菜单管理
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-11-21 下午 3:58
 **/
public class MenuManage {
    public static void BuildMenu() {
        WeixinProxy weixinProxy = new WeixinProxy(new WeixinAccount("wx9daff6e213d80721", "d4624c36b6795d1d99dcf0547af5443d"), new FileCacheStorager<>());
        try {
            List<Button> buttons = new ArrayList<>();

            String loginUrl = String.format("http://oray-sidou.vicp.io/wx/index?backurl=%s", URLEncoder.encode("http://www.baidu.com", "UTF-8"));
            Button mainBtn2 = new Button("微商城", loginUrl, ButtonType.view);

            String centerUrl = String.format("http://oray-sidou.vicp.io/wx/index?backurl=%s", URLEncoder.encode("http://www.baidu.com", "UTF-8"));
            Button button31 = new Button("个人中心", centerUrl, ButtonType.view);
            String orderUrl = String.format("http://oray-sidou.vicp.io/wx/index?backurl=%s", URLEncoder.encode("http://www.baidu.com", "UTF-8"));
            Button button32 = new Button("我的订单", orderUrl, ButtonType.view);
            String contactUrl = String.format("http://oray-sidou.vicp.io/wx/index?backurl=%s", URLEncoder.encode("http://www.baidu.com", "UTF-8"));
            Button button33 = new Button("联系客服", contactUrl, ButtonType.view);
            Button mainBtn3 = new Button("微服务", button31, button32, button33);

            buttons.add(mainBtn2);
            buttons.add(mainBtn3);
            ApiResult ret = weixinProxy.createMenu(buttons);
            System.out.printf("创建菜单返回结果：" + ret.getReturnMsg());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BuildMenu();
    }
}
