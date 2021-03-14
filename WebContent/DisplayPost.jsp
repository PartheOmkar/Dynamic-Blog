<%@page import="com.blog.entities.CommentEntity"%>
<%@page import="com.blog.dao.CommentDao"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.blog.entities.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.blog.helper.ConnectionProvider"%>
<%@page import="com.blog.dao.CategoryDao"%>
<%@page import="com.blog.entities.DisplayPost"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%
	DisplayPost displayPost = (DisplayPost)session.getAttribute("displaypost");
%>
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
	
<title> <%= displayPost.getpName() %> </title>
</head>
<body>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
%>
<%@include file="Navbar.jsp" %>

	<div class="container-fluid ">
		<div class="row p-3">
			<!-- \\\\\\\\\\\\\\\\\\\\LEFT SIDE (display post)-->
			<br />
			<div class="col-9 border border-primary " >
				<div>
				<br />
				<h1><%= displayPost.getpName() %></h1>
				<b> Date :- </b><%= displayPost.getpDate() %>
				<span class="float-right"><b> Author :- </b> <%= displayPost.getuName() %></span>
				<hr style="height:1px; color:black; background-color:black;">
				<br />
				<b>Category :- </b> <%=displayPost.getcName() %>
				<br />
				<b>Description :- </b> <i><%=displayPost.getpDescription() %></i>
				<hr />
				<p>
				<%= displayPost.getpData() %>
				
				</p>
				</div>
				<hr style="height:0px;color:#007bff;background-color:#007bff;">
				<div>
				<p><b> Comments :- </b></p>
				<%
					if(user!=null){
				%>
					
					<form action="AddComment" method="POST">
						<div class="mb-3 p-0">
						  <label for="exampleFormControlTextarea1" class="form-label"><span class="text-success"><b>Write Comment</b></span></label>
						  <input type="hidden" name="pid" value="<%= displayPost.getPid() %>" >
						  <input type="hidden" name="uid" value="<%= user.getId() %>"> 
						  <textarea name ="Comment" class="form-control" maxlength="250" id="exampleFormControlTextarea1" rows="3"></textarea>
						</div>
						<button type="submit" class="btn btn-outline-primary">Submit</button>
					</form>
				<%
					}else
					{
						%>
						
						<div class="alert alert-danger" role="alert">
  							if you want to comment then sign in !
						</div>
							
						<%
					}
				%>
				<!-- Display Comments -->
				<p></p>
				<%
					CommentDao cdao = new CommentDao(ConnectionProvider.getConnection());
					ArrayList<CommentEntity> getcom = null;
					getcom = cdao.DisplayComment(displayPost.getPid());
					
					if(getcom != null && getcom.size() > 0){
						
						for(CommentEntity c : getcom){
				%>
						<b><span class="fa fa-user-circle"></span><i></i> <%= c.getUname()  %></b>
						<div class="p-2"><span class="fa fa-quote-left"></span><i></i> <%= c.getCommentText() %></div>
				<%
									
						}
						
					}
					%>
				
				</div>
				
				
			</div>
			<!-- ////////////////////// RIGHT SIDE //////////////////////////////// -->
			<div class="col-3 "  >
				   
				    <div class="list-group">
					  <form action="DisplayPostByCid" method="post">
						<input type="hidden" name = "cid" value="0">
						<button type="submit"class="list-group-item list-group-item-action active">All Category</button>
					</form> 	
	    			<%
	    			CategoryDao cat = new CategoryDao(ConnectionProvider.getConnection());
	    			ArrayList<Category> c = cat.getCategory();
	    			for(Category ca : c){
	    			%>
					<form action="DisplayPostByCid" method="post">
						<input type="hidden" name = "cid" value="<%= ca.getcId()%>">
						<button type="submit"class="list-group-item list-group-item-action"><%= ca.getcName() %></button>
					</form> 
	    			<%
	    			}
	    			%>
	    			</div>
	    			<br/>
	    			my name is parthe omkar and i am fine
	    	</div>
    	</div>
    </div>	
    
	<!-- ######################### footer ################################### -->
	<div >
		<%@include file="Footer.jsp" %>
	</div>
</body>
</html>