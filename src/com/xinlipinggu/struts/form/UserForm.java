package com.xinlipinggu.struts.form;


import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class UserForm extends ActionForm implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//该表单用来定义用户信息
	private String username;
	private String password;
	private int uId;
	private boolean remberUser;
	private int pagenow;
	public int getPagenow() {
		return pagenow;
	}
	public void setPagenow(int pagenow) {
		this.pagenow = pagenow;
	}
	public boolean remberUser() {
		return remberUser;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public void setRemberUser(boolean remberUser) {
		this.remberUser = remberUser;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
