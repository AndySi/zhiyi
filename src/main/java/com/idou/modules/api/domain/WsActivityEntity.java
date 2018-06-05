package com.idou.modules.api.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author:ZhangSi
 * @email:andy_si@163.com
 * @date:2018/6/5
 */
public class WsActivityEntity implements Serializable {
    private static final long serialVersionUID = 476898112244559872L;
    private long id;
    private String title;
    private String link;
    private int poll;
    private long typeid;
    private String typename;
    private Date createtime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getPoll() {
        return poll;
    }

    public void setPoll(int poll) {
        this.poll = poll;
    }

    public long getTypeid() {
        return typeid;
    }

    public void setTypeid(long typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
