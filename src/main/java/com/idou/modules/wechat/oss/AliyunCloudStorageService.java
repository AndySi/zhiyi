package com.idou.modules.wechat.oss;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.idou.common.exception.RRException;
import com.idou.modules.app.dto.OssConfigEntity;
import org.apache.log4j.Logger;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * 阿里云 OSS文件类
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-07-24 上午 10:46
 **/
public class AliyunCloudStorageService extends CloudStorageService {
    private OSSClient ossClient;

    public AliyunCloudStorageService(OssConfigEntity config) {
        this.config =config;
        // 实例化OSSClient
        this.ossClient = new OSSClient(config.getAliyunEndPoint(), config.getAliyunAccessKeyId(),
                config.getAliyunAccessKeySecret());
        // 创建bucket
        this.ossClient.createBucket(config.getAliyunBucketName());
        // 设置bucket权限
        this.ossClient.setBucketAcl(config.getAliyunBucketName(), CannedAccessControlList.PublicRead);
    }


    @Override
    public String upload(byte[] data, String path) {
        return upload(new ByteArrayInputStream(data), path);
    }

    @Override
    public String upload(byte[] data) {
        return upload(data, getPath(config.getAliyunPrefix()));
    }

    @Override
    public String upload(InputStream inputStream, String path) {
        try {
            // 创建上传Object的Metadata
            ObjectMetadata meta = new ObjectMetadata();
            // 设置上传文件长度
            meta.setContentLength(inputStream.available());
            // 指定该Object被下载时的网页的缓存行为
            meta.setCacheControl("no-cache");
            // 指定该Object下设置Header
            meta.setHeader("Pragma", "no-cache");
            // 指定该Object被下载时的内容编码格式
            meta.setContentEncoding("utf-8");
            // 文件的MIME，定义文件的类型及网页编码，决定浏览器将以什么形式、什么编码读取文件。如果用户没有指定则根据Key或文件名的扩展名生成，
            // 如果没有扩展名则填默认值application/octet-stream
            meta.setContentType("image/jpeg");
            // 上传文件   (上传文件流的形式)
            PutObjectResult result = this.ossClient.putObject(config.getAliyunBucketName(), path, inputStream, meta);
            // 关闭client
            ossClient.shutdown();
            // 解析结果
            // result.getETag();
        } catch (Exception e) {
            throw new RRException("上传文件失败，请检查配置信息", e);
        }
        return config.getAliyunDomain() + "/" + path;
    }

    @Override
    public String upload(InputStream inputStream) {
        return upload(inputStream, getPath(config.getAliyunPrefix()));
    }

    /**
     * 根据key删除OSS服务器上的文件
     *
     * @param ossClient  oss连接
     * @param bucketName 存储空间
     * @param folder     模拟文件夹名 如"qj_nanjing/"
     * @param key        Bucket下的文件的路径名+文件名 如："upload/cake.jpg"
     */
    public void deleteFile(OSSClient ossClient, String bucketName, String folder, String key) {
        ossClient.deleteObject(bucketName, folder + key);
        Logger.getLogger(AliyunCloudStorageService.class).info("删除" + bucketName + "下的文件" + folder + key + "成功");
    }

    /**
     * 通过文件名判断并获取OSS服务文件上传时文件的contentType
     *
     * @param fileName 文件名
     * @return 文件的contentType
     */
    public String getContentType(String fileName) {
        //文件的后缀名
        String fileExtension = fileName.substring(fileName.lastIndexOf("."));
        if (".bmp".equalsIgnoreCase(fileExtension)) {
            return "image/bmp";
        }
        if (".gif".equalsIgnoreCase(fileExtension)) {
            return "image/gif";
        }
        if (".jpeg".equalsIgnoreCase(fileExtension) || ".jpg".equalsIgnoreCase(fileExtension) || ".png".equalsIgnoreCase(fileExtension)) {
            return "image/jpeg";
        }
        if (".html".equalsIgnoreCase(fileExtension)) {
            return "text/html";
        }
        if (".txt".equalsIgnoreCase(fileExtension)) {
            return "text/plain";
        }
        if (".vsd".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.visio";
        }
        if (".ppt".equalsIgnoreCase(fileExtension) || "pptx".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.ms-powerpoint";
        }
        if (".doc".equalsIgnoreCase(fileExtension) || "docx".equalsIgnoreCase(fileExtension)) {
            return "application/msword";
        }
        if (".xml".equalsIgnoreCase(fileExtension)) {
            return "text/xml";
        }
        //默认返回类型
        return "image/jpeg";
    }
}
