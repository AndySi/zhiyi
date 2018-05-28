package com.idou.modules.app.controller;

import com.idou.modules.app.entity.ApiUserEntity;
import com.idou.modules.app.interceptor.AuthorizationInterceptor;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2018-01-04 上午 10:45
 **/

public abstract class ApiCommController {
    protected ApiUserEntity getUser(HttpServletRequest request) {
        return (ApiUserEntity) request.getSession().getAttribute(AuthorizationInterceptor.OAUTH_USER_KEY);
    }

    protected Long getUserId(HttpServletRequest request) {
        // TODO 仅用于测试，走微信逻辑，需要删除
        if (getUser(request) != null) {
            return getUser(request).getId();
        }
        return 1L;
    }
}
