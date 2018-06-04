package com.idou.modules.sysEx.controller;

import com.idou.common.utils.Query;
import com.idou.common.utils.R;
import com.idou.modules.api.domain.WsNewsTypeEntity;
import com.idou.modules.api.service.WsNewsTypeService;
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
@RequestMapping("/sysWs/wsnewstype")
public class WsNewsTypeController {
	@Autowired
	private WsNewsTypeService wsNewsTypeService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sysWs:wsnewstype:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<WsNewsTypeEntity> list = wsNewsTypeService.queryList(query);
		int total = wsNewsTypeService.queryTotal(query);
		return R.page(total, list);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sysWs:wsnewstype:info")
	public R info(@PathVariable("id") Long id){
		WsNewsTypeEntity wsNewsType = wsNewsTypeService.queryObject(id);
		
		return R.ok().put("data", wsNewsType);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sysWs:wsnewstype:add")
	public R save(@RequestBody WsNewsTypeEntity wsNewsType){
		wsNewsTypeService.save(wsNewsType);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sysWs:wsnewstype:update")
	public R update(@RequestBody WsNewsTypeEntity wsNewsType){
		wsNewsTypeService.update(wsNewsType);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sysWs:wsnewstype:delete")
	public R delete(@RequestBody Long[] ids){
		wsNewsTypeService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
