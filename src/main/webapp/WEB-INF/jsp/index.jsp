<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>


   <title>Login</title>
   </head>
   <body>
<p>LOGIN</p>
	<div class="container" >

	<div class ="form-group form">
	<form action="login" method="post">
	
	<label>
	User name:
	</label>
	<input type="text" id="name" name="name" placeholder="name" class="form-control"/>
	<br>
	<label>
	Password:
	</label>
	<input type="text" id="password" name="password" placeholder="password" class="form-control"/>
	</div>

	
	</div>
	<button id="loginButton" class="form-control">Login</button>
	</form>
	</div>
	<br>
	<p>REGISTER</p>
		<div class="container2" >

	<div class ="form-group form2">
	<form action="register" method="post">
	<div>

	<label>
	First name
	</label>
	<input type="text" id="fname" name="fname" placeholder="first name" class="form-control"/>
	<br>
	<label>
	Last name
	</label>
	<input type="text" id="lname" name="lname" placeholder="last name" class="form-control"/>
	<br>
	<label>
	User name:
	</label>
	<input type="text" id="name" name="name" placeholder="name" class="form-control2"/>
	<br>
	<label>
	Password:
	</label>
	<input type="text" id="password" name="password" placeholder="password" class="form-control2"/>
	<br>
	<label>
	Email
	</label>
	<input type="text" id="email" name="email" placeholder="email" class="form-control2"/>
	<br>
	<label>
	Address
	</label>
	<input type="text" id="address" name="address" placeholder="address" class="form-control2"/>
	</div>
	<br>
	<label>
	town
	</label>
	<input type="text" id="town" name="town" placeholder="Town" class="form-control2"/>
	<br>
	<label>
	county
	</label>
	<input type="text" id="county" name="county" placeholder="county" class="form-control2"/>
	<br>
	<label>
	Payment Method
	</label>
	<label for="Shipping_Address" class="control-label">Payment
										Type</label> <br><select id="payment" name="payment">
										<option  value="1">Visa</option>
										<option value="2">MasterCard</option>
										<option value="3">PayPal</option>
									</select>
	<label>
	<br>
	<label>
	Number
	</label>
	<input type="text" id="number" name="number" placeholder="number" class="form-control2"/>
	<br>
	Expiry date
	</label>
	<input type="number" id="date" name="date" placeholder="date" class="form-control2"/>
	<br>
	<label>
	Expiry Year
	</label>
	<input type="number" id="year" name="year" placeholder="year" class="form-control2"/>
	
	
	</div>
	<button id="RegisterButton" class="form-control2">Register</button>
	
	</form>
	
     
    </body> 
</html>