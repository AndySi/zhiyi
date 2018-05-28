package com.idou.modules.wechat.oss;

import com.idou.common.utils.DateUtils;
import com.idou.modules.app.dto.OssConfigEntity;
import org.apache.commons.lang.StringUtils;

import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

/**
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-11-29 下午 3:24
 **/
public abstract class CloudStorageService {
    OssConfigEntity config;;
    /**
     * 文件路径
     *
     * @param prefix 前缀
     * @return 返回上传路径
     */
    public String getPath(String prefix) {
        //生成uuid
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        //文件路径
        String path = DateUtils.format(new Date(), "yyyyMMdd") + "/" + uuid;
        if (StringUtils.isNotBlank(prefix)) {
            path = prefix + "/" + path;
        }
        return path;
    }

    /**
     * 文件上传
     *
     * @param data 文件字节数组
     * @param path 文件路径，包含文件名
     * @return 返回http地址
     */
    public abstract String upload(byte[] data, String path);

    /**
     * 文件上传
     *
     * @param data 文件字节数组
     * @return 返回http地址
     */
    public abstract String upload(byte[] data);

    /**
     * 文件上传
     *
     * @param inputStream 字节流
     * @param path        文件路径，包含文件名
     * @return 返回http地址
     */
    public abstract String upload(InputStream inputStream, String path);

    /**
     * 文件上传
     *
     * @param inputStream 字节流
     * @return 返回http地址
     */
    public abstract String upload(InputStream inputStream);
}
