package com.idou.modules.sys.authc;

import com.idou.modules.sys.entity.SysUserEntity;
import com.idou.modules.sys.service.ShiroService;
import com.idou.modules.sys.service.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * 认证
 *
 * @author zhangsi
 * @email 917661718@qq.com
 * @date 2017-05-20 14:00
 */
@Component
public class AuthcRealm extends AuthorizingRealm {
    @Autowired
    private ShiroService shiroService;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 授权(验证权限时调用)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SysUserEntity user = (SysUserEntity)principals.getPrimaryPrincipal();
        Long userId = user.getUserId();

        //用户权限列表
        Set<String> permsSet = shiroService.getUserPermissions(userId);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(permsSet);
        return info;
    }

    /**
     * 认证(登录时调用)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String name = token.getUsername();
        // 访问一次，计数一次
        //ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        //opsForValue.increment(SysConstant.SHIRO_LOGIN_COUNT + name, 1);

        // 计数大于5时，设置用户被锁定一小时
        //if (Integer.parseInt(opsForValue.get(SysConstant.SHIRO_LOGIN_COUNT + name)) >= 5) {
        //    opsForValue.set(SysConstant.SHIRO_IS_LOCK + name, "LOCK");
        //    stringRedisTemplate.expire(SysConstant.SHIRO_IS_LOCK + name, 1, TimeUnit.HOURS);
        //}
        //if ("LOCK".equals(opsForValue.get(SysConstant.SHIRO_IS_LOCK + name))) {
        //    throw new DisabledAccountException("密码输入错误过多，帐号已禁止登录！");
        //}

        String username = (String) authcToken.getPrincipal();
        // 查询用户信息
        SysUserEntity user = sysUserService.queryByUserName(username);

        if (null == user) {
            throw new UnknownAccountException("帐号或密码不正确！");
        }
        // 账号锁定
        if (user.getStatus() == 0) {
            throw new LockedAccountException("账号已被锁定,请联系管理员");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(
                user,   //登录识别串信息
                user.getPassword(), //密码
                ByteSource.Util.bytes(user.getSalt()),  //盐值
                getName()   //realm name
        );
        return info;
    }
}
