<%@page import="com.blog.entities.PostLikeEntity"%>
<%@page import="com.blog.dao.PostLikeDao"%>
<%@page import="com.blog.entities.Message"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="com.blog.entities.Category"%>
<%@page import="com.blog.entities.User"%>
<%@page import="com.blog.helper.ConnectionProvider"%>
<%@page import="com.blog.dao.DisplayPostDao"%>
<%@page import="com.blog.entities.CreatePost"%>
<%@page import="com.blog.entities.DisplayPost"%>
<%@page import="com.blog.helper.ConnectionProvider"%>
<%@page import="com.blog.dao.CreatePostDao"%>
<%@page import="com.blog.dao.CategoryDao"%>
<%@page import="java.util.ArrayList"%>

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

<title>Blog</title>
</head>
<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
%>
<body>
	<!-- Navbar code Start -->
	<%@include file="Navbar.jsp" %>
	<!-- Navbar code End -->
	
	<!-- clip path start -->
	
	<div class="container-fluid p-0 m-0">
  
            <div class="jumbotron primary-background text-black ">
                <div class="container">
                    <h3 class="display-3">Welcome to Blog </h3>

                    <p>Welcome to technical blog, world of technology
                        A programming language is a formal language, which comprises a set of instructions that produce various kinds of output. Programming languages are used in computer programming to implement algorithms.
                    </p>
                    <p>
                        Most programming languages consist of instructions for computers. There are programmable machines that use a set of specific instructions, rather than general programming languages. 
                    </p>
                    <%
                    	if(user==null){
                    %>
                    	<a href="Signup_page.jsp" class="btn btn-outline-primary"> <span class="fa 	fa fa-user-plus"></span>Sign up</a>
                    	<a href="Login_Page.jsp" class="btn btn-outline-primary"> <span class="fa fa-user-circle"></span> Login</a>
        
                    <%
                    	}
                    %>   
                </div>
            </div>
      </div>
	<!-- clip path end -->
	
	
	
	<!-- Main Post thumbnail or body Start -->
	<div class="container-fluid">
		<div class="row">
		<!-- ######################################################################### -->
		
    		<div class="col-9 border-primary " >
    			<%
    				Message ms = (Message)session.getAttribute("msgbypost");
    				if(ms!=null){
    			%>
    			<div class="alert <%= ms.getCssClass() %>" role="alert">
  							<%=ms.getMsg() %>
				</div>
				<%
					session.removeAttribute("msgbypost");
    				}
				%>
    			<%
    				ArrayList<DisplayPost> list;
    				list = (ArrayList<DisplayPost>)session.getAttribute("getPostByCid");	
    			
    				if(list==null){
						DisplayPostDao dpost = new DisplayPostDao(ConnectionProvider.getConnection());
						list = dpost.getPostData();
    				}
					for(DisplayPost p : list){
				%>
							
							<div class="card" >
							  <div class="card-body">
							  	<h5 class="card-title"><b><%= p.getpName() %></b></h5>
							    <p>
							    	<b>Date :- </b><%= p.getpDate() %> <span class="float-right"><b>Author :- </b> <%= p.getuName() %> </span>
							    </p>
							    <p class="card-text"><%= p.getpDescription() %></p>
							    <div>
							    	<div class="float-left">
								    <form action="ShowPostById" method="post">
								    	<input type="hidden" name = "pid" value="<%= p.getPid() %>">
								    	<button type="submit" class="btn btn-primary">Read More...</button>
								    </form>
								    </div>
								    <!-- ########################### Like Button Start ######################################-->
								    <div class="float-right">
							    	<%
							    		PostLikeDao ldao = new PostLikeDao(ConnectionProvider.getConnection());
							    		int count = ldao.DisplayLike(p.getPid());
							    		
							    		
							    		if(user!=null){
							    			boolean flag = ldao.IfuserLike(p.getPid(), user.getId());
							    	%>
							    		<button class="btn btn-outline-primary border-0" onclick="doLike(<%=p.getPid()%>,<%=user.getId() %>)">
							    		<%
							    		
							    			if(flag){
							    				%>
							    				<span class="fa fa-thumbs-up">Liked</span>
							    				<% 
							    			}else{
							    				%>
							    				<span class="fa fa-thumbs-o-up">Like</span>
							    				<%
							    			}
							    		%>
							    		<span class=".like-counter<%=p.getPid()%>">   <%= count %></span> 
							    		</button>
							    	<% 		
							    		}else{
							    	%>
							    		<button class="btn btn-outline-primary float-right" disabled>
							    			<i class="fa fa-thumbs-up"></i>Like <%= count %>
							    		</button>
							    	<%		
							    		}
							    	%>
							    	</div>
							    	<!-- ########################### Like Button End ######################################-->
							    </div>
							  </div>
							</div>
							<p>
					<%
						}
					session.removeAttribute("getPostByCid");
				%>
    		</div>
    	<!-- ############################################################################### -->
    	<div class="col-3 border-primary">
			<%
				Integer Categoryfalg = (Integer)session.getAttribute("CategoryId");
				if(Categoryfalg == null){
					Categoryfalg = 0;
				}
			%>
				    <div class="list-group">
					  <form action="DisplayPostByCid" method="post">
						<input type="hidden" name = "cid" value="0">
						<button type="submit"class="list-group-item list-group-item-action
							<%if(Categoryfalg == 0){
								%>
								active
								<%
							}
						%> ">All Category</button>
					</form> 	
	    			<%
	    			CategoryDao cat = new CategoryDao(ConnectionProvider.getConnection());
	    			ArrayList<Category> c = cat.getCategory();
	    			for(Category ca : c){
	    			%>
					<form action="DisplayPostByCid" method="post">
						<input type="hidden" name = "cid" value="<%= ca.getcId()%>">
						<button type="submit"class="list-group-item list-group-item-action
						<%if(Categoryfalg == ca.getcId()){
								%>
								active
								<%
							}
						%> 
						"><%= ca.getcName() %></button>
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
	<!-- Main Post thumbnail or body End -->
	
	
	
	<!-- Footer start -->
	<div >
		<%@include file="Footer.jsp" %>
	</div>
	<!-- Footer End -->
	<script type="text/javascript">
	function doLike(pid, uid)
	{
	    console.log(pid + "," + uid)
	    const d = {
	        uid: uid,
	        pid: pid,
	    }
	    var str1 = ".like-counter";
    	var str2 = pid;
    	var Classname = str1.concat(str2);
    	console.log(Classname);
	    $.ajax({
	        url: "DoLikeOnPost",
	        type: 'POST',
	        data: d,
	        success: function (data, textStatus, jqXHR) {
	            
	            if (data.trim() == 'true')
	            {
	            	
	                let c = $(Classname).html();
	                c++;
	                $(Classname).html(c);
	            }
	        },
	        error: function (jqXHR, textStatus, errorThrown) {
	            console.log(data)
	        }
	    })
	}
	</script>
</body>
</html>
