<!DOCTYPE html>

  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html lang="en">
<head>
<!-- $(document).ready(function() {
    $("form#ratingForm").submit(function(e) 
    {
        e.preventDefault(); // prevent the default click action from being performed
        if ($("#ratingForm :radio:checked").length == 0) {
            $('#status').html("nothing checked");
            return false;
        } else {
            $('#status').html( 'You picked ' + $('input:radio[name=rating]:checked').val() );
        }
    });
}); -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.checked {
  color: orange;
}
</style>
    <meta charset="UTF-8">
    <title>PAY!</title>
    <link href="/css/main.css" rel="stylesheet">
</head>
<h1>Here are the customers</h1>
<body >

 <p>
    Your bought items:<br />
    <c:forEach var="orders" items="${allOrders}">
        
       <div class = "item"><div class="start"><form action="orderDetails" method="POST">
       <input type="hidden" name="email" value="${orders.name}"><button id="loginButton" class="form-control">${orders.name}</button></form><br><br><br><br></div></div>
       

    </c:forEach>
  </p>
<br>

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