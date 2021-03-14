package com.blog.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.dao.CreatePostDao;
import com.blog.entities.CreatePost;
import com.blog.entities.Message;
import com.blog.entities.User;
import com.blog.helper.ConnectionProvider;

/**
 * Servlet implementation class CreatePost_page
 */
@WebServlet("/CreatePost_page")
public class CreatePost_page extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession s = request.getSession();
		User user = (User) s.getAttribute("currentUser");
		
		int uId = user.getId();
		
		int cId = Integer.parseInt(request.getParameter("pCategory"));
		String pName = request.getParameter("pName");
		String pDescription = request.getParameter("pDescription");
		String pData = request.getParameter("pData");
		
		CreatePost p = new CreatePost(pName, pDescription, pData, uId, cId);
		
		CreatePostDao d = new CreatePostDao(ConnectionProvider.getConnection());
		
		if(d.createPost(p)) {
			
			Message msg = new Message("The post has uploaded successfully","success", "alert-success");
			s.setAttribute("msg", msg);
			response.sendRedirect("CreatePost_page.jsp");
		}
		else
		{
			Message msg = new Message("somthing went wrong try again","Error", "alert-danger");
			s.setAttribute("msg", msg);
			response.sendRedirect("CreatePost_page.jsp");
		}
	}

}
