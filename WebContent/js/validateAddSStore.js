function validate()
{
	
	var dc_id=document.addSStoreForm.sId.value;
	var dc_id1=dc_id.length;
	var dc_phone=document.addSStoreForm.sPhone.value;
	var dc_phone1=dc_phone.length;
	var dc_add1=document.addSStoreForm.add1.value;
	var dc_name=document.addSStoreForm.mName.value;
	var dc_pin=document.addSStoreForm.pin.value;
	var dc_city=document.addSStoreForm.city.value;
	var dc_state=document.addSStoreForm.state.value;
	var dc_land=document.addSStoreForm.landmark.value;
	
	var id=document.addSStoreForm.id.value;
	var id1=id.length;
	var pass1=document.addSStoreForm.pass.value;
	
	var re = /[0-9]/;
	
	//var re=/^[0-9a-zA-Z]+$/;
	document.getElementById("sId").innerHTML="";
	document.getElementById("sPhone").innerHTML="";
	document.getElementById("add1").innerHTML="";
	document.getElementById("mName").innerHTML="";
	document.getElementById("pin").innerHTML="";
	document.getElementById("city").innerHTML="";
	document.getElementById("state").innerHTML="";
	document.getElementById("landmark").innerHTML="";
	document.getElementById("id").innerHTML="";
	document.getElementById("pass").innerHTML="";
	if(dc_id == "")
	{
		alert("Error:Please provide a login id !");
		document.addSStoreForm.sId.focus();
		return false;
	}

	else if(dc_id1<6)
	{
	document.getElementById("sId").innerHTML='<span style="color:red">Dc Id should be of atleast 6 digit !</span>';
	document.addSStoreForm.sId.focus();
	return false;
	}
	if(dc_phone == "")
	{
		alert("Error:Please provide a phone number!");
		document.addSStoreForm.sPhone.focus();
		return false;
	}
	else if(isNaN(dc_phone))
	{
		document.getElementById("sPhone").innerHTML='<span style="color:red">Enter Numeric value only !</span>';
		document.addSStoreForm.sPhone.focus();
		return false;
	
	}
	else if(dc_phone1<10)
	{
		document.getElementById("sPhone").innerHTML='<span style="color:red">Dc Phone Number should be of 10 digit !</span>';
		document.addSStoreForm.sPhone.focus();
		return false;
	}
	else if(dc_name== "")
	{
		
		document.getElementById("mName").innerHTML='<span style="color:red">Mandatory field !</span>';
		document.addSStoreForm.mName.focus();
		return false;
	}
	else if(dc_add1 == "")
	{
		document.getElementById("add1").innerHTML='<span style="color:red">Mandatory field!</span>';
		document.addSStoreForm.add1.focus();
		return false;
	}
	
	
	else if(dc_pin=="")
	{
		document.getElementById("pin").innerHTML='<span style="color:red">Mandatory field!</span>';
		 document.addSStoreForm.pin.focus();
		 return false;
	}
	else if(isNaN(dc_pin))
	{
		document.getElementById("pin").innerHTML='<span style="color:red">Enter Numeric value only ! </span>'; 
		document.addSStoreForm.pin.focus();
		return false;
	}
	else if(dc_pin.length<6)
	{
		 document.getElementById("pin").innerHTML='<span style="color:red">Pin should be of 6 digits! </span>';
		 document.addSStoreForm.pin.focus();
		 return false;
	 }
	else if(dc_name== "")
	{
		
		document.getElementById("mName").innerHTML='<span style="color:red">Mandatory field !</span>';
		document.addSStoreForm.mName.focus();
		return false;
	}
	else if(dc_city== "")
	{
		
		document.getElementById("city").innerHTML='<span style="color:red">Mandatory field !</span>';
		document.addSStoreForm.city.focus();
		return false;
	}
	else if(dc_state== "")
	{
		
		document.getElementById("state").innerHTML='<span style="color:red">Mandatory field !</span>';
		document.addSStoreForm.state.focus();
		return false;
	}
	else if(dc_land== "")
	{
		document.getElementById("landmark").innerHTML='<span style="color:red">Mandatory field !</span>';
		document.addSStoreForm.landmark.focus();
		return false;
	} 
	
	else if(id == "")
	{
	alert("Error:Please provide a  id !");
	document.addSStoreForm.id.focus();
	return false;
	}
	
	else if(id1<6)
		{
		document.getElementById("id").innerHTML='<span style="color:red">Id should be of atleast 6 digit !</span>';
		document.addSStoreForm.id.focus();
		return false;
		}
	else if(pass1!=" ")
		{
			if(pass1.length<6)
				{
				document.getElementById("pass").innerHTML='<span style="color:red">Password must contain at least six characters! </span>';
				document.addSStoreForm.pass.focus();
				return false;
				}
			
			
		    if(!re.test(pass1))
		    	{
		    	document.getElementById("pass").innerHTML='<span style="color:red">password must contain at least one number (0-9)! </span>';
		    	document.addSStoreForm.pass.focus();
		    	return false;
		    	}
		 
		}
	
return true;
	
	
}


			
		
		

	
	
	
	
