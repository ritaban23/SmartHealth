function validate()
{

	var p_id=document.addproductsform.pId.value;
	var p_id1=p_id.length;	
	var p_name=document.addproductsform.pName.value;

	var p_add1=document.addproductsform.pDesc.value;
	document.getElementById("pId").innerHTML="";
	
	document.getElementById("pName").innerHTML="";
	document.getElementById("pDesc").innerHTML="";
	if(p_id == "")
	{
		alert("Error:Please provide a store id !");
		document.addproductsform.pId.focus();
		return false;
	}
	
	else if(p_id1<6)
	{
	document.getElementById("pId").innerHTML='<span style="color:red">Store Id should be of atleast 6 digit !</span>';
	document.addproductsform.pId.focus();
	return false;
	}
	else if(p_name== "")
	{
		
		document.getElementById("pName").innerHTML='<span style="color:red">Mandatory field !</span>';
		document.addproductsform.pName.focus();
		return false;
	}
	else if(p_add1 == "")
	{
		alert("Error: Description is mandatory!");
		document.addproductsform.pDesc.focus();
		return false;
	}
	return true;
	
}