package com.idou.modules.api.interceptor;


import com.idou.common.exception.RRException;
import com.idou.modules.api.annotation.Login;
import com.idou.modules.api.service.UserService;
import com.idou.modules.api.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限(Token)验证
 * @author zhangsi
 * @email 917661718@qq.com
 * @date 2017-03-23 15:38
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private JwtUtils jwtUtils;

    public static final String USER_KEY = "userId";

    public static final String OAUTH_USER_KEY = "OAUTH_USER_KEY";

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Login annotation;
        if(handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(Login.class);
        }else{
            return true;
        }

        if(annotation == null){
            return true;
        }

        //获取用户凭证
        String token = request.getHeader(jwtUtils.getHeader());
        if(StringUtils.isBlank(token)){
            token = request.getParameter(jwtUtils.getHeader());
        }

        //凭证为空
        if(StringUtils.isBlank(token)){
            throw new RRException(jwtUtils.getHeader() + "不能为空", HttpStatus.UNAUTHORIZED.value());
        }

        Claims claims = jwtUtils.getClaimByToken(token);
        if(claims == null || jwtUtils.isTokenExpired(claims.getExpiration())){
            throw new RRException(jwtUtils.getHeader() + "失效，请重新登录", HttpStatus.UNAUTHORIZED.value());
        }

        //设置userId到request里，后续根据userId，获取用户信息
        request.setAttribute(USER_KEY, Long.parseLong(claims.getSubject()));

        return true;

        /*HttpSession session = request.getSession();
        if (session.getAttribute(OAUTH_USER_KEY) == null) {
            String code = request.getParameter("code");
            if (StringUtil.isBlank(code)) {
                String accept = request.getHeader("Accept");
                if (StringUtils.hasText(accept)
                        && accept.contains("application/json")) {
                    throw new RRException("用户未授权", 301);
                } else {
                    response.sendRedirect(weixinProxy.getOauthApi().getUserAuthorizationURL(
                            getAccessUri(request), "state", "snsapi_userinfo"));
                }
                return false;
            } else {
                OauthToken oToken = null;
                User user = null;
                try {
                    oToken = weixinProxy.getOauthApi().getAuthorizationToken(code);
                    user = weixinProxy.getUser(oToken.getOpenId());
                } catch (WeixinException e) {
                    if (e.getErrorCode().equals("40029")) { // invalid code
                        response.sendRedirect(weixinProxy.getOauthApi().getUserAuthorizationURL(String
                                        .format("%s://%s%s", request.getScheme(),
                                                request.getServerName(),
                                                request.getRequestURI()), "state",
                                "snsapi_base"));
                        return false;
                    } else if (e.getErrorCode().equals("40001")) { // invalid token
                        // 刷新token
                        weixinProxy.getTokenManager().refreshCache();
                        // 重新获取用户信息
                        user = weixinProxy.getUser(oToken.getOpenId());
                    } else {
                        throw e;
                    }
                }
                ApiUserEntity dbUser = new ApiUserEntity();
                BeanUtils.copyProperties(user, dbUser, "subscribeTime",
                        "verified", "firstLoginTime", "lastLoginTime",
                        "gender");
                dbUser.setSubscribeTime(user.getFormatSubscribeTime());
                dbUser.setLastLoginTime(new Date());
                dbUser.setSubscribe(user.isSubscribe());
                dbUser.setGender(user.getGender());
                dbUser.setSource("weixin");
                dbUser = userService.saveOrUpdate(dbUser);
                session.setAttribute(OAUTH_USER_KEY, dbUser);
                session.setAttribute(OAUTH_TOKEN_KEY, oToken);
            }
        }
        return true;*/
    }

    private String getAccessUri(HttpServletRequest request) {
        int port = request.getServerPort();
        String access_uri = String.format("%s://%s%s", request.getScheme(),
                request.getServerName(), request.getRequestURI());
        if (port != 80) {
            access_uri = String.format("%s://%s:%s%s", request.getScheme(),
                    request.getServerName(), port,
                    request.getRequestURI());
        }
        return access_uri;
    }
}
