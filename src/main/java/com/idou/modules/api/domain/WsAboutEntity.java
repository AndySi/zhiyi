package com.idou.modules.api.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author:ZhangSi
 * @email:andy_si@163.com
 * @date:2018/6/2
 */
public class WsAboutEntity implements Serializable {
    private static final long serialVersionUID = -5124866703800923836L;

    private long id;
    private String cover;
    private Date createTime;
    private List<WsAboutListEntity> aboutList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<WsAboutListEntity> getAboutList() {
        return aboutList;
    }

    public void setAboutList(List<WsAboutListEntity> aboutList) {
        this.aboutList = aboutList;
    }
}
