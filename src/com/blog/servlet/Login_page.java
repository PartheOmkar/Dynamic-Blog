package com.blog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.dao.UserDao;
import com.blog.entities.Message;
import com.blog.entities.User;
import com.blog.helper.ConnectionProvider;

/**
 * Servlet implementation class Login_page
 */
@WebServlet("/Login_page")
public class Login_page extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		UserDao dao = new UserDao(ConnectionProvider.getConnection());
		
		User u = dao.validationOfEmailandPassword(email, password);
		
		if(u==null) {
			
			Message msg = new Message("Email or Password are Incorrect", "Error", "alert-danger");
			
			HttpSession s = request.getSession();
			s.setAttribute("msg", msg);
			
			response.sendRedirect("Login_Page.jsp");
			
		}else {
			
			HttpSession s = request.getSession();
            s.setAttribute("currentUser", u);

           response.sendRedirect("Main.jsp");
		}
		
	}

}
