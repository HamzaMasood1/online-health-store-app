<!DOCTYPE html>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>PAY!</title>
    <link href="/css/main.css" rel="stylesheet">
</head>
<h1>PAY FOR YOUR PRODUCTS HERE</h1>
<body>
the product id is ${id}!
 <p>
    items in your cart :<br />
    <c:forEach var="items" items="${cartItems}">
        
       <div class = "item"><div class="start"><br>${items.title}<br><img src="${items.image}" width="193", height="130"/></div></div>
    </c:forEach>
  </p>
<br>
<form action="confirmBuy" method="post">
		<button id="itemButton" class="form-control">Confirm</button>
		</form>
<!-- 
    <h2>Hello 
items</h2>
 <p>
   <h1> items in your cart :</h1>
    <c:forEach var="items" items="${lists}">
 
   <div class = "item"><div class="start"><img src="${items.image}" width="193", height="130"/>
   <p class="title"><a  href="${contextPath}/itemHome">${items.title}</a></p></div></div> </c:forEach>
       
  
    -->
    
</body>
</html>