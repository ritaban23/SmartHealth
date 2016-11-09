
function validate()
{
	var id=document.loginform.userId.value;
	var id1=id.length;
	var pwd1=document.loginform.password.value;
	document.getElementById("userId").innerHTML="";
	document.getElementById("pwd").innerHTML="";
	var re = /[0-9]/;
	if(id == "")
	{
	alert("Error:Please provide a login id !");
	document.loginform.userId.focus();
	return false;
	}
	else if(id1<6)
		{
		document.getElementById("userId").innerHTML='<span style="color:red">User Id should be of atleast 6 digit !</span>';
		document.loginform.userId.focus();
		return false;
		}
	else if(pwd1!=" ")
		{
			if(pwd1.length<6)
				{
				document.getElementById("pwd").innerHTML='<span style="color:red">Password must contain at least six characters! </span>';
				document.loginform.password.focus();
				return false;
				}
		/*	if(pwd1== id) 
				{
			      alert("Error: Password must be different from Username!");
			      document.loginform.password.focus();
			      return false;
				}
			*/
		    if(!re.test(pwd1))
		    	{
		    	document.getElementById("pwd").innerHTML='<span style="color:red">password must contain at least one number (0-9)! </span>';
		    	document.loginform.password.focus();
		    	return false;
		    	}
		 
		}

	
	return true;
}




