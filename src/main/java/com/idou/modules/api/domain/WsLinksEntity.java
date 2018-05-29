package com.idou.modules.api.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * @author zhangSi
 * @email andy_si@163.com
 * @date 2018-05-29 16:21:07
 */
public class WsLinksEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//网址名
	private String name;
	//网址链接
	private String url;
	//
	private Date createtime;

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
	 * 设置：网址名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：网址名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：网址链接
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：网址链接
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置：
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * 获取：
	 */
	public Date getCreatetime() {
		return createtime;
	}
}
