function validate()
{
	alert('hi');
	alert("hi");
	if(document.getElementById("myCheck").checked = true)
		{
			var x=document.getElementById("quantity");
			if(x=="0")
				{
				alert("fields should be filled");
				//document.poGenerateForm.quantity.focus();
				return false;
				}
		}
	return true;
}