package com.idou.modules.app.entity;

import com.idou.common.validator.group.AddGroup;
import com.idou.common.validator.group.UpdateGroup;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 商品SKU（库存）
 *
 * @author ZhangSi
 * @email 917661718@qq.com
 * @date 2017-11-23 15:17:43
 */
public class ApiItemSkuEntity implements Serializable {

    private static final long serialVersionUID = 3811458973992905716L;
    @NotNull(message = "商品编号不能为空", groups = UpdateGroup.class)
    private Long id;
    //商品编号
    @NotNull(message = "商品编号不能为空", groups = AddGroup.class)
    private Long itemId;
    private String name;
    //SKU属性
    @NotBlank(message = "SKU属性不能为空", groups = AddGroup.class)
    private String attr;
    private String attrInfo;
    //原价
    @NotNull(message = "原价不能为空", groups = AddGroup.class)
    private BigDecimal originalPrice;
    //销售价
    @NotNull(message = "销售价不能为空", groups = AddGroup.class)
    private BigDecimal price;
    //库存
    @NotNull(message = "库存不能为空", groups = AddGroup.class)
    private Integer stock;
    //SKU销量
    @NotNull(message = "销量不能为空", groups = AddGroup.class)
    private Integer saleNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAttrInfo() {
        return attrInfo;
    }

    public void setAttrInfo(String attrInfo) {
        this.attrInfo = attrInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }
}
