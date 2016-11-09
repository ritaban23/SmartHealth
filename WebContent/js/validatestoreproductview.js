function validate()
{
	var quant=document.viewform.q.value;
	var threshold=document.viewform.th.value;
	document.getElementById("q").innerHTML="";
	document.getElementById("th").innerHTML="";
	if((quant == "")||(quant=="0"))
	{
	
		document.getElementById("q").innerHTML='<span style="color:red">Cannot be zero!</span>';
		document.viewform.q.focus();
		return false;
	}
	if(isNaN(quant))
	{
	document.getElementById("q").innerHTML='<span style="color:red">numeric only</span>';
	document.viewform.q.focus();
	return false;
	}
	else if((threshold == "")||(threshold=="0"))
	{
	
		document.getElementById("th").innerHTML='<span style="color:red">Cannot be zero!</span>';
		document.viewform.th.focus();
		return false;
	}
	if(isNaN(threshold))
	{
	document.getElementById("th").innerHTML='<span style="color:red">numeric only</span>';
	document.viewform.th.focus();
	return false;
	}
	return true;
}