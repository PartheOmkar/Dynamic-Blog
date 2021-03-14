<%@page import="com.blog.entities.Message"%>
<%@page import="com.blog.entities.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.blog.helper.ConnectionProvider"%>
<%@page import="com.blog.dao.CategoryDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

	<!-- CSS Script -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<!-- Java Script -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
	

<title>Create Post</title>
</head>
<body>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
%>
<%@include file="Navbar.jsp" %>
<% 
	if(user==null){
		response.sendRedirect("Login_Page.jsp");
	}
%>
<br>
<div class="container border">
	<form action="CreatePost_page" method="post">
		<div class="mb-3">
			<!-- Post category -->
			
				<%
                      Message m =(Message)session.getAttribute("msg");
                      if(m!=null){
                %>
                <div class="alert <%= m.getCssClass() %>" role="alert">
  					<%=m.getMsg() %>
				</div>
                <% 
                      session.removeAttribute("msg");
                        		
                      }
                %>			
			<label for="exampleFormControlInput1" class="form-label">Post Category</label>
			<select name="pCategory" class="form-select form-control" aria-label="Default select example">
				<option selected disabled>--Select Category--</option>
			<%
				CategoryDao cat = new CategoryDao(ConnectionProvider.getConnection());
				ArrayList<Category> list = cat.getCategory();
				for(Category c :list)
				{
			%>
			
			  		<option value="<%= c.getcId() %>"><%=c.getcName()%></option>
			<%
				}
			%>
			</select>
		</div>
		
		<!-- Post Title -->
		<div class="mb-3">
		  <label for="exampleFormControlInput1" class="form-label">Post Title</label>
		  <input name="pName" type="text" class="form-control" id="exampleFormControlInput1" placeholder="Post Title">
		</div>
		
		<!-- Post Description -->
		<div class="mb-3">
		  <label for="exampleFormControlTextarea1" class="form-label">Post Description</label>
		  <textarea name="pDescription" maxlength="300" class="form-control" id="exampleFormControlTextarea1" rows="3" placeholder="Post Description only 300 words are allow"></textarea>
		</div>
		
		<!-- Post Data -->
		<div class="mb-3">
		  <label for="exampleFormControlTextarea1" class="form-label">Post Data</label>
		  <textarea name="pData" class="form-control" rows="10" placeholder="Enter Post"></textarea>
		</div>
		
		<div class="d-grid gap-2 d-md-block text-center ">
		  <button class="btn btn-primary" type="submit">Upload</button>
		</div>
	</form>
</div>
<br>
</body>
</html>