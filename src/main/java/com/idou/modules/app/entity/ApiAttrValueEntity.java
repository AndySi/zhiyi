package com.idou.modules.app.entity;

import java.io.Serializable;

/**
 * 属性值
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-11-23 下午 3:36
 **/

public class ApiAttrValueEntity implements Serializable {
    private static final long serialVersionUID = 5500183150809396209L;
    //属性值编号
    private Long id;
    //属性值
    private String value;
    //属性名编号
    private Long nameId;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getNameId() {
        return nameId;
    }

    public void setNameId(Long nameId) {
        this.nameId = nameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ApiAttrValueEntity{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", nameId=" + nameId +
                ", name='" + name + '\'' +
                '}';
    }
}
