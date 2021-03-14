package com.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.blog.entities.CreatePost;
import com.blog.entities.DisplayPost;
public class DisplayPostDao {
	
	private Connection con;

	public DisplayPostDao(Connection con) {
		super();
		this.con = con;
	}
	
	
	public ArrayList<DisplayPost> getPostData(){
		
	ArrayList<DisplayPost> list = new ArrayList<>();
		
		try {
				String queary = "SELECT p.pid, p.pTitle, p.pDescription, p.pData, c.cName, u.name, p.pDate FROM post p INNER JOIN Category c ON p.cId = c.cId INNER JOIN user u ON p.uId = u.ID";
				
				Statement st = this.con.createStatement();
				ResultSet set = st.executeQuery(queary);
				
				while(set.next()) {
					
					int pid = set.getInt("pid");
					String pName = set.getString("pTitle");
					String pDescription = set.getString("pDescription");
					String pData = set.getString("pData");
					String uName = set.getString("name");
					String cName = set.getString("cName");
					Timestamp pDate = Timestamp.valueOf(set.getString("pDate"));
					
					DisplayPost displayPost = new DisplayPost(pid, pName, pDescription, pData, uName, cName, pDate);
					
					list.add(displayPost);
					
				}
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}

	public DisplayPost getPostDataById(int pid) {
		
		DisplayPost dp = null;
		
		try {
				String queary = "SELECT p.pid, p.pTitle, p.pDescription, p.pData, c.cName, u.name, p.pDate\n"
						+ "FROM post p INNER JOIN Category c ON p.cId = c.cId\n"
						+ "INNER JOIN user u ON p.uId = u.ID\n"
						+ "WHERE p.pid= ?";
				
				PreparedStatement pstmt = this.con.prepareStatement(queary);
				pstmt.setInt(1,pid);
			
				ResultSet res = pstmt.executeQuery();
				
				while(res.next()) {
					
					dp = new DisplayPost();
					dp.setPid(pid);
					dp.setpName(res.getString("pTitle"));
					dp.setpDescription(res.getString("pDescription"));
					dp.setpData(res.getString("pData"));
					dp.setuName(res.getString("name"));
					dp.setcName(res.getString("cName"));
					dp.setpDate(Timestamp.valueOf(res.getString("pDate")));
					
				}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return dp;
	}
	
	public ArrayList<DisplayPost> getPostByCid(int cid){
		
		ArrayList<DisplayPost> pbycid = new ArrayList<>();
		DisplayPost dp = null;
		try {
			
			String qu = "SELECT p.pid, p.pTitle, p.pDescription, p.pData, c.cName, u.name, p.pDate\n"
					+ "FROM post p INNER JOIN Category c ON p.cId = c.cId\n"
					+ "INNER JOIN user u ON p.uId = u.ID\n"
					+ "WHERE c.cId= ?";
			PreparedStatement st = this.con.prepareStatement(qu);
			st.setInt(1, cid);
			
			ResultSet set = st.executeQuery();
			
			while(set.next()) {
				int pid = set.getInt("pid");
				String pName = set.getString("pTitle");
				String pDescription = set.getString("pDescription");
				String pData = set.getString("pData");
				String uName = set.getString("name");
				String cName = set.getString("cName");
				Timestamp pDate = Timestamp.valueOf(set.getString("pDate"));
				dp = new DisplayPost(pid, pName, pDescription, pData, uName, cName, pDate);
				pbycid.add(dp);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return pbycid;
		
	}
}
