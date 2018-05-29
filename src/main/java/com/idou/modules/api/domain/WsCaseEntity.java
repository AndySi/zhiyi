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
public class WsCaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//标题
	private String title;
	//封面
	private String cover;
	//案例类型
	private Long typeid;
	//创建时间
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
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：封面
	 */
	public void setCover(String cover) {
		this.cover = cover;
	}
	/**
	 * 获取：封面
	 */
	public String getCover() {
		return cover;
	}
	/**
	 * 设置：案例类型
	 */
	public void setTypeid(Long typeid) {
		this.typeid = typeid;
	}
	/**
	 * 获取：案例类型
	 */
	public Long getTypeid() {
		return typeid;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreatetime() {
		return createtime;
	}
}
