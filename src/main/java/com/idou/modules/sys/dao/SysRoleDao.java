package com.idou.modules.sys.dao;

import com.idou.modules.sys.entity.SysRoleEntity;

import java.util.List;

/**
 * 角色管理
 *
 * @author zhangsi
 * @email 917661718@qq.com
 * @date 2016年9月18日 上午9:33:33
 */
public interface SysRoleDao extends BaseDao<SysRoleEntity> {
	
	/**
	 * 查询用户创建的角色ID列表
	 */
	List<Long> queryRoleIdList(Long createUserId);
}
