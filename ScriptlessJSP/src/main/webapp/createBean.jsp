<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

    <%-- check the attribute named userinfo at session scope
         if available retrieve else create and set it
     --%>
	<jsp:useBean id="userinfo" class="beans.User" scope="session" />
	
	<%-- populating the bean --%>
	<%--  
	<jsp:setProperty name="userinfo"  property="uid"  param="uid" />
	<jsp:setProperty name="userinfo"  property="pwd"  param="pwd" />
	<jsp:setProperty name="userinfo"  property="fname"  param="fname" />
	<jsp:setProperty name="userinfo"  property="lname"  param="lname" />
	<jsp:setProperty name="userinfo"  property="email"  param="email" />
	<jsp:setProperty name="userinfo"  property="contact"  param="contact" />
	<jsp:setProperty name="userinfo"  property="age"  param="age" />
	--%>
	<jsp:setProperty name="userinfo"  property="*" />
	
	<jsp:forward page="/displayBean.jsp" />
	
	
</body>
</html>