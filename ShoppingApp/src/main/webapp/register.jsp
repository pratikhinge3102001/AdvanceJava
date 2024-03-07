<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="http://localhost:8080/ShoppingApp/register" method="post">
		Uid : <input type="text" name="uid"/>
		<br/>
		Pwd : <input type="password" name="pwd"/>
		<br/>
		First Name : <input type="text" name="fname"/>
		<br/>
		Middle Name : <input type="text" name="mname"/>
		<br/>
		Last Name : <input type="text" name="lname"/>
		<br/>
		Email : <input type="email" name="eml">
		<br/>
		Contact No : <input type="number" name="contact">
		<input type="submit" value="LOGIN" />
	</form>
</body>
</html>