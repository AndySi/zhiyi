package com.idou.modules.sysEx.controller;


import com.alibaba.fastjson.JSONObject;
import com.idou.common.exception.RRException;
import com.idou.common.utils.Query;
import com.idou.common.utils.R;
import com.idou.modules.api.domain.WsCaseEntity;
import com.idou.modules.api.service.WsCaseService;
import com.idou.modules.sysEx.utils.ImageUtils;
import com.idou.modules.sysEx.utils.KeyBuilder;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @author zhangSi
 * @email andy_si@163.com
 * @date 2018-05-29 16:21:07
 */
@RestController
@RequestMapping("/sysWs/wscase")
public class WsCaseController {
    private static Logger logger = LoggerFactory.getLogger(WsCaseController.class);
    @Autowired
    private WsCaseService wsCaseService;
    @Autowired
    private ImageUtils imageUtils;

    @RequestMapping("/uploadImg")
    public R uploadImg(HttpServletRequest request) {
        JSONObject ret = new JSONObject();
        //返回信息
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> filemap = multipartRequest.getFileMap();
        // 指定一个上传图片目录
        String realPath = imageUtils.getLocation();
        String filePath = "/case" + "/";
        String imgPath = realPath + filePath;
        // 构建文件目录
        File file = new File(imgPath);
        if (!file.exists()) {
            file.mkdirs();
        }

        for (Map.Entry<String, MultipartFile> entity : filemap.entrySet()) {
            // 上传文件
            MultipartFile mf = entity.getValue();
            if (mf.isEmpty() || StringUtils.isBlank(mf.getOriginalFilename())) {
                throw new RRException("图片不能为空");
            }
            String contentType = mf.getContentType();
            if (!contentType.contains("")) {
                throw new RRException("图片格式错误");
            }
            String fileName = mf.getOriginalFilename();
            logger.info("上传图片:name={},type={}", fileName, contentType);
            // 重新生成图片名
            String path = imgPath + KeyBuilder.generate();
            File uploadFile = new File(path);
            try {
                mf.transferTo(uploadFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
            ret.put("src", path);
        }
        return R.ok().put("data", ret);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sysWs:wscase:list")
    public R list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);

        List<WsCaseEntity> list = wsCaseService.queryList(query);
        int total = wsCaseService.queryTotal(query);

        return R.page(total, list);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("sysWs:wscase:info")
    public R info(@PathVariable("id") Long id) {
        WsCaseEntity wsCase = wsCaseService.queryObject(id);

        return R.ok().put("data", wsCase);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sysWs:wscase:save")
    public R save(@RequestBody WsCaseEntity wsCase) {
        wsCaseService.save(wsCase);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sysWs:wscase:update")
    public R update(@RequestBody WsCaseEntity wsCase) {
        wsCaseService.update(wsCase);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sysWs:wscase:delete")
    public R delete(@RequestBody Long[] ids) {
        wsCaseService.deleteBatch(ids);

        return R.ok();
    }

}
