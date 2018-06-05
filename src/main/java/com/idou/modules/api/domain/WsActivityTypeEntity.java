package com.idou.modules.api.domain;

import java.io.Serializable;

/**
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2018-06-05 下午 4:39
 **/

public class WsActivityTypeEntity implements Serializable{
    private static final long serialVersionUID = -5974497636604509294L;
    //
    private Long id;
    //
    private String name;
    //
    private Integer sortnum;

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

    public Integer getSortnum() {
        return sortnum;
    }

    public void setSortnum(Integer sortnum) {
        this.sortnum = sortnum;
    }
}
