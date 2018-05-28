package com.idou.modules.app.dto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * OSS配置
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-07-24 下午 2:11
 **/
@Component
public class OssConfigEntity {
    //阿里云绑定的域名
    @Value("${oss.aliyun.aliyunDomain}")
    private String aliyunDomain;
    //阿里云路径前缀
    @Value("${oss.aliyun.aliyunPrefix}")
    private String aliyunPrefix;
    //阿里云EndPoint
    @Value("${oss.aliyun.aliyunEndPoint}")
    private String aliyunEndPoint;
    //阿里云AccessKeyId
    @Value("${oss.aliyun.aliyunAccessKeyId}")
    private String aliyunAccessKeyId;
    //阿里云AccessKeySecret
    @Value("${oss.aliyun.aliyunAccessKeySecret}")
    private String aliyunAccessKeySecret;
    //阿里云BucketName
    @Value("${oss.aliyun.aliyunBucketName}")
    private String aliyunBucketName;

    //七牛绑定的域名
    @Value("${oss.qiniu.qiniuDomain}")
    private String qiniuDomain;
    //七牛路径前缀
    @Value("${oss.qiniu.qiniuPrefix}")
    private String qiniuPrefix;
    //七牛ACCESS_KEY
    @Value("${oss.qiniu.qiniuAccessKey}")
    private String qiniuAccessKey;
    //七牛SECRET_KEY
    @Value("${oss.qiniu.qiniuSecretKey}")
    private String qiniuSecretKey;
    //七牛存储空间名
    @Value("${oss.qiniu.qiniuBucketName}")
    private String qiniuBucketName;

    public String getAliyunDomain() {
        return aliyunDomain;
    }

    public void setAliyunDomain(String aliyunDomain) {
        this.aliyunDomain = aliyunDomain;
    }

    public String getAliyunPrefix() {
        return aliyunPrefix;
    }

    public void setAliyunPrefix(String aliyunPrefix) {
        this.aliyunPrefix = aliyunPrefix;
    }

    public String getAliyunEndPoint() {
        return aliyunEndPoint;
    }

    public void setAliyunEndPoint(String aliyunEndPoint) {
        this.aliyunEndPoint = aliyunEndPoint;
    }

    public String getAliyunAccessKeyId() {
        return aliyunAccessKeyId;
    }

    public void setAliyunAccessKeyId(String aliyunAccessKeyId) {
        this.aliyunAccessKeyId = aliyunAccessKeyId;
    }

    public String getAliyunAccessKeySecret() {
        return aliyunAccessKeySecret;
    }

    public void setAliyunAccessKeySecret(String aliyunAccessKeySecret) {
        this.aliyunAccessKeySecret = aliyunAccessKeySecret;
    }

    public String getAliyunBucketName() {
        return aliyunBucketName;
    }

    public void setAliyunBucketName(String aliyunBucketName) {
        this.aliyunBucketName = aliyunBucketName;
    }

    public String getQiniuDomain() {
        return qiniuDomain;
    }

    public void setQiniuDomain(String qiniuDomain) {
        this.qiniuDomain = qiniuDomain;
    }

    public String getQiniuPrefix() {
        return qiniuPrefix;
    }

    public void setQiniuPrefix(String qiniuPrefix) {
        this.qiniuPrefix = qiniuPrefix;
    }

    public String getQiniuAccessKey() {
        return qiniuAccessKey;
    }

    public void setQiniuAccessKey(String qiniuAccessKey) {
        this.qiniuAccessKey = qiniuAccessKey;
    }

    public String getQiniuSecretKey() {
        return qiniuSecretKey;
    }

    public void setQiniuSecretKey(String qiniuSecretKey) {
        this.qiniuSecretKey = qiniuSecretKey;
    }

    public String getQiniuBucketName() {
        return qiniuBucketName;
    }

    public void setQiniuBucketName(String qiniuBucketName) {
        this.qiniuBucketName = qiniuBucketName;
    }
}
