package com.blog.entities;

public class PostLikeEntity {
	
private int uid;
private int pid;
private int lid;
private int count;

	
	public PostLikeEntity(int uid, int pid, int lid, int count) {
	super();
	this.uid = uid;
	this.pid = pid;
	this.lid = lid;
	this.count = count;
	}

	public PostLikeEntity(int uid, int pid, int lid) {
		super();
		this.uid = uid;
		this.pid = pid;
		this.lid = lid;
	}
	
	

	public PostLikeEntity(int uid, int pid) {
		super();
		this.uid = uid;
		this.pid = pid;
	}

	public int getUid() {
		return uid;
	}
	
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public int getPid() {
		return pid;
	}
	
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	public int getLid() {
		return lid;
	}
	
	public void setLid(int lid) {
		this.lid = lid;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	

}
