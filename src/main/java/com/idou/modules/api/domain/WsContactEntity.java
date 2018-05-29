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
public class WsContactEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//总机电话
	private String tel1;
	//电话
	private String tel2;
	//传真
	private String fax;
	//邮箱
	private String email;
	//地址
	private String addr;
	//地址图片
	private String addrpic;
	//工作时间
	private String worktime;
	//banner
	private String banner;

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
	 * 设置：总机电话
	 */
	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}
	/**
	 * 获取：总机电话
	 */
	public String getTel1() {
		return tel1;
	}
	/**
	 * 设置：电话
	 */
	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}
	/**
	 * 获取：电话
	 */
	public String getTel2() {
		return tel2;
	}
	/**
	 * 设置：传真
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}
	/**
	 * 获取：传真
	 */
	public String getFax() {
		return fax;
	}
	/**
	 * 设置：邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：邮箱
	 */
	public String getEmail() {
		return email;
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
	 * 设置：地址图片
	 */
	public void setAddrpic(String addrpic) {
		this.addrpic = addrpic;
	}
	/**
	 * 获取：地址图片
	 */
	public String getAddrpic() {
		return addrpic;
	}
	/**
	 * 设置：工作时间
	 */
	public void setWorktime(String worktime) {
		this.worktime = worktime;
	}
	/**
	 * 获取：工作时间
	 */
	public String getWorktime() {
		return worktime;
	}
	/**
	 * 设置：banner
	 */
	public void setBanner(String banner) {
		this.banner = banner;
	}
	/**
	 * 获取：banner
	 */
	public String getBanner() {
		return banner;
	}
}
