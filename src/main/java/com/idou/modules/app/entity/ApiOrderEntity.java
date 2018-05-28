package com.idou.modules.app.entity;

import com.idou.common.validator.group.AddGroup;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 订单表
 *
 * @author ZhangSi
 * @email 917661718@qq.com
 * @date 2017-11-23 15:17:43
 */
public class ApiOrderEntity implements Serializable {
    private static final long serialVersionUID = 6643725528759430362L;
    //
    private Long id;
    //订单号
    private String orderNo;
    //活动商品编号
    @ApiModelProperty(value = "商品编号", required = true)
    @NotNull(message = "商品编号不能为空", groups = AddGroup.class)
    private Long itemId;
    //订单数量
    @ApiModelProperty(value = "订单数量", required = true)
    @NotNull(message = "订单数量不能为空", groups = AddGroup.class)
    private Integer orderNum;
    //订单金额
    @ApiModelProperty(value = "订单金额", required = true)
    @NotNull(message = "订单金额不能为空", groups = AddGroup.class)
    private BigDecimal orderMoney;
    //订单地址
    @ApiModelProperty(value = "订单地址", required = true)
    @NotNull(message = "订单地址不能为空", groups = AddGroup.class)
    private Long addressId;
    //下单人
    @ApiModelProperty(value = "下单人")
    private Long userId;
    //收货人
    @ApiModelProperty(value = "收货人", required = true)
    @NotBlank(message = "收货人不能为空", groups = AddGroup.class)
    private String receiver;
    //收货人手机号码
    @ApiModelProperty(value = "收货人手机号码", required = true)
    @NotBlank(message = "收货人手机号码不能为空", groups = AddGroup.class)
    private String tel;
    //支付方式（0：微信）
    private Integer payType;
    //订单方式
    private Integer orderState;
    //创建时间
    private Date createTime;
    // 过期时间
    private Date expireTime;

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public BigDecimal getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(BigDecimal orderMoney) {
        this.orderMoney = orderMoney;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
