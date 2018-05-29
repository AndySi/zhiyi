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
@RequestMapping("/api/wslinks")
public class WsLinksController {
	@Autowired
	private WsLinksService wsLinksService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("api:wslinks:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<WsLinksEntity> wsLinksList = wsLinksService.queryList(query);
		int total = wsLinksService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(wsLinksList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("api:wslinks:info")
	public R info(@PathVariable("id") Long id){
		WsLinksEntity wsLinks = wsLinksService.queryObject(id);
		
		return R.ok().put("wsLinks", wsLinks);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("api:wslinks:save")
	public R save(@RequestBody WsLinksEntity wsLinks){
		wsLinksService.save(wsLinks);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("api:wslinks:update")
	public R update(@RequestBody WsLinksEntity wsLinks){
		wsLinksService.update(wsLinks);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("api:wslinks:delete")
	public R delete(@RequestBody Long[] ids){
		wsLinksService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
