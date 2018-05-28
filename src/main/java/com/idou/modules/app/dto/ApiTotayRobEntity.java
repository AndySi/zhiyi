package com.idou.modules.app.dto;

import com.idou.modules.app.entity.ApiUserEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 今日必抢活动商品列表VO
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-11-24 下午 2:56
 **/
@ApiModel(value = "ApiTotayRobEntity", description = "今日必抢对象")
public class ApiTotayRobEntity implements Serializable {
    private static final long serialVersionUID = -5825178053136940447L;
    @ApiModelProperty(value = "活动商品编号")
    private Long id;
    @ApiModelProperty(value = "商品编号")
    private Long itemId;
    @ApiModelProperty(value = "商品图片URL")
    private String coverUrl;
    @ApiModelProperty(value = "商品名称")
    private String name;
    @ApiModelProperty(value = "商品描述")
    private String describe;
    @ApiModelProperty(value = "商品原价")
    private BigDecimal originalPrice;
    @ApiModelProperty(value = "商品售价")
    private BigDecimal price;
    @ApiModelProperty(value = "商品库存")
    private int stock;
    @ApiModelProperty(value = "商品SKU销售量")
    private int saleNum;
    @ApiModelProperty(value = "商品购买用户列表")
    private List<ApiUserEntity> userList;
    @ApiModelProperty(value = "活动开始时间")
    private Date startTime;
    @ApiModelProperty(value = "活动结束时间")
    private Date endTime;
    @ApiModelProperty(value = "发货时间")
    private Date sendTime;

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

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(int saleNum) {
        this.saleNum = saleNum;
    }

    public List<ApiUserEntity> getUserList() {
        return userList;
    }

    public void setUserList(List<ApiUserEntity> userList) {
        this.userList = userList;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}
