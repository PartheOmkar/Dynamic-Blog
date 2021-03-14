package com.blog.entities;

public class CommentEntity {
	
	private int pid;
	private int uid;
	private String uname;
	private String CommentText;
	// for insert comment
	public CommentEntity(int pid, int uid, String commentText) {
		super();
		this.pid = pid;
		this.uid = uid;
		CommentText = commentText;
	}
	// for Display comment
	
	public CommentEntity(int uid, String uname, String commentText) {
		super();
		this.uid = uid;
		this.uname = uname;
		CommentText = commentText;
	}
	
	
	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getCommentText() {
		return CommentText;
	}

	public void setCommentText(String commentText) {
		CommentText = commentText;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}
	
	

}
