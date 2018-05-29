package com.idou.modules.api.dto;

/**
 * 数据传输层
 * <p>
 * 用来暴露接口
 *
 * @author zhangSi
 * @email: andy_si@163.com
 * @create 2017-11-24 下午 3:51
 **/

public class ApiExposerVo {
    //秒杀是否开启
    private boolean isOpen;
    //一种加密措施
    private String md5;
    //ID
    private long itemId;
    //系统当前时间
    private long now;
    //开启时间
    private long start;
    //结束时间
    private long end;

    public ApiExposerVo(boolean isOpen, long itemId) {
        this.isOpen = isOpen;
        this.itemId = itemId;
    }

    public ApiExposerVo(boolean isOpen, String md5, long itemId) {
        this.isOpen = isOpen;
        this.md5 = md5;
        this.itemId = itemId;
    }

    public ApiExposerVo(boolean isOpen, String md5, long itemId, long now, long start, long end) {
        this.isOpen = isOpen;
        this.md5 = md5;
        this.itemId = itemId;
        this.now = now;
        this.start = start;
        this.end = end;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public long getNow() {
        return now;
    }

    public void setNow(long now) {
        this.now = now;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }
}
