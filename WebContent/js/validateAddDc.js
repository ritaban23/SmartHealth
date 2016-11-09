function validate()
{
	
	var dc_id=document.dcControllerForm.dcId.value;
	var dc_id1=dc_id.length;
	var dc_phone=document.dcControllerForm.dPhone.value;
	var dc_phone1=dc_phone.length;
	var dc_add1=document.dcControllerForm.add1.value;
//	var dc_add2=document.dcControllerForm.add2.value;
	var dc_pin=document.dcControllerForm.pin.value;
	var dc_city=document.dcControllerForm.city.value;
	var dc_state=document.dcControllerForm.state.value;
	var dc_land=document.dcControllerForm.landmark.value;
	
	var id=document.dcControllerForm.id.value;
	var id1=id.length;
	var pass1=document.dcControllerForm.pass.value;
	
	var re = /[0-9]/;
	
	//var re=/^[0-9a-zA-Z]+$/;
	document.getElementById("dcId").innerHTML="";
	document.getElementById("dPhone").innerHTML="";
	document.getElementById("add1").innerHTML="";
	document.getElementById("add2").innerHTML="";
	document.getElementById("pin").innerHTML="";
	document.getElementById("city").innerHTML="";
	document.getElementById("state").innerHTML="";
	document.getElementById("landmark").innerHTML="";
	document.getElementById("id").innerHTML="";
	document.getElementById("pass").innerHTML="";
	if(dc_id == "")
	{
		alert("Error:Please provide a login id !");
		document.dcControllerForm.dcId.focus();
		return false;
	}

	else if(dc_id1<6)
	{
	document.getElementById("dcId").innerHTML='<span style="color:red">Dc Id should be of atleast 6 digit !</span>';
	document.dcControllerForm.dcId.focus();
	return false;
	}
	if(dc_phone == "")
	{
		alert("Error:Please provide a phone number!");
		document.dcControllerForm.dPhone.focus();
		return false;
	}
	else if(isNaN(dc_phone))
	{
		document.getElementById("dPhone").innerHTML='<span style="color:red">Enter Numeric value only !</span>';
		document.dcControllerForm.dPhone.focus();
		return false;
	
	}
	else if(dc_phone1<10)
	{
		document.getElementById("dPhone").innerHTML='<span style="color:red">Dc Phone Number should be of 10 digit !</span>';
		document.dcControllerForm.dPhone.focus();
		return false;
	}
	else if(dc_add1 == "")
	{
		document.getElementById("add1").innerHTML='<span style="color:red">Mandatory field!</span>';
		document.dcControllerForm.add1.focus();
		return false;
	}
	
	
	else if(dc_pin=="")
	{
		document.getElementById("pin").innerHTML='<span style="color:red">Mandatory field!</span>';
		 document.dcControllerForm.pin.focus();
		 return false;
	}
	else if(isNaN(dc_pin))
	{
		document.getElementById("pin").innerHTML='<span style="color:red">Enter Numeric value only ! </span>'; 
		document.dcControllerForm.pin.focus();
		return false;
	}
	else if(dc_pin.length<6)
	{
		 document.getElementById("pin").innerHTML='<span style="color:red">Pin should be of 6 digits! </span>';
		 document.dcControllerForm.pin.focus();
		 return false;
	 }
	else if(dc_city== "")
	{
		
		document.getElementById("city").innerHTML='<span style="color:red">Mandatory field !</span>';
		document.dcControllerForm.city.focus();
		return false;
	}
	else if(dc_state== "")
	{
		
		document.getElementById("state").innerHTML='<span style="color:red">Mandatory field !</span>';
		document.dcControllerForm.state.focus();
		return false;
	}
	else if(dc_land== "")
	{
		document.getElementById("landmark").innerHTML='<span style="color:red">Mandatory field !</span>';
		document.dcControllerForm.landmark.focus();
		return false;
	} 
	
	else if(id == "")
	{
	alert("Error:Please provide a  id !");
	document.dcControllerForm.id.focus();
	return false;
	}
	
	else if(id1<6)
		{
		document.getElementById("id").innerHTML='<span style="color:red">Id should be of atleast 6 digit !</span>';
		document.dcControllerForm.id.focus();
		return false;
		}
	else if(pass1!=" ")
		{
			if(pass1.length<6)
				{
				document.getElementById("pass").innerHTML='<span style="color:red">Password must contain at least six characters! </span>';
				document.dcControllerForm.pass.focus();
				return false;
				}
			
			
		    if(!re.test(pass1))
		    	{
		    	document.getElementById("pass").innerHTML='<span style="color:red">password must contain at least one number (0-9)! </span>';
		    	document.dcControllerForm.pass.focus();
		    	return false;
		    	}
		 
		}
	
return true;
	
	
}


			
		
		

	
	
	
	
