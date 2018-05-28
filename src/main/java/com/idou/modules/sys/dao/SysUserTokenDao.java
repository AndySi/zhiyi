package com.idou.modules.sys.dao;

import com.idou.modules.sys.entity.SysUserTokenEntity;

/**
 * 系统用户Token
 *
 * @author zhangsi
 * @email 917661718@qq.com
 * @date 2017-03-23 15:22:07
 */
public interface SysUserTokenDao extends BaseDao<SysUserTokenEntity> {
    
    SysUserTokenEntity queryByUserId(Long userId);

    SysUserTokenEntity queryByToken(String token);
	
}
