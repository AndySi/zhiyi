package com.idou.modules.sysEx.controller;

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

		List<WsMenuEntity> list = wsMenuService.queryList(query);
		int total = wsMenuService.queryTotal(query);
		
		return R.page(total, list);
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sysWs:menu:update")
	public R update(@RequestParam("id") long id, @RequestParam("val") boolean val){
		wsMenuService.update(id, val);
		return R.ok();
	}
}
