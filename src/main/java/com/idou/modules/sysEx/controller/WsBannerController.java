package com.idou.modules.sysEx.controller;

import com.idou.common.utils.PageUtils;
import com.idou.common.utils.Query;
import com.idou.common.utils.R;
import com.idou.modules.api.domain.WsBannerEntity;
import com.idou.modules.api.service.WsBannerService;
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
@RequestMapping("/api/wsbanner")
public class WsBannerController {
	@Autowired
	private WsBannerService wsBannerService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("api:wsbanner:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<WsBannerEntity> wsBannerList = wsBannerService.queryList(query);
		int total = wsBannerService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(wsBannerList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("api:wsbanner:info")
	public R info(@PathVariable("id") Long id){
		WsBannerEntity wsBanner = wsBannerService.queryObject(id);
		
		return R.ok().put("wsBanner", wsBanner);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("api:wsbanner:save")
	public R save(@RequestBody WsBannerEntity wsBanner){
		wsBannerService.save(wsBanner);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("api:wsbanner:update")
	public R update(@RequestBody WsBannerEntity wsBanner){
		wsBannerService.update(wsBanner);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("api:wsbanner:delete")
	public R delete(@RequestBody Long[] ids){
		wsBannerService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
