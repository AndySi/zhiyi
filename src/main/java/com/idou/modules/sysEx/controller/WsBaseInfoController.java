package com.idou.modules.sysEx.controller;

import com.idou.common.utils.R;
import com.idou.modules.api.domain.WsBaseInfoEntity;
import com.idou.modules.api.service.WsBaseInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * 
 * @author zhangSi
 * @email andy_si@163.com
 * @date 2018-05-29 11:27:30
 */
@RestController
@RequestMapping("/sysWs/baseInfo")
public class WsBaseInfoController {
	@Autowired
	private WsBaseInfoService wsBaseinfoService;

	/**
	 * 信息
	 */
	@RequestMapping("/info")
	@RequiresPermissions("sysWs:baseinfo:info")
	public R info(){
		WsBaseInfoEntity wsBaseinfo = wsBaseinfoService.queryObject();
		
		return R.ok().put("data", wsBaseinfo);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sysWs:baseinfo:save")
	public R save(@RequestBody WsBaseInfoEntity wsBaseinfo){
		wsBaseinfoService.save(wsBaseinfo);
		
		return R.ok();
	}
}
