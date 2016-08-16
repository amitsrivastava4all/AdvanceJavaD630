package com.srivastava.actions;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private String userid;
	private String pwd;
	private String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String doLogin(){
		if(this.getUserid().equals(this.getPwd())){
			
			this.setMessage(this.getText("welcome.msg")+this.getUserid());
			return "welcome";
		}
		else
		{
			this.setMessage(this.getText("error.invalid"));
			return "error";
		}
	}

}
