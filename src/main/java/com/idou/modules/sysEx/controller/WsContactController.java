package com.idou.modules.sysEx.controller;

import com.idou.common.utils.R;
import com.idou.modules.api.domain.WsContactEntity;
import com.idou.modules.api.service.WsContactService;
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
 * @date 2018-05-29 16:21:07
 */
@RestController
@RequestMapping("/sysWs/wscontact")
public class WsContactController {
	@Autowired
	private WsContactService wsContactService;

	/**
	 * 图片上传
	 *
	 * @param mf
	 * @return
	 */
	@RequestMapping(value = "/uploadImg", method = RequestMethod.POST)
	@RequiresPermissions("sysWs:wsjoin:add")
	public R uploadImg(@RequestParam(value = "file") MultipartFile mf) {
		return ImageUtils.uploadSave(mf, "contact");
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info")
	@RequiresPermissions("sysWs:wscontact:info")
	public R info(){
		WsContactEntity wsContact = wsContactService.queryObject();
		
		return R.ok().put("data", wsContact);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sysWs:wscontact:add")
	public R save(@RequestBody WsContactEntity wsContact){
		wsContactService.save(wsContact);
		
		return R.ok();
	}
}
