package com.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.blog.entities.CreatePost;

public class CreatePostDao {
	
	private Connection con;
	
	
	public CreatePostDao(Connection con) {
		super();
		this.con = con;
	}


	public boolean createPost(CreatePost p) {
		boolean flag = false;
		
		try {
				String queary = "insert into post(pTitle,pDescription,pData,cId,uId) values(?,?,?,?,?)";
				
				PreparedStatement pstm = this.con.prepareStatement(queary);
				
				pstm.setString(1, p.getpName());
				pstm.setString(2, p.getpDescription());
				pstm.setString(3, p.getpData());
				pstm.setInt(4, p.getcId());
				pstm.setInt(5, p.getuId());
				
				pstm.executeUpdate();
				
				flag = true;
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return flag;
	}
	
	

}
