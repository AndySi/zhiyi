package com.idou.modules.app.entity;

import java.io.Serializable;

/**
 * 商品详情
 *
 * @author ZhangSi
 * @email 917661718@qq.com
 * @date 2017-11-23 15:17:43
 */
public class ApiItemDetailEntity implements Serializable {

    private static final long serialVersionUID = 3886677424160615081L;
    //
    private Long id;
    //商品编号
    private Long itemId;
    //图片地址
    private String imgUrl;
    // 排序
    private int sort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "ApiItemDetailEntity{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", imgUrl='" + imgUrl + '\'' +
                ", sort=" + sort +
                '}';
    }
}
