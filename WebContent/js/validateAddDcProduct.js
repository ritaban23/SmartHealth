function validate()
{
	if(document.productForm.product.value==-1)
	{
	//alert("choose your product");
	document.getElementById("pro").innerHTML='<span style="color:red">choose a product!</span>';
	document.productForm.product.focus();
	return false;
	}

}