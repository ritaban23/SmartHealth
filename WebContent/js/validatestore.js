function validate()
{
	
	var quant=document.vform.quantity.value;//alert('hi');
	var threshold=document.vform.th.value;
	document.getElementById("q").innerHTML="";
	document.getElementById("th").innerHTML="";
	if((quant == "")||(quant=="0"))
	{
	
		document.getElementById("q").innerHTML='<span style="color:red">Cannot be zero!</span>';
		document.vform.quantity.focus();
		return false;
	}
	if(isNaN(quant))
		{
		document.getElementById("q").innerHTML='<span style="color:red">numeric only</span>';
		document.vform.quantity.focus();
		return false;
		}
	else if((threshold == "")||(threshold=="0"))
	{
	
		document.getElementById("th").innerHTML='<span style="color:red">Cannot be zero!</span>';
		document.vform.th.focus();
		return false;
	}
	if(isNaN(threshold))
	{
	document.getElementById("th").innerHTML='<span style="color:red">numeric only</span>';
	document.vform.th.focus();
	return false;
	}
	return true;
}