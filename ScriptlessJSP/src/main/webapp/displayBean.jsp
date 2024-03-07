<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="userinfo" class="beans.User" scope="session" />
	<h1> Welcome <jsp:getProperty name="userinfo"  property="fname" />
	             <jsp:getProperty name="userinfo"  property="lname" />
	</h1>
	<p> Email : <jsp:getProperty property="email" name="userinfo"/> </p>
	<p> Contact : <jsp:getProperty property="contact" name="userinfo"/> </p>
	<p> Age : <jsp:getProperty property="age" name="userinfo"/> </p>
</body>
</html>