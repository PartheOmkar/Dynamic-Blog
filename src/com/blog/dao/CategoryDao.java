package com.blog.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.blog.entities.Category;

public class CategoryDao {
	
	private Connection con;

	public CategoryDao(Connection con) {
		super();
		this.con = con;
	}
	
	public ArrayList<Category> getCategory(){
		
		ArrayList<Category> list = new ArrayList<>();
			
		try {
			
			String queary = "SELECT * FROM Category";
			
			Statement st = this.con.createStatement();
			ResultSet set = st.executeQuery(queary);
			
			while(set.next()) {
				
				int cId = set.getInt("cId");
				String cName = set.getString("cName");
				Category c = new Category(cId, cName);
				list.add(c);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	

}
