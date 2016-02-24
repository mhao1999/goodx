package com.goodx.models;

import java.io.Serializable;

public class GoodXUserRole implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String roleName;

	private String email;
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getRoleName() {
		return this.roleName;
	}
	
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
