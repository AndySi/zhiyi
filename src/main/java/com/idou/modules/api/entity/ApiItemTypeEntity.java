package com.idou.modules.api.entity;

import com.idou.common.validator.group.AddGroup;
import com.idou.common.validator.group.UpdateGroup;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 商品分类
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-12-05 下午 4:05
 **/

public class ApiItemTypeEntity implements Serializable {
    private static final long serialVersionUID = -7035523941154017576L;
    @NotNull(message = "分类ID不能为空", groups = UpdateGroup.class)
    private Long id;
    @NotBlank(message = "分类名称不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String name;
    private Long pid;
    private String parentName;
    private Date createTime;
    private List<?> list;
    /**
     * ztree属性
     */
    private Boolean open;

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

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

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ApiItemTypeEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pid=" + pid +
                ", createTime=" + createTime +
                '}';
    }
}
