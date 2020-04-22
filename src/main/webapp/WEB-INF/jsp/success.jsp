<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

   

<html>
    <head>
	<link rel="stylesheet" type="text/css" href="style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello DT354</title>
    </head>
    <body>
    <h2 class="hello-title">Hello ${name}!</h2>
<h1>WELCOME${userName}</h1>
		<br>
		Congrats you have logged into your page
		<br>
		<label>view items</label>
		<form action="addItem" method="post">
		<button id="itemButton" class="form-control">Add Item</button>
		</form>
		<br>
		 <p>
    items in your cart :<br />
    <c:forEach var="items" items="${lists}">
        ${items.title}<br />
    </c:forEach>
  </p>
  	<form action="startCart" method="post">
		<button id="cartButton" class="form-control">ENTER STORE</button>
		</form>
   
		
		
		
			

	
	

	
    </body>
</html>
