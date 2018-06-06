package com.idou.modules.api.domain;

import java.io.Serializable;


/**
 * 
 * 
 * @author zhangSi
 * @email andy_si@163.com
 * @date 2018-05-29 11:27:30
 */
public class WsBaseInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//logo
	private String logo;
	private String companyname;
	//口号
	private String slogan;
	//服务热线
	private String tel;
	//QQ
	private String qq;
	//服务时间
	private String servertime;
	//二维码
	private String qrcode;
	//地址
	private String addr;
	//关于我们
	private String aboutus;
	//版权信息
	private String copyright;

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
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
	 * 设置：logo
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}
	/**
	 * 获取：logo
	 */
	public String getLogo() {
		return logo;
	}
	/**
	 * 设置：口号
	 */
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	/**
	 * 获取：口号
	 */
	public String getSlogan() {
		return slogan;
	}
	/**
	 * 设置：服务热线
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * 获取：服务热线
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * 设置：QQ
	 */
	public void setQq(String qq) {
		this.qq = qq;
	}
	/**
	 * 获取：QQ
	 */
	public String getQq() {
		return qq;
	}
	/**
	 * 设置：服务时间
	 */
	public void setServertime(String servertime) {
		this.servertime = servertime;
	}
	/**
	 * 获取：服务时间
	 */
	public String getServertime() {
		return servertime;
	}
	/**
	 * 设置：二维码
	 */
	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}
	/**
	 * 获取：二维码
	 */
	public String getQrcode() {
		return qrcode;
	}
	/**
	 * 设置：地址
	 */
	public void setAddr(String addr) {
		this.addr = addr;
	}
	/**
	 * 获取：地址
	 */
	public String getAddr() {
		return addr;
	}
	/**
	 * 设置：关于我们
	 */
	public void setAboutus(String aboutus) {
		this.aboutus = aboutus;
	}
	/**
	 * 获取：关于我们
	 */
	public String getAboutus() {
		return aboutus;
	}
	/**
	 * 设置：版权信息
	 */
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	/**
	 * 获取：版权信息
	 */
	public String getCopyright() {
		return copyright;
	}
}
