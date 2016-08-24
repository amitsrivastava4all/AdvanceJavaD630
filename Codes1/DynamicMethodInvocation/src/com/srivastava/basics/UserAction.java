package com.srivastava.basics;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{

	private String message;
	
	public String execute()
	{
		message = "Inside execute method";
		return SUCCESS;		
	}
	
	public String add()
	{
		message = "Inside add method";
		System.out.println("Inside Add ... ");
		return SUCCESS;		
	}
	
	public String update()
	{
		message = "Inside update method";
		return SUCCESS;		
	}
	
	public String delete()
	{
		message = "Inside delete method";
		System.out.println("Inside Delete ... ");
		return SUCCESS;		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
