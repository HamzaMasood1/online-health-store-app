<!DOCTYPE html>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Items!</title>
    <link href="/css/main.css" rel="stylesheet">
</head>
<body>
<form action="/searchProducts" method="GET"
				class="form-inline my-2 my-lg-0">
				<select id="type" name="type">
										<option  value="title">Title</option>
										<option value="price">Price</option>
										<option value="manufacturer">Manufacturer</option>
										<option value="category">Category</option>
									</select>
									<br>
									<select id="style" name="style">
										<option  value="Ascending">Ascending</option>
										<option value="Descending">Descending</option>
										
									</select>
				<input id="keyword" name="keyword" class="form-control mr-sm-2"
					type="text" placeholder="Search">
				<button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
			</form>
			<br>
    <h2>Hello 
items</h2>
 <p>
   <h1> items to choose from</h1>
    <c:forEach var="items" items="${lists}">
    <c:choose>
    <c:when test="${!items.itemState}">Out of stock</c:when>
    <c:when test="${items.itemState}">In stock</c:when>
    </c:choose>
 
   <div class = "item"><div class="start"><img src="${items.image}" width="193", height="130"/>
   <p class="title"><form method="post" action="setQuantity"><input id="quantity" name="quantity" class="form-control mr-sm-2"
					type="number" placeholder="quantity"><br>Current Quantity: ${items.quantity}<input type="hidden" name="itemId" value="${items.id}"><button id="loginButton" class="form-control">Add ${items.title} quantity</button></form><br>
		</form></p></div></div> </c:forEach>
       
 
		
  <form action="AdminUser" method="post">
		<button id="itemButton" class="form-control">Return Home</button>
		</form>
   
</body>
</html>
