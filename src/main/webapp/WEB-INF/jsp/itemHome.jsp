<!DOCTYPE html>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Items!</title>
    <link href="/css/main.css" rel="stylesheet">
</head>
<body>
    <h2>Hello 
items</h2>
 <p>
    items in your cart :<br />
    <c:forEach var="items" items="${lists}">
        ${items.title}<br />
    </c:forEach>
  </p>
   
</body>
</html>