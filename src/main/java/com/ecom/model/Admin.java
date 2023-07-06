package com.ecom.model;

import java.io.Serializable;

public class Admin implements Serializable {
	private int id;
	private String name;
	private String email;
	private String mobile;
	private String password;
	private String status;
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	public Admin(int id, String name, String email, String mobile, String status) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.status = status;
	}

	public Admin(int id, String name, String email, String mobile, String password, String status) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
