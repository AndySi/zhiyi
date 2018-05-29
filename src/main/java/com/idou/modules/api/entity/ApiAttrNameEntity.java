package com.idou.modules.api.entity;

import com.idou.common.validator.group.AddGroup;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 属性名
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-11-23 下午 3:35
 **/

public class ApiAttrNameEntity implements Serializable {
    private static final long serialVersionUID = -8554743148500382051L;
    //属性名编号
    private Long id;
    //属性名
    @NotBlank(message = "属性名不能为空", groups = AddGroup.class)
    private String name;
    //商品分类编号
    @NotNull(message = "商品分类编号不能为空", groups = AddGroup.class)
    private Long itemTypeId;
    private String itemTypeName;
    //父属性编号
    private Long pid;
    private String parentName;

    private List<?> list;
    /**
     * ztree属性
     */
    private Boolean open;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(Long itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    public String getItemTypeName() {
        return itemTypeName;
    }

    public void setItemTypeName(String itemTypeName) {
        this.itemTypeName = itemTypeName;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    @Override
    public String toString() {
        return "ApiAttrNameEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", itemTypeId=" + itemTypeId +
                ", itemTypeName='" + itemTypeName + '\'' +
                ", pid=" + pid +
                ", parentName='" + parentName + '\'' +
                ", list=" + list +
                ", open=" + open +
                '}';
    }
}
