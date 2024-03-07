<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1> Welcome ${userinfo.fname} ${userinfo.lname} </h1>
	
	<p> Email : ${userinfo.email } </p>
	<p> Age : ${userinfo.age } </p>
	<p> City : ${userinfo.address.city  } </p>
	
	<%-- data from other sources --%>
	<p> request param : ${param.area}  </p> 
	<p> request header host : ${header.host }</p>
	<p> request header client : ${header["user-agent"] }</p>
	<p> context param : ${initParam.adminemail } </p>
	<p> Cookie - uidcookie : ${cookie.uidcookie.value }</p>
	
	
	<%-- no way to iterate through the bean of type collection --%>
	<p> First hobby : ${hobbylist["0"] } </p>
	<p> Second hobby : ${hobbylist["1"] } </p>
	
	<h2> Selected hobbies </h2>
	<ul>
		<c:forEach var="hobby" items="${hobbylist}">
			<li> ${hobby} </li>
		</c:forEach>
	</ul>
</body>
</html>





