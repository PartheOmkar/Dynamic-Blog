package com.blog.entities;

import java.sql.Timestamp;

public class DisplayPost {
	
	private int pid;
	private String pName;
	private String pDescription;
	private String pData;
	private String uName;
	private String cName;
	private Timestamp pDate;
	
	public DisplayPost() {
		super();
	}

	public DisplayPost(int pid, String pName, String pDescription, String pData, String uName, String cName,
			Timestamp pDate) {
		super();
		this.pid = pid;
		this.pName = pName;
		this.pDescription = pDescription;
		this.pData = pData;
		this.uName = uName;
		this.cName = cName;
		this.pDate = pDate;
	}
	

	public DisplayPost(int pid, String pName, String pDescription, String pData, String uName, String cName) {
		super();
		this.pid = pid;
		this.pName = pName;
		this.pDescription = pDescription;
		this.pData = pData;
		this.uName = uName;
		this.cName = cName;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

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

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Timestamp getpDate() {
		return pDate;
	}

	public void setpDate(Timestamp pDate) {
		this.pDate = pDate;
	}
		
}
