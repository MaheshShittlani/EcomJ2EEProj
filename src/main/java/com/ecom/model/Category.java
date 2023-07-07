package com.ecom.model;

import java.io.Serializable;
import java.util.Date;

public class Category implements Serializable {
	private int id;	
	private String title;
	private String status;
	private Date createdAt;
	private Date updatedAt;
	
	public Category() {
		// TODO Auto-generated constructor stub
	}
	
	public Category(String title, String status) {
		this.title = title;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}
