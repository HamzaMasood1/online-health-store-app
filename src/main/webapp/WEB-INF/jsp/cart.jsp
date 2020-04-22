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

									<br>
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
    
 
   <div class = "item"><div class="start"><img src="${items.image}" width="193", height="130"/>
   <p class="title"><c:choose>
					<c:when test="${!items.itemState}">Out of Stock</c:when>
					<c:when test="${items.itemState}">
						<form class="form-horizontal" method="post" action="pay">
							<div class="form-group">
								<input type="hidden" name="itemId" value="${items.id}"/>
								<input id="quantity" name="quantity" class="form-control mr-sm-2"
					type="number" placeholder="Input Quanitity">
								<input type="submit" class="btn btn-primary btn-sm"
									value="Add To Cart" />
							</div>
						</form>
					</c:when>
				</c:choose><br> <form action="clearItems" method="post">
		<input type="hidden" name="itemId" value="${items.id}"><button id="itemButton" class="form-control">Clear ${items.title}s </button>
		</form></p><br><form action="viewComments" method="post">
		<input type="hidden" name="itemId" value="${items.id}"><button id="itemButton" class="form-control">View Comments</button>
		</form><br>Average Rating: ${items.averageRating}<br>In cart Quantity: ${items.inCartQuantity}</div></div> </c:forEach>
       
  <br>
   	
									<!--  >input id="loyaltyCard" name="loyaltyCard" class="form-control mr-sm-2"
					type="text" placeholder="Standard/Silver/Gold"-->
									 <form action="confirmLoyaltyCard" method="post">
									 <label for="Loyalty Card" class="control-label">Loyalty Card
										Type</label> <br><select id="loyaltyCard" name="loyaltyCard">
										<option  value="Standard">Standard</option>
										<option value="Silver">Silver</option>
										<option value="Gold">Gold</option>
									</select>
		<button id="itemButton" class="form-control">Confirm Loyalty Card</button>
		</form>
		<br>
		<h2>${card}</h2>
		<br>
		
  <form action="confirmCart" method="post">
		<button id="itemButton" class="form-control">Confirm CART</button>
		</form>
   
</body>
</html>



