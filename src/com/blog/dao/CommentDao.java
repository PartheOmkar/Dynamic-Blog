package com.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.blog.entities.CommentEntity;

public class CommentDao {

	private Connection con;
	
	public CommentDao(Connection con) {
		super();
		this.con = con;
	}
	
	public boolean InsertComment(int pid, int uid, String CommentText) {
		boolean flag = false;
		
		try {
			
			String queari = "INSERT INTO PostComment (Comment,cpid,cuid) VALUES (?,?,?);";
			PreparedStatement pstmt = this.con.prepareStatement(queari);
			pstmt.setString(1, CommentText);
			pstmt.setInt(2, pid);
			pstmt.setInt(3, uid);
			pstmt.executeUpdate();
			
			flag = true;
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return flag;
	}
	public ArrayList<CommentEntity> DisplayComment(int pid) {
		
		ArrayList<CommentEntity> CommentList = new ArrayList<>();
		try {
			
			String queari = "SELECT c.Comment, c.cuid, u.name FROM PostComment c \n"
					+ "INNER JOIN user u ON u.ID = c.cuid WHERE cpid=?";
			
			PreparedStatement pstmt = this.con.prepareStatement(queari);
			pstmt.setInt(1, pid);
			
			ResultSet rst = pstmt.executeQuery();
			
			while(rst.next()) {
				
				String commentText = rst.getString("Comment");
				int uid = rst.getInt("cuid");
				String uname = rst.getString("name");
				
				CommentEntity ce = new CommentEntity(uid, uname, commentText);
				CommentList.add(ce);
				
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return CommentList;
	}
}
