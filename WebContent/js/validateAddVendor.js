function validate()
{
	
	var v_id=document.addVendorForm.vId.value;
	var v_id1=v_id.length;
	var v_name=document.addVendorForm.vName.value;
	var v_add1=document.addVendorForm.vAdd.value;
	document.getElementById("vId").innerHTML="";
	
	document.getElementById("vName").innerHTML="";
	document.getElementById("vAdd").innerHTML="";
	if(v_id == "")
	{
		alert("Error:Please provide a vendor id !");
		document.addVendorForm.vId.focus();
		return false;
	}
	
	else if(v_id1<6)
	{
	document.getElementById("vId").innerHTML='<span style="color:red">Vendor Id should be of atleast 6 digit !</span>';
	document.addVendorForm.vId.focus();
	return false;
	}
	else if(v_name== "")
	{
		
		document.getElementById("vName").innerHTML='<span style="color:red">Mandatory field !</span>';
		document.addVendorForm.vName.focus();
		return false;
	}
	else if(v_add1 == "")
	{
		alert("Error: Description is mandatory!");
		document.addVendorForm.vAdd.focus();
		return false;
	}
	return true;
	
}