<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<f:form action="save" modelAttribute="con">
		Enter fname : 
		<f:input path="fname"/>
		<br/>
		Enter lname :
		<f:input path="lname"/>
		<br/>
		Enter uid : 
		<f:input path="uid"/>
		<br/>
		Enter password :
		<f:input path="password"/>
		<br/>
		Enter email : 
		<f:input path="email"/>
		<br/>
		Enter contactno :
		<f:input path="contactno"/>
		<br/>
		<input type="submit" value="Create New" />
	</f:form>
	
		
	

</body>
</html>