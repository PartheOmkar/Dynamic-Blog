package com.blog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.entities.Message;

/**
 * Servlet implementation class Logout_page
 */
@WebServlet("/Logout_page")
public class Logout_page extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		PrintWriter out = response.getWriter();
		
		HttpSession s = request.getSession();
		
		s.removeAttribute("currentUser");
		
		Message m = new Message("Logout successfully", "sucess", "alert-success");
		
		s.setAttribute("msg", m);
		
		response.sendRedirect("Login_Page.jsp");
		
	}

}
