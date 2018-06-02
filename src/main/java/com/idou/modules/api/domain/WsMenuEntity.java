package com.idou.modules.api.domain;

import java.io.Serializable;


/**
 * @author zhangSi
 * @email andy_si@163.com
 * @date 2018-05-29 11:27:30
 */
public class WsMenuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //菜单名
    private String name;
    //排序号
    private Integer sortnum;
    private Integer usable;
    private String alias;

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Integer getUsable() {
        return usable;
    }

    public void setUsable(Integer usable) {
        this.usable = usable;
    }

    /**
     * 设置：
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置：菜单名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取：菜单名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置：排序号
     */
    public void setSortnum(Integer sortnum) {
        this.sortnum = sortnum;
    }

    /**
     * 获取：排序号
     */
    public Integer getSortnum() {
        return sortnum;
    }
}
