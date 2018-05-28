package com.idou.modules.app.entity;

import java.io.Serializable;

/**
 * banner
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-11-23 下午 4:01
 **/

public class ApiBannerEntity implements Serializable {
    private static final long serialVersionUID = -4517716794988005652L;
    private Long id;
    private String imgUrl;
    private int statu;
    private int sort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getStatu() {
        return statu;
    }

    public void setStatu(int statu) {
        this.statu = statu;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "ApiBannerEntity{" +
                "id=" + id +
                ", imgUrl='" + imgUrl + '\'' +
                ", statu=" + statu +
                ", sort=" + sort +
                '}';
    }
}
