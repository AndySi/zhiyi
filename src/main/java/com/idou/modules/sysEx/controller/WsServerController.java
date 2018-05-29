package com.idou.modules.sysEx.controller;

import com.idou.common.utils.PageUtils;
import com.idou.common.utils.Query;
import com.idou.common.utils.R;
import com.idou.modules.api.domain.WsServerEntity;
import com.idou.modules.api.service.WsServerService;
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
 * @date 2018-05-29 16:21:07
 */
@RestController
@RequestMapping("/api/wsserver")
public class WsServerController {
	@Autowired
	private WsServerService wsServerService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("api:wsserver:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<WsServerEntity> wsServerList = wsServerService.queryList(query);
		int total = wsServerService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(wsServerList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("api:wsserver:info")
	public R info(@PathVariable("id") Long id){
		WsServerEntity wsServer = wsServerService.queryObject(id);
		
		return R.ok().put("wsServer", wsServer);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("api:wsserver:save")
	public R save(@RequestBody WsServerEntity wsServer){
		wsServerService.save(wsServer);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("api:wsserver:update")
	public R update(@RequestBody WsServerEntity wsServer){
		wsServerService.update(wsServer);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("api:wsserver:delete")
	public R delete(@RequestBody Long[] ids){
		wsServerService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
