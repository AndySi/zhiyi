package com.idou.modules.sysEx.controller;

import com.idou.common.utils.Query;
import com.idou.common.utils.R;
import com.idou.modules.api.domain.WsServerEntity;
import com.idou.modules.api.service.WsServerService;
import com.idou.modules.sysEx.utils.ImageUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
@RequestMapping("/sysWs/wsserver")
public class WsServerController {
	@Autowired
	private WsServerService wsServerService;

	/**
	 * 封面图片上传
	 *
	 * @param mf
	 * @return
	 */
	@RequestMapping(value = "/uploadImg", method = RequestMethod.POST)
	public R uploadImg(@RequestParam(value = "file") MultipartFile mf) {
		return ImageUtils.uploadSave(mf, "server");
	}

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sysWs:wsserver:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<WsServerEntity> list = wsServerService.queryList(query);
		int total = wsServerService.queryTotal(query);
		return R.page(total ,list);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sysWs:wsserver:info")
	public R info(@PathVariable("id") Long id){
		WsServerEntity wsServer = wsServerService.queryObject(id);
		
		return R.ok().put("data", wsServer);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sysWs:wsserver:add")
	public R save(@RequestBody WsServerEntity wsServer){
		wsServerService.save(wsServer);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sysWs:wsserver:update")
	public R update(@RequestBody WsServerEntity wsServer){
		wsServerService.update(wsServer);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sysWs:wsserver:delete")
	public R delete(@RequestBody Long[] ids){
		wsServerService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
