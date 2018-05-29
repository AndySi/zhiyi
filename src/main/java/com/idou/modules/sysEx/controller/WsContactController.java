package com.idou.modules.sysEx.controller;

import com.idou.common.utils.PageUtils;
import com.idou.common.utils.Query;
import com.idou.common.utils.R;
import com.idou.modules.api.domain.WsContactEntity;
import com.idou.modules.api.service.WsContactService;
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
@RequestMapping("/api/wscontact")
public class WsContactController {
	@Autowired
	private WsContactService wsContactService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("api:wscontact:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<WsContactEntity> wsContactList = wsContactService.queryList(query);
		int total = wsContactService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(wsContactList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("api:wscontact:info")
	public R info(@PathVariable("id") Long id){
		WsContactEntity wsContact = wsContactService.queryObject(id);
		
		return R.ok().put("wsContact", wsContact);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("api:wscontact:save")
	public R save(@RequestBody WsContactEntity wsContact){
		wsContactService.save(wsContact);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("api:wscontact:update")
	public R update(@RequestBody WsContactEntity wsContact){
		wsContactService.update(wsContact);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("api:wscontact:delete")
	public R delete(@RequestBody Long[] ids){
		wsContactService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
