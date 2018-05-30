package com.idou.modules.sysEx.controller;

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
@RequestMapping("/sysWs/wscasetype")
public class WsCaseTypeController {
	@Autowired
	private WsCaseTypeService wsCaseTypeService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sysWs:wscasetype:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<WsCaseTypeEntity> list = wsCaseTypeService.queryList(query);
		int total = wsCaseTypeService.queryTotal(query);

		return R.page(total, list);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sysWs:wscasetype:info")
	public R info(@PathVariable("id") Long id){
		WsCaseTypeEntity wsCaseType = wsCaseTypeService.queryObject(id);
		
		return R.ok().put("data", wsCaseType);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sysWs:wscasetype:add")
	public R save(@RequestBody WsCaseTypeEntity wsCaseType){
		wsCaseTypeService.save(wsCaseType);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sysWs:wscasetype:update")
	public R update(@RequestBody WsCaseTypeEntity wsCaseType){
		wsCaseTypeService.update(wsCaseType);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sysWs:wscasetype:delete")
	public R delete(@RequestBody Long[] ids){
		wsCaseTypeService.deleteBatch(ids);
		
		return R.ok();
	}


	/**
	 * 属性名-商品类别选择
	 *
	 * @return
	 */
	@RequestMapping("/queryAllList")
	@RequiresPermissions("sysWs:wscasetype:list")
	public R queryAllList() {
		//查询列表数据
		List<WsCaseTypeEntity> list = wsCaseTypeService.queryList();
		return R.ok().put("data", list);
	}
}
