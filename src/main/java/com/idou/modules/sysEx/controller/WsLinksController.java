package com.idou.modules.sysEx.controller;

import com.idou.common.utils.PageUtils;
import com.idou.common.utils.Query;
import com.idou.common.utils.R;
import com.idou.modules.api.domain.WsLinksEntity;
import com.idou.modules.api.service.WsLinksService;
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
@RequestMapping("/sysWs/wslinks")
public class WsLinksController {
	@Autowired
	private WsLinksService wsLinksService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sysWs:wslinks:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<WsLinksEntity> list = wsLinksService.queryList(query);
		int total = wsLinksService.queryTotal(query);

		return R.page(total, list);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sysWs:wslinks:info")
	public R info(@PathVariable("id") Long id){
		WsLinksEntity wsLinks = wsLinksService.queryObject(id);
		
		return R.ok().put("data", wsLinks);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sysWs:wslinks:add")
	public R save(@RequestBody WsLinksEntity wsLinks){
		wsLinksService.save(wsLinks);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sysWs:wslinks:update")
	public R update(@RequestBody WsLinksEntity wsLinks){
		wsLinksService.update(wsLinks);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sysWs:wslinks:delete")
	public R delete(@RequestBody Long[] ids){
		wsLinksService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
