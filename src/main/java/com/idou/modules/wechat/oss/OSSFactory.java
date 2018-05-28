package com.idou.modules.wechat.oss;

import com.idou.common.enums.CloudServiceEnum;
import com.idou.modules.app.dto.OssConfigEntity;

/**
 * 文件上传Factory
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-11-29 下午 3:00
 **/

public final class OSSFactory {
    public static CloudStorageService bulid(int type, OssConfigEntity config) {
        if (type == CloudServiceEnum.QINIU.getValue()) {
            return new QiniuCloudStorageService(config);
        } else if (type == CloudServiceEnum.ALIYUN.getValue()) {
            return new AliyunCloudStorageService(config);
        }
        return null;
    }
}
