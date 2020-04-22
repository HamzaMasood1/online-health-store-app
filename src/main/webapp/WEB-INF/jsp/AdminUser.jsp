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
    <h2 class="hello-title">Hello Admin</h2>

		<br>
		Manage your store here
		<br>
		<label>view items</label>
		<form action="viewItems" method="post">
		<button id="itemButton" class="form-control">VIEW ITEMS</button>
		</form>
		<br>

  	<form action="AddItemsPage" method="post">
		<button id="cartButton" class="form-control">ADD ITEMS</button>
		</form>
			<br>

  	<form action="allCustomers" method="post">
		<button id="cartButton" class="form-control">VIEW CUSTOMERS</button>
		</form>

    </body>
</html>
