package com.idou.modules.sysEx.utils;

import com.alibaba.fastjson.JSONObject;
import com.idou.common.constant.CodeMsg;
import com.idou.common.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * img工具类
 *
 * @author:ZhangSi
 * @email:andy_si@163.com
 * @date:2018/5/30
 */
@ConfigurationProperties(prefix = "img")
@Component
public class ImageUtils {
    private static Logger logger = LoggerFactory.getLogger(ImageUtils.class);

    private static String location;
    private static String nginxLocation;

    public static R uploadSave(MultipartFile mf, String catalog){
        JSONObject ret = new JSONObject();
        if (mf.isEmpty()) {
            return R.error(CodeMsg.FILE_NOT_NULL.getMsg());
        }
        // 获取文件名,文件类型
        String fileName = mf.getOriginalFilename();
        String contentType = mf.getContentType();
        logger.info("上传的文件名为：:name={},type={}", fileName, contentType);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        logger.info("上传的后缀名为：", suffixName);
        // 文件上传后的路径
        String newPath = catalog + File.separator + DateUtils.getYmd() + File.separator;
        String filePath = location + newPath;
        // 解决中文问题，liunx下中文路径，图片显示问题，重新生成图片名
        fileName = KeyBuilder.generate() + suffixName;
        // 构建文件目录
        File dest = new File(filePath + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            mf.transferTo(dest);
            ret.put("src", nginxLocation + File.separator + newPath + fileName);
            ret.put("title", fileName);
            return R.ok().put("data", ret);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return R.error(CodeMsg.FILE_UPLOAD_FAIL.getMsg());
    }

    public String getNginxLocation() {
        return nginxLocation;
    }

    public void setNginxLocation(String nginxLocation) {
        this.nginxLocation = nginxLocation;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
