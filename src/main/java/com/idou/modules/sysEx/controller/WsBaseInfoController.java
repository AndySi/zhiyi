package com.idou.modules.sysEx.controller;

import com.idou.common.utils.R;
import com.idou.modules.api.domain.WsBaseInfoEntity;
import com.idou.modules.api.service.WsBaseInfoService;
import com.idou.modules.sysEx.utils.ImageUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * 
 * @author zhangSi
 * @email andy_si@163.com
 * @date 2018-05-29 11:27:30
 */
@RestController
@RequestMapping("/sysWs/wsbaseInfo")
public class WsBaseInfoController {
	@Autowired
	private WsBaseInfoService wsBaseinfoService;

	/**
	 * 图片上传
	 *
	 * @param mf
	 * @return
	 */
	@RequestMapping(value = "/uploadImg", method = RequestMethod.POST)
	@RequiresPermissions("sysWs:wsbaseInfo:add")
	public R uploadImg(@RequestParam(value = "file") MultipartFile mf) {
		return ImageUtils.uploadSave(mf, "index");
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info")
	@RequiresPermissions("sysWs:wsbaseInfo:info")
	public R info(){
		WsBaseInfoEntity wsBaseinfo = wsBaseinfoService.queryObject();
		
		return R.ok().put("data", wsBaseinfo);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sysWs:wsbaseInfo:add")
	public R save(@RequestBody WsBaseInfoEntity wsBaseinfo){
		wsBaseinfoService.save(wsBaseinfo);
		
		return R.ok();
	}
}
