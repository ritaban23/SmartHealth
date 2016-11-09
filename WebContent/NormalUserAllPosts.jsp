<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="bean.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SmartHealth</title>
<link rel="icon" href="img/3.jpg" type="image/x-icon" />
<script type="text/javascript" src="js/validateFirst.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/add.css" type="text/css">
<script src="jquery.min.js"></script>
<script src="bootstrap.min.js"></script>
</head>
<body>
<div class="wrapper">

		<div class="head1">
		   					
		
							<div class ="hd1">
							
												<a href="NormalUserController" >
												<img src="img/3.jpg" class="imagel" alt="Demo" style="width:183px; height:103px;">
												</a>
							
							</div>
						
		
							<div class ="hd2">
												<h1 style="color: white;font-family:cursive;font-size:35px;"><b>SMARTHEALTH</b></h1>
							
							
							
						
									<div class="btn-group" >
												 <a href="NormalUserController"><button type="button" class="btn btn-primary">HOME</button></a>
 												 <a href="NormalUserController?action=logout"><button type="button" class="btn btn-primary">LOGOUT</button></a>
  											
									</div>


							</div>
			</div>	
			
			
			<div class="head3">			
			
			
			<div class="cd1">	
			
			<br>
			<h1><b>QUICK ACCESS</b></h1>
			
			<br>
		<div><a href="NormalUserController?action=updateUserDetail" style="color:white;">Update User Detail </a><br></div><br><br>
		<div><a href="NormalUserController?action=sendFriendRequest"style="color:white;">Send Friend Request</a><br></div><br><br>
		<div><a href="NormalUserController?action=seeAllFriendRequest"style="color:white;">See All Friend Request</a><br></div><br><br>
		<div><a href="NormalUserController?action=seeAllFriends"style="color:white;">See All Friend</a><br></div><br><br>
		<div><a href="NormalUserController?action=updateHealthData"style="color:white;">Update Health Data</a><br></div><br><br>
		<div><a href="NormalUserController?action=seeHealthData"style="color:white;">See Your Health Data</a><br></div><br><br>
		<div><a href="NormalUserController?action=seeYourFriendHealthData"style="color:white;"> See Your Friend Health Data</a><br></div><br><br>
		<div><a href="NormalUserController?action=seeAllFourm"style="color:white;"> See All Fourm and Pages</a><br></div><br><br>
		<div><a href="NormalUserController?action=quit"style="color:white;"> Quit</a><br></div><br><br>
			
			
			
			
			</div>
		
										<div class="g1">	
											
											</div>
									<div class="cd2" >

									
									
				<h1 align="center" style="color: #2222B5;"><b>All Posts</b></h1>
					<% if(session.getAttribute("msg") != null){
						out.println(session.getAttribute("msg").toString());
						session.removeAttribute("msg");
		
				}%>
				
																<% Forum forum = (Forum)request.getAttribute("forum"); %>
																<%  List<Post> posts = (ArrayList<Post>)request.getAttribute("all_posts");%>
																
																	
																	<div class="form-group">
																		<label class="control-label col-sm-2" for="forum" style="width: 100%;">Forum Topic : <%= forum.getTopic() %> </label>
																		<br>
																	</div>
																	<div class="form-group">
																		<label class="control-label col-sm-2" for="forum" style="width: 100%;">Forum Created by : <%= forum.getCreator_name() %> </label>
																		<br>
																	</div>
																	
																	<div class="form-group">
																		<label class="control-label col-sm-2" for="forum" style="width: 100%;">Forum Summary : <%= forum.getSummary() %> </label>
																		<br>
																	</div>
																	<br>
																	<button type="button" class="btn btn-info" data-toggle="collapse"
					data-target="#demo">Click to know more about us</button>
				<div id="demo" class="collapse">
					<p style="color: green;">
						We are enlisted in Fortune500<br> We have the best in class
						environment.<br> We love our customers. We are the best
						retailer company in asia.<br> We have the best in class
						environment.<br> We love our customers. We are the best
						retailer company in asia.<br> We have the best in class
						environment.<br> We love our customers. We are the best
						retailer company in asia.<br> We have the best in class
						environment.<br> We love our customers.

					</p>
				</div>
																	<%-- 
																	
																			<button type="button" class="btn btn-info" data-toggle="collapse"
																				data-target="#demo">Add A New Post</button>
																			<div id="demo" class="collapse">
																				
																								<form name="loginform" method="post" action="NormalUserController" onsubmit="return validate();">
																				
																									<div class="form-group">
																										<label for="userId">Enter Text For Post:</label>
																										<textarea rows="4" name="posttext"></textarea>								
																									</div>
																									<input type="hidden" name="forumid" value="<%=forum.getForum_id()%>">
																									<input type="hidden" name="action" value="addPost">
																									<div class="form-inline">
																										<button type="submit" class="btn btn-success">Login</button>
																										<button type="reset" class="btn btn-danger">Reset</button>
																									</div>
																				
																																								
																				
																				
																			</div> --%>
																	<br><br>
																<%
																int i = 1;
																for(Post post : posts){ %>
																	<div class="form-group">
																		<label class="control-label col-sm-2" for="forum" style="width: 100%;"><%=i++ %>. Post Text : <%= post.getText_entry() %> </label>
																		<br>
																	</div>
																	<div class="form-group">
																		<label class="control-label col-sm-2" for="forum" style="width: 100%;">Post Creator : <%= post.getUsername() %> </label>
																		<br>
																	</div>
																	<br>
																<%} %>
														
														
														
																		  
																		  								 
																		  
									</div>
				
				
				
				
				<div class="g2">
				</div>
				
		
		</div>
			
			
			<div class="foot">
		<p>@copyright group1</p>
		</div>
		
	</div>	


</body>
</html>