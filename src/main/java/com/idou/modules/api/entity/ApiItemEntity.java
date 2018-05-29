package com.idou.modules.api.entity;

import com.idou.common.validator.group.AddGroup;
import com.idou.common.validator.group.UpdateGroup;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 商品
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-11-23 下午 3:19
 **/
public class ApiItemEntity implements Serializable {
    private static final long serialVersionUID = -663136636256795550L;

    @NotNull(message = "商品ID不能为空", groups = UpdateGroup.class)
    private Long id;
    // 名称
    @NotBlank(message = "商品名称不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String name;
    // 分类ID
    @NotNull(message = "商品分类不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private Long typeId;
    // 描述
    @NotBlank(message = "商品描述不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String describe;
    // 商品图片
    @NotBlank(message = "商品图片不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String coverUrl;
    // SPU售量
    private Integer SPUSaleNum;

    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
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

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public Integer getSPUSaleNum() {
        return SPUSaleNum;
    }

    public void setSPUSaleNum(Integer SPUSaleNum) {
        this.SPUSaleNum = SPUSaleNum;
    }
}
