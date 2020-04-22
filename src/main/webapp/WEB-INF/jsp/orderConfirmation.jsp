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
<h1>Here are your products</h1>
<body >
the product id is ${id}!
 <p>
    Your bought items:<br />
    <c:forEach var="items" items="${cartItems}">
        
       <div class = "item"><div class="start"><br>${items.title}<br><img src="${items.image}" width="193", height="130"/><br>
       <label>Comments</label><br><form method="post" action="postComment"><input type="hidden" name="itemId" value="${items.id}"><textarea name="comment"rows="5" value="comment" cols="20"></textarea><br><input type="number" name="rating" id="number"><br><button id="loginButton" class="form-control">Post Comment</button></form><br><span class="heading">User Rating</span>
<span class="fa fa-star checked"></span>
<span class="fa fa-star "></span>
<span class="fa fa-star"></span>
<span class="fa fa-star checked"></span>
<span class="fa fa-star"></span></div></div>
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