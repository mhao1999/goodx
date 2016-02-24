package com.goodx.models;

import java.io.Serializable;

public class GoodXRolesPermission implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String permission;

	private String roleName;
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPermission() {
		return this.permission;
	}
	
	public void setPermission(String permission) {
		this.permission = permission;
	}
	
	public String getRoleName() {
		return this.roleName;
	}
	
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
