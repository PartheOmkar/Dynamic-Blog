package com.blog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.dao.DisplayPostDao;
import com.blog.entities.DisplayPost;
import com.blog.helper.ConnectionProvider;

/**
 * Servlet implementation class ShowPostById
 */
@WebServlet("/ShowPostById")
public class DisplayPostById extends HttpServlet {
	/*
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		PrintWriter out = res.getWriter();
		out.print("hii");
	}
	*/
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		
		int pid = Integer.parseInt(request.getParameter("pid"));
		
		DisplayPostDao pdisplay = new DisplayPostDao(ConnectionProvider.getConnection());
		DisplayPost pd = pdisplay.getPostDataById(pid);
		
		HttpSession s = request.getSession();
		s.setAttribute("displaypost", pd);
		
		response.sendRedirect("DisplayPost.jsp");
		
	}

}
