package com.blog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.blog.dao.UserDao;
import com.blog.entities.Message;
import com.blog.entities.User;
import com.blog.helper.ConnectionProvider;

/**
 * Servlet implementation class Signup_page
 */
@WebServlet("/Signup_page")
public class Signup_page extends HttpServlet {
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		
		PrintWriter out = res.getWriter();
		
		String check = req.getParameter("check");
	
		if(check==null) {
			out.println("check turms and condition");
		}else {
			String name = req.getParameter("user_name");
			String email = req.getParameter("user_email");
			String password = req.getParameter("user_password");
			String gender = req.getParameter("gender");
			String about = req.getParameter("about");
			
			// create user object ot set data
			
			User user = new User(name, email, password, gender, about);
			
			// create user dao object
			
			UserDao dao = new UserDao(ConnectionProvider.getConnection());
			
			if(dao.saveUser(user)) {
				
				Message m = new Message("Account Has been Created successfully", "sucess", "alert-success");
				
				HttpSession s = req.getSession();
				s.setAttribute("msg", m);
				
				res.sendRedirect("Signup_page.jsp");
				
			}else {
				
				Message m = new Message("Somthing Wrong! please Try again", "Error", "alert-danger");
				
				HttpSession s = req.getSession();
				s.setAttribute("msg", m);
				
				res.sendRedirect("Signup_page.jsp");
				
			}
		}
	}

}
