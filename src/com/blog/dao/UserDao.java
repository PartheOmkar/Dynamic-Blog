package com.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import com.blog.entities.User;

public class UserDao {
	
	private Connection con;

	public UserDao(Connection con) {
		this.con = con;
	}
	
	// method to insert data
	
	public boolean saveUser(User user)
	{
		boolean f = false;
		try {
				// user --> database
				
				String queary = "insert into user(name,email,password,gender,about) values(?,?,?,?,?)";
				
				PreparedStatement pstmt = this.con.prepareStatement(queary);
				pstmt.setString(1, user.getName());
				pstmt.setString(2, user.getEmail());
				pstmt.setString(3, user.getPassword());
				pstmt.setString(4, user.getGender());
				pstmt.setString(5, user.getAbout());
				
				pstmt.executeUpdate();
				f=true;
				
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
	}
	
	public User validationOfEmailandPassword(String email, String password) {
		User user = null;
		
		try {
			
			String queary = "select * from user where email =? and password=?";
			
			PreparedStatement pt = this.con.prepareStatement(queary);
			pt.setString(1, email);
			pt.setString(2, password);
			
			ResultSet rst =  pt.executeQuery();
			if(rst.next()) {
				user = new User();
				user.setId(rst.getInt("ID"));
				user.setName(rst.getString("name"));
				user.setEmail(rst.getString("email"));
				user.setGender(rst.getString("gender"));
				user.setAbout(rst.getString("about"));
				user.setDateTime(Timestamp.valueOf(rst.getString("rdate")));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
}
