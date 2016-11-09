<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="bean.Moderator" %>
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
							
												<a href="ModeratorController" >
												<img src="img/3.jpg" class="imagel" alt="Demo" style="width:183px; height:103px;">
												</a>
							
							</div>
						
		
							<div class ="hd2">
												<h1 style="color: white;font-family:cursive;font-size:35px;"><b>SMARTHEALTH</b></h1>
							
							
							
						
									<div class="btn-group" >
												 <a href="ModeratorController"><button type="button" class="btn btn-primary">HOME</button></a>
 												 <a href="ModeratorController?action=logout"><button type="button" class="btn btn-primary">LOGOUT</button></a>
  											
									</div>


							</div>
			</div>	
			
			
			<div class="head3">			
			
			
			<div class="cd1">	
			
			<br>
			<h1><b>QUICK ACCESS</b></h1>
			
			<br>
		<div><a href="ModeratorController?action=updateUserDetail" style="color:white;">Update User Detail </a><br></div><br><br>
		<div><a href="ModeratorController?action=addForum"style="color:white;">Add Forum</a><br></div><br><br>
		<div><a href="ModeratorController?action=closeForum"style="color:white;">Close Forum</a><br></div><br><br>
		<div><a href="ModeratorController?action=quit"style="color:white;"> Quit</a><br></div><br><br>
			
			
			
			
			</div>
		
										<div class="g1">	
											
											</div>
									<div class="cd2" >

									
									
				<h1 align="center" style="color: #2222B5;"><b>Moderator</b></h1>
					<% if(session.getAttribute("msg") != null){
						out.println(session.getAttribute("msg").toString());
						session.removeAttribute("msg");
				}%>
																<% Moderator mod = (Moderator)request.getAttribute("mod");%>	
														<div class="form-group">		 
																  <label class="control-label col-sm-2" for="First Name" style="width: 21.666667%;">First Name</label>
														  <div class="col-sm-10">
																	 <input type="text" class="form-control" id="First name"  value= <%=mod.getFirst_name() %> readonly>
																	 </div>
														</div>
														<div class="form-group">
																	 <label class="control-label col-sm-2" for="Last Name" style="width: 18.666667%;">Last Name</label>
																	 <div class="col-sm-10">
																	 <input type="text" class="form-control" id="Last Name" value=<%= mod.getLast_name() %> readonly>
														</div>
														</div>
														<div class="form-group">
																	 <label class="control-label col-sm-2" for="UserName" style="width: 24.666667%;">UserName </label>
																	 <div class="col-sm-10">
																	 <input type="text" class="form-control" id="UserName"  value=<%=mod.getUser_name() %> readonly>
														</div>
														<div class="form-group">
																	 <label class="control-label col-sm-2" for="PrimaryEmail" style="width: 24.666667%;">Primary Email Id </label>
																	 <div class="col-sm-10">
																	 <input type="text" class="form-control" id="PrimaryEmail"  value=<%=mod.getPrimary_email() %> readonly>
														</div>
														<div class="form-group">
																	 <label class="control-label col-sm-2" for="Secondary Email" style="width: 24.666667%;">Secondary Email </label>
																	 <div class="col-sm-10">
																	 <input type="text" class="form-control" id="SecondaryEmail"  value=<%=mod.getSecondary_email() %> readonly>
														</div>
														<div class="form-group">
																	 <label class="control-label col-sm-2" for="Postal Address" style="width: 24.666667%;">Postal Address </label>
																	 <div class="col-sm-10">
																	 <input type="text" class="form-control" id="UserName"  value=<%=mod.getPostal_address() %> readonly>
														</div>
														
														<div class="form-group">
																	 <label class="control-label col-sm-2" for="Emergency Number" style="width: 24.666667%;">Emergency Number </label>
																	 <div class="col-sm-10">
																	 <input type="text" class="form-control" id="UserName" name="number" value=<%=mod.getEmergency_number() %>>
														</div>
														</div>							  
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