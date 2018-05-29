package com.idou.modules.sysEx.controller;

import com.idou.common.utils.PageUtils;
import com.idou.common.utils.Query;
import com.idou.common.utils.R;
import com.idou.modules.api.domain.WsCaseTypeEntity;
import com.idou.modules.api.service.WsCaseTypeService;
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
@RequestMapping("/api/wscasetype")
public class WsCaseTypeController {
	@Autowired
	private WsCaseTypeService wsCaseTypeService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("api:wscasetype:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<WsCaseTypeEntity> wsCaseTypeList = wsCaseTypeService.queryList(query);
		int total = wsCaseTypeService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(wsCaseTypeList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("api:wscasetype:info")
	public R info(@PathVariable("id") Long id){
		WsCaseTypeEntity wsCaseType = wsCaseTypeService.queryObject(id);
		
		return R.ok().put("wsCaseType", wsCaseType);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("api:wscasetype:save")
	public R save(@RequestBody WsCaseTypeEntity wsCaseType){
		wsCaseTypeService.save(wsCaseType);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("api:wscasetype:update")
	public R update(@RequestBody WsCaseTypeEntity wsCaseType){
		wsCaseTypeService.update(wsCaseType);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("api:wscasetype:delete")
	public R delete(@RequestBody Long[] ids){
		wsCaseTypeService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
