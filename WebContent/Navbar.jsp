
<%@page import="com.blog.entities.User"%>
<%
User user = (User) session.getAttribute("currentUser");
%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">Blog</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="Main.jsp#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Dropdown
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">Action</a>
          <a class="dropdown-item" href="#">Another action</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Something else here</a>
        </div>
      </li>
      <%
      	if(user!=null){
      %>
      <li class="nav-item">
        <a class="nav-link" href="Profile.jsp">Profile</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Post
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">our post</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="CreatePost_page.jsp">do post</a>
        </div>
      </li>
      <%
      	}
      %>
    </ul>
    
    
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  	
  	<div>
	<%
		
		if(user!=null)
		{
		%>
		<div class="dropdown">
		  <button class="btn btn-outline-primary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    <span class="fa fa-user-circle-o"></span><%= user.getName() %>
		  </button>
		  <div class="dropdown-menu dropdown-menu-right">
		    <a class="dropdown-item" href="#">Profile</a>
		    <a class="dropdown-item" href="#">Our Post</a>
		    <a class="dropdown-item" href="Logout_page">Log Out</a>
		  </div>
		</div>
		<% 	
		}else{
			%>
			<a href="Login_Page.jsp" type="button" class="btn btn-outline-primary"> <span class="fa fa-user-circle-o"></span>Log in</a>	
		<%
		}
	%>
		
  	</div>
  
  </div>
</nav>
