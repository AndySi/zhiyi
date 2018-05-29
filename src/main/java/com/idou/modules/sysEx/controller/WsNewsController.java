package com.idou.modules.sysEx.controller;

import com.idou.common.utils.PageUtils;
import com.idou.common.utils.Query;
import com.idou.common.utils.R;
import com.idou.modules.api.domain.WsNewsEntity;
import com.idou.modules.api.service.WsNewsService;
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
@RequestMapping("/api/wsnews")
public class WsNewsController {
	@Autowired
	private WsNewsService wsNewsService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("api:wsnews:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<WsNewsEntity> wsNewsList = wsNewsService.queryList(query);
		int total = wsNewsService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(wsNewsList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("api:wsnews:info")
	public R info(@PathVariable("id") Long id){
		WsNewsEntity wsNews = wsNewsService.queryObject(id);
		
		return R.ok().put("wsNews", wsNews);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("api:wsnews:save")
	public R save(@RequestBody WsNewsEntity wsNews){
		wsNewsService.save(wsNews);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("api:wsnews:update")
	public R update(@RequestBody WsNewsEntity wsNews){
		wsNewsService.update(wsNews);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("api:wsnews:delete")
	public R delete(@RequestBody Long[] ids){
		wsNewsService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
