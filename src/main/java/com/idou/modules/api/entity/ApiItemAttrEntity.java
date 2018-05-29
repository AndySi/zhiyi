package com.idou.modules.api.entity;

import com.idou.common.validator.group.AddGroup;
import com.idou.common.validator.group.UpdateGroup;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 商品属性
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-12-21 下午 1:23
 **/

public class ApiItemAttrEntity implements Serializable {
    private static final long serialVersionUID = -3850550464115745441L;

    private Long id;
    @NotNull(message = "商品编号不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private Long itemId;
    private String itemName;
    @NotNull(message = "属性名编号不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private Long attrNameId;
    private String attrName;
    @NotNull(message = "属性值编号不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private Long attrValueId;
    private String attrValue;

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

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Long getAttrNameId() {
        return attrNameId;
    }

    public void setAttrNameId(Long attrNameId) {
        this.attrNameId = attrNameId;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public Long getAttrValueId() {
        return attrValueId;
    }

    public void setAttrValueId(Long attrValueId) {
        this.attrValueId = attrValueId;
    }

    public String getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue;
    }

    @Override
    public String toString() {
        return "ApiItemAttrEntity{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", attrNameId=" + attrNameId +
                ", attrName='" + attrName + '\'' +
                ", attrValueId=" + attrValueId +
                ", attrValue='" + attrValue + '\'' +
                '}';
    }
}
