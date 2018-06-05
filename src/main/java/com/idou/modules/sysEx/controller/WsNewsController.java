package com.idou.modules.sysEx.controller;

import com.idou.common.utils.Query;
import com.idou.common.utils.R;
import com.idou.modules.api.domain.WsNewsEntity;
import com.idou.modules.api.service.WsNewsService;
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
@RequestMapping("/sysWs/wsnews")
public class WsNewsController {
	@Autowired
	private WsNewsService wsNewsService;

	/**
	 * 封面图片上传
	 *
	 * @param mf
	 * @return
	 */
	@RequestMapping(value = "/uploadCover", method = RequestMethod.POST)
	@RequiresPermissions("sysWs:wsnewstype:add")
	public R uploadImg(@RequestParam(value = "file") MultipartFile mf) {
		return ImageUtils.uploadSave(mf, "news");
	}

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sysWs:wsnews:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<WsNewsEntity> list = wsNewsService.queryList(query);
		int total = wsNewsService.queryTotal(query);
		
		return R.page(total, list);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("sysWs:wsnews:info")
	public R info(@PathVariable("id") Long id){
		WsNewsEntity wsNews = wsNewsService.queryObject(id);
		
		return R.ok().put("data", wsNews);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("sysWs:wsnews:add")
	public R save(@RequestBody WsNewsEntity wsNews){
		wsNewsService.save(wsNews);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("sysWs:wsnews:update")
	public R update(@RequestBody WsNewsEntity wsNews){
		wsNewsService.update(wsNews);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("sysWs:wsnews:delete")
	public R delete(@RequestBody Long[] ids){
		wsNewsService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
