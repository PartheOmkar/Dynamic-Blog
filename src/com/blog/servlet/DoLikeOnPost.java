package com.blog.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.dao.PostLikeDao;
import com.blog.helper.ConnectionProvider;

/**
 * Servlet implementation class DoLikeOnPost
 */
@WebServlet("/DoLikeOnPost")
public class DoLikeOnPost extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		boolean flag = false;
		int pid = Integer.parseInt(request.getParameter("pid"));
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		PostLikeDao ldao = new PostLikeDao(ConnectionProvider.getConnection());
		flag = ldao.DoLike(uid, pid);
		out.print(flag);
		
	}

}
