package com.idou.modules.api.domain;

import java.io.Serializable;

/**
 * 关于列表
 *
 * @author:ZhangSi
 * @email:andy_si@163.com
 * @date:2018/6/2
 */
public class WsAboutListEntity implements Serializable {
    private static final long serialVersionUID = -2818348964789319602L;
    private long id;
    private String title;
    private String content;
    private long aboutId;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getAboutId() {
        return aboutId;
    }

    public void setAboutId(long aboutId) {
        this.aboutId = aboutId;
    }
}
