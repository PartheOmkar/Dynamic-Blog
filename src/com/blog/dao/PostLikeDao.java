package com.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.blog.entities.PostLikeEntity;

public class PostLikeDao {
	
	Connection con;

	public PostLikeDao(Connection con) {
		super();
		this.con = con;
	}
	
	public boolean DoLike(int uid, int pid) {
		boolean flag = false;
		try {
				if(IfuserLike(pid, uid)) {
					
					flag = DeleteLike(pid, uid);
					
				}else {
					String queary = "INSERT INTO PostLike (postId,userId) VALUES (?,?)";
					PreparedStatement pstmt = this.con.prepareStatement(queary);
					pstmt.setInt(1,pid);
					pstmt.setInt(2,uid);
				
					pstmt.executeUpdate();
					
					flag = true;
				}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public boolean DeleteLike(int pid, int uid) {
		
		boolean flag = false;
		try {
			
			String queary = "DELETE FROM PostLike WHERE postId=? AND userId=?";
			PreparedStatement pstmt = this.con.prepareStatement(queary);
			pstmt.setInt(1, pid);
			pstmt.setInt(2, uid);
			pstmt.executeUpdate();
			
			flag = true;
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	return flag;
	}
	
	public int DisplayLike(int pid) {
		
		int count = 0;
		try {
			
			String queary = "SELECT count(*) AS count FROM PostLike WHERE postId=?";
			
			PreparedStatement pstmt = this.con.prepareStatement(queary);
			pstmt.setInt(1, pid);
			
			ResultSet set = pstmt.executeQuery();
			if(set.next()) {
				count = set.getInt("count");
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return count;
	}
	
	public boolean IfuserLike(int pid, int uid) {
		boolean flag = false;
		
		try {
			
			String queary = "SELECT userId FROM PostLike WHERE postId = ? AND userId = ?";
			PreparedStatement pstmt = this.con.prepareStatement(queary);
			pstmt.setInt(1, pid);
			pstmt.setInt(2, uid);
			
			ResultSet set =  pstmt.executeQuery();
			
			if(set.next()) {
				flag = true;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//System.out.print("\n if user like "+ flag);
		return flag;
	}
	
}
