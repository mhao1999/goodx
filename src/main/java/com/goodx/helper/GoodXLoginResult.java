package com.goodx.helper;

import java.io.Serializable;

public class GoodXLoginResult implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private boolean success;
	
	private String message;
	
	public GoodXLoginResult(boolean success, String message) {
		this.success = success;
		this.message = message;
	}
	
	public boolean getSuccess() {
		return this.success;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
