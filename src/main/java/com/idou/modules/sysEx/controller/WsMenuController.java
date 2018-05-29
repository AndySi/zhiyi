package com.idou.modules.sysEx.controller;

import com.idou.common.utils.PageUtils;
import com.idou.common.utils.Query;
import com.idou.common.utils.R;
import com.idou.modules.api.domain.WsMenuEntity;
import com.idou.modules.api.service.WsMenuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author zhangSi
 * @email andy_si@163.com
 * @date 2018-05-29 11:27:30
 */
@RestController
@RequestMapping("/sysWs/wsmenu")
public class WsMenuController {
	@Autowired
	private WsMenuService wsMenuService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sysWs:menu:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<WsMenuEntity> wsMenuList = wsMenuService.queryList(query);
		int total = wsMenuService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(wsMenuList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("generator:wsmenu:info")
	public R info(@PathVariable("id") Long id){
		WsMenuEntity wsMenu = wsMenuService.queryObject(id);
		
		return R.ok().put("wsMenu", wsMenu);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("generator:wsmenu:save")
	public R save(@RequestBody WsMenuEntity wsMenu){
		wsMenuService.save(wsMenu);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("generator:wsmenu:update")
	public R update(@RequestBody WsMenuEntity wsMenu){
		wsMenuService.update(wsMenu);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("generator:wsmenu:delete")
	public R delete(@RequestBody Long[] ids){
		wsMenuService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
