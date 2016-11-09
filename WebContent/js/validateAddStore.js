function validate()
{
	
	var s_id=document.addStoreForm.sId.value;
	var s_id1=s_id.length;
	var s_phone=document.addStoreForm.sPhone.value;
	var s_phone1=s_phone.length;
	var s_name=document.addStoreForm.mName.value;
	var s_add1=document.addStoreForm.add1.value;
	var s_add2=document.addStoreForm.add2.value;
	var s_pin=document.addStoreForm.pin.value;
	var s_city=document.addStoreForm.city.value;
	var s_state=document.addStoreForm.state.value;
	var s_land=document.addStoreForm.landmark.value;
	
	
	var id=document.addStoreForm.id.value;
	var id1=id.length;
	var pass1=document.addStoreForm.pass.value;
	
	var re = /[0-9]/;
	document.getElementById("sId").innerHTML="";
	document.getElementById("sPhone").innerHTML="";
	document.getElementById("mName").innerHTML="";
	document.getElementById("pin").innerHTML="";
	document.getElementById("city").innerHTML="";
	document.getElementById("state").innerHTML="";
	document.getElementById("landmark").innerHTML="";
	document.getElementById("add1").innerHTML="";
	document.getElementById("add2").innerHTML="";
	
	
	document.getElementById("pass").innerHTML="";
	document.getElementById("id").innerHTML="";
	
	if(s_id == "")
	{
		alert("Error:Please provide a store id !");
		document.addStoreForm.sId.focus();
		alert("nm");
		return false;
	}
	
	else if(s_id1<6)
	{
	document.getElementById("sId").innerHTML='<span style="color:red">Store Id should be of atleast 6 digit !</span>';
	document.addStoreForm.sId.focus();
	return false;
	}
	if(s_phone == "")
	{
		alert("Error:Please provide a phone number!");
		document.addStoreForm.sPhone.focus();
		return false;
	}
	else if(isNaN(s_phone))
	{
		document.getElementById("sPhone").innerHTML='<span style="color:red">Enter Numeric value only !</span>';
		document.addStoreForm.sPhone.focus();
		return false;
	
	}
	else if(s_phone1<10)
	{
		document.getElementById("sPhone").innerHTML='<span style="color:red">Store Phone Number should be of 10 digit !</span>';
		document.addStoreForm.sPhone.focus();
		return false;
	}
	if(s_name== "")
	{
		
		document.getElementById("mName").innerHTML='<span style="color:red">Mandatory field !</span>';
		document.addStoreForm.mName.focus();
		return false;
	}
	
	if(s_add1 == "")
	{
		alert("Error:Address 1 is mandatory!");
		document.addStoreForm.add1.focus();
		return false;
	}
	
	if(s_add2 == "")
	{
		
		return true;
	}
	
	if(s_pin=="")
	{
		 alert("Error:fill the pin code!");
		 document.addStoreForm.pin.focus();
		 return false;
	}
	else if(isNaN(s_pin))
	{
		document.getElementById("pin").innerHTML='<span style="color:red">Enter Numeric value only ! </span>'; 
		document.addStoreForm.pin.focus();
		return false;
	}
	else if(s_pin.length<6)
	{
		 document.getElementById("pin").innerHTML='<span style="color:red">Pin should be of 6 digits! </span>';
		 document.addStoreForm.pin.focus();
		 return false;
	 }
	if(s_city== "")
	{
		
		document.getElementById("city").innerHTML='<span style="color:red">Mandatory field !</span>';
		document.addStoreForm.city.focus();
		return false;
	}
	if(s_state== "")
	{
		
		document.getElementById("state").innerHTML='<span style="color:red">Mandatory field !</span>';
		document.addStoreForm.state.focus();
		return false;
	}
	if(s_land== "")
	{
		document.getElementById("landmark").innerHTML='<span style="color:red">Mandatory field !</span>';
		document.addStoreForm.landmark.focus();
		return false;
	} 
	
	if(id == "")
	{
	alert("Error:Please provide a  id !");
	document.addStoreForm.id.focus();
	return false;
	}
	
	if(id1<6)
		{
		document.getElementById("id").innerHTML='<span style="color:red">Id should be of atleast 6 digit !</span>';
		document.addStoreForm.id.focus();
		return false;
		}
	if(pass1!=" ")
		{
			if(pass1.length<6)
				{
				document.getElementById("pass").innerHTML='<span style="color:red">Password must contain at least six characters! </span>';
				document.addStoreForm.pass.focus();
				return false;
				}
			
			
		    if(!re.test(pass1))
		    	{
		    	document.getElementById("pass").innerHTML='<span style="color:red">password must contain at least one number (0-9)! </span>';
		    	document.addStoreForm.pass.focus();
		    	return false;
		    	}
		 
		}
return true;

}