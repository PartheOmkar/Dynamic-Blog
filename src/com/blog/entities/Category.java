package com.blog.entities;

public class Category {
	
	private int cId;
	private String cName;
	
	//default cunstructor
	public Category() {
		super();
	}

	//cunstructor
	public Category(int cId, String cName) {
		super();
		this.cId = cId;
		this.cName = cName;
	}

	// getters and seters methods
	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}
	
}
