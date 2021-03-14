<%@page import="com.blog.entities.User"%>
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

<title>Profile</title>
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
<br/>
<div class="container">
	<div class="row">
		<div class="col-3"></div>
		<div class="col-6">
			<table class="table table-bordered">
			  <thead class="text-center">
			    <tr>
			      <th colspan="2"><%= user.getName() %></th>
			    </tr>
			  </thead>
			  <tbody>
			  	<tr>
			      <td>ID :- </td>
			      <td><%= user.getId() %></td>
			    </tr>
			    <tr>
			      <td>Name :- </td>
			      <td><%= user.getName() %></td>
			    </tr>
			    <tr>
			      <td>Email :- </td>
			      <td><%= user.getEmail() %></td>
			    </tr>
			    <tr>
			      <td>Gender :- </td>
			      <td><%= user.getGender() %></td>
			    </tr>
			    <tr>
			      <td>About :- </td>
			      <td><%= user.getAbout() %></td>
			    </tr>
			    <tr>
			      <td>Registration Date :- </td>
			      <td><%= user.getDateTime() %></td>
			    </tr>
			  </tbody>
			</table>
		</div>      
	</div>
</div>

</body>
</html>