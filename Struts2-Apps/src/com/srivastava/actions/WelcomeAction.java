package com.srivastava.actions;

public class WelcomeAction {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public String hello(){
		this.setMessage("Hello User");
		return "success";
		
	}

}
