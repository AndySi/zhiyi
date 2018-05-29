package com.idou.modules.sysEx.controller;

import com.idou.common.utils.PageUtils;
import com.idou.common.utils.Query;
import com.idou.common.utils.R;
import com.idou.modules.api.domain.WsJoinEntity;
import com.idou.modules.api.service.WsJoinService;
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
@RequestMapping("/api/wsjoin")
public class WsJoinController {
	@Autowired
	private WsJoinService wsJoinService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("api:wsjoin:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<WsJoinEntity> wsJoinList = wsJoinService.queryList(query);
		int total = wsJoinService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(wsJoinList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("api:wsjoin:info")
	public R info(@PathVariable("id") Long id){
		WsJoinEntity wsJoin = wsJoinService.queryObject(id);
		
		return R.ok().put("wsJoin", wsJoin);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("api:wsjoin:save")
	public R save(@RequestBody WsJoinEntity wsJoin){
		wsJoinService.save(wsJoin);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("api:wsjoin:update")
	public R update(@RequestBody WsJoinEntity wsJoin){
		wsJoinService.update(wsJoin);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("api:wsjoin:delete")
	public R delete(@RequestBody Long[] ids){
		wsJoinService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
