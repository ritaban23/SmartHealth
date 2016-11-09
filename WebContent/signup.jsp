<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SMARTHEALTH</title>
<link rel="icon" href="img/3.jpg" type="image/x-icon" />
<link href="css/style.css" rel="stylesheet" type="text/css">
<link href="css/dcpage.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script type="text/javascript" src="js/validateFirst.js"></script>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<div class="wrapper">
		<div class="head1">
			<div class="hd1" style="height: 103px; width: 183.9px;">
				<a href="first.html"> <img src="img/3.jpg" class="imagel"
					alt="Demo" style="width: 183px; height: 103px;">
				</a>
			</div>
			<div class="hd2">
				<h1
					style="color: white; font-family: cursive; font-size: 35px; background-color:">
					<b>SMARTHEALTH</b>
				</h1>
				<div class="btn-group">
					<a href="home.jsp"><button type="button" class="btn btn-primary">Home</button></a>
				</div>
			</div>			
		</div>
		<div class="cd2" style="margin-left:450px;margin-top:140px;height:1000px">
				<div id="SuccessfulSignUpdetail">
						<%if(session.getAttribute("successfulmsg") != null){
							out.print(session.getAttribute("successfulmsg").toString());	
						}%>

					</div>
				<h1 align="center" style="color: #2222B5;">
					<b>Sign Up</b>
				</h1>
				<br>
				<h4 align="center" style="color: #2222B5;">Enter your
					credentials to signup</h4>
				
			
				<form name="loginform" method="post" action="HomeController"
					onsubmit="return validate();">

					<div class="form-group">
						<label for="userId">User Id(Unique):</label> <input type="text"
							class="form-control" name="userId" placeholder="User Id"><span
							id="userId"></span>
					</div>
					<div class="form-group">
						<label for="pwd">Password:</label> <input type="password"
							class="form-control" name="password" placeholder="Password"><span
							id="pwd"></span>
					</div>
					<div class="form-group">
						<label for="pwd">Primary Email Id:</label> <input type="text"
							class="form-control" name="pemail" placeholder="Primary Email Id"><span
							id="pwd"></span>
					</div>
					<div class="form-group">
						<label for="pwd">Secondary Email Id:</label> <input type="text"
							class="form-control" name="semail" placeholder="Secondary Email Id"><span
							id="pwd"></span>
					</div>
					<div class="form-group">
						<label for="pwd">First Name:</label> <input type="text"
							class="form-control" name="fname" placeholder="First Name"><span
							id="pwd"></span>
					</div>
					<div class="form-group">
						<label for="pwd">Last Name:</label> <input type="text"
							class="form-control" name="lname" placeholder="Last Name"><span
							id="pwd"></span>
					</div>
					<div class="form-group">
						<label for="pwd">About Me:</label><textarea class="form-control" name="aboutme" placeholder="aboutme"></textarea><span
							id="pwd"></span>
					</div>
					<div class="form-group">
						<label for="pwd">URL of First Photo:</label> <input type="text"
							class="form-control" name="furl" placeholder="URL of first photo"><span
							id="pwd"></span>
					</div>
					<div class="form-group">
						<label for="pwd">URL of Second Photo:</label> <input type="text"
							class="form-control" name="surl" placeholder="URL of Second photo"><span
							id="pwd"></span>
					</div>
					<div class="form-group">
						<label for="pwd">URL of Third Photo:</label> <input type="text"
							class="form-control" name="turl" placeholder="URL of Third photo"><span
							id="pwd"></span>
					</div>
					<div class="form-group">
						<label for="pwd">PostalAddress:</label> <input type="text"
							class="form-control" name="paddress" placeholder="Postal Address"><span
							id="pwd"></span>
					</div>
					<br>
					<div id="SignUpdetail">
						<%if(session.getAttribute("msg") != null){
							out.print(session.getAttribute("msg").toString());	
						}%>

					</div>

					<input type="hidden" name="page_type" value="normal_user_signup">
					<div class="form-inline">
						<button type="submit" class="btn btn-success">SignUp</button>
						<button type="reset" class="btn btn-danger">Reset</button>
					</div>


				</form>
		</div>
		
	</div>
		
</div>
</body>