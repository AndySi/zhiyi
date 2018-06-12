package com.idou.modules.api.domain;

import java.io.Serializable;


/**
 * @author zhangSi
 * @email andy_si@163.com
 * @date 2018-05-29 16:21:07
 */
public class WsBannerEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    //
    private Long id;
    //banner图片路径
    private String url;
    private String mobileurl;
    //banner图片链接
    private String link;
    //排序
    private Integer sortnum;
    //案例名称
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMobileurl() {
        return mobileurl;
    }

    public void setMobileurl(String mobileurl) {
        this.mobileurl = mobileurl;
    }

    /**
     * 设置：
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置：banner图片路径
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取：banner图片路径
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置：banner图片链接
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * 获取：banner图片链接
     */
    public String getLink() {
        return link;
    }

    /**
     * 设置：排序
     */
    public void setSortnum(Integer sortnum) {
        this.sortnum = sortnum;
    }

    /**
     * 获取：排序
     */
    public Integer getSortnum() {
        return sortnum;
    }
}
