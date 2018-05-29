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
public class WsNewsTypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//
	private String name;
	//
	private Integer sortnum;

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
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：
	 */
	public void setSortnum(Integer sortnum) {
		this.sortnum = sortnum;
	}
	/**
	 * 获取：
	 */
	public Integer getSortnum() {
		return sortnum;
	}
}
