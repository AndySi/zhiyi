package com.idou.modules.sysEx.controller;

import com.idou.common.utils.Query;
import com.idou.common.utils.R;
import com.idou.modules.api.domain.WsActivityEntity;
import com.idou.modules.api.service.WsActivityService;
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
@RequestMapping("/sysWs/wsactivity")
public class WsActivityController {
	@Autowired
	private WsActivityService wsActivityService;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sysWs:wsactivity:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<WsActivityEntity> list = wsActivityService.queryList(query);
		int total = wsActivityService.queryTotal(query);
		
		return R.page(total, list);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sysWs:wsactivity:info")
	public R info(@PathVariable("id") Long id){
		WsActivityEntity wsactivity = wsActivityService.queryObject(id);
		
		return R.ok().put("data", wsactivity);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sysWs:wsactivity:add")
	public R save(@RequestBody WsActivityEntity wsactivity){
		wsActivityService.save(wsactivity);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sysWs:wsactivity:update")
	public R update(@RequestBody WsActivityEntity wsactivity){
		wsActivityService.update(wsactivity);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sysWs:wsactivity:delete")
	public R delete(@RequestBody Long[] ids){
		wsActivityService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
