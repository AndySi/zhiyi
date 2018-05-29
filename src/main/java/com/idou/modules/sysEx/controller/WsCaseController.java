package com.idou.modules.sysEx.controller;

import com.idou.common.utils.PageUtils;
import com.idou.common.utils.Query;
import com.idou.common.utils.R;
import com.idou.modules.api.domain.WsCaseEntity;
import com.idou.modules.api.service.WsCaseService;
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
@RequestMapping("/api/wscase")
public class WsCaseController {
	@Autowired
	private WsCaseService wsCaseService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("api:wscase:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<WsCaseEntity> wsCaseList = wsCaseService.queryList(query);
		int total = wsCaseService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(wsCaseList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("api:wscase:info")
	public R info(@PathVariable("id") Long id){
		WsCaseEntity wsCase = wsCaseService.queryObject(id);
		
		return R.ok().put("wsCase", wsCase);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("api:wscase:save")
	public R save(@RequestBody WsCaseEntity wsCase){
		wsCaseService.save(wsCase);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("api:wscase:update")
	public R update(@RequestBody WsCaseEntity wsCase){
		wsCaseService.update(wsCase);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("api:wscase:delete")
	public R delete(@RequestBody Long[] ids){
		wsCaseService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
