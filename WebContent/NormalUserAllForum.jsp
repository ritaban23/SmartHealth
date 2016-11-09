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

									
									
				<h1 align="center" style="color: #2222B5;"><b>All Forums</b></h1>
					<% if(session.getAttribute("msg") != null){
						out.println(session.getAttribute("msg").toString());
						session.removeAttribute("msg");
				}%>
																<%  List<Forum> forums = (ArrayList<Forum>)request.getAttribute("all_forums");%>
																<%
																int i = 1;
																for(Forum forum:forums){ %>
																		
																	<div class="form-group">
																			 <label class="control-label col-sm-2" for="fourm" style="width: 100%;"><%=i++ %>. Forum Topic : 
																		 	<a href="NormalUserController?action=forumPost&forumid=<%=forum.getForum_id()%>">
																		 		<%= forum.getTopic() %>
																		 	</a>
																		  </label>	
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