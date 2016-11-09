<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SMARTHEALTH</title>
<link rel="icon" href="img/3.jpg" type="image/x-icon" />
<link href="css/style.css" rel="stylesheet" type="text/css">
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
					<a href="signup.jsp"><button type="button" class="btn btn-primary">SignUP</button></a>

					
				</div>


			</div>
		</div>


		<div class="head2"></div>
		<div class="head3">
			<div class="cd1" id="c">

				<h1>

					<b style="color: white;">&nbsp;&nbsp;About Us</b>

				</h1>
				<br> <br>

				<p style="color: white;">
					&nbsp;&nbsp; We are the best retailer company in Asia.<br>
					&nbsp;&nbsp; We have the best in class environment.<br>
					&nbsp;&nbsp; We love our customers.

				</p>
				<button type="button" class="btn btn-info" data-toggle="collapse"
					data-target="#demo">Click to know more about us</button>
				<div id="demo" class="collapse">
					<p style="color: white;">
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
			</div>
			<div class="cd2">

				<h1 align="center" style="color: #2222B5;">
					<b>Welcome User</b>
				</h1>
				<br>
				<h4 align="center" style="color: #2222B5;">Enter your
					credentials to get started</h4>

				<form name="loginform" method="post" action="HomeController"
					onsubmit="return validate();">

					<div class="form-group">
						<label for="userId">User Id:</label> <input type="text"
							class="form-control" name="userId" placeholder="User Id"><span
							id="userId"></span>
					</div>
					<div class="form-group">
						<label for="pwd">Password:</label> <input type="password"
							class="form-control" name="password" placeholder="Password"><span
							id="pwd"></span>
					</div>
					<div class="checkbox">
						<label><input type="checkbox"> Remember me</label>
					</div>
					<br>
					<div id="logindetail">
						<%if(session.getAttribute("msg") != null){
							out.print(session.getAttribute("msg").toString());	
						}%>

					</div>

					<input type="hidden" name="page_type" value="login">
					<div class="form-inline">
						<button type="submit" class="btn btn-success">Login</button>
						<button type="reset" class="btn btn-danger">Reset</button>
					</div>


				</form>
			



			</div>
		</div>


		<div class="foot">
			<p>@copyright group1</p>
		</div>

	</div>



</body>
</html>