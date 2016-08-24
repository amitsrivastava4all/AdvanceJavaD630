package com.srivastava.actions;

import com.opensymphony.xwork2.ActionSupport;

public class JQueryAction extends ActionSupport {
	private String userid;
	private String password;
	private String message;
	
	public String execute(){
		if(this.getUserid().equals(this.getPassword())){
			this.setMessage("Welcome "+this.getUserid());
		}
		else
		{
			this.setMessage("Invalid Userid or Password");
		}
		return SUCCESS;
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
