package com.blog.entities;

public class CreatePost {
	
	private int pid;
	private String pName;
	private String pDescription;
	private String pData;
	private int uId;
	private int cId;

	//default cunstructor
	public CreatePost() {
		super();
	}

	// cunstructor with filds pName, pDesc, pData, uId, cId
	public CreatePost(String pName, String pDescription, String pData, int uId, int cId) {
		super();
		this.pName = pName;
		this.pDescription = pDescription;
		this.pData = pData;
		this.uId = uId;
		this.cId = cId;
	}
	// cunstructro for getting post
	public CreatePost(int pid, String pName, String pDescription, String pData, int uId, int cId) {
		super();
		this.pid = pid;
		this.pName = pName;
		this.pDescription = pDescription;
		this.pData = pData;
		this.uId = uId;
		this.cId = cId;
	}

	// getters and setters
	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpDescription() {
		return pDescription;
	}

	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}

	public String getpData() {
		return pData;
	}

	public void setpData(String pData) {
		this.pData = pData;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	

}
