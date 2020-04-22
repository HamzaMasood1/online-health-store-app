<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
<h1>ADD ITEMS TO YOUR STORE</h1>
<form action="AddItem" method="post">
	<label>
	NAME
	</label>
	<input type="text" id="name" name="name" placeholder="Name" class="form-control"/>
	<br>
	<label>
	PRICE
	</label>
	<input type="number" id="price" name="price" placeholder="price" class="form-control"/>
	<br>
	<label>
	CATEGORY
	</label>
	<input type="text" id="category" name="category" placeholder="category" class="form-control2"/>
	<br>
	<label>
	MANUFACTURER
	</label>
	<input type="text" id="manufacturer" name="manufacturer" placeholder="manufacturer" class="form-control2"/>
	<br>
	<label>
	QUANTITY
	</label>
	<input type="number" id="quantity" name="quantity" placeholder="quantity" class="form-control2"/>
	<br>
 <input type="file" name="pic" accept="image/*">
 <br>
	<button id="RegisterButton" class="form-control2">ADD</button>
	
	</form>
	
     
    </body> 
</html>