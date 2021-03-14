package com.blog.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.dao.DisplayPostDao;
import com.blog.entities.DisplayPost;
import com.blog.entities.Message;
import com.blog.helper.ConnectionProvider;

/**
 * Servlet implementation class DisplayPostByCid
 */
@WebServlet("/DisplayPostByCid")
public class DisplayPostByCid extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession ses = request.getSession();
		ArrayList<DisplayPost> dp ;
		
		int cid = Integer.parseInt(request.getParameter("cid"));
		
			if(cid==0) {
				DisplayPostDao dpost = new DisplayPostDao(ConnectionProvider.getConnection());
				dp = dpost.getPostData();
			}
			else {
				DisplayPostDao pbycid = new DisplayPostDao(ConnectionProvider.getConnection());
				dp = pbycid.getPostByCid(cid);
				
				if(dp!=null  && dp.size()>0) 
				{
					//Do nothing
				}else {
					Message msg = new Message("This Category Post are not Available", "Error", "alert-danger");
					ses.setAttribute("msgbypost", msg);
				}
				
			}
			ses.setAttribute("getPostByCid", dp);
			ses.setAttribute("CategoryId", cid);
			response.sendRedirect("Main.jsp");
	}
	
}
