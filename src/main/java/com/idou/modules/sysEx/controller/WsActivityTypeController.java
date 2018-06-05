package com.idou.modules.sysEx.controller;

import com.idou.common.utils.Query;
import com.idou.common.utils.R;
import com.idou.modules.api.domain.WsActivityTypeEntity;
import com.idou.modules.api.service.WsActivityTypeService;
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
@RequestMapping("/sysWs/wsactivitytype")
public class WsActivityTypeController {
	@Autowired
	private WsActivityTypeService wsActivityTypeService;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sysWs:wsactivitytype:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<WsActivityTypeEntity> list = wsActivityTypeService.queryList(query);
		int total = wsActivityTypeService.queryTotal(query);
		return R.page(total, list);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sysWs:wsactivitytype:info")
	public R info(@PathVariable("id") Long id){
		WsActivityTypeEntity ret = wsActivityTypeService.queryObject(id);
		
		return R.ok().put("data", ret);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sysWs:wsactivitytype:add")
	public R save(@RequestBody WsActivityTypeEntity entity){
		wsActivityTypeService.save(entity);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sysWs:wsactivitytype:update")
	public R update(@RequestBody WsActivityTypeEntity entity){
		wsActivityTypeService.update(entity);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sysWs:wsactivitytype:delete")
	public R delete(@RequestBody Long[] ids){
		wsActivityTypeService.deleteBatch(ids);
		
		return R.ok();
	}

	@RequestMapping("/queryAllList")
	@RequiresPermissions("sysWs:wsactivitytype:list")
	public R queryAllList() {
		//查询列表数据
		List<WsActivityTypeEntity> list = wsActivityTypeService.queryList();
		return R.ok().put("data", list);
	}
}
