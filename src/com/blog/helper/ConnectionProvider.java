package com.blog.helper;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DatabaseConnection
 */

public class ConnectionProvider extends HttpServlet {
	
	private static Connection con;
	
	public static Connection getConnection() {
		
		try {
			
			if(con == null) {
				Class.forName("org.sqlite.JDBC");
	            String dbURL = "jdbc:sqlite:/opt/SpringToolSuitEditor/Blog/Blog.sqlite";
	            con = DriverManager.getConnection(dbURL);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	

}
